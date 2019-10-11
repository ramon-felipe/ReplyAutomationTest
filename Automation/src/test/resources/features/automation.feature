Feature: Tests to Reply Company
  http://automationpractice.com

  @tag1
  Scenario Outline: Create an account and buy a dress
    Given I access the page <page>
    And I click on "Sign in" link
    And I create an account "<email>", "<firstName>", "<lastName>", "<password>", "<dayOfBirth>", "<monthOfBirth>", "<yearOfBirth>", "<company>", "<adress>", "<city>", "<state>", "<zipCode>", "<homePhone>", "<mobilePhone>"
    And I click on submenu "SUMMER DRESSES" of menu "DRESSES"
    And I add the first product to the kart
    And I click on "Proceed to checkout" link
    And I proceed to shipping section
    And I agree with terms and proceed to checkout
    When I select the payment method "Pay by bank wire" and confirm the order
    Then I validate the order confirmation

    Examples: 
      | page                                    | email    | firstName | lastName | password | dayOfBirth | monthOfBirth | yearOfBirth | company | adress     | city | state   | zipCode | homePhone | mobilePhone |
      | http://automationpractice.com/index.php | <RANDOM> | Arnold    | Zen      |    12345 |         10 |           12 |        1975 |         | Street One | abc  | Alabama |   54321 |           |   980887755 |
