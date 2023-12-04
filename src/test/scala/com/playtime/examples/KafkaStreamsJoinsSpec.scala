package com.playtime.examples

import com.playtime.KafkaStreamsJoins
import org.apache.kafka.common.serialization.{LongSerializer, StringSerializer}
import org.apache.kafka.streams.state.KeyValueStore
import org.apache.kafka.streams.{KeyValue, TopologyTestDriver}
import org.apache.kafka.streams.test.ConsumerRecordFactory
import org.scalatest.matchers.should._
import org.scalatest.flatspec.AnyFlatSpec

class KafkaStreamsJoinsSpec extends AnyFlatSpec with Matchers with KafkaTestSetup {

  import org.apache.kafka.streams.scala.ImplicitConversions._
  import collection.JavaConverters._

  // test fixtures
  val inputTopicOne = "input-topic-1"
  val inputTopicTwo = "input-topic-2"
  val outputTopic = "output-topic"

  val stateStore = "saved-state"

  // input-topic-1
  val userRegions = scala.collection.mutable.Seq[KeyValue[String, String]](
    ("sensor-1", "MN"),
    ("sensor-2", "WI"),
    ("sensor-3-in-topic-one", "IL")
  ).asJava

  // input-topic-2
  val sensorMetric = scala.collection.mutable.Seq[KeyValue[String, java.lang.Long]](
    KeyValue.pair("sensor-1", 99L),
    KeyValue.pair("sensor-2", 1L),
    KeyValue.pair("sensor-99-in-topic-two", 1L),
    KeyValue.pair("sensor-100-in-topic-two", 100L)
  ).asJava

  val recordFactory = new ConsumerRecordFactory(new StringSerializer(), new StringSerializer())

  val recordFactoryTwo: ConsumerRecordFactory[String, java.lang.Long] =
    new ConsumerRecordFactory(new StringSerializer(), new LongSerializer())


  // -------  KTable to KTable Joins ------------ //
  "KTable to KTable Inner join" should "save expected results to state store" in {

    val driver = new TopologyTestDriver(
      KafkaStreamsJoins.kTableToKTableJoin(inputTopicOne, inputTopicTwo, stateStore),
      config
    )

    driver.pipeInput(recordFactory.create(inputTopicOne, userRegions))
    driver.pipeInput(recordFactoryTwo.create(inputTopicTwo, sensorMetric))

    // Perform tests
    val store: KeyValueStore[String, String] = driver.getKeyValueStore(stateStore)

    store.get("sensor-1") shouldBe "MN/99"
    store.get("sensor-3-in-topic-one") shouldBe null
    store.get("sensor-99-in-topic-two") shouldBe null

    driver.close()
  }

  "KTable to KTable Left join" should "save expected results to state store" in {

    val driver = new TopologyTestDriver(
      KafkaStreamsJoins.kTableToKTableLeftJoin(inputTopicOne, inputTopicTwo, stateStore),
      config
    )

    driver.pipeInput(recordFactory.create(inputTopicOne, userRegions))
    driver.pipeInput(recordFactoryTwo.create(inputTopicTwo, sensorMetric))

    // Perform tests
    val store: KeyValueStore[String, String] = driver.getKeyValueStore(stateStore)

    store.get("sensor-1") shouldBe "MN/99"
    store.get("sensor-3-in-topic-one") shouldBe "IL/0"
    store.get("sensor-99-in-topic-two") shouldBe null
    store.get("sensor-100-in-topic-two") shouldBe null

    driver.close()
  }

  "KTable to KTable Outer join" should "save expected results to state store" in {

    val driver = new TopologyTestDriver(
      KafkaStreamsJoins.kTableToKTableOuterJoin(inputTopicOne, inputTopicTwo, stateStore),
      config
    )

    driver.pipeInput(recordFactory.create(inputTopicOne, userRegions))
    driver.pipeInput(recordFactoryTwo.create(inputTopicTwo, sensorMetric))

    // Perform tests
    val store: KeyValueStore[String, String] = driver.getKeyValueStore(stateStore)

    store.get("sensor-1") shouldBe "MN/99"
    store.get("sensor-3-in-topic-one") shouldBe "IL/0"
    store.get("sensor-99-in-topic-two") shouldBe "null/1"
    store.get("sensor-100-in-topic-two") shouldBe "null/100"

    driver.close()
  }


  // -------  KStream to KTable Joins ------------ //

  "KStream to KTable join" should "save expected results to state store" in {

    val driver = new TopologyTestDriver(
      KafkaStreamsJoins.kStreamToKTableJoin(inputTopicOne,
                                            inputTopicTwo,
                                            outputTopic, stateStore),
                                            config
    )

    driver.pipeInput(recordFactory.create(inputTopicOne, userRegions))
    driver.pipeInput(recordFactoryTwo.create(inputTopicTwo, sensorMetric))

    // Perform tests
    val store: KeyValueStore[String, String] = driver.getKeyValueStore(stateStore)

    store.get("sensor-1") shouldBe "99/MN" // v,k compared with above
    store.get("sensor-3-in-topic-one") shouldBe null
    store.get("sensor-99-in-topic-two") shouldBe null
    store.get("sensor-100-in-topic-two") shouldBe null

    driver.close()
  }

