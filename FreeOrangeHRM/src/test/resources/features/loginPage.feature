Feature: OrangeHRM Login

  As a user
  I want to login to OrangeHRM
  So that I can access the dashboard


  Scenario Outline: Login with valid credentials

    Given user is on the OrangeHRM login page
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on login button
    Then OrangeHRM dashboard should be displayed

    Examples:
      | username | password |
      | Admin    | admin123 |