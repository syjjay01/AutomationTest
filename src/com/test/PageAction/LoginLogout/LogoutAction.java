package com.test.PageAction.LoginLogout;

import org.openqa.selenium.WebDriver;

public class LogoutAction extends BasePage {
	
	public LogoutAction(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public void Logout() throws Exception{
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		findElement("userListObject").click();
		findElement("logoutObject").click();
	}
	
    //¹Ø±Õä¯ÀÀÆ÷
	public void closeBrowser(){
		driver.quit();
	}
}



