Feature: us2
  In order to retrieve some or all of my savings
  As a bank client
  I want to make a withdrawal from my account

  Background: I have a provisioned account
    Given I have an empty account

  Scenario: I make one withdrawal from my account
    Given I have an deposit operation of 100 Euros
    When I withdraw 60 Euros
    Then My balance should be 40 Euros

  Scenario: I make multiple withdrawals from my account
    Given I have an deposit operation of 100 Euros
    When I withdraw 20 Euros
    And I withdraw 20 Euros
    Then My balance should be 60 Euros
