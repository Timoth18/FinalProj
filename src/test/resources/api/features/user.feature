@api
Feature: Valid API operations using dummyapi.io

  Scenario: Get a user by valid ID
    Given the user ID is "60d0fe4f5311236168a109ca"
    When I send GET request to the user endpoint
    Then the response status code should be 200
    And the user data should contain "firstName"

  Scenario: Try to get a non-existing user (Negative)
    Given the user ID is "invalidid1234567890"
    When I send GET request to the user endpoint
    Then the response status code should be 404

  Scenario: Get list of users
    When I send GET request to the users endpoint
    Then the response status code should be 200
    And the response should contain "data"

  Scenario: Get tags
    When I send GET request to the tags endpoint
    Then the response status code should be 200
    And the response should contain "tags"

  Scenario: Get paginated list of users
    When I send GET request to the users page endpoint with page 1 and limit 5
    Then the response status code should be 200
    And the response should contain "data"