package com.knoldus.controller

import com.knoldus.module.{Item, Products}
import com.knoldus.service.ProductItem

class Inventory {

  val itemObject: Item = new ProductItem

  def inventorySearch(index: String, itemName: String = "Mobile"): List[Products] = {

    index match {

      case "search" => itemObject.search(itemName)
      case "priceLowToHigh" => itemObject.priceLowToHigh()
      case "priceHighToLow" => itemObject.priceHighToLow()
      case "ratingHighToLow" => itemObject.ratingHighToLow()
      case "ratingLowToHigh" => itemObject.ratingLowToHigh()
      case _ => List()
    }
  }
}
