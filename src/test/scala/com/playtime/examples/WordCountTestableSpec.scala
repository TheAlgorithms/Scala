package com.playtime.examples

import com.playtime.WordCountTestable
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.{StringDeserializer, StringSerializer}
import org.apache.kafka.streams.TopologyTestDriver
import org.apache.kafka.streams.state.KeyValueStore
import org.apache.kafka.streams.test.ConsumerRecordFactory
import org.scalatest.matchers.should._
import org.scalatest.flatspec.AnyFlatSpec

class WordCountTestableSpec extends AnyFlatSpec with Matchers with KafkaTestSetup {

  val wordCountApplication = new WordCountTestable

  "Convert streaming data into lowercase and publish into output topic" should "push lower text to kafka" in {
    val driver = new TopologyTestDriver(wordCountApplication.toLowerCaseStream("input-topic", "output-topic"), config)
    val recordFactory = new ConsumerRecordFactory("input-topic", new StringSerializer(), new StringSerializer())
    val words = "Hello, WORLDY, World worlD Test"
    driver.pipeInput(recordFactory.create(words))
    val record: ProducerRecord[String, String] = driver.readOutput("output-topic", new StringDeserializer(), new StringDeserializer())
    record.value() shouldBe words.toLowerCase
    driver.close()
  }

  "WordCountTestable" should "count number of words" in {
    val driver = new TopologyTestDriver(wordCountApplication.countNumberOfWords("input-topic", "output-topic", "counts-store"), config)
    val recordFactory = new ConsumerRecordFactory("input-topic", new StringSerializer(), new StringSerializer())
    val words = "Hello Kafka Streams, All streams lead to Kafka"
    driver.pipeInput(recordFactory.create(words))
    val store: KeyValueStore[String, java.lang.Long] = driver.getKeyValueStore("counts-store")    
    store.get("hello") shouldBe 1
    store.get("kafka") shouldBe 2
    store.get("streams") shouldBe 2
    store.get("lead") shouldBe 1
    store.get("to") shouldBe 1    
    driver.close()

  }

}
