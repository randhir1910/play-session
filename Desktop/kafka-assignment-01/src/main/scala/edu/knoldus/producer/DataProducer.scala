package edu.knoldus.producer

import java.util.Properties
import model.StudentData
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.apache.log4j.Logger

object DataProducer extends App {

  val log = Logger.getLogger(this.getClass)
  val topic = "studentList"
  val studentList = List("randhir", "ravi", "shubham", "vinisha")
  val props = new Properties()

  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "edu.knoldus.serialization.DataSerialization")

  val producer = new KafkaProducer[String, StudentData](props)

  for (index <- 1 to studentList.size) {
    val key = index.toString
    val value = StudentData(key, studentList(index))
    val record = new ProducerRecord[String, StudentData](topic, key, value)
    producer.send(record)
  }
  producer.close()
  log.info("Data successfully send")

}