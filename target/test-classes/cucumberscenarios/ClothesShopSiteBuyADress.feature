Feature: Purchasing A Dress

  Scenario: Buy A Dress
    Given I have navigated to the sites dresses products page
    And I have added a chosen dress to my basket
    When I proceed to checkout, input all my details and confirm payment
    Then I will receive a purchase successful confirmation notification