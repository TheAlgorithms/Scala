package com.playtime.examples

import com.playtime.KafkaStreamsTransformations
import org.apache.kafka.common.serialization.StringSerializer
import org.apache.kafka.streams.{KeyValue, TopologyTestDriver}
import org.apache.kafka.streams.state.KeyValueStore
import org.apache.kafka.streams.test.ConsumerRecordFactory
import org.scalatest.matchers.should._
import org.scalatest.flatspec.AnyFlatSpec

class KafkaStreamsTransformationsSpec extends AnyFlatSpec with Matchers with KafkaTestSetup {

    import org.apache.kafka.streams.scala.ImplicitConversions._
    import collection.JavaConverters._

    // test fixtures
    val inputTopicOne = "input-topic-1"

    val stateStore = "saved-state"

    // input-topic-1
    val userRegions = scala.collection.mutable.Seq[KeyValue[String, String]](
      ("sensor-1", "MN"),
      ("sensor-2", "WI"),
      ("sensor-11", "IL")
    ).asJava

    val recordFactory = new ConsumerRecordFactory(new StringSerializer(), new StringSerializer())

  // -------  Kafka Streams Transformation Examples ------------ //
  "KStream branch" should "branch streams according to filter impl" in {

    val keyFilter1 = "sensor-1"
    val keyFilter2 = "sensor-2"

    val driver = new TopologyTestDriver(
      KafkaStreamsTransformations.kStreamBranch(inputTopicOne,
                                                keyFilter1,
                                                keyFilter2,
                                                stateStore),
      config
    )

    driver.pipeInput(recordFactory.create(inputTopicOne, userRegions))

    // Perform tests
    val storeOne: KeyValueStore[String, String] = driver.getKeyValueStore(s"${keyFilter1}-${stateStore}")
    val storeTwo: KeyValueStore[String, String] = driver.getKeyValueStore(s"${keyFilter2}-${stateStore}")


    storeOne.get("sensor-1") shouldBe "MN"
    storeOne.get("sensor-11") shouldBe "IL"
    storeTwo.get("sensor-2") shouldBe "WI"

    driver.close()
  }

  "KStream filter" should "filter streams according designated filter" in {

    val valFilter = "MN"
    val driver = new TopologyTestDriver(
      KafkaStreamsTransformations.kStreamFilter(inputTopicOne,
        valFilter,
        stateStore),
      config
    )

    driver.pipeInput(recordFactory.create(inputTopicOne, userRegions))

    // Perform tests
    val storeOne: KeyValueStore[String, String] = driver.getKeyValueStore(s"${stateStore}")

    storeOne.get("sensor-1") shouldBe valFilter
    storeOne.get("sensor-2") shouldBe null
    storeOne.get("sensor-11") shouldBe null

    driver.close()
  }

  "KStream flatMap" should "update streams according flatMap impl" in {

    val valFilter = "MN"
    val flatMappen = List("temp", "location", "codename")
    val driver = new TopologyTestDriver(
      KafkaStreamsTransformations.kStreamFlatMap(inputTopicOne,
        flatMappen,
        stateStore),
      config
    )

    driver.pipeInput(recordFactory.create(inputTopicOne, userRegions))

    // Perform tests
    val storeOne: KeyValueStore[String, String] = driver.getKeyValueStore(s"${stateStore}")

    // just MN, not tesing for WI or IL
    flatMappen.foreach { s =>
      storeOne.get(s"${s}-${valFilter}") shouldBe valFilter
    }

    driver.close()
  }

  "KStream map" should "update streams according map impl" in {

    val driver = new TopologyTestDriver(
      KafkaStreamsTransformations.kStreamMap(inputTopicOne,
        stateStore),
      config
    )

    driver.pipeInput(recordFactory.create(inputTopicOne, userRegions))

    // Perform tests
    val storeOne: KeyValueStore[String, String] = driver.getKeyValueStore(s"${stateStore}")

    storeOne.get("sensor-1") shouldBe "MN-new"
    storeOne.get("sensor-2") shouldBe "WI-new"
    storeOne.get("sensor-11") shouldBe "IL-new"

    driver.close()
  }

  "KStream groupBy" should "group values accordingly" in {

    val newRegions = scala.collection.mutable.Seq[KeyValue[String, String]](
      ("sensor-1", "MN"),
      ("sensor-2", "WI"),
      ("sensor-12", "MN"),
      ("sensor-11", "IL")
    ).asJava

    val driver = new TopologyTestDriver(
      KafkaStreamsTransformations.kStreamGroupBy(inputTopicOne,
        stateStore),
      config
    )

    driver.pipeInput(recordFactory.create(inputTopicOne, newRegions))

    // Perform tests
    val storeOne: KeyValueStore[String, Long] = driver.getKeyValueStore(s"${stateStore}")

    storeOne.get("MN") shouldBe 2
    storeOne.get("WI") shouldBe 1

    driver.close()
  }
}
