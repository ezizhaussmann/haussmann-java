@ReportingModuleRegressionTest
Feature: Reporting Manager can see all different reports
  @ProductMostViewedReport
  Scenario: reporting manager can see products most viewed report
    Given reporting manager is already on the reporting dashboard
    When reporting manager should be able to see products most viewed report
    Then reporting manager verify products most viewed report successful displayed
