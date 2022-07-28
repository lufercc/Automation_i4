Feature: trello Login

  Scenario: I login to trello
    Given Abro trello
    When pongo mi usuarion "test" y password "test"
    Then Verifico que el logo de trello se muestra