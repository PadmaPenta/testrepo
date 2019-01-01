package com.restapi.methods;

import java.util.ArrayList;
import org.testng.Assert;

import com.sample.WebandAPITesting.Utilities.BaseTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APIMethods extends BaseTest{
	//public String uname;
	Response resp;
	public String data;
	
	public Response getRestAPIResponse(){
		//uname = PropertiesHelper.getProperty("apitestdata","username");
		//Response resp=RestAssured.get("https://api.github.com/users/", uname,"/events");unable to pass variable name to url
		resp=RestAssured.get("https://api.github.com/users/PadmaPenta/events");
		return resp;
	}
	public String verifyResponseCode(Response resp){
		int code=resp.getStatusCode();
		//System.out.println("Status Code "+code);
		Assert.assertEquals(code,200);
		data=resp.asString();
		return data;
	}	
	public boolean verifyResponseBodyFields(String respdata){
		Assert.assertTrue(respdata.contains("id"), "id field should be displayed in response body");
		Assert.assertTrue(respdata.contains("type"), "type field should be displayed in response body");
		Assert.assertTrue(respdata.contains("actor"), "actor field should be displayed in response body");
		Assert.assertTrue(respdata.contains("repo"), "repo field should be displayed in response body");
		Assert.assertTrue(respdata.contains("payload"), "repo field should be displayed in response body");
		Assert.assertTrue(respdata.contains("created_at"), "created date field should be displayed in response body");
		return true;
	}	
	public boolean verifyPublic(Response resp){
		JsonPath jsonPathEvaluator = resp.jsonPath();
		ArrayList<String> list=new ArrayList<String>();
		list=jsonPathEvaluator.get("public");
		for(int i=0;i<list.size();i++){
        Assert.assertEquals(list.get(i), true, "Public should be true in the Response");
		}
		return true;
	}	
}
