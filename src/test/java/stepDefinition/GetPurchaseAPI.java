package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import setUp.APIConfig;
import utilities.helperMethods;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

public class GetPurchaseAPI{

	APIConfig api;
	helperMethods util;
	
	@Given("I make a request to the Plexure login API -GET https://qatestapi.azurewebsites.net/api/login")
	public void make_a_API_request(){
		api = new APIConfig();	
	}
	
	@When("I login to the API endpoint ([^\\\"]*) using ([^\\\"]*) and ([^\\\"]*), response code ([^\"]*) returned")
	public void successful_response_code_returned(String endpoint, String username, String password,int responsecode) {
		make_a_API_request();	
		int StatusCode = api.callLoginAPI(endpoint,username,password);
		System.out.println(StatusCode);
		Assert.assertTrue(StatusCode==responsecode);	    
	}

	@Then("^I get the valid successful response returned$")
	public void i_get_the_API_response_returned_successfully(String endpoint, String username, String password) {
		   String JsonResponse = api.getAPIResponse(endpoint,username,password);
		   System.out.println("API Response is : "+JsonResponse);
		   Assert.assertTrue(JsonResponse.contains("{" +
					"\"username\": \"String\",\"" +
					"\"user_id\": \"Int\",\"" +
					"\"token\": \"String\",\"" +
					"}"));
		    
		}
	
	@Then("^I get the valid mising error response returned$")
	public void i_get_the_API_error_response_returned_successfully(String endpoint, String username, String password) {
		   String JsonResponse = api.getAPIResponse(endpoint,username,password);
		   System.out.println("API Response is : "+JsonResponse);
		   Assert.assertTrue(JsonResponse.contains("{" +
					"\"Error\": \"‘Username and password are required’" +
					"}"));
		    
		}
	
	@Then("^I get the valid unauthorized response returned$")
	public void i_get_the_API_unauthorized_response_returned_successfully(String endpoint, String username, String password) {
		   String JsonResponse = api.getAPIResponse(endpoint,username,password);
		   System.out.println("API Response is : "+JsonResponse);
		   Assert.assertTrue(JsonResponse.contains("{" +
				   "\"Error\": \"‘Unauthorized’" +
					"}"));
		    
		}
	
	
}
