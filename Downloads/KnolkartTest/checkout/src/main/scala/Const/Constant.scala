package Const

case class Products(itemName: String, description: String, vendor: String, price: Double, rating: Double, count: Int)
object Constant {
  //scalastyle:off
  val item1 = Products("Mobile", "galaxy s8", " Samsung india", 53000, 4.4, 6)
  val item2 = Products("Mobile", "iphone x", "Apple India", 89000, 4.2, 6)
  val item3 = Products("Mobile", "one plus 5T", "OnePlus india", 33000, 4.5, 6)
  val item4 = Products("Mobile", "Pixel 2", "Google india", 65000, 4.1, 6)
  val item5 = Products("Laptop", "MacBook pro", "Apple india", 165000, 4.0, 6)
  val item6 = Products("Laptop", "inspiron", "Dell india", 65000, 4.1, 6)
  val item7 = Products("Laptop", "Yoga", "Lenovo india", 55000, 3.8, 6)

}
