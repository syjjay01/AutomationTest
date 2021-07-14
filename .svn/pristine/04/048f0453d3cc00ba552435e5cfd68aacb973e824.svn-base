package com.test.PageAction.AccidentReport;

import org.openqa.selenium.Alert;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.test.PageAction.LoginLogout.BasePage;

public class RecycleBin_Page extends BasePage{
	
	String addAccidentTile = getWriteData("事故标题_AccidentReport");
	
	public RecycleBin_Page(WebDriver driver) throws Exception {
		super(driver);
	}
    
	public void recycleBin() throws Exception{
		// 进入页面
		implicitlyWait(1000);
		findElement("sgbgObject").click();
		Thread.sleep(1000);
		findElement("hszObject").click();
		WebElement iframeElement =findElement("iframeObject");
		driver.switchTo().frame(iframeElement);
	}

	public void recycleBin_Search() throws Exception{
		//查询功能
		findElement("nameObject").sendKeys(addAccidentTile);
		findElement("searchBtnObject").click();
		Thread.sleep(2000);	
		//验证查询
		Assert.assertEquals(findElement("nameTextObject").getText(),addAccidentTile);
		Thread.sleep(1000);	
	}
	
	public void recycleBin_Reset() throws Exception{
		//重置功能		
		findElement("nameObject").sendKeys(addAccidentTile);
		findElement("searchBtnObject").click();
		Thread.sleep(2000);	
		findElement("resetBtnObject").click();
		Thread.sleep(2000);
		Assert.assertTrue(findElement("projectIdObject").getAttribute("value").isEmpty());
		Assert.assertTrue(findElement("storeNameObject").getAttribute("value").isEmpty());
		Assert.assertTrue(findElement("nameObject").getAttribute("value").isEmpty());
	}

	public void recycleBin_Activate() throws Exception{
		//激活功能	
		findElement("nameObject").sendKeys(addAccidentTile);
		findElement("searchBtnObject").click();
		Thread.sleep(3000);	
		findElement("activateBtnObject").click();
		Thread.sleep(3000);	
		
		Alert JavaScriptPrompt = driver.switchTo().alert();
		JavaScriptPrompt.accept();
		Thread.sleep(4000);
		
		//验证是否激活成功
		findElement("nameObject").sendKeys(addAccidentTile);
		findElement("searchBtnObject").click();
		Thread.sleep(1000);
		Assert.assertTrue(findElement("emptyResultTextObject").getText().contains("没有找到匹配的记录"));
	}
	
}
