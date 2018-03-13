package edu.knoldus.producer

import java.util.Properties
import model.StudentData
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.apache.log4j.Logger

object DataProducer extends App {

  val log = Logger.getLogger(this.getClass)
  val topic = "studentList"
  val studentList = List("randhir", "ravi", "shubham", "vinisha")
  val mobileList = List(99999999, 88888888, 77777777, 66666666);
  val props = new Properties()

  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "edu.knoldus.serialization.StudentSerialization")

  val producer = new KafkaProducer[String, StudentData](props)

  for (index <- 0 until studentList.size) {
    val key = index.toString
    val value = StudentData(key, studentList(index), mobileList(index))
    val record = new ProducerRecord[String, StudentData](topic, key, value)
    producer.send(record)
  }
  producer.close()
  log.info("Data successfully send")

}