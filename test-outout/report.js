$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/features/city_movies_showtimings.feature");
formatter.feature({
  "line": 1,
  "name": "City movies advanced",
  "description": "",
  "id": "city-movies-advanced",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Get locations",
  "description": "",
  "id": "city-movies-advanced;get-locations",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@smoke123"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "the apis are up and running for \"http://cmapi.bananaappscenter.com/\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "a user performs a get request to \"api/Location/LocationDetails\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "perform the request",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "the response code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I should see json response with pairs on the filtered \"Msg\" node",
  "rows": [
    {
      "cells": [
        "Message",
        "Success Location Details"
      ],
      "line": 10
    },
    {
      "cells": [
        "StatusCode",
        "200"
      ],
      "line": 11
    },
    {
      "cells": [
        "isError",
        "false"
      ],
      "line": 12
    },
    {
      "cells": [
        "isSuccess",
        "true"
      ],
      "line": 13
    }
  ],
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
formatter.match({});
formatter.result({
  "status": "undefined"
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