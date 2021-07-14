package com.test.TestCase.StoreMgmt;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.libarary.Utils.ScreenShotListener;
import com.test.PageAction.LoginLogout.LoginPage;
import com.test.PageAction.LoginLogout.LogoutAction;
import com.test.PageAction.StoreMgmt.RoomNumber_Page;
import com.test.TestCase.LoginLogout.BaseTestCase;

@Listeners({ScreenShotListener.class})
public class TC_RoomNumber extends BaseTestCase{
	
	@BeforeClass
	public void start() throws Exception{
		super.init();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(getUsersData("adminUser"));
	}
	
	@Test
	public void roomNumber() throws Exception{	
		RoomNumber_Page roomNumberPage = new RoomNumber_Page(driver);
		//进入菜单
		roomNumberPage.roomNumber();
		//房号列表：按按楼栋楼层 或 按房型 
		roomNumberPage.roomNumber_List();
		//房号变更申请
		roomNumberPage.roomNumber_Apply();
		//房号变更历史
		roomNumberPage.roomNumber_History();
		
//		roomNumberPage.roomNumber_Search();//查询功能
//		roomNumberPage.roomNumHistory_Check();//变更历史查看	
//		roomNumberPage.roomNumber_Add();//添加房号（包含变更历史撤销功能）
//		roomNumberPage.roomNumber_Change();//修改房号（包含变更历史撤销功能）
//		roomNumberPage.roomNumber_Delete();//删除房号（包含变更历史撤销功能）
//		roomNumberPage.roomNumber_recover();//恢复房号（包含变更历史撤销功能）	
	}
	
	@AfterClass
	public void end() throws Exception{
		LogoutAction logoutAction = new LogoutAction(driver);
		logoutAction.Logout();
	}
	
}
