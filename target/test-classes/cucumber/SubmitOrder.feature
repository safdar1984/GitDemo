
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

	Background: 
	Given I landed on Ecommerce page
	
  @tag2
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on Confirmation Page

    Examples: 
      | name  									| password 	| productName		|
      | raosafdarraza@gmail.com | S@fdar123 | ZARA COAT 3 	|
     
