@tag
  Feature: Purchase the order from Ecommerce Website

    Background:
      Given I landed on Ecommerce Page
    @Regression
    Scenario Outline: Positive Test of Submitting the order
      Given Logged in with username <name> and password <password>
      When I add the product <productName> to Cart
      Then Checkout <productName> and submit the order




      Examples:
        |name                   | password    | productName|
        |palfirobert14@yahoo.com|Robertpalfi15|ZARA COAT 3 |
