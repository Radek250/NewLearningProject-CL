Feature: Log in
  Scenario Outline: Log in to your account
    Given I open site https://prod-kurs.coderslab.pl
    When I click sign in button
    And I fill log in form "<email>" "<password>"
    Then I am logged in to my account
    Examples:
      |email                        |password |
      |michal.dobrzycki@coderslab.pl|CodersLab|


  Scenario Outline: Log in with wrong login or password data
    Given I open https://prod-kurs.coderslab.pl
    When I click on sign in button
    And I fill log in form with "<email>" "<password>"
    Then I`m not logged in to my account
    Examples:
      |email                        |password |
      |wrongEmail@coderslab.pl      |CodersLab|
      |michal.dobrzycki@coderslab.pl|coderslab|


  Scenario: Log in with empty login field
    Given I open a site https://prod-kurs.coderslab.pl
    When I click sign in button on main page
    And I fill out email field log in form "michal.dobrzycki@coderslab.pl"
    Then I am not logged in to my account


  Scenario: Log in with empty password field
    Given I open the site https://prod-kurs.coderslab.pl
    When I click a sign in button on main page
    And I fill out password field in log in form "CodersLab"
    Then I am not logged into my account


  Scenario: Log in with empty login and password field
    Given I open the site https://prod-kurs.coderslab.pl in browser
    When I click a sign in button
    And I submit form without filling out login and password fields
    Then I`m not logged into my account
