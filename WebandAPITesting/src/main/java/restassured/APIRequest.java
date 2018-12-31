package restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIRequest {
	@Test(priority=1)
	public void testResponse(){
		Response resp=RestAssured.get("http://api.github.com/orgs/octokit/repos");
		int code=resp.getStatusCode();
		System.out.println("Status Code "+code);
		Assert.assertEquals(code,200);
	}
	
	@Test(priority=2)
	public void testBody(){
		Response resp=RestAssured.get("http://api.github.com/orgs/octokit/repos");
		String data=resp.asString();
		System.out.println("Data is"+data);
		System.out.println("Response time is"+resp.getTime());
	}

}
