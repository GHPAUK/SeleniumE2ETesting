Feature: Changing password

  Scenario: Changing password
    Given the user clicks change password
    When the user changes their password
    Then the password has been changed