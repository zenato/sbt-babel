sbtPlugin := true

organization := "io.teamscala.sbt"

name := "sbt-babel"

scalaVersion := "2.10.5"

resolvers += Resolver.bintrayRepo("zenato", "sbt-plugins")
resolvers += Resolver.typesafeRepo("releases")

libraryDependencies ++= Seq(
  "com.typesafe" % "jstranspiler" % "1.0.0"
  /*
  "org.webjars.npm" % "babel-core" % "5.6.15",
  "org.webjars.npm" % "mkdirp" % "0.5.1",
  "org.webjars.npm" % "when" % "3.7.3"
  */
)

addSbtPlugin("com.typesafe.sbt" %% "sbt-js-engine" % "1.1.3")

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
