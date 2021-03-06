package com.test.PageAction.StoreMgmt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.test.PageAction.LoginLogout.BasePage;

public class CashierSite_Page extends BasePage{
	
	String posName="自动化收银点名称"+getDateTime();
	
	public CashierSite_Page(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public void cashierSite() throws Exception{
		// 进入页面
		implicitlyWait(1000);
		findElement("mdglObject").click();
		findElement("sydObject").click();
		WebElement iframeElement =findElement("iframeObject");
		driver.switchTo().frame(iframeElement);
	}

	public void cashierSite_Search() throws Exception{
		//查询功能
		findElement("storenameObject").sendKeys(getTestData("门店名称_syd"));
		findElement("posnameObject").sendKeys(getTestData("收银点名称_syd"));
		findElement("searchBtnObject").click();
		Thread.sleep(2000);
		AssertEqualsFromExcel(findElement("posnameTextObject").getText(),"收银点名称_syd");
		AssertEqualsFromExcel(findElement("storenameTextObject").getText(),"门店名称_syd");
	}
	
	public void cashierSite_Reset() throws Exception{
		//重置功能
		cashierSite_Search();
		String oldRecordText=findElement("recordObject").getText();
		findElement("resetBtnObject").click();
		Thread.sleep(2000);
		Assert.assertTrue(findElement("storenameObject").getAttribute("value").isEmpty());
		Assert.assertTrue(findElement("posnameObject").getAttribute("value").isEmpty());
		String newRecordText=findElement("recordObject").getText();
		Assert.assertNotSame(oldRecordText, newRecordText);
	}
	
	public void cashierSite_ViewDetail() throws Exception{
		//查看功能
		cashierSite_Search();
		findElement("viewBtnObject").click();
		Thread.sleep(1000);
		AssertEqualsFromExcel(findElement("posnameTextObject3").getText(),"收银点名称_syd");
		findElement("postListBtnObject").click();
		Assert.assertTrue(findElement("searchBtnObject").isDisplayed());
	}
	
	public void cashierSite_Update() throws Exception{
	    //修改功能
		cashierSite_Search();
		AssertEqualsFromExcel(findElement("posflagTextObject").getText(),"收银点状态_syd");
		findElement("updateBtnObject").click();
		Thread.sleep(1000);
		selectByVisibleTextFromExcel(findElement("flagSelObject"), "收银点状态2_syd");
		findElement("submitBtnObject").click();
		Thread.sleep(2000);
		cashierSite_Search();
		AssertEqualsFromExcel(findElement("posflagTextObject").getText(),"收银点状态2_syd");
		//恢复修改数据
		findElement("updateBtnObject").click();
		Thread.sleep(1000);
		selectByVisibleTextFromExcel(findElement("flagSelObject"), "收银点状态_syd");
		findElement("submitBtnObject").click();
		Thread.sleep(2000);
	}	

	public void cashierSite_Add() throws Exception{
		//添加收银点
		findElement("addBtnObject").click();
		findElement("storenameTextObject2").click();
		findElement("posnameTextObject2").sendKeys(posName);
		selectByVisibleTextFromExcel(findElement("postypeTextObject2"), "收银点类型_syd");
		findElement("submitBtnObject2").click();
		Thread.sleep(2000);
		findElement("posnameObject").sendKeys(posName);
		findElement("postypeObject").sendKeys(getTestData("收银点类型_syd"));
		findElement("searchBtnObject").click();
		Thread.sleep(2000);
		Assert.assertEquals(findElement("posnameTextObject").getText(), posName);	
	}
	
//	public void cashierSite_Update() throws Exception{
//		//修改功能
//		cashierSite_Search();
//		WebElement posflagElement=findElement("posflagTextObject");
//		if (!posflagElement.getText().equals(getTestData("收银点状态_syd"))){
//			Thread.sleep(2000);
//			findElement("updateBtnObject").click();
//			selectByVisibleTextFromExcel(findElement("comboBoxObject"), "收银点状态_syd");
//			findElement("submitBtnObject").click();
//			Thread.sleep(2000);
//			findElement("storenameObject").sendKeys(getTestData("门店名称_syd"));
//			findElement("posnameObject").sendKeys(getTestData("收银点名称_syd"));
//			findElement("searchBtnObject").click();
//			Thread.sleep(2000);
//			WebElement posflagElement2=findElement("posflagTextObject");
//			AssertEqualsFromExcel(posflagElement2.getText(), "收银点状态_syd");
//		}else{
//			Thread.sleep(2000);
//			findElement("updateBtnObject").click();
//			selectByVisibleTextFromExcel(findElement("comboBoxObject"), "收银点状态2_syd");
//			findElement("submitBtnObject").click();
//			Thread.sleep(2000);
//			findElement("storenameObject").sendKeys(getTestData("门店名称_syd"));
//			findElement("posnameObject").sendKeys(getTestData("收银点名称_syd"));
//			findElement("searchBtnObject").click();
//			Thread.sleep(2000);
//			WebElement posflagElement3=findElement("posflagTextObject");
//			AssertEqualsFromExcel(posflagElement3.getText(), "收银点状态2_syd");
//		}	
//	}
	
	
}
