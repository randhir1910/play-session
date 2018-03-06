package view

import Const.Constant
import com.knoldus.controller.{Inventory, account}
import com.knoldus.module.Products
import org.apache.log4j.Logger

object HomePage extends App {

  val logger = Logger.getLogger(this.getClass)

  logger.info("1.Register User \n 2. Login User \n 3. View Item \n")
  val validate = readInt()
  validate match {
    case Constant.One => val user = new account
      logger.info("Enter name  ")
      val name = readLine()
      logger.info("Enter username ")
      val userName = readLine()
      logger.info("Enter address  ")
      val address = readLine()
      logger.info("Enter mobile ")
      val mobile = readLine()
      logger.info("Enter  password ")
      val password = readLine()
      user.addUser(name, userName,address, mobile, password)
    case Constant.Two => val user = new account
      logger.info("Enter mobile ")
      val mobile = readLine()
      logger.info("Enter  password ")
      val password = readLine()
      user.userLogin(mobile, password)
    case Constant.Three => logger.info("1.Search Item  By Name \n 2.HighTLow Price \n 3.LowToHigh Price \n " +
      "4.LowToHigh Rating \n 5.HighToLow Rating \n")
      val choice = readInt()
      val product = new Inventory
      choice match {
        case Constant.One => logger.info("enter item name ")
          val itemName = readLine()
          val item: List[Products] = product.inventorySearch("search", itemName)
          if (!item.isEmpty) {
            for (product <- item) {
              logger.info(product + "\n")
            }
          }
          else {
            logger.info("Product Not found ")
          }
        case Constant.Two =>
          val item: List[Products] = product.inventorySearch("priceHighToLow")
          if (!item.isEmpty) {
            for (product <- item) {
              logger.info(product + "\n")
            }
          }
          else {
            logger.info("Product Not found ")
          }
        case Constant.Three =>
          val item: List[Products] = product.inventorySearch("priceLowToHigh")
          if (!item.isEmpty) {
            for (product <- item) {
              logger.info(product + "\n")
            }
          }
          else {
            logger.info("Product Not found ")
          }
        case Constant.Four =>
          val item: List[Products] = product.inventorySearch("ratingLowToHigh")
          if (!item.isEmpty) {
            for (product <- item) {
              logger.info(product + "\n")
            }
          }
          else {
            logger.info("Product Not found ")
          }
        case _ =>
          val item: List[Products] = product.inventorySearch("ratingHighToLow")
          if (!item.isEmpty) {
            for (product <- item) {
              logger.info(product + "\n")
            }
          }
          else {
            logger.info("Product Not found ")
          }
      }
  }
}
