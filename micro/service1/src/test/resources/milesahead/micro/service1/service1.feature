Feature: We can retrieve service1 information

  Scenario: We can retrieve service1 information
    When I request service1 information
    Then I validate service1 information
