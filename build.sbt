
organization in ThisBuild := "org.user"
version in ThisBuild := "1.0-SNAPSHOT"

// the Scala version that will be used for cross-compiled libraries
scalaVersion in ThisBuild := "2.13.0"

lazy val `user-mgmt` = (project in file("."))
  .aggregate(`user-mgmt-api`, `user-mgmt-impl`,`product-service-api`,`product-service-impl`)

lazy val `user-mgmt-api` = (project in file("user-mgmt-api"))
  .settings(common)
  .settings(
    libraryDependencies ++= Seq(
      lagomJavadslApi,
      lombok
    )
  )

lazy val `user-mgmt-impl` = (project in file("user-mgmt-impl"))
  .enablePlugins(LagomJava)
  .settings(common)
  .settings(
    libraryDependencies ++= Seq(
      lagomJavadslPersistenceCassandra,
      lagomJavadslKafkaBroker,
      lagomLogback,
      lagomJavadslTestKit,
      lombok
    )
  )
  .settings(lagomForkedTestSettings)
  .dependsOn(`user-mgmt-api`)
lazy val `product-service-api` = (project in file("product-service-api"))
  .settings(common)
  .settings(
    libraryDependencies ++= Seq(
      lagomJavadslApi,
      lombok
    )
  )

lazy val `product-service-impl` = (project in file("product-service-impl"))
  .enablePlugins(LagomJava)
  .settings(common)
  .settings(
    libraryDependencies ++= Seq(
      lagomJavadslPersistenceCassandra,
      lagomJavadslKafkaBroker,
      lagomLogback,
      lagomJavadslTestKit,
      lombok
    )
  )
  .settings(lagomForkedTestSettings)
  .dependsOn(`product-service-api`,`user-mgmt-api`)


val lombok = "org.projectlombok" % "lombok" % "1.18.8"

def common = Seq(
  javacOptions in Compile += "-parameters"
)
