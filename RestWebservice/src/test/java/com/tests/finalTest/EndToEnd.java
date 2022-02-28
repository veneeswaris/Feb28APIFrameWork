package com.tests.finalTest;

import org.testng.annotations.Test;

import com.tests.simpleCRUDWithTekarchAPP.*;

public class EndToEnd {
	AddUserDataTest add=new AddUserDataTest();
	DeleteUserDataTest delete=new DeleteUserDataTest();
	GetUserDataTest get=new GetUserDataTest();
	LoginToAPI login=new LoginToAPI();
	UpdateUserDataTest update=new UpdateUserDataTest();
	@Test
	public void endToEnd()
	{
		login.loginPojo();
		add.addUserPojo();
		get.getAllUsers();
		update.updateUserPojo();
		delete.deleteUserPojo();
		
		
	}

}

