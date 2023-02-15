package com.test.RA;
import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestLogIn {
	
	Logger logger;
	
	@BeforeMethod
	public void setUp() {
		
		try {
			
			FileInputStream fis = new FileInputStream("log4j.properties");
			Properties properties = new Properties();
			properties.load(fis);
			fis.close();
			
			FileOutputStream fos = new FileOutputStream("log4j1.properties");
			
//			
			properties.setProperty("logname", "testlogin2.out");
			properties.store(fos, null);
			fos.close();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PropertyConfigurator.configure("log4j1.properties");
		 logger = Logger.getLogger(TestLogs.class.getName());
		 
//		 
		 logger.info("Browser started");
		
		
		
	}
  @Test
  public void TestLogin() {
	  
	  
		RALib lib = new RALib();
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification given = RestAssured.given();

		Response response = given.request(Method.GET, "/api/users?page=1");
		System.out.println(response.getBody().asString());
		logger.info("Getting response Body");
		
		JSONObject jsonObject = new JSONObject(response.getBody().asString());
//		System.out.println(jsonObject.getInt("total"));
		JSONArray jsonArray = jsonObject.getJSONArray("data");
		logger.info("Getting data object");
		
		
		int c=0;
		int c1=0;
		
		
		
		for (int i = 0; i < 6; i++) {
			Object object = jsonArray.get(i);
			JsonPath jsonPath = new JsonPath(object.toString());
			System.out.println(jsonPath.get("id"));
//			Response getUser = lib.GetUser((Integer) jsonPath.get("id"));
//			System.out.println(getUser.getBody().asString());
//			JsonPath jsonPath1 = new JsonPath(getUser.getBody().asString());
//			System.out.println(jsonPath1.getJsonObject("data.first_name"));
//			String jsonObject2 = jsonPath1.getJsonObject("data.first_name");
//			
//			
//			System.out.println(jsonPath.get("first_name"));
			
			String firstName = lib.getFirstName((Integer) jsonPath.get("id"));
			String lastname = lib.getLastName((Integer) jsonPath.get("id"));
			String emailName  = lib.getemail((Integer) jsonPath.get("id"));
			String avatar = lib.getAvatar((Integer) jsonPath.get("id"));
//			System.out.println(jsonPath.get("email"));
			
			
//			
			
			if (firstName.equals(jsonPath.get("first_name"))) {
				c+=1;
				c1+=1;
				System.out.println("First Name Matches");
				
			} else {
				c+=1;
				System.out.println("Not MAtch");

			}
			
			
			
			if (lastname.equals(jsonPath.get("last_name"))) {
				System.out.println("last Name Matches");
				
			} else {
				System.out.println("Not MAtch");

			}
			
			
			if (emailName.equals(jsonPath.get("email"))) {
				System.out.println("Email Matches");
				
			} else {
				System.out.println("Not MAtch");

			}
			
			
			
			if (avatar.equals(jsonPath.get("avatar"))) {
				System.out.println("avatar Matches");
				
			} else {
				System.out.println("Not MAtch");

			
			
		}
			
			System.out.println("value of c "+ c + " value of c1 "+c1);
			assertEquals(c, c1);
		
		
		
//		
	}
	  
	  logger.info("Test Login Passed");
	  
  }
  
  @AfterMethod
	public void TearDown() {
	  logger.info("Browser Closed");
	  
		
		
	}
}
