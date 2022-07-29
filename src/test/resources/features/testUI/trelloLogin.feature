Feature: trello Login

  Scenario: I login to trello
    Given Abro trello
    When pongo mi usuarion "autotester248@gmail.com" y password "password"
    Then Verifico que el logo de trello se muestra

  @deleteB
  Scenario: Test
    Given Como usuario quiero usar este endpoint "/1/boards/"
    And I have the body "{\"name\" : \"new BoardCUCU\"}"
    And I send a "POST" the request
    Given Abro trello
    When pongo mi usuarion "autotester248@gmail.com" y password "password"
    Then Verificar que el board "new BoardCUCU" sea visible

