lazy val settings = Seq(
  scalaVersion := "2.11.7",
  testFrameworks += new TestFramework("scalaprops.ScalapropsFramework"),
  parallelExecution in Test := false,
  libraryDependencies += "com.github.scalaprops" %% "scalaprops" % "0.2.1" % "test"
)

lazy val root = project.in(file("."))
  .settings(settings: _*)
  .settings(libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test")
  .dependsOn(macros)

lazy val macros = project.in(file("macros"))
  .settings(settings: _*)
  .settings(
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % scalaVersion.value,
      compilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full))
  )
