package com.test.TestCase.StoreMgmt;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.libarary.Utils.ScreenShotListener;
import com.test.PageAction.LoginLogout.LoginPage;
import com.test.PageAction.LoginLogout.LogoutAction;
import com.test.PageAction.StoreMgmt.Store_Page;
import com.test.TestCase.LoginLogout.BaseTestCase;

@Listeners({ScreenShotListener.class})
public class TC_Store extends BaseTestCase{
	
	@BeforeClass
	public void start() throws Exception{
		super.init();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(getUsersData("adminUser"));
	}
	
	@Test
	public void store() throws Exception{		
		Store_Page storePage = new Store_Page(driver);
		storePage.store();//���빦��ҳ��			
		storePage.store_Reset();//���ù��ܣ�������ѯ���ܣ�
		storePage.store_ViewDetail();//�鿴����		
		storePage.store_Change();//�޸Ĺ���		
//		storePage.store_UpgradeNewProduct();//������Ʒ����
//		storePage.store_CancelNewProduct();//ȡ����Ʒ����		
	}
	
	@AfterClass
	public void end() throws Exception{
		LogoutAction logoutAction = new LogoutAction(driver);
		logoutAction.Logout();
	}
	
}
