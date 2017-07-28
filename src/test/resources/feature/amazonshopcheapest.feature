Feature: Amazon Shop for the cheapest item
  As a new customer (Not logged in) on Amazon,
  I want to be able to shop for an item I want,
  to look for the cheapest item available and add to the basket

  Scenario: Search an item
    Given Amazon Homepage is open
    When I search for item "iphone"
    Then I see the search results page
    And I verify the price for first 5 results

  Scenario: Sort item by Lowest Price
    Given I see the search results page
    And I see the sort dropdown in results page
    When I select sort by Lowest Price
    Then I see the results sorted by Lowest Price
    And I verify the price for first 5 results

  Scenario: Select First Lowest Price Product Result
    Given I see the results sorted by Lowest Price
    When I select the First item
    Then I am on the Product Details Page

  Scenario: Add Lowest Price Product to Basket
    Given I am on the Product Details Page
    When I click Add to Basket Link
    Then I see the notification of the item added to the basket

  Scenario: Verify cheapest item is added to the basket
    Given I see the notification of the item added to the basket
    When I click on the Basket button
    Then I go to Basket page
    And I see the cheapest item added to the basket