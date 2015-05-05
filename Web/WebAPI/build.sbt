name := "WebAPI"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "org.mongodb" % "mongo-java-driver" % "3.0.0-beta3",
  "com.google.code.gson" % "gson" % "2.3.1"
)     

play.Project.playJavaSettings
