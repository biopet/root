organization := "nl.biopet"
name := "biopetRoot"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.11"

resolvers += Resolver.mavenLocal

lazy val biopetRoot = (project in file("."))
  .aggregate(biopetSummary, biopetSummaryTool, biopetReport, biopetUtils, biopetTools)

lazy val biopetUtils = project in file("biopet-utils")
lazy val biopetTools = (project in file("biopet-tools"))
  .dependsOn(biopetUtils)
lazy val biopetSummary = (project in file("biopet-summary"))
  .dependsOn(biopetUtils)
lazy val biopetSummaryTool = (project in file("biopet-summary-tool"))
  .dependsOn(biopetSummary, biopetUtils)
lazy val biopetReport = (project in file("biopet-report"))
  .enablePlugins(PlayScala)
  .dependsOn(biopetSummary, biopetUtils)
