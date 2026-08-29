Feature: OrangeHRM Login
  As an authorized OrangeHRM user
  I want to authenticate using my credentials
  So that I can securely access the OrangeHRM application

  Background:
    Given the user navigates to the OrangeHRM login page

  Scenario: Verify Login page is displayed
    Then the Username field should be displayed
    And the Password field should be displayed
    And the Login button should be displayed
    And the Forgot Password link should be displayed

 