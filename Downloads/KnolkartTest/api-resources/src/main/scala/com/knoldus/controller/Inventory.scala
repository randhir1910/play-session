package com.knoldus.controller

import com.knoldus.module.{Inventory, ProductItem, Products}

class Inventory {

  val itemObject: Inventory = new ProductItem

  def inventorySearch(index: String, itemName: String = "Mobile"): List[Products] = {

    index match {

      case "search" => itemObject.search(itemName)
      case "priceLowToHigh" => itemObject.filterByLowToHighPrice()
      case "priceHighToLow" => itemObject.priceHighToLow()
      case "ratingHighToLow" => itemObject.filterByHighToLowRating()
      case "ratingLowToHigh" => itemObject.filterByLowToHighRating()
      case _ => List()
    }
  }
}
