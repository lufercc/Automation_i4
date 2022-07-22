Feature: This is my first test case

  Scenario: get all boards
    Given Send a request to "/1/members/me/boards" and "test"
    When I send a "GET" the request
    Then I expect 200

  Scenario: get all boards
    Given Send a request to "/1/members/me/boards/meboards"
#    And I have the body "{'name' : 'new Board'}"
    When I send a "GET" the request
    Then I expect 404

  Scenario: get all boards
    Given Send a request to "/1/members/me/boards/meboards"
    And I have the body "{'name' : 'new Board'}"
    When I send a "POST" the request
    Then I expect 404