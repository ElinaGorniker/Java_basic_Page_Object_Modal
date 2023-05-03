Feature: Shopping Automation
  Scenario: Testing authorization
    Given I go to the Website
    When I click on Sign In button
    And I specify my credentials and click Login
    Then I can log into the website

  Scenario: Testing the purchase of two items
    Given I go to the Website
    When I click Shop button
    And  I add one element to the cart
    And I go to cart

