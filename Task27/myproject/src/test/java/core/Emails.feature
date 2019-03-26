Feature: Test emails pages

  @login
  Scenario: Test login page
    Given Main application page is opened
    When Enter correct user login and password
    Then Logout link is displayed