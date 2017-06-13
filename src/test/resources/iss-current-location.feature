Feature: International Space Station Current Location
  @func
  Scenario: Retrieve International Space Station Current Location
    Given I access the ISS Current Location
    When I retrieve the ISS Current Location
    Then I see the ISS Current Location

  @perf
  Scenario: ISS response time is less than 2 seconds
    Given I access the ISS Current Location
    When I retrieve the ISS Current Location
    Then The response time should be less than 2000 miliseconds