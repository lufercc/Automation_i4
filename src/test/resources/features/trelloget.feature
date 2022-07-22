Feature: This is my first test case

  Scenario: Como usuario quiero obtener la lista de todos mis boards
    Given Como usuario quiero usar este endpoint "/1/members/me/boards"
    When I send a "GET" the request
    Then I expect the status code is 200

  Scenario: Como usuario quiero verificar q el status code es 404 cuando envio un request a un endpoint no existente
    Given Como usuario quiero usar este endpoint "/1/members/me/boards/nonexist"
    When I send a "GET" the request
    Then I expect the status code is 404

  @createBoard
  Scenario: Como usuario quiero crear un boards
    Given Como usuario quiero usar este endpoint "/1/boards/"
    And I have the body "{\"name\" : \"new Board from Cucucmber 2\"}"
    When I send a "POST" the request
    Then I expect the status code is 200

  @createBoard
  Scenario: Como usuario quiero obter un  boards especifico
    Given Como usuario quiero usar este endpoint "/1/boards/"
    And I have the body "{\"name\" : \"newBoard\"}"
    And Como usuario quiero usar este endpoint "/1/boards/{{id}}"
    When I send a "GET" the request
    Then I expect the status code is 200
    And I expect the name is "newBoard"

#  usar backgrounds
#  1. tienen crear el board
#  2. obternet el bord creado