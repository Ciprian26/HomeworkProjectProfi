@UI
Feature: Register using email option

  @Run
  Scenario: Register
    Given random email is generated and saved
    And user navigates to PROFIT_PAGE
    And user is on PROFIT_PAGE
    When new user is registered with random email
    And user activates new account
    Then user is redirected to PROFIT_PAGE
    And user is logged-in
