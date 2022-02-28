package com.tests.simpleCRUDWithTekarchAPP;

import org.testng.annotations.Test;

import com.test.constants.EndPoints;
import com.test.pojoModels.UpdateUserPojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class UpdateUserDataTest {
	@Test
	public void updateUserPojo()
	{
		if(LoginToAPI.token1==null)
		{
			LoginToAPI.loginPojo();
		}
		UpdateUserPojo obj=new UpdateUserPojo();
		obj.setAccountno("TA-9876541");
		obj.setDepartmentno("12");
		obj.setSalary("11000");
		obj.setPincode("987654");
		obj.setUserid("sDz6hu8wXncPmDthLNXn");
		obj.setId("OrjfNMiNi3NGgGvFob2I");
		Header header1=new Header("token",LoginToAPI.token1);
		Response res=RestAssured.given().
		contentType(ContentType.JSON).
		header(header1).
		body(obj).
		when().put(EndPoints.BASE_URI+EndPoints.UPDATE_DATA);
		String value=res.jsonPath().get("status");
		System.out.println(value);
		res.then().statusCode(200);
		System.out.println("End Of Update");
	}
}
