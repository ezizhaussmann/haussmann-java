@StoreModuleRegressionTest
Feature: Store manager can manage orders,products,product categories,website and stores.
  @ViewAllStores
  Scenario:Store Manager can view all stores
    Given store manage is on manage stories page
    When store manager view all stores
    Then view all stores successfully

