Feature:
  As a User
  I should be able to Login to the application
  So that I can search for items and save it in cart

  Background:
    Given I launch the app

  @coke
  Scenario: As a User I should be able to navigate to the Login Page on clicking the Login Link
    When I click on the Login Link
    Then I should be navigated to Login Page

  Scenario: As a User I should be able to Login to the app by entering credentials
    When I click on the Login Link
    And I enter credentials and continue
    Then I should be able to Login

