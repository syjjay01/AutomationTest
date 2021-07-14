package com.test.TestCase.HomePage;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import com.libarary.Utils.ScreenShotListener;
import com.test.PageAction.HomePage.HomePage_Page;
import com.test.PageAction.LoginLogout.LoginPage;
import com.test.PageAction.LoginLogout.LogoutAction;
import com.test.TestCase.LoginLogout.BaseTestCase;

@Listeners({ScreenShotListener.class})
public class TC_HomePage extends BaseTestCase{
	
	@BeforeClass
	public void start() throws Exception{
		super.init();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(getUsersData("adminUser"));
	}
	
	
	@Test
	public void HomePage() throws Exception{
	
		HomePage_Page HomePagePage= new HomePage_Page(driver);
		//Ê×Ò³
		HomePagePage.HomePage();
		HomePagePage.HomePage_verify();
	}
	
	@AfterClass
	 public void end() throws Exception{
		LogoutAction logoutAction = new LogoutAction(driver);
		logoutAction.Logout();
	 }

}
