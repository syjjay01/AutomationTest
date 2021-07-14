package com.test.TestCase.AccidentReport;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.libarary.Utils.ScreenShotListener;
import com.test.PageAction.AccidentReport.AccidentReport_Page;
import com.test.PageAction.LoginLogout.LoginPage;
import com.test.PageAction.LoginLogout.LogoutAction;
import com.test.TestCase.LoginLogout.BaseTestCase;

@Listeners({ScreenShotListener.class})
public class TC_AccidentReport extends BaseTestCase{

	@BeforeClass
	public void start() throws Exception{
		super.init();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(getUsersData("adminUser"));
	}
	
	@Test
	public void accidentReport() throws Exception{
		AccidentReport_Page accidentReportPage = new AccidentReport_Page(driver);
		accidentReportPage.accidentReport();//进入菜单
		accidentReportPage.accidentReport_Reset();//重置功能（包含查询功能）
		accidentReportPage.accidentReport_ViewDetail();//查看功能
		accidentReportPage.accidentReport_Change();//修改功能	
		accidentReportPage.accidentReport_Delete();//删除功能（包含了新增功能）
	}
	
	@AfterClass
	public void end() throws Exception{
		LogoutAction logoutAction = new LogoutAction(driver);
		logoutAction.Logout();
	}
	
}
