package test.features.steps;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;

// import cucumber.api.DataTable;
// import cucumber.api.PendingException;

import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
// import utilities.RestAssuredExtension;

import java.util.HashMap;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetPostSteps 
{
	@Given("^user perform GET operation for \"([^\"]*)\"$")
	public void userPerformGETOperationFor(String url) throws Throwable
	{
		given().contentType(ContentType.JSON);		
	}
	
	@And("^user perform GET for the post number \"([^\"]*)\"$")
	public void userPerformGETForThePostNumber(String postNumber) throws Throwable
	{
		when().get(String.format("http://localhost:3000/posts/%s",postNumber)).
		then().body("author",equalTo("Sarjerao"));
	}
			
	@Then("^user should see the author name as \"([^\"]*)\"$")
	public void userShouldSeeTheAuthorNameAs(String arg0) throws Throwable
	{
		
	}

}
