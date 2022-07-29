Feature: trello Login

  Scenario: I login to trello
    Given Abro trello
    When pongo mi usuarion "autotester248@gmail.com" y password "password"
    Then Verifico que el logo de trello se muestra