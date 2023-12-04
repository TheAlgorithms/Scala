package com.playtime

import java.time.Duration
import java.util.Properties
import java.util.concurrent.TimeUnit

import org.apache.kafka.streams.{StreamsConfig, Topology}
import org.apache.kafka.streams.kstream.{GlobalKTable, JoinWindows, Materialized}
import org.apache.kafka.streams.scala.ImplicitConversions._
import org.apache.kafka.streams.scala.{Serdes, StreamsBuilder}
import org.apache.kafka.streams.scala.kstream.{KStream, KTable}

object KafkaStreamsJoins {

  import Serdes._

  val props: Properties = {
    val p = new Properties()
    p.put(StreamsConfig.APPLICATION_ID_CONFIG, "kafka-streams-examples")
    p.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    p
  }

  def kTableToKTableJoin(inputTopic1: String,
                         inputTopic2: String,
                         storeName: String): Topology = {

    val builder: StreamsBuilder = new StreamsBuilder

    val userRegions: KTable[String, String] = builder.table(inputTopic1)
    val regionMetrics: KTable[String, Long] = builder.table(inputTopic2)

    userRegions.join(regionMetrics,
      Materialized.as(storeName))((regionValue, metricValue) => regionValue + "/" + metricValue)

    builder.build()
  }

  def kTableToKTableLeftJoin(inputTopic1: String,
                         inputTopic2: String,
                         storeName: String): Topology = {

    val builder: StreamsBuilder = new StreamsBuilder

    val userRegions: KTable[String, String] = builder.table(inputTopic1)
    val regionMetrics: KTable[String, Long] = builder.table(inputTopic2)

    userRegions.leftJoin(regionMetrics,
      Materialized.as(storeName))((regionValue, metricValue) => regionValue + "/" + metricValue)

    builder.build()
  }

  def kTableToKTableOuterJoin(inputTopic1: String,
                             inputTopic2: String,
                             storeName: String): Topology = {

    val builder: StreamsBuilder = new StreamsBuilder

    val userRegions: KTable[String, String] = builder.table(inputTopic1)
    val regionMetrics: KTable[String, Long] = builder.table(inputTopic2)

    userRegions.outerJoin(regionMetrics,
      Materialized.as(storeName))((regionValue, metricValue) => regionValue + "/" + metricValue)

    builder.build()
  }

  def kStreamToKTableJoin(inputTopic1: String,
                          inputTopic2: String,
                          outputTopicName: String,
                          storeName: String): Topology = {

    val builder: StreamsBuilder = new StreamsBuilder

    val userRegions: KTable[String, String] = builder.table(inputTopic1)
    val regionMetrics: KStream[String, Long] = builder.stream(inputTopic2)

    regionMetrics.join(userRegions){(regionValue, metricValue) =>
      regionValue + "/" + metricValue
    }.to(outputTopicName)

    val outputTopic: KTable[String, String] =
      builder.table(
        outputTopicName,
        Materialized.as(storeName)
      )

    builder.build()
  }

  def kStreamToKTableLeftJoin(inputTopic1: String,
                          inputTopic2: String,
                          outputTopicName: String,
                          storeName: String): Topology = {

    val builder: StreamsBuilder = new StreamsBuilder

    val userRegions: KTable[String, String] = builder.table(inputTopic1)
    val regionMetrics: KStream[String, Long] = builder.stream(inputTopic2)

    regionMetrics.leftJoin(userRegions){(regionValue, metricValue) =>
      regionValue + "/" + metricValue
    }.to(outputTopicName)

    val outputTopic: KTable[String, String] =
      builder.table(
        outputTopicName,
        Materialized.as(storeName)
      )

    builder.build()
  }

  def kStreamToKTableOuterJoin(inputTopic1: String,
                              inputTopic2: String,
                              outputTopicName: String,
                              storeName: String): Topology = {

    // N/A - KStream to KTable is not supported
    new StreamsBuilder().build()
  }


  // -------- KStream to KStream joins ------------//

