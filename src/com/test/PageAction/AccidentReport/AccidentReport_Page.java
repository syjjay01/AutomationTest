package com.test.PageAction.AccidentReport;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.test.PageAction.LoginLogout.BasePage;

public class AccidentReport_Page extends BasePage{
	
	String addAccidentTime=getDateTime();//新增时事故时间
	String addAccidentTile="自动化事故标题"+ addAccidentTime;//新增时事故标题
	
	
	public AccidentReport_Page(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public void accidentReport() throws Exception{
		// 进入页面
		implicitlyWait(1000);
		Thread.sleep(1000);
		findElement("sgbgObject").click();
		Thread.sleep(2000);
		findElement("sgbg1Object").click();
		WebElement iframeElement =findElement("iframeObject");
		driver.switchTo().frame(iframeElement);
	}
	
	public void accidentReport_Search() throws Exception{
		//查询功能
		findElement("projectIdObject").sendKeys(getTestData("项目编码_sgbg"));
		findElement("storeNameObject").sendKeys(getTestData("门店名称_sgbg"));	
		findElement("nameObject").sendKeys(getTestData("事故标题_sgbg"));	
		sendKeystoReadOnlyField(findElement("startTimeObject"), "开始时间_sgbg");
		findElement("searchBtnObject").click();
		Thread.sleep(1000);	
		//验证查询
		AssertEqualsFromExcel(findElement("projectIdTextObject").getText(),"项目编码_sgbg");
		AssertEqualsFromExcel(findElement("stroreTextObject").getText(),"门店名称_sgbg");	
		AssertEqualsFromExcel(findElement("accidentTitleTextObject").getText(),"事故标题_sgbg");
	}	
	
	public void accidentReport_Reset() throws Exception{
		//重置功能
		accidentReport_Search();
		String oldRecordText=findElement("recordObject").getText();
		findElement("resetBtnObject").click();
		Thread.sleep(2000);
		Assert.assertTrue(findElement("projectIdObject").getAttribute("value").isEmpty());
		Assert.assertTrue(findElement("storeNameObject").getAttribute("value").isEmpty());
		Assert.assertTrue(findElement("nameObject").getAttribute("value").isEmpty());
		if(findElement("emptyResultTextObject").getText().contains("没有找到匹配的记录")){
			System.out.println("重置后的时间段没有记录");			
		}else{
			String newRecordText=findElement("recordObject").getText();
			Assert.assertNotSame(oldRecordText, newRecordText);
		}
	}	
	
	public void accidentReport_ViewDetail() throws Exception{
		//查看功能(调用查询)
		accidentReport_Search();
		findElement("checkBtnObject").click();
		Thread.sleep(1000);	
		//验证查看
		AssertEqualsFromExcel(findElement("storeNameCheckObject").getText(),"门店名称_sgbg");
		AssertEqualsFromExcel(findElement("accidentTitleCheckObject").getText(),"事故标题_sgbg");	
		findElement("accidentListBtnObject").click();
		Thread.sleep(1000);
		Assert.assertTrue(findElement("searchBtnObject").isDisplayed());
	}
		
	public void accidentReport_Change() throws Exception{
		//修改功能(调用查询)
		accidentReport_Search();
		AssertEqualsFromExcel(findElement("accidentTypeTextObject").getText(),"事故类型1_sgbg");
		findElement("changeBtnObject").click();
		Thread.sleep(1000);	
		//修改界面
		selectByVisibleTextFromExcel(findElement("accidentTypeSelObject"),"事故类型2_sgbg");
		findElement("submitBtnObject").click();
		Thread.sleep(2000);	
		//验证修改
		accidentReport_Search();
		AssertEqualsFromExcel(findElement("accidentTypeTextObject").getText(),"事故类型3_sgbg");
		//恢复修改数据
		findElement("changeBtnObject").click();
		Thread.sleep(1000);	
		//修改回原来的数据
		selectByVisibleTextFromExcel(findElement("accidentTypeSelObject"),"事故类型_sgbg");
		findElement("submitBtnObject").click();
		Thread.sleep(2000);
		}
	
	public void accidentReport_Add() throws Exception{
		//添加事故功能
		findElement("addNewObject").click();
		Thread.sleep(1000);	
		//先选择门店
		findElement("storeInputObject").sendKeys(getTestData("门店名称2_sgbg"));	
		findElement("storeSerchBtnObject").click();
		Thread.sleep(1000);		
		findElement("storeObject").click();
		Thread.sleep(1000);	
		//添加界面
		findElement("accidentTitleInpObject").sendKeys(addAccidentTile);	
		selectByVisibleText(findElement("accidentTypeSelObject"), "----财物失窃/客房");
		findElement("accidentTimeInpObject").sendKeys(addAccidentTime);	
		findElement("submitBtnObject").click();
		Thread.sleep(2000);	
		//验证添加
		findElement("nameObject").sendKeys(addAccidentTile);	
		findElement("searchBtnObject").click();
		Thread.sleep(1000);	
		Assert.assertEquals(findElement("accidentTitleTextObject").getText(),addAccidentTile);
		//把事故标题写入excel
		writeExcel(addAccidentTile,2);
	}	
	
	public void accidentReport_Delete() throws Exception{	
		//调用新增功能，删除新增的那条记录
		accidentReport_Add();
		//删除功能（数据删除）
		findElement("deleteBtnObject").click();
		Thread.sleep(2000);
		//浏览器自带确定框
		Alert JavaScriptPrompt = driver.switchTo().alert();
		JavaScriptPrompt.accept();
		Thread.sleep(2000);
		//验证删除
		findElement("nameObject").sendKeys(addAccidentTile);	
		findElement("searchBtnObject").click();
		Thread.sleep(1000);	
		Assert.assertEquals(findElement("emptyResultTextObject").getText(), "没有找到匹配的记录");//验证删除后查不到记录
	}
}
