Feature:
  As a shopper I want to search, add one or more products to shopping cart and buy them

  @smoke
  Scenario: Adding more than one items to shopping cart and verifying the details
    Given I launch the app
    When I add the following products
      | category | productName           | quantity |
      | Bags     | Ruby on Rails Tote    | 1        |
      | Mugs     | Ruby on Rails Mug     | 2        |
      | Clothing | Spree Baseball Jersey | 3        |
    Then I should see "6" Items in the Cart of Price "103.94"
    And I should be able to checkout as Guest