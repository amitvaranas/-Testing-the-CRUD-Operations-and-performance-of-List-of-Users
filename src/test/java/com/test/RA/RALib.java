package com.test.RA;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RALib {
	
	
	public String getFirstName(int ID) {
		Response getUser = GetUser(ID);
		JsonPath jsonPath1 = new JsonPath(getUser.getBody().asString());
		System.out.println(jsonPath1.getJsonObject("data.first_name"));
		String f_name = jsonPath1.getJsonObject("data.first_name");
		return f_name;
		
	}
	
	
	public String getLastName(int ID) {
		Response getUser = GetUser(ID);
		JsonPath jsonPath1 = new JsonPath(getUser.getBody().asString());
		System.out.println(jsonPath1.getJsonObject("data.last_name"));
		String f_name = jsonPath1.getJsonObject("data.last_name");
		return f_name;
		
	}
	
	
	public String getemail(int ID) {
		Response getUser = GetUser(ID);
		JsonPath jsonPath1 = new JsonPath(getUser.getBody().asString());
		System.out.println(jsonPath1.getJsonObject("data.email"));
		String f_name = jsonPath1.getJsonObject("data.email");
		return f_name;
		
	}
	
	
	public String getAvatar(int ID) {
		Response getUser = GetUser(ID);
		JsonPath jsonPath1 = new JsonPath(getUser.getBody().asString());
		System.out.println(jsonPath1.getJsonObject("data.avatar"));
		String f_name = jsonPath1.getJsonObject("data.avatar");
		return f_name;
		
	}
	public Response GetUser(int ID) {
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification given = RestAssured.given();
		Response response = given.request(Method.GET, "/api/users/"+ID);
		return response;
		
	}
	
	
	

}
