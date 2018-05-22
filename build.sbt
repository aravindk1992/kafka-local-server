
name := "kafka-local-server"

version := "0.1"

scalaVersion := "2.12.6"

val scalaSettings = Seq(
  scalaVersion := "2.11.8",
  scalacOptions ++= Seq("-feature", "-unchecked", "-deprecation", "-encoding", "utf8")
)

val ConfluentRegistryVersion = "3.3.0"

resolvers ++= Seq(
  DefaultMavenRepository,
  Resolver.bintrayRepo("typesafe", "releases"),
  Resolver.sonatypeRepo("releases"),
  "Confluent Platform" at "http://packages.confluent.io/maven/",
  "Apache Releases" at "https://repository.apache.org/content/repositories/releases/",
  "Apache Snapshots" at "https://repository.apache.org/content/repositories/snapshots/",
  Resolver.mavenLocal
)

libraryDependencies += "org.apache.curator" % "curator-test" % "2.0.0-incubating"
libraryDependencies += "org.apache.kafka" %% "kafka" % "0.10.2.1"
libraryDependencies += "org.apache.avro"  %  "avro"  %  "1.8.2"
libraryDependencies +="io.confluent" % "kafka-schema-registry" % ConfluentRegistryVersion excludeAll(
  ExclusionRule(organization = "org.slf4j", name = "slf4j-log4j12"),
  ExclusionRule(organization = "log4j", name = "log4j")
)
libraryDependencies += "io.confluent" % "kafka-schema-registry-client" % ConfluentRegistryVersion excludeAll(
  ExclusionRule(organization = "org.slf4j", name = "slf4j-log4j12"),
  ExclusionRule(organization = "log4j", name = "log4j")
)
