package edu.knoldus.model


trait user {

  def addUser(newUser: UserInformation): Boolean


  def loginUser(mobile: String, password: String): Boolean
}
