package com.knoldus

import edu.knoldus.model.{UserData, UserInformation}
import org.scalatest.FunSuite

class UserDataTest extends FunSuite {

  val user = new UserData

  val userList: List[UserInformation] = List(UserInformation("Randhir", "randhir1910", "e75 noida sec 15", "9953188803", "12345")
    , UserInformation("Ravi", "ravi1995", "Delhi", "7503385689", "123456"))

  val userExist = List(UserInformation("Randhir", "randhir1910", "e75 noida sec 15", "9953188803", "12345"))

  test("check for add user") {

    assert(user.addUser(UserInformation("Ravi", "ravi1995", "Delhi", "7503385689", "123456")) == userList)
    assert(user.addUser(UserInformation("Randhir", "randhir1910", "Delhi", "9953188803", "123909")) == userExist)
  }

  test("check for login user") {
    assert(user.loginUser("randhir1910", "12345"))
    assert(!user.loginUser("9953188803", "123458"))
  }

  test("get all user") {
    assert(user.getAllUser() == List(UserInformation("Randhir", "randhir1910", "e75 noida sec 15", "9953188803", "12345")))
  }
}
