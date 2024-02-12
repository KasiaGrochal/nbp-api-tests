Feature: NBP Api exchange rate tables test

  Scenario: Get Table A values
    Given I send GET table "A" request
    When I filter response to get values for currency code "USD"
    Then I can print exchange rate for given currency
    When I filter response to get values for currency name "dolar amerykański"
    Then I can print exchange rate for given currency
    When I filter response to get values for exchange rates higher than 5
    Then I can print appropriate currency names
    When I filter response to get values for exchange rates below 3
    Then I can print appropriate currency names
