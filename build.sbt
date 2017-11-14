sbtPlugin := true

organization := "io.teamscala.sbt"

name := "sbt-babel"

description := "An SBT plugin to perform Babel compilation."

scalaVersion := "2.10.6"

resolvers += Resolver.typesafeRepo("releases")

libraryDependencies ++= Seq(
  "com.typesafe" % "jstranspiler" % "1.0.1"
)

addSbtPlugin("com.typesafe.sbt" %% "sbt-js-engine" % "1.2.2")

licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT"))
