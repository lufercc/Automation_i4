Feature: This is my first test case

  Scenario: get all boards
    Given Send a request to "/1/members/me/boards"
    When I send a "GET" the request
    Then I expect "200"