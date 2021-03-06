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
		loginPage.Login(getUsersData("运营专员"));
	}
	
	@Test
	public void renew() throws Exception{
		Renew_Page renewPage = new Renew_Page(driver);
		renewPage.renew();//进入菜单
		renewPage.renew_Search();//查询功能
		renewPage.renew_Reset();//重置功能	
		renewPage.renew_ViewDetail();//查看功能	
		renewPage.renew_Change();//修改功能	
	  //  renewPage.renew_Add();//新增续约功能(添加功能注释掉:服务器没办法链接外网，上传图片无法保存成功)
	}
	
	@AfterClass
	public void end() throws Exception{
		LogoutAction logoutAction = new LogoutAction(driver);
		logoutAction.Logout();
	}
	
}
