val PureConfigVersion = "0.17.0"
val EnumeratumVersion = "1.7.0"
val LogbackVersion    = "1.2.6"
val ScalaTestVersion  = "3.2.10"
val FlexmarkVersion   = "0.62.2"

scalafmtOnCompile := true

lazy val root = (project in file("."))
  .settings(
    organization := "com.github.thealgorithms",
    name         := "TheAlgorithmsScala",
    version      := "0.2.0-SNAPSHOT",
    scalaVersion := "2.13.6",
    libraryDependencies ++= Seq(
      "com.beachape"          %% "enumeratum"      % EnumeratumVersion,
      "com.github.pureconfig" %% "pureconfig"      % PureConfigVersion,
      "ch.qos.logback" %% "logback-core" % LogbackVersion,
      "ch.qos.logback"         %% "logback-classic" % LogbackVersion,
      "org.apache.kafka" %% "kafka-streams-scala" % "2.7.0",
      "org.apache.kafka" %% "kafka-streams-test-utils" % "2.7.0" % "test",
      "org.slf4j"        %% "slf4j-api" % "1.7.22",
      "org.scalatest"         %% "scalatest"       % ScalaTestVersion          % Test,
      "org.scalatestplus"     %% "mockito-3-4"     % (ScalaTestVersion + ".0") % Test,
      "org.scalactic"         %% "scalactic"       % ScalaTestVersion          % Test,
      "com.vladsch.flexmark"   % "flexmark-all"    % FlexmarkVersion           % Test
    ),
    addCompilerPlugin("org.typelevel" %% "kind-projector"     % "0.13.2" cross CrossVersion.full),
    addCompilerPlugin("com.olegpy"    %% "better-monadic-for" % "0.3.1")
  )
