package com.test.TestCase.StoreMgmt;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.libarary.Utils.ScreenShotListener;
import com.test.PageAction.LoginLogout.LoginPage;
import com.test.PageAction.LoginLogout.LogoutAction;
import com.test.PageAction.StoreMgmt.RoomType_Page;
import com.test.TestCase.LoginLogout.BaseTestCase;

@Listeners({ScreenShotListener.class})
public class TC_RoomType extends BaseTestCase{
	
	@BeforeClass
	public void start() throws Exception{
		super.init();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(getUsersData("adminUser"));
	}
	
	@Test
	public void roomType() throws Exception{
		RoomType_Page roomTypePage = new RoomType_Page(driver);
		//����˵�
		roomTypePage.roomType();
    	//�����б����ù��ܣ�������ѯ���ܣ�
		roomTypePage.roomTypeList_Reset();
		//���ͱ������
		roomTypePage.roomType_Apply();
		//���ͱ����ʷ
		roomTypePage.roomType_History();
	}
		
	@AfterClass
	public void end() throws Exception{
		LogoutAction logoutAction = new LogoutAction(driver);
		logoutAction.Logout();
	}
	
}
