Feature: Login Functionality

  Scenario: Verify user can log in with valid credentials
    Given user navigates to login page
    When user enters username "Admin" and password "admin123"
    And clicks on login button
    Then user should see the homepage