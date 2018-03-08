import java.util.Properties

import model.StudentData
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.log4j.Logger

import scala.collection.JavaConverters._

object DataConsumer extends App {

  val log = Logger.getLogger(this.getClass)
  val topic = "studentList"
  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "edu.knoldus.deserialization/DataDeSerialization")
  props.put("group.id", "studentList-group")
  props.put("enable.auto.commit", "false")

  val consumer = new KafkaConsumer[String, StudentData](props)

  consumer.subscribe(java.util.Collections.singletonList(topic))
  while (true) {
    val records = consumer.poll(5000)
    for (record <- records.asScala)
      log.info(s"Student Data:${record.value()}")
  }

}