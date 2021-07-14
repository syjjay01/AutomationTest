package com.test.PageAction.AccidentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.test.PageAction.LoginLogout.BasePage;

public class AccidentStatsReport_Page extends BasePage{
	
	public AccidentStatsReport_Page(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public void accidentStatisReport() throws Exception{
		// 进入页面
		implicitlyWait(1000);
		findElement("sgbgObject").click();
		Thread.sleep(1000);
		findElement("sgtjbbObject").click();
		WebElement iframeElement =findElement("iframeObject");
		driver.switchTo().frame(iframeElement);
	}

	public void accidentStatisReport_Search() throws Exception{
		//查询功能
		findElement("projectIdObject").sendKeys(getTestData("项目编码_sgtjbb"));
		findElement("storeNameObject").sendKeys(getTestData("门店名称_sgtjbb"));	
		selectByVisibleTextFromExcel(findElement("brandTypeIdObject"),"性质_sgtjbb");
		sendKeystoReadOnlyField(findElement("startTimeObject"), "开始时间_sgtjbb");	
		sendKeystoReadOnlyField(findElement("endTimeObject"),"结束时间_sgtjbb");
		findElement("searchBtnObject").click();
		Thread.sleep(2000);	
		//验证查询功能
		AssertEqualsFromExcel(findElement("accidentTypeTextObject").getText(),"事故分类_sgtjbb");
		AssertEqualsFromExcel(findElement("numberTextObject").getText(),"事故数量_sgtjbb");
		AssertEqualsFromExcel(findElement("moneyTextObject").getText(),"总损失金额_sgtjbb");	
	}
	
	public void accidentStatisReport_Reset() throws Exception{
		//重置功能
		accidentStatisReport_Search();
		findElement("resetBtnObject").click();
		Thread.sleep(2000);
		AssertNotSameFromExcel(findElement("numberTextObject").getText(), "事故数量_sgtjbb");		
		AssertNotSameFromExcel(findElement("moneyTextObject").getText(), "总损失金额_sgtjbb");		
		Assert.assertTrue(findElement("projectIdObject").getAttribute("value").isEmpty());
		Assert.assertTrue(findElement("storeNameObject").getAttribute("value").isEmpty());	
	}
	
	public void accidentStatisReport_Export() throws Exception{
		//导出功能
		findElement("exportBtnObject").click();
		Thread.sleep(2000);		
	}
}
