package setUp;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIConfig {

	/**
	 * @author Thomas Cheriyan
	 *
	 * Lead QA Engineer
	 */
	
	private static Response response;
	private static final String BASE_URL = "Https://qatestapi.azurewebsites.net";
	private static final String requestLoginBody = "{" +
			"\"username\": \"String\",\"" +
			"\"password\": \"String\",\"" +
			"}";
	private static final String requestPurchaseBody = "{" +
			"\"username\": \"String\",\"" +
			"\"password\": \"String\",\"" +
			"}";
	
	public int callLoginAPI(String resourceEndpoint,String uname,String pwd) {
		 RestAssured.baseURI = BASE_URL;
		 RequestSpecification request = RestAssured.given().auth().basic(uname, pwd);
		 
		 // get authorization header
		 request.header("Content-Type", "application/JSON");
		 request.body(requestLoginBody);
		 response = request.post(resourceEndpoint);
		 
		 int statusCode = response.getStatusCode();
		 return statusCode;
	}
	
	public int callPurchaseAPI(String resourceEndpoint,String uname,String pwd) {
		 RestAssured.baseURI = BASE_URL;
		 RequestSpecification request = RestAssured.given().auth().basic(uname, pwd);
		 
		 // get authorization header
		 request.header("Content-Type", "application/JSON");
		 request.body(requestLoginBody);
		 response = request.post(resourceEndpoint);
		 
		 int statusCode = response.getStatusCode();
		 return statusCode;
	}
	
	public String getAPIResponse(String resourceEndpoint,String uname,String pwd) {
			 
		RestAssured.baseURI = BASE_URL;
		 RequestSpecification request = RestAssured.given().auth().basic(uname, pwd);
		 
		 // get authorization header
		 request.header("Content-Type", "application/JSON");
		 request.body(requestLoginBody);
		 response = request.post(resourceEndpoint);
			 
			 String jsonString = response.asString();
			 
			 return jsonString;
			 
	}
	
	public static void main(String[] args){
	APIConfig test = new APIConfig();
	System.out.println(test.callLoginAPI("/login","Tester","Plexure123"));
	System.out.println(test.getAPIResponse("/login","Tester","Plexure123"));
	}

}