  def kStreamToKStreamJoin(inputTopic1: String,
                              inputTopic2: String,
                              outputTopicName: String,
                              storeName: String): Topology = {

    val builder: StreamsBuilder = new StreamsBuilder

    val userRegions: KStream[String, String] = builder.stream(inputTopic1)
    val regionMetrics: KStream[String, Long] = builder.stream(inputTopic2)

    regionMetrics.join(userRegions)(
      ((regionValue, metricValue) => regionValue + "/" + metricValue),
      JoinWindows.of(Duration.ofMinutes(5L))
    ).to(outputTopicName)

    val outputTopic: KTable[String, String] =
      builder.table(
        outputTopicName,
        Materialized.as(storeName)
      )

    builder.build()
  }

  def kStreamToKStreamLeftJoin(inputTopic1: String,
                           inputTopic2: String,
                           outputTopicName: String,
                           storeName: String): Topology = {

    val builder: StreamsBuilder = new StreamsBuilder

    val userRegions: KStream[String, String] = builder.stream(inputTopic1)
    val regionMetrics: KStream[String, Long] = builder.stream(inputTopic2)

    regionMetrics.leftJoin(userRegions)(
      ((regionValue, metricValue) => regionValue + "/" + metricValue),
      JoinWindows.of(Duration.ofMinutes(5L))
    ).to(outputTopicName)

    val outputTopic: KTable[String, String] =
      builder.table(
        outputTopicName,
        Materialized.as(storeName)
      )

    builder.build()
  }

  def kStreamToKStreamOuterJoin(inputTopic1: String,
                               inputTopic2: String,
                               outputTopicName: String,
                               storeName: String): Topology = {

    val builder: StreamsBuilder = new StreamsBuilder

    val userRegions: KStream[String, String] = builder.stream(inputTopic1)
    val regionMetrics: KStream[String, Long] = builder.stream(inputTopic2)

    regionMetrics.outerJoin(userRegions)(
      ((regionValue, metricValue) => regionValue + "/" + metricValue),
      JoinWindows.of(Duration.ofMinutes(5L))
    ).to(outputTopicName)

    val outputTopic: KTable[String, String] =
      builder.table(
        outputTopicName,
        Materialized.as(storeName)
      )

    builder.build()
  }

  // -------- KStream to GlobalKTable joins ------------//

  def kStreamToGlobalKTableJoin(inputTopic1: String,
                           inputTopic2: String,
                           outputTopicName: String,
                           storeName: String): Topology = {

    val builder: StreamsBuilder = new StreamsBuilder

    val userRegions: GlobalKTable[String, String] = builder.globalTable(inputTopic1)
    val regionMetrics: KStream[String, Long] = builder.stream(inputTopic2)

    regionMetrics.join(userRegions)(
      (lk, rk) => lk,
      ((regionValue, metricValue) => regionValue + "/" + metricValue)
    ).to(outputTopicName)

    val outputTopic: KTable[String, String] =
      builder.table(
        outputTopicName,
        Materialized.as(storeName)
      )

    builder.build()
  }

  def kStreamToGlobalKTableLeftJoin(inputTopic1: String,
                                inputTopic2: String,
                                outputTopicName: String,
                                storeName: String): Topology = {

    val builder: StreamsBuilder = new StreamsBuilder

    val userRegions: GlobalKTable[String, String] = builder.globalTable(inputTopic1)
    val regionMetrics: KStream[String, Long] = builder.stream(inputTopic2)

    regionMetrics.leftJoin(userRegions)(
      (lk, rk) => lk,
      ((regionValue, metricValue) => regionValue + "/" + metricValue)
    ).to(outputTopicName)

    val outputTopic: KTable[String, String] =
      builder.table(
        outputTopicName,
        Materialized.as(storeName)
      )

    builder.build()
  }

  // Not Supported
  def kStreamToGlobalKTableOuterJoin(inputTopic1: String,
                                inputTopic2: String,
                                outputTopicName: String,
                                storeName: String): Topology = {

    new StreamsBuilder().build()
  }
}
