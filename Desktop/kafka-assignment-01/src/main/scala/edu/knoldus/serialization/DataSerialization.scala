import java.io.{ByteArrayOutputStream, ObjectOutputStream, ObjectStreamException}
import java.util

import model.StudentData
import org.apache.kafka.common.serialization.Serializer

class DataSerialization extends Serializer[StudentData] {

  override def configure(map: util.Map[String, _], b: Boolean): Unit = ???

  override def close(): Unit = ???

  override def serialize(topic: String, data: StudentData): Array[Byte] = {
    try {
      val byteArrayOutputStream = new ByteArrayOutputStream()
      val outputStream = new ObjectOutputStream(byteArrayOutputStream)
      outputStream.writeObject(data)
      outputStream.close()
      byteArrayOutputStream.close()
      byteArrayOutputStream.toByteArray
    }
    catch {
      case exception: ObjectStreamException => throw new Exception(exception)
    }
  }

}
