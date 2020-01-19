Feature: Add new delivery Address
  Scenario Outline: Add new delivery address
    Given I open a site prod-kurs.coderslab.pl
    When I click log in button
    And I fill log in form by "<email>" "<password>"
    And I click Addresses button
    And I click Create new address button
    And I fill the form by "<alias>" "<address>" "<city>" "<postcode>"
    Then I have new address added to my addresses
    Examples:
    |alias|email                        |password |address         |city     |postcode|
    |Praca|michal.dobrzycki@coderslab.pl|CodersLab|ul. Wroclawska 1|Wroclaw  |50-001  |
