@web
Feature: Homepage Functionality

  Scenario: Open demoblaze homepage
    Given I navigate to the demoblaze homepage
    Then I should see the logo

  Scenario: Check categories exist
    Given I navigate to the demoblaze homepage
    Then I should see the "CATEGORIES" section