$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Cases.feature");
formatter.feature({
  "line": 1,
  "name": "Assessment Test",
  "description": "",
  "id": "assessment-test",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Case1",
  "description": "",
  "id": "assessment-test;case1",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Connect the post url",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Get the post",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});