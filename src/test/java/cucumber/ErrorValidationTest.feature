@tag
Feature: Negative Testing

  @tag2
  Scenario Outline: Error Validation testing
    Given I landed on the Ecommerce Page
    When I want to log in with <email> and <password>
    Then I verify the "Incorrect email or password." message is displayed

    Examples: 
      |email									|	password		|
      |agnivo.test@yopmail.com|	Agnivo@20		|
