package com.test.TestCase.LicenseMgmt;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.libarary.Utils.ScreenShotListener;
import com.test.PageAction.LicenseMgmt.LicenseSummary_Page;
import com.test.PageAction.LoginLogout.LoginPage;
import com.test.PageAction.LoginLogout.LogoutAction;
import com.test.TestCase.LoginLogout.BaseTestCase;

@Listeners({ScreenShotListener.class})
public class TC_LicenseSummary extends BaseTestCase{

	@BeforeClass
	public void start() throws Exception{
		super.init();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(getUsersData("adminUser"));
	}
	
	@Test
	public void licenseSummary() throws Exception{
		LicenseSummary_Page licenseSummaryPage = new LicenseSummary_Page(driver);
		licenseSummaryPage.licenseSummary();//进入菜单
		licenseSummaryPage.licenseSummary_Reset();//重置功能（包含查询功能）
	}
	
	@AfterClass
	public void end() throws Exception{
		LogoutAction logoutAction = new LogoutAction(driver);
		logoutAction.Logout();
	}
	
}
