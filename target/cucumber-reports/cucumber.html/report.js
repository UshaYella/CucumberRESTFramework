$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/dwpAPI.feature");
formatter.feature({
  "name": "To Validate DWP API",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Validate to get list of users",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I get authorization token",
  "keyword": "Given "
});
formatter.match({
  "location": "DWPAPITests.i_get_authorization_token()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I trigget get service to fetch userList",
  "keyword": "Then "
});
formatter.match({
  "location": "DWPAPITests.i_trigget_get_service_to_fetch_userList()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get 200 success code without errors in body",
  "keyword": "Then "
});
formatter.match({
  "location": "DWPAPITests.i_should_get_success_code_without_errors_in_body(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Validate to get list of users lives in London",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I trigget get service to fetch users lives in \"London\"",
  "keyword": "Then "
});
formatter.match({
  "location": "DWPAPITests.i_trigget_get_service_to_fetch_users_lives_in(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get 200 success code without errors in body",
  "keyword": "Then "
});
formatter.match({
  "location": "DWPAPITests.i_should_get_success_code_without_errors_in_body(Integer)"
});
formatter.result({
  "status": "passed"
});
});