package com.knoldus.controller

import edu.knoldus.model.{UserData, UserInformation, user}
import org.apache.log4j.Logger

class account {

  val userObject: user = new UserData
  val logger = Logger.getLogger(this.getClass)

  def addUser(name: String, address: String, mobile: String, password: String): Unit = {
    val user = UserInformation(name, address, mobile, password)
    if (userObject.addUser(user)) {
      // new checkout(user)
    }
    else {
      logger.info("mobile number already registered..")
    }
  }

  def userLogin(mobile: String, password: String): Unit = {

    if (userObject.loginUser(mobile, password)) {

    }
    else {
      logger.info("invalid userId or password ")
    }
  }
}
