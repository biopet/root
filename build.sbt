name := "biopetRoot"

version := "1.0"

scalaVersion := "2.11.11"

lazy val biopetSummary = (project in file("biopet-summary"))
lazy val biopetSummaryTool = (project in file("biopet-summary-tool"))
  .dependsOn(biopetSummary)
lazy val biopetReport = (project in file("biopet-report"))
  .enablePlugins(PlayScala)
  .dependsOn(biopetSummary)
