@api
Feature: User API Operations

  Scenario: Get a user by ID
    Given the user ID is "60d0fe4f5311236168a109ca"
    When I send GET request to the user endpoint
    Then the response status code should be 200
    And the user data should contain "firstName"

  Scenario: Try to get a non-existing user
    Given the user ID is "nonexistentid"
    When I send GET request to the user endpoint
    Then the response status code should be 404