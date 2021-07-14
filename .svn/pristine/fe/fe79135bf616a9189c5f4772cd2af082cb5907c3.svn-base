package com.test.TestCase.LicenseMgmt;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.libarary.Utils.ScreenShotListener;
import com.test.PageAction.LicenseMgmt.OperationLicense_Page;
import com.test.PageAction.LoginLogout.LoginPage;
import com.test.PageAction.LoginLogout.LogoutAction;
import com.test.TestCase.LoginLogout.BaseTestCase;

@Listeners({ScreenShotListener.class})
public class TC_OperationLicense extends BaseTestCase{
	
	@BeforeClass
	public void start() throws Exception{
		super.init();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(getUsersData("adminUser"));
	}
	
	@Test
	public void operationLicense() throws Exception{
		OperationLicense_Page operationLicensePage = new OperationLicense_Page(driver);
		operationLicensePage.operationLicense();//进入菜单
		operationLicensePage.operationLicense_Reset();//重置功能（包含查询功能）	
		operationLicensePage.operationLicense_ViewDetail();//查看功能		
		operationLicensePage.operationLicense_Change();//修改功能	
		operationLicensePage.operationLicense_Review_Adopt();//审核通过（包含新增功能）		
//		operationLicensePage.operationLicense_Review_Return();//审核退回（包含新增功能）
	}
	
	@AfterClass
	public void end() throws Exception{
		LogoutAction logoutAction = new LogoutAction(driver);
		logoutAction.Logout();
	}
	
}
