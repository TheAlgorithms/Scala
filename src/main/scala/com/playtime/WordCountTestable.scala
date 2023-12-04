package com.playtime

import java.time.Duration
import java.util.Properties

import org.apache.kafka.streams.kstream.Materialized
import org.apache.kafka.streams.scala.ImplicitConversions._
import org.apache.kafka.streams.{KafkaStreams, StreamsConfig, Topology}
import org.apache.kafka.streams.scala.{Serdes, StreamsBuilder}
import org.apache.kafka.streams.scala.kstream.{KStream, KTable}

class WordCountTestable {

  import Serdes._

  val props: Properties = {
    val p = new Properties()
    p.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-modified")
    p.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    p
  }

  def countNumberOfWords(inputTopic: String,
                         outputTopic: String, storeName: String): Topology = {

    val builder: StreamsBuilder = new StreamsBuilder
    val textLines: KStream[String, String] = builder.stream[String, String](inputTopic)
    val wordCounts: KTable[String, Long] = textLines
      .flatMapValues(textLine => textLine.toLowerCase.split("\\W+"))
      .groupBy((_, word) => word)
      .count()(Materialized.as("counts-store"))
    wordCounts.toStream.to(outputTopic)
    builder.build()
  }

  def toLowerCaseStream(inputTopic: String, outputTopic: String): Topology = {
    val builder: StreamsBuilder = new StreamsBuilder()
    val textLines: KStream[String, String] = builder.stream(inputTopic)
    val wordCounts: KStream[String, String] = textLines
      .mapValues(textLine => textLine.toLowerCase)
    wordCounts.to(outputTopic)
    builder.build()
  }
}

object WordCountTestable extends WordCountTestable {

  def main(args: Array[String]): Unit = {
    val builder: Topology = countNumberOfWords("input-topic", "output-topic", "counts-store")
    val streams: KafkaStreams = new KafkaStreams(builder, props)
    streams.start()

    sys.ShutdownHookThread {
      streams.close(Duration.ofSeconds(10))
    }
  }
}
