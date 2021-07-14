package com.test.TestCase.StoreMgmt;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.libarary.Utils.ScreenShotListener;
import com.test.PageAction.LoginLogout.LoginPage;
import com.test.PageAction.LoginLogout.LogoutAction;
import com.test.PageAction.StoreMgmt.Renew_Page;
import com.test.TestCase.LoginLogout.BaseTestCase;

@Listeners({ScreenShotListener.class})
public class TC_Renew extends BaseTestCase{
	
	@BeforeClass
	public void start() throws Exception{
		super.init();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(getUsersData("��ӪרԱ"));
	}
	
	@Test
	public void renew() throws Exception{
		Renew_Page renewPage = new Renew_Page(driver);
		renewPage.renew();//����˵�
		renewPage.renew_Search();//��ѯ����
		renewPage.renew_Reset();//���ù���	
		renewPage.renew_ViewDetail();//�鿴����	
		renewPage.renew_Change();//�޸Ĺ���	
	  //  renewPage.renew_Add();//������Լ����(���ӹ���ע�͵�:������û�취�����������ϴ�ͼƬ�޷�����ɹ�)
	}
	
	@AfterClass
	public void end() throws Exception{
		LogoutAction logoutAction = new LogoutAction(driver);
		logoutAction.Logout();
	}
	
}