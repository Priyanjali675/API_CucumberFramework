Feature: Validating Maps functionality

  @AddPlace
  Scenario Outline: Add Place functionality
    Given AddPlace payload with "<Name>" "<Language>" and "<Address>"
    When user calls "AddPlaceAPI" with "post" http request
    Then "status" in the response body is "OK"
    Examples:
      | Name   | Language   | Address                               |
      | House B | Spanish   | 61, Ola, Barcelona |

  @GetPlace
  Scenario: Get Place functionality
    Given Get place url
    When user calls "GetPlaceAPI" with "get" http request
    Then "name" in the response body is "House B"

  @DeletePlace
  Scenario: Delete Place functionality
    Given Delete payload
    When user calls "DeletePlaceAPI" with "delete" http request
    And "status" in the response body is "OK"
