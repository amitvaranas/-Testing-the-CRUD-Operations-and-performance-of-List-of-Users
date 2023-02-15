package com.test.RA;

import org.json.JSONObject;

import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostReq {
	
	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification given = RestAssured.given();
		
		JSONObject reqpar = new JSONObject();
		reqpar.put("name", "Amit");
		reqpar.put("job", "test engg");
		System.out.println(reqpar.toString());
		
		
		given.body(reqpar.toString());
		
		given.headers("Content-Type", "application/json");
		

		Response response = given.request(Method.POST, "/api/users");
		System.out.println(response.getStatusCode());
//		System.out.println(response.getSessionId());
		System.out.println(response.getBody().asString());
		
		Gson gson = new Gson();
		User user = gson.fromJson(response.getBody().asString(), User.class);
//		user.setName("amit");
		System.out.println(user.getName());
		System.out.println(user.getJob());
		System.out.println(user.getId());
		System.out.println(user.getCreatedAt());
		
		

	}

}
