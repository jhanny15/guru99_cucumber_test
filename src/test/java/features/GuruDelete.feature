Feature: Delete a customer
  GuruDelete is a page where the user can delete a customer's name.

  Scenario: User submits Customer
    Given Open GuruDelete page
    When User types "prova"
    And User clicks submit button
    Then User sees confirm button

  Scenario: User deletes Customer
    Given Open GuruDelete page
    When User types "prova"
    And User clicks submit button
    Then User sees confirm button
    And User clicks confirm
    Then User sees success alert