Feature: We can retrieve service2 information

  Scenario: We can retrieve service2 information
    When I request service2 information
    Then I validate service2 information
