Feature: Filter Products
  As a shopper I want to filter out products based on various criteria in the catalogue so that it is easy for me to look for a product

  @Filter
  Scenario Outline: Filter by Brand
    Given I launch the app
    When I filter by category "Bags"
    Then I should see products belong to Category "Bags" in the results

  Examples:
    | category |
    | Bags     |
    | Mugs     |
    | Clothing |

  @Filter
  Scenario: Filter by Brand and see Price Range
    Given I launch the app
    When I filter by category "Bags"
    Then I should see the filter for price range
