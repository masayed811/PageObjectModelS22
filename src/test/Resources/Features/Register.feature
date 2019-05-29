@register
Feature: User should able to register
  Scenario:
    Given user is on register page
    When user enters all registration details
    Then user should able to register successfully