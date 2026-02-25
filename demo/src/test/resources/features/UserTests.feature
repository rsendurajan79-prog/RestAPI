Feature: User API Validations

  Scenario: Verify specific user details
    Given the API base URI is "https://reqres.in/api"
    When I send a GET request to "/users/2"
    Then the response status code should be 200
    And the user first name should be "Janet"

   # reqres_800fda223fd941b4bb1bbc6a810c210b