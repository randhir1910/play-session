package model

trait Student {
  override def toString: String = super.toString
}

case class StudentData(id: String, name: String) extends Student
