Feature: Register and Login for Insurance
  GuruInsurance is a page where the user can register and login to see the insurance

  Scenario: User goes to the register page
    Given Open GuruInsurance page
    When User clicks register button
    Then User should see "Title"

  Scenario: User fills registration form
    Given Open GuruInsurance page
    When User clicks register button
    And User fills registration form
    Then User should see "Log in"

  Scenario: User logs in successfully
    Given Open GuruInsurance page
    When User clicks register button
    And User fills registration form
    And User logs in
    Then User should see "Broker Insurance WebPage"