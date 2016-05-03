# sbt-babel [![Build Status](https://travis-ci.org/zenato/sbt-babel.svg?branch=master)](https://travis-ci.org/zenato/sbt-babel)

An SBT plugin to perform [Babel](http://babeljs.io) compilation.


Installation
------------

To use this plugin use the addSbtPlugin command within your project's `plugins.sbt` file:

```scala
addSbtPlugin("io.teamscala.sbt" % "sbt-babel" % "1.0.4")
```

Your project's build file also needs to enable sbt-web plugins. For example with `build.sbt`:

```scala
lazy val root = (project in file(".")).enablePlugins(SbtWeb)

JsEngineKeys.engineType := JsEngineKeys.EngineType.Node
```

Install babel-core, either globally with npm:

```shell
npm install babel-core -g
```

Or locally in your project with a `package.json` file:

```json
{
  "devDependencies": {
    "babel-core": "^6.8.0",
    "babel-preset-stage-0" // If you needed more..
  }
}
```

Usage
------------

For example with `build.sbt`:
```scala
BabelKeys.options := WebJs.JS.Object(
  "presets" -> List("stage-0")
  // More options ...
)
```

Or locally in your project with a `.babelrc` file:
```json
{
  "presets": ["stage-0"]
}
```
