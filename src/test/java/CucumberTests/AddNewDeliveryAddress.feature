Feature: Add new delivery Address
  Scenario Outline: Add new delivery address
    Given I open a site prod-kurs.coderslab.pl
    When I click log in button
    And I fill log in form by "<email>" "<password>"
    And I click Addresses button
    And I click Create new address button
    And I fill the form by "<address>" "<city>" "<postcode>"
    Then I have new address added to my addresses
    Examples:
    |email                        |password |address         |city     |postcode|
    |michal.dobrzycki@coderslab.pl|CodersLab|ul. Wroclawska 1|Wroclaw  |50-001  |
    |michal.dobrzycki@coderslab.pl|CodersLab|ul. Milicka 2   |Trzebnica|55-100  |
    |michal.dobrzycki@coderslab.pl|CodersLab|ul. Obornika 91 |Trzebnica|55-100  |
    |michal.dobrzycki@coderslab.pl|CodersLab|ul. Kaliska 19  |Krotoszyn|63-700  |
    |michal.dobrzycki@coderslab.pl|CodersLab|ul. Trzebnicka 5|Milicz   |56-300  |






