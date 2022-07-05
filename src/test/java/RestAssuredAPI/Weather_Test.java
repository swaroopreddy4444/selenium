package RestAssuredAPI;

import org.testng.annotations.Test;

import com.github.dockerjava.transport.DockerHttpClient.Response;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.ResponseBodyData;
import io.restassured.specification.RequestSpecification;

public class Weather_Test {

	@Test
	public void GetWeatherDetails()
	{
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a GET request call directly by using RequestSpecification.get() method.
		// Make sure you specify the resource name.
		
		Response response = (Response) httpRequest.request(Method.GET,"/Hyderabad");

		// Response.asString method will directly return the content of the body
		// as String.
		System.out.println("Response Body is =>  " + ((ResponseBodyData) response).asString());
	}
}