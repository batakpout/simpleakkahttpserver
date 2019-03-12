name := "akkahttp"

version := "0.1"

scalaVersion := "2.12.8"

mainClass in(Compile, packageBin) := Some("Main")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.13",
  "com.typesafe.akka" %% "akka-stream" % "2.5.13",
  "com.typesafe.akka" %% "akka-http" % "10.1.3"
)