lazy val commonSettings = Seq(
  name := "sbt-babel",
  organization := "io.teamscala.sbt",
  description := "An SBT plugin to perform Babel compilation.",
  licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT")),
  scalaVersion := "2.10.5"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    sbtPlugin := true,

    resolvers += Resolver.typesafeRepo("releases"),

    libraryDependencies ++= Seq(
      "com.typesafe" % "jstranspiler" % "1.0.0"
      //"org.webjars.npm" % "babel-core" % "5.6.15",
      //"org.webjars.npm" % "mkdirp" % "0.5.1",
      //"org.webjars.npm" % "when" % "3.7.3"
    ),

    addSbtPlugin("com.typesafe.sbt" %% "sbt-js-engine" % "1.1.3")
  )
