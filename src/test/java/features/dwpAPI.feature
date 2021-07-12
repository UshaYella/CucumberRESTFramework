Feature: To Validate DWP API 

  Scenario: Validate to get list of users
    Then I trigger get service to fetch userList
    Then I should get 200 success code without errors in body

  Scenario: Validate to get list of users lives in London
    Then I trigger get service to fetch users lives in "London"
    Then I trigger get service to fetch users lives in 50 miles radius
    Then I should get 200 success code without errors in body

