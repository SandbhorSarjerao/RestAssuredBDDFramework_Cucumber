Feature: City movies advanced

@smoke123
Scenario: Get locations
	Given the apis are up and running for "http://cmapi.bananaappscenter.com/"
	When a user performs a get request to "api/Location/LocationDetails"
	And perform the request
	Then the response code should be 200
	And I should see json response with pairs on the filtered "Msg" node
		| Message 		|	Success Location Details	|
		|	StatusCode	|	200												|
		|	isError			|	false											|
		|	isSuccess		|	true											|
		
@smoke456
Scenario: Check the movie details
	Given the apis are up and running for "http://cmapi.bananaappscenter.com/"	
	When a user performs a post request to "api/MovieBooking/MovieBooking" with below details
		|	Movie_ID		|	3	|
		|	Location_ID	|	5	|
	And perform the post request
	Then the response code should be 500	
	And I should see json response with pairs on the filtered "Msg" node
		| Message 		|	Success Moviebooking Details	|
		|	StatusCode	|	500														|
		|	isError			|	false													|
		|	isSuccess		|	true													|