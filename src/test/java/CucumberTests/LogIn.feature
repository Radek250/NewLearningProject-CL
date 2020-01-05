Feature: Log in
  Scenario Outline: Log in to your account
    Given I open site https://prod-kurs.coderslab.pl
    When I click sign in button
    And I fill log in form "<email>" "<password>"
    Then I am logged in to my account
    Examples:
      |email                        |password |
      |michal.dobrzycki@coderslab.pl|CodersLab|
