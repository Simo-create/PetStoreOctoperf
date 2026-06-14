Feature: Login test
  # Author: Simona Nedel
  # Description: Tests for the Login feature of the website Petstore
  # https://petstore.octoperf.com/

  Scenario: Enter the home page
    Given Open the JPetHomePage
    When Click on Enter the Store
    Then The JPetStore page is displayed

  Scenario: User navigates to Sign In page
    Given Open the JPetHomePage
    When Click on Enter the Store
    And Click on Sign In
    Then Login page is displayed

  Scenario: Login with valid credentials
    Given User is on Login page
    When Enter username "j2ee"
    And Enter password "j2ee"
    And Click on Login
    Then User is logged in successfully

  Scenario: Login with empty credentials
    Given User is on Login page
    When Click on Login
    Then Validation message is displayed