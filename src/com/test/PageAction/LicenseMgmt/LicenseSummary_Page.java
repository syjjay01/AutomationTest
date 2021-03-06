package com.test.PageAction.LicenseMgmt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.test.PageAction.LoginLogout.BasePage;

public class LicenseSummary_Page extends BasePage{
	
	public LicenseSummary_Page(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public void licenseSummary() throws Exception{
		// 进入页面
		implicitlyWait(1000);
		findElement("zzglObject").click();
		Thread.sleep(1000);
		findElement("zzqmbObject").click();
		WebElement iframeElement =findElement("iframeObject");
		driver.switchTo().frame(iframeElement);
	}

	public void licenseSummary_Search() throws Exception{
		//查询功能
		findElement("projectIdObject").sendKeys(getTestData("项目编码_zzqmb"));
		findElement("storeNameObject").sendKeys(getTestData("门店名称_zzqmb"));	
		selectByVisibleTextFromExcel(findElement("brandIdObject"),"品牌_zzqmb");
		selectByVisibleTextFromExcel(findElement("brandTypeIdObject"),"性质_zzqmb");
		selectByVisibleTextFromExcel(findElement("FlagObject"),"状态_zzqmb");
		findElement("searchBtnObject").click();
		Thread.sleep(1000);	
		//验证查询功能
		AssertEqualsFromExcel(findElement("projectIdTextObject").getText(),"项目编码_zzqmb");
		AssertEqualsFromExcel(findElement("storeTextObject").getText(),"门店名称_zzqmb");	
		AssertEqualsFromExcel(findElement("flagTextObject").getText(),"状态_zzqmb");	
		AssertEqualsFromExcel(findElement("branIdTextObject").getText(),"品牌_zzqmb");
		AssertEqualsFromExcel(findElement("branTypeTextObject").getText(),"性质_zzqmb");
		Thread.sleep(1000);	
	}
	
	public void licenseSummary_Reset() throws Exception{
		//重置功能
		licenseSummary_Search();
		String oldRecordText=findElement("recordObject").getText();
		findElement("resetBtnObject").click();
		Thread.sleep(2000);
		Assert.assertTrue(findElement("projectIdObject").getAttribute("value").isEmpty());
		Assert.assertTrue(findElement("storeNameObject").getAttribute("value").isEmpty());
		String newRecordText=findElement("recordObject").getText();
		Assert.assertNotSame(oldRecordText, newRecordText);
	}
	
}
