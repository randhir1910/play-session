package edu.knoldus.model


trait user {

  def addUser(newUser: UserInformation): List[UserInformation]

  def loginUser(mobile: String, password: String): Boolean

  def getAllUser(): List[UserInformation]
}
