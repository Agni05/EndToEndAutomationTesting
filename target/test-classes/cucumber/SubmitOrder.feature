@tag
Feature: Ecommerce Website Testing

  Background:
  Given I landed on the Ecommerce Page


 @SubmitOrder
 Scenario Outline: Submit Order Test
   Given I want to log in with <email> and <password>
   When I add the product <pname> to the cart
   And I checkout the product <pname>
   And I search for <country> and click on it
   And I submit the order
   Then "THANKYOU FOR THE ORDER." message is displayed

    Examples: 
      |email									|	password		|	pname						|			country			|
      |agnivo.test@yopmail.com|	Agnivo@2001	|	ZARA COAT 3			|				india			|
      |agni.test@yopmail.com	|	Agnivo@2001	| ADIDAS ORIGINAL	|	united states		|
      
  @OrderHistoryTest
  Scenario Outline: Order History Fuctionality Testing
    Given I want to log in with <email> and <password>
    When I clicked on order button
    Then I verify <pname> is available in order section

    Examples: 
      |email									|	password		|	pname						|
      |agnivo.test@yopmail.com|	Agnivo@2001	|	ZARA COAT 3			|
      |agni.test@yopmail.com	|	Agnivo@2001	| ADIDAS ORIGINAL	|
