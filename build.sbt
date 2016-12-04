name := "trucking-shared"

version := "0.1"

organization := "com.hortonworks.orendainx"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  /*
   * As a shared library meant only for keeping trucking components consistent,
   * we don't need to export any dependencies.  Marking dependencies as 'provided'.
   */
  "org.apache.storm" % "storm-core" % "1.0.2" % "provided"
)

// TODO: Better way to resolve this specific conflict.
fork := true
scalacOptions += "-Yresolve-term-conflict:package"
