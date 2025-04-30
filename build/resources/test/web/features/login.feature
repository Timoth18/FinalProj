@web
Feature: Web UI Tests for Demoblaze

  Scenario: Open homepage and verify title
    Given I navigate to the demoblaze homepage
    Then I should see the title "PRODUCT STORE"

  Scenario: View category Phones
    Given I navigate to the demoblaze homepage
    When I click on the "Phones" category
    Then I should see phones listed

  Scenario: Open a product from the homepage
    Given I navigate to the demoblaze homepage
    When I click on the first product
    Then I should see the product details

  Scenario: Try login with wrong credentials (Negative)
    Given I navigate to the demoblaze homepage
    When I login with "RANDOMUSERNAMEKOKOKO" and "wrongpass"
    Then I should see a login error

  Scenario: Add product to cart
    Given I navigate to the demoblaze homepage
    When I click on the first product
    And I add it to the cart
    Then I should see a confirmation alert

  Scenario: End-to-End Test - Add to cart and place order
    Given I navigate to the demoblaze homepage
    When I click on the first product
    And I add it to the cart
    And I should see a confirmation alert
    And I go to the cart and place the order with details
    Then I should see a purchase confirmation