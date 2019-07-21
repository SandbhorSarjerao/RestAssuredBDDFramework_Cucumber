Feature:
	Verify different GET opetations using REST-assured
	
	Scenario: Verify one author of the post
		Given	user perform GET operation for "/post"
		And user perform GET for the post number "1"
		Then user should see the author name as "Sarjerao"