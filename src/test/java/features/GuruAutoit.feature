Feature: Become an Instructor
  GuruAutoIt is a page where the user can apply to be an instructor

  Scenario: User clicks 'Create A Course'
    Given Open GuruAutoIt page
    When User clicks Create Course
    Then User sees "3 steps"

  Scenario: User submits form Success
    Given Open GuruAutoIt page
    When User fills form
    And User clicks Submit
    Then User sees "Thank You!"
