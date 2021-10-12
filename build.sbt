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
      "ch.qos.logback"         % "logback-classic" % LogbackVersion,
      "org.scalatest"         %% "scalatest"       % ScalaTestVersion          % Test,
      "org.scalatestplus"     %% "mockito-3-4"     % (ScalaTestVersion + ".0") % Test,
      "org.scalactic"         %% "scalactic"       % ScalaTestVersion          % Test,
      "com.vladsch.flexmark"   % "flexmark-all"    % FlexmarkVersion           % Test
    ),
    addCompilerPlugin("org.typelevel" %% "kind-projector"     % "0.13.2" cross CrossVersion.full),
    addCompilerPlugin("com.olegpy"    %% "better-monadic-for" % "0.3.1")
  )
