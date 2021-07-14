package com.test.PageAction.LoginLogout;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) throws Exception {
		super(driver);
		driver.manage().window().maximize();
		driver.get(getTestData("url"));
		pageLoadTimeout(3);
	}
	
	public void Login(String userName) throws Exception{	
		
		String password = getUserPassword(userName);
		
		WebElement userNameElement = findElement("userNameObject");
        if(userNameElement.isDisplayed()){
        	userNameElement.sendKeys(userName);
        }else{
    		findElement("linkObject").click();
    		implicitlyWait(3000);
    		WebElement userNameElement2 = findElement("userNameObject");
    		userNameElement2.sendKeys(userName);
        }

        findElement("passwordObject").sendKeys(password);
		findElement("loginObject").click();
		pageLoadTimeout(5000);
	}
}



