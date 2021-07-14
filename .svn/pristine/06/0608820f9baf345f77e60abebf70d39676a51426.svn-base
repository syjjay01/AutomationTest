package com.test.TestCase.AccidentReport;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.libarary.Utils.ScreenShotListener;
import com.test.PageAction.AccidentReport.AccidentStatsReport_Page;
import com.test.PageAction.LoginLogout.LoginPage;
import com.test.PageAction.LoginLogout.LogoutAction;
import com.test.TestCase.LoginLogout.BaseTestCase;

@Listeners({ScreenShotListener.class})
public class TC_AccidentStatsReport extends BaseTestCase{
	
	@BeforeClass
	public void start() throws Exception{
		super.init();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(getUsersData("adminUser"));
	}
	
	@Test
	public void accidentStatisReport() throws Exception{
		AccidentStatsReport_Page accidentStatisReportPage = new AccidentStatsReport_Page(driver);
		accidentStatisReportPage.accidentStatisReport();//进入菜单
		accidentStatisReportPage.accidentStatisReport_Reset();//重置功能（包含查询功能）
		accidentStatisReportPage.accidentStatisReport_Export();//导出功能
	}
	
	@AfterClass
	public void end() throws Exception{
		LogoutAction logoutAction = new LogoutAction(driver);
		logoutAction.Logout();
	}
	
}
