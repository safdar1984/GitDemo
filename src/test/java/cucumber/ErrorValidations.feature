
@tag
Feature: Error validation
  I want to use this template for my feature file


Background: 
	Given I landed on Ecommerce page
	
  @Regression
  Scenario Outline: Positive Test of Submitting the order
    Given I landed on Ecommerce page
    When Logged in with username <name> and password <password>
    
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name  									| password 	| productName		|
      | raosafdarraza@gmail.com | S@fdar124 | ZARA COAT 3 	|