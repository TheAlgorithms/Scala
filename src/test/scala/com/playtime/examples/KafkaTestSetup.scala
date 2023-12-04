package com.playtime.examples

import java.util.Properties

import org.apache.kafka.common.serialization._
import org.apache.kafka.streams.StreamsConfig

trait KafkaTestSetup {
  val config = new Properties()
  config.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "testing")
  config.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "testing:1234")
  config.setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String.getClass.getName)
  config.setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass.getName)
}
