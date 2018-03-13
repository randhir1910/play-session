import java.util.Properties

import model.StudentData
import org.apache.kafka.clients.consumer.KafkaConsumer

import scala.collection.JavaConverters._

object DataConsumer extends App {

  val topic = "studentList"
  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "edu.knoldus.deserialization.StudentDeSerialization")
  props.put("group.id", "student-group")
  props.put("enable.auto.commit", "false")

  val consumer = new KafkaConsumer[String, StudentData](props)

  consumer.subscribe(java.util.Collections.singletonList(topic))
  while (true) {
    val records = consumer.poll(5000)
    for (record <- records.asScala)
      println(s"Student Data:${record.value()}")

  }

}