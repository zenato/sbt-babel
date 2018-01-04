sbtPlugin := true

organization := "io.teamscala.sbt"

name := "sbt-babel"

description := "An SBT plugin to perform Babel compilation."

sbtVersion in Global := "1.0.4"

crossSbtVersions := Seq("1.0.4", "0.13.16")

crossScalaVersions := Seq("2.12.4", "2.10.7")

resolvers += Resolver.typesafeRepo("releases")

libraryDependencies ++= Seq(
  "com.typesafe" % "jstranspiler" % "1.0.1"
)

addSbtPlugin("com.typesafe.sbt" %% "sbt-js-engine" % "1.2.2")

licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT"))
