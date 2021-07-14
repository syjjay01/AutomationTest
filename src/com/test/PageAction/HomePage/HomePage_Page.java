package com.test.PageAction.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.test.PageAction.LoginLogout.BasePage;

public class HomePage_Page extends BasePage {
	
	public HomePage_Page(WebDriver driver) throws Exception{
		super(driver);
	}
	
	
	public void HomePage() throws Exception{
		implicitlyWait(1000);
		findElement("HomePageObject").click();
		WebElement iframeElement = findElement("iframeObject");
		driver.switchTo().frame(iframeElement);
	}
	
	public void HomePage_verify() throws Exception{
		//验证首页温馨提示图片
		Thread.sleep(2000);
		Assert.assertTrue(findElement("warmPromptObject").isDisplayed());
		Thread.sleep(2000);
		Assert.assertTrue(findElement("wordsObject").getText().contains("全球门店系统业务流程"));		
	}

}
