Feature: Serravalle Website Journey

Scenario: Verify address details
  Given user is on the Serravalle Website
  When user click on the ham burger menu
  Then address detail are displayed

Scenario: Verify visit journey
  Given user is on the Serravalle Website
  When user click on visit option and answer the questions
  Then Home Page is displayed

  Scenario Outline: Verify Header menu links
    Given user is on the Serravalle Website
    And user click on the ham burger menu
    When on clicking "<Link>"
    Then "<URL>" is open
    Examples:
    |Link|URL|
    |Boutiques|Stores|
    |Your Visit|plan-your-visit|
    |Things to Do |what-on|
    |Eat & Drink   |food-drink|
    |Current Offers|offers    |

  Scenario: Verify Social links
    Given user is on the Serravalle Website
    And user click on the ham burger menu
    Then Social Links are displayed