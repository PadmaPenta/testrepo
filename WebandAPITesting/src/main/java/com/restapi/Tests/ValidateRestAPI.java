package com.restapi.Tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.restapi.methods.*;

import io.restassured.response.Response;
public class ValidateRestAPI extends APIMethods{
public String respdata;
Response resp;
ValidateRestAPI  validation=null;

@BeforeSuite
public void callRestAPI(){
validation=new ValidateRestAPI();
resp=validation.getRestAPIResponse();
}
@Test(priority=1)
public void validateResponseCode(){	
logger = extent.startTest("TestCase : 'validateResponseCode' has been started");
//ValidateRestAPI validation=new ValidateRestAPI();
respdata=validation.verifyResponseCode(resp);
}
@Test(priority=2)
public void validateResponseBodyFields(){	
logger = extent.startTest("TestCase : 'validateResponseBodyFields' has been started");
//ValidateRestAPI validation=new ValidateRestAPI();
validation.verifyResponseBodyFields(respdata);
}
@Test(priority=3)
public void validatePublicField(){	
logger = extent.startTest("TestCase : 'validateResponseBodyFields' has been started");
//ValidateRestAPI validation=new ValidateRestAPI();
validation.verifyPublic(resp);
}
}