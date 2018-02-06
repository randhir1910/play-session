
lazy val commonSettings = Seq(

  name := "knolkart",

  version := "0.1",

  scalaVersion := "2.12.4",

  libraryDependencies += "log4j" % "log4j" % "1.2.17"

)


lazy val root = (project in file("."))
  .aggregate(account, inventory, checkout)

lazy val account = (project in file("account"))
  .settings(
    libraryDependencies += "log4j" % "log4j" % "1.2.17"
  )
lazy val inventory = (project in file("inventory"))
  .settings(
    libraryDependencies += "log4j" % "log4j" % "1.2.17"
  )

lazy val checkout = (project in file("checkout"))
  .settings(
    libraryDependencies += "log4j" % "log4j" % "1.2.17"
  ).dependsOn(inventory)

lazy val dashboard = (project in file("dashboard"))
  .settings(
    commonSettings,
  ).dependsOn(apiresouces, account)

lazy val apiresouces = (project in file("api-resources"))
  .settings(
    commonSettings,
  ).dependsOn(account, inventory)