@regression @add-collection
Feature: Add Collection

  @id-001 @add-search-result
  Scenario: Add search result picture into new Collection 1.
    Given the user is on the main page
    And the user goes to Login Page
    And the user logs in "zenautomator101" credential
    When he searches pics with keyword "Cute Puppies"
    And he adds the first image into new collection name "Cute Puppies Collection"
    And he navigates to his collection page
    Then he can see the new collection is added in his collection

