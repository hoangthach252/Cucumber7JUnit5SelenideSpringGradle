@regression @login
Feature: Login

  @id-002
  Scenario: Add search result picture into new Collection 2.
    Given the user is on the main page
    And the user goes to Login Page
    And the user logs in "zenautomator101" credential
    Then the user is redirected to Home Page

  @id-003
  Scenario: Add search result picture into new Collection 3.
    Given the user is on the main page
    And the user goes to Login Page
    And the user logs in "zenautomator101" credential
    Then the user is redirected to Home Page
