@tag
Feature: Error Validation

  @ErrorValidation
  Scenario Outline: Positive Test of Submitting the order
    Given I landed on Ecommerce Page
    When Logged in with username <name> and password <password>
    Then Verify toast if the text is "Incorrect email or password."




    Examples:
      |name                   | password    |
      |palfirobert14@yahoo.com|Robertpalfi151|
