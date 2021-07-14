package com.test.TestCase.LoginLogout;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.libarary.Base.SingletonDriver;
import com.libarary.Utils.ScreenShotUtil;
import com.test.PageAction.LoginLogout.BasePage;

public class BaseTestCase {	  
	 //系testcase相關類，driver都是从SingletonDriver处获取，不传递
	 public WebDriver driver;	 
	 //所以构造方法不需要输入参数，直接调用SingletonDriver获取唯一的driver就可以
	 public void init() {
		 driver=SingletonDriver.getDriver();
	    }

	 public void takeScreenShot() { 
	  String testCaseName = this.getClass().getSimpleName();
	  ScreenShotUtil.takeScreenshot((TakesScreenshot) driver, testCaseName);
	  }
     

	 public String getUsersData(String userData) throws Exception{
		 return BasePage.getUsersData(userData);
	 }
	 
	 
}
