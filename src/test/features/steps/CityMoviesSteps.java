package test.features.steps;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import bdd.ResponseHolder;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;

import org.hamcrest.Matchers.*;

//import static com.jayway.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class CityMoviesSteps {

	String url;
	String lastName;
	ResponseHolder responseHolder;
	Response response;
	String TOKEN;
	Map<String, Object> responseMap;
	Map<String, String> query;
	Map<String, String> body;
	
	@Given("^the apis are up and running for \"([^\"]*)\"$")
	public void the_apis_are_up_and_running_for(String url) throws Throwable {
		this.url = url;
		response = given().when().get(url);
		Assert.assertEquals(200, response.getStatusCode());
	}

	@When("^a user performs a get request to \"([^\"]*)\"$")
	public void a_user_performs_a_get_request_to(String api_url) throws Throwable {
		this.url = this.url + api_url;
	}
	
	@When("^I add the following filers$")
	public void I_add_the_following_filers(DataTable dataTable) throws Throwable {
		query = new LinkedHashMap<String, String>();
		
		for(DataTableRow row : dataTable.getGherkinRows()) 
		{
			this.body.put(row.getCells().get(0),row.getCells().get(1));
		}
	}
	
	@When("^flowing body parameters$")
	public void flowing_body_parameters(DataTable dataTable) throws Throwable {
		body = new LinkedHashMap<String, String>();
		
		for(DataTableRow row : dataTable.getGherkinRows()) 
		{
			this.body.put(row.getCells().get(0),row.getCells().get(1));
		}
		response = given().contentType(ContentType.JSON).body(this.body).when().post(this.url);
		ResponseHolder.setResponse(response);
	}

	@And("^perform the request$")
	public void perform_the_request() throws Throwable {
		if(query==null)
		{
			response = given().when().get(this.url);
		}
		else
		{
			response = given().queryParams(query).when().get(this.url);
		}
		ResponseHolder.setResponse(response);
	}

	@Then("^the response code should be (\\d+)$")
	public void the_response_code_should_be(int responseCode) throws Throwable {
		Assert.assertEquals(responseCode, ResponseHolder.getResponseCode());
	}

	@SuppressWarnings("unchecked")
	@Then("^I should see json response with pairs on the filtered \"([^\"]*)\" node$")
	public void i_should_see_json_response_with_pairs_on_the_filtered_node(String filter, DataTable dataTable) throws Throwable {
		query = new LinkedHashMap<String, String>();
		
		for(DataTableRow row : dataTable.getGherkinRows()) 
		{
			query.put(row.getCells().get(0), row.getCells().get(1));
		}
		
		ObjectReader reader = new ObjectMapper().reader(Map.class);
		
		responseMap = reader.readValue(ResponseHolder.getResponseBody());
		
		responseMap = (Map<String, Object>) responseMap.get(filter);
		
		for(String key : query.keySet())
		{
			Assert.assertTrue(responseMap.containsKey(key));
			Assert.assertEquals(query.get(key), responseMap.get(key).toString());
		}
	}

	@When("^a user performs a post request to \"([^\"]*)\" with below details$")
	public void a_user_performs_a_post_request_to_with_below_details(String url, DataTable dataTable) throws Throwable {
		this.url = this.url + url;
		this.body = new LinkedHashMap<String, String>();
		
		for(DataTableRow row : dataTable.getGherkinRows()) 
		{
			this.body.put(row.getCells().get(0),row.getCells().get(1));
		}
	}

	@When("^perform the post request$")
	public void perform_the_post_request() throws Throwable {
		response = given().contentType(ContentType.JSON).body(this.body).when().post(this.url);
		ResponseHolder.setResponse(response);
	}	
}
