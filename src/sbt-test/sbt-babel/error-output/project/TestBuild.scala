import java.util.concurrent.atomic.AtomicInteger

import com.typesafe.sbt.web.SbtWeb
import com.typesafe.sbt.web.SbtWeb.autoImport._
import sbt.Keys._
import sbt._

object TestBuild extends Build {

  class TestLogger(target: File) extends Logger {
    val unrecognisedInputCount = new AtomicInteger(0)

    def trace(t: => Throwable): Unit = {}

    def success(message: => String): Unit = {}

    def log(level: Level.Value, message: => String): Unit = {
      if (level == Level.Error) {
        if (message.contains( """ParseError: expected "indent", got "=="""")) {
          if (unrecognisedInputCount.addAndGet(1) == 1) {
            IO.touch(target / "unrecognised-input-error")
          }
        }
      }
    }
  }

  class TestReporter(target: File) extends LoggerReporter(-1, new TestLogger(target))

  lazy val root = Project(
    id = "test-build",
    base = file("."),
    settings = Seq(WebKeys.reporter := new TestReporter(target.value))
  ).enablePlugins(SbtWeb)

}