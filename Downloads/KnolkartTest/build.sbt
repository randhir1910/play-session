
name := "knolkart"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies += "log4j" % "log4j" % "1.2.17"

coverageEnabled := true

lazy val root = (project in file("."))
  .aggregate(account, inventory, checkout)

lazy val account = (project in file("account"))
  .settings(
    libraryDependencies ++= Seq("log4j" % "log4j" % "1.2.17", "org.scalatest" % "scalatest_2.12" % "3.0.4" % "test"
    ))
lazy val inventory = (project in file("inventory"))
  .settings(
    libraryDependencies ++= Seq("log4j" % "log4j" % "1.2.17", "org.scalatest" % "scalatest_2.12" % "3.0.4" % "test")
  )

lazy val checkout = (project in file("checkout"))
  .settings(
    libraryDependencies ++= Seq("log4j" % "log4j" % "1.2.17", "org.scalatest" % "scalatest_2.12" % "3.0.4" % "test"
    )).dependsOn(inventory)

lazy val dashboard = (project in file("dashboard"))
  .settings(
    libraryDependencies ++= Seq("log4j" % "log4j" % "1.2.17", "org.scalatest" % "scalatest_2.12" % "3.0.4" % "test"
    )).dependsOn(apiresouces, account)

lazy val apiresouces = (project in file("api-resources"))
  .settings(
    libraryDependencies ++= Seq("log4j" % "log4j" % "1.2.17", "org.scalatest" % "scalatest_2.12" % "3.0.4" % "test"
    )).dependsOn(account, inventory)