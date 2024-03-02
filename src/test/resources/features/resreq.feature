Feature: ResReq API Test
  Scenario Outline: Get Existing User
    Given user hit the get api
    When user provide '<id>'
    Then validate value

    Examples:
    |id|
    |  1|
