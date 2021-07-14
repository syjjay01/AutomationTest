package com.test.TestCase.LoginLogout;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.libarary.Utils.ScreenShotListener;
import com.test.PageAction.LoginLogout.LoginPage;

@Listeners({ScreenShotListener.class})
public class TC_Login extends BaseTestCase{

	@BeforeTest(alwaysRun=true)
	public void start(){	
		super.init();
	}
	
	
	@Test(groups = "TC_LoginSucessfully")
	public void loginSuccessfully() throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(getUsersData("adminUser"));
	}	
}
