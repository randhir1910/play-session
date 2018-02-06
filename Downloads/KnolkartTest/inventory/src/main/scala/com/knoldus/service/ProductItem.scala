package com.knoldus.service

import com.knoldus.Const.Constant
import com.knoldus.module.{Item, Products}


class ProductItem extends Item {

  val itemDb: List[Products] = List(Constant.item1,Constant.item2,Constant.item3,Constant.item4,Constant.item5,Constant.item6,Constant.item1)

  override def search(itemName: String): List[Products] = {

    itemDb.filter(_.itemName == itemName)
  }

  override def priceHighToLow(): List[Products] = {

    itemDb.sortWith(_.price > _.price)
  }

  override def priceLowToHigh(): List[Products] = {

    itemDb.sortWith(_.price < _.price)

  }

  override def ratingHighToLow(): List[Products] = {

    itemDb.sortWith(_.rating > _.rating)

  }

  override def ratingLowToHigh(): List[Products] = {

    itemDb.sortWith(_.rating < _.rating)

  }
}
