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
		//进入菜单
		roomTypePage.roomType();
    	//房型列表：重置功能（包含查询功能）
		roomTypePage.roomTypeList_Reset();
		//房型变更申请
		roomTypePage.roomType_Apply();
		//房型变更历史
		roomTypePage.roomType_History();
	}
		
	@AfterClass
	public void end() throws Exception{
		LogoutAction logoutAction = new LogoutAction(driver);
		logoutAction.Logout();
	}
	
}
