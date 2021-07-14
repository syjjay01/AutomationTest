package com.test.TestCase.StoreMgmt;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.libarary.Utils.ScreenShotListener;
import com.test.PageAction.LoginLogout.LoginPage;
import com.test.PageAction.LoginLogout.LogoutAction;
import com.test.PageAction.StoreMgmt.CashierSite_Page;
import com.test.TestCase.LoginLogout.BaseTestCase;

@Listeners({ScreenShotListener.class})
public class TC_CashierSite extends BaseTestCase{
	
	@BeforeClass
	public void start() throws Exception{
		super.init();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(getUsersData("adminUser"));
	}
	
	@Test
	public void cashierSite() throws Exception{
		CashierSite_Page cashierSitePage = new CashierSite_Page(driver);
		cashierSitePage.cashierSite();//进入页面
		cashierSitePage.cashierSite_Reset();//重置功能（包含查询功能）	
		cashierSitePage.cashierSite_ViewDetail();//查看功能		
		cashierSitePage.cashierSite_Update();//修改功能
		cashierSitePage.cashierSite_Add();//添加收银点功能
	}
	
	@AfterClass
	public void end() throws Exception{
		LogoutAction logoutAction = new LogoutAction(driver);
		logoutAction.Logout();
	}
	
}