  "KStream to KTable left join" should "save expected results to state store" in {

    val driver = new TopologyTestDriver(
      KafkaStreamsJoins.kStreamToKTableLeftJoin(inputTopicOne,
        inputTopicTwo,
        outputTopic, stateStore),
      config
    )

    driver.pipeInput(recordFactory.create(inputTopicOne, userRegions))
    driver.pipeInput(recordFactoryTwo.create(inputTopicTwo, sensorMetric))

    // Perform tests
    val store: KeyValueStore[String, String] = driver.getKeyValueStore(stateStore)

    store.get("sensor-1") shouldBe "99/MN"
    store.get("sensor-3-in-topic-one") shouldBe null
    store.get("sensor-99-in-topic-two") shouldBe "1/null"
    store.get("sensor-100-in-topic-two") shouldBe "100/null"

    driver.close()
  }

  // KStream to KTable outer join is not supported

  // -------  KStream to KStream Joins ------------ //

  "KStream to KStream inner join" should "save expected results to state store" in {

    val driver = new TopologyTestDriver(
      KafkaStreamsJoins.kStreamToKStreamJoin(inputTopicOne,
        inputTopicTwo,
        outputTopic, stateStore),
      config
    )

    driver.pipeInput(recordFactory.create(inputTopicOne, userRegions))
    driver.pipeInput(recordFactoryTwo.create(inputTopicTwo, sensorMetric))

    // Perform tests
    val store: KeyValueStore[String, String] = driver.getKeyValueStore(stateStore)

    store.get("sensor-1") shouldBe "99/MN"
    store.get("sensor-3-in-topic-one") shouldBe null
    store.get("sensor-99-in-topic-two") shouldBe null

    driver.close()
  }

  "KStream to KStream Left join" should "save expected results to state store" in {

    val driver = new TopologyTestDriver(
      KafkaStreamsJoins.kStreamToKStreamLeftJoin(inputTopicOne,
        inputTopicTwo,
        outputTopic, stateStore),
      config
    )

    driver.pipeInput(recordFactory.create(inputTopicOne, userRegions))
    driver.pipeInput(recordFactoryTwo.create(inputTopicTwo, sensorMetric))

    // Perform tests
    val store: KeyValueStore[String, String] = driver.getKeyValueStore(stateStore)

    store.get("sensor-1") shouldBe "99/MN"
    store.get("sensor-3-in-topic-one") shouldBe null
    store.get("sensor-99-in-topic-two") shouldBe "1/null"
    store.get("sensor-100-in-topic-two") shouldBe "100/null"

    driver.close()
  }

  "KStream to KStream Outer join" should "save expected results to state store" in {

    val driver = new TopologyTestDriver(
      KafkaStreamsJoins.kStreamToKStreamOuterJoin(inputTopicOne,
        inputTopicTwo,
        outputTopic, stateStore),
        config
    )

    driver.pipeInput(recordFactory.create(inputTopicOne, userRegions))
    driver.pipeInput(recordFactoryTwo.create(inputTopicTwo, sensorMetric))

    // Perform tests
    val store: KeyValueStore[String, String] = driver.getKeyValueStore(stateStore)

    store.get("sensor-1") shouldBe "99/MN"
    store.get("sensor-3-in-topic-one") shouldBe "0/IL"
    store.get("sensor-99-in-topic-two") shouldBe "1/null"
    store.get("sensor-100-in-topic-two") shouldBe "100/null"

    driver.close()
  }

  // -------  KStream to GlobalKTable Joins ------------ //
  // Expect results are the same as KStream to KTable examples
  "KStream to GlobalKTable inner join" should "save expected results to state store" in {

    val driver = new TopologyTestDriver(
      KafkaStreamsJoins.kStreamToGlobalKTableJoin(inputTopicOne,
        inputTopicTwo,
        outputTopic, stateStore),
      config
    )

    driver.pipeInput(recordFactory.create(inputTopicOne, userRegions))
    driver.pipeInput(recordFactoryTwo.create(inputTopicTwo, sensorMetric))

    // Perform tests
    val store: KeyValueStore[String, String] = driver.getKeyValueStore(stateStore)

    store.get("sensor-1") shouldBe "99/MN"
    store.get("sensor-3-in-topic-one") shouldBe null
    store.get("sensor-99-in-topic-two") shouldBe null

    driver.close()
  }

  "KStream to GlobalKTable left join" should "save expected results to state store" in {

    val driver = new TopologyTestDriver(
      KafkaStreamsJoins.kStreamToGlobalKTableLeftJoin(inputTopicOne,
        inputTopicTwo,
        outputTopic, stateStore),
      config
    )

    driver.pipeInput(recordFactory.create(inputTopicOne, userRegions))
    driver.pipeInput(recordFactoryTwo.create(inputTopicTwo, sensorMetric))

    // Perform tests
    val store: KeyValueStore[String, String] = driver.getKeyValueStore(stateStore)

    store.get("sensor-1") shouldBe "99/MN"
    store.get("sensor-3-in-topic-one") shouldBe null
    store.get("sensor-99-in-topic-two") shouldBe "1/null"
    store.get("sensor-100-in-topic-two") shouldBe "100/null"

    driver.close()
  }

  // KStream to GlobalKTable outer join is not supported


}
