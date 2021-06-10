Feature: us1
  In order to save money
  As a bank client
  I want to make a deposit in my account

  Background: I have a new empty account
    Given I have an empty account

  Scenario: I make one deposit on my account
    Given I have an deposit operation of 100 Euros
    When I deposit 100 Euros
    Then My balance should be 200 Euros

  Scenario: I make multiple deposits on my account
    Given I have an deposit operation of 100 Euros
    When I deposit 50 Euros
    And I deposit 50 Euros
    And I deposit 50 Euros
    And I deposit 50 Euros
    Then My balance should be 300 Euros
