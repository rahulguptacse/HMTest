Feature: Serravalle Website Journey

Scenario: Verify address details under Ham Burger Menu
  Given user is on the Serravalle Website
  When user click on the ham burger menu
  Then address detail are displayed

  Scenario Outline: Verify Header menu links under Ham Burger Menu
    Given user is on the Serravalle Website
    And user click on the ham burger menu
    When on clicking "<Link>"
    Then "<URL>" is open
    Examples:
    |Link|URL|
    |Boutiques|stores|
    |Your Visit|plan-your-visit|
    |Things to Do |whats-on|
    |Eat & Drink   |food-drink|
    |Current Offers|offers    |

  Scenario: Verify Social links under Ham Burger Menu
    Given user is on the Serravalle Website
    And user click on the ham burger menu
    Then Social Links are displayed

  Scenario: Verify visit journey on the Home page
    Given user is on the Serravalle Website
    When user click on visit option and answer the questions
    Then Home Page is displayed

  Scenario: Verify Footer on the Home page
    Given user is on the Serravalle Website
    When user scroll to footer
    Then Footer items are displayed