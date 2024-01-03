Feature:
  As a user I want to get user data by GET request
  Scenario: First BDD test
    When I sent request to user API
    Then User get user data

Scenario Outline: First BDD test
  When I sent request to user API
  Then User get <file> user data diff files
  Examples:
    | file      |  |
    | body.json |  |