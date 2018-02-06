package edu.knoldus.services

import edu.knoldus.model.{UserInformation, user}

import scala.util.Random


class UserData extends user {

  val user: List[UserInformation] = List(
    UserInformation("Randhir", "e75 noida sec 15", "9953188803", "12345"),
    UserInformation("Raj", "Delhi", "9953188803", "vjvjh"),
    UserInformation("Ravi", "Mumbai", "9953188803", "ghjhgk")
  )

  override def addUser(newUser: UserInformation): Boolean = {

    if (List() == user.filter(_.phone == newUser.phone)) {
      true
    }
    else {

      false
    }
  }

  override def loginUser(mobile: String, password: String): Boolean = {

    if (List() != user.filter(_.phone == mobile).filter(_.password == password)) {
      true
    }
    else {
      false
    }

  }

  implicit def tokenGenerate(token: String): String = {

    token.hashCode + Random.nextInt().toString
  }
}
