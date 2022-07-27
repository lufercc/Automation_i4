Feature: Scenarios para get y delete, q necesitan un board previamente

  Background:
    Given Como usuario quiero usar este endpoint "/1/boards/"
    And I have the body "{\"name\" : \"new BoardCUCU\"}"
    And I send a "POST" the request

  @deleteA
  Scenario: Como usuario quiero obter un  boards especifico
    When Como usuario quiero usar este endpoint "/1/boards/[[id]]"
    And I send a "GET" the request
    Then I expect the status code is 200
    And I expect the name is "new BoardCUCU"

  Scenario: Como usuario quiero probar el methodo delete para boards
    When Como usuario quiero usar este endpoint "/1/boards/[[id]]"
    And I send a "DELETE" the request
    Then I expect the status code is 200