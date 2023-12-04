import java.time.Duration
import java.util.Properties

import org.apache.kafka.streams.kstream.Materialized
import org.apache.kafka.streams.scala.ImplicitConversions._
import org.apache.kafka.streams.scala._
import org.apache.kafka.streams.scala.kstream._
import org.apache.kafka.streams.{KafkaStreams, StreamsConfig}
import org.slj4j.{ Logger, LoggerFactory }

object WordCount extends App {
  import Serdes._

  val props: Properties = {
    val p = new Properties()
    p.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-modified")
    p.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    p
  }

  private val log: Logger = LoggerFactory.getLogger(this.getClass);

  val builder: StreamsBuilder = new StreamsBuilder
  val textLines: KStream[String, String] =
    builder.stream[String, String]("TextLinesTopic")
  val wordCounts: KTable[String, Long] = textLines
    .flatMapValues(textLine => textLine.toLowerCase.split("\\W+"))
    .groupBy((_, word) => word)
    .count()(Materialized.as("counts-store"))
  wordCounts.toStream.to("WordsWithCountsTopic2")

  wordCounts.filter { case (k, v) => k == "test" }.toStream.to("TestCounts")

  val streams: KafkaStreams = new KafkaStreams(builder.build(), props)
  
  streams.start()
  log.info(s"About to start kafka consumer...")

  
  sys.ShutdownHookThread {
    streams.close(Duration.ofSeconds(10))
  }
}
