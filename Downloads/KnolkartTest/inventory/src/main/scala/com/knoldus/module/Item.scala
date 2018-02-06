package com.knoldus.module

trait Item {


  def search(itemName: String): List[Products]

  def priceLowToHigh(): List[Products]

  def priceHighToLow(): List[Products]

  def ratingLowToHigh(): List[Products]

  def ratingHighToLow(): List[Products]


}
