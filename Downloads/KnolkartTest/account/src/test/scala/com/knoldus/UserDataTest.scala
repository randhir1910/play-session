package com.knoldus

import edu.knoldus.model.{UserData, UserInformation}
import org.scalatest.FunSuite

class UserDataTest extends FunSuite {

  val user = new UserData

  val userList: List[UserInformation] = List(UserInformation("Randhir", "e75 noida sec 15", "9953188803", "12345")
    , UserInformation("Ravi", "Delhi", "7503385689", "123456"))

  test("check for add user") {

    assert(user.addUser(UserInformation("Ravi", "Delhi", "7503385689", "123456")) == userList)
  }

  test("check for login user") {
    assert(user.loginUser("9953188803", "12345"))
    assert(!user.loginUser("9953188803", "123458"))
  }

}
