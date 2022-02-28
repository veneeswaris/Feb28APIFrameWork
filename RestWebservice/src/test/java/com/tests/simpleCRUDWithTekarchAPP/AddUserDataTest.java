package com.tests.simpleCRUDWithTekarchAPP;

import org.testng.annotations.Test;

import com.test.constants.EndPoints;
import com.test.pojoModels.AddUserPojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
//import pojos.AddUserPojo;

public class AddUserDataTest {

	@Test
	public static void addUserPojo()
	{
		if(LoginToAPI.token1==null)
		{
			LoginToAPI.loginPojo();
		}
		AddUserPojo obj=new AddUserPojo();
		obj.setAccountno("TA-9876333");
		obj.setDepartmentno("3");
		obj.setSalary("3000");
		obj.setPincode("987000");
		Header header1=new Header("token",LoginToAPI.token1);
		Response res=RestAssured.
				given().
		header(header1).
		contentType(ContentType.JSON).
		body(obj).
		when().
		post(EndPoints.BASE_URI+EndPoints.ADD_DATA);
		res.then().statusCode(201);
		String value=res.jsonPath().get("status");
		System.out.println(value);
		System.out.println("End of AddUser");
	}
}
