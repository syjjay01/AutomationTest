package com.test.TestCase.AccidentReport;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.libarary.Utils.ScreenShotListener;
import com.test.PageAction.AccidentReport.RecycleBin_Page;
import com.test.PageAction.LoginLogout.LoginPage;
import com.test.PageAction.LoginLogout.LogoutAction;
import com.test.TestCase.LoginLogout.BaseTestCase;

@Listeners({ScreenShotListener.class})
public class TC_RecycleBin extends BaseTestCase{
	
	@BeforeClass
	public void start() throws Exception{
		super.init();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(getUsersData("adminUser"));
	}
	
	@Test
	public void recycleBin() throws Exception{
		RecycleBin_Page recycleBinPage = new RecycleBin_Page(driver);
		recycleBinPage.recycleBin();//����˵�
		recycleBinPage.recycleBin_Reset();//���ù��ܣ�������ѯ���ܣ�
		recycleBinPage.recycleBin_Activate();//�����
	}

	@AfterClass
	public void end() throws Exception{
		LogoutAction logoutAction = new LogoutAction(driver);
		logoutAction.Logout();
	}
	
}
