Feature: Testing a CountryLookup API
  Users should be able to submit GET requests to a web service,
  and should get CountryName and CountryCode associated with the given IpAddress

  Scenario Outline:  Getting CountryName and CountryCode associated the given IpAddress
    When The user gives the following "<IpAddress>"
    Then The user should get the country name as "<CountryName>"
    Then The user should get the country code as "<CountryCode>"

    Examples:
      | IpAddress         | CountryName    | CountryCode  |
      |    151.38.39.114  |  Italy         |    IT        |
      |    12.25.205.51   |  United States |    US        |
      |    64.81.104.131  |  United States |    US        |
      |    200.21.225.82  |  Colombia      |    CO        |
