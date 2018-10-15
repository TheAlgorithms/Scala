name := "TheAlgorithmsScala"

version := "0.1"

scalaVersion := "2.12.7"
crossScalaVersions := Seq(scalaVersion.value, "2.11.12", "2.10.7") // keep versions in sync with .travis.yml

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"