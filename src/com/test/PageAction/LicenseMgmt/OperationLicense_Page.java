package com.test.PageAction.LicenseMgmt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import com.test.PageAction.Login.BasePage;
import org.testng.Assert;

import com.test.PageAction.LoginLogout.BasePage;

public class OperationLicense_Page extends BasePage{
	
	String addIdNum="自动化新增证照号码"+getDateTime();//添加时生成证照号码
	String changeIdNum="自动化修改后证照号码"+getDateTime();//修改后生成证照号码

	public OperationLicense_Page(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public void operationLicense() throws Exception{
		// 进入页面
		implicitlyWait(1000);
		findElement("zzglObject").click();
		Thread.sleep(1000);
		findElement("yyzzObject").click();
		WebElement iframeElement =findElement("iframeObject");
		driver.switchTo().frame(iframeElement);
	}

	public void operationLicense_Search() throws Exception{
		//查询功能
		findElement("projectIdObject").sendKeys(getTestData("项目编码_yyzz"));
		findElement("storeNameObject").sendKeys(getTestData("门店名称_yyzz"));	
		selectByVisibleTextFromExcel(findElement("brandIdObject"),"品牌_yyzz");
		selectByVisibleTextFromExcel(findElement("certCategoryObject"),"证照名称_yyzz");
		selectByVisibleTextFromExcel(findElement("reviewFlagObject"),"审核状态_yyzz");
		findElement("searchBtnObject").click();
		Thread.sleep(1000);	
		
		AssertEqualsFromExcel(findElement("projectidTextObject").getText(),"项目编码_yyzz");
		AssertEqualsFromExcel(findElement("storeTextObject").getText(),"门店名称_yyzz");	
		AssertEqualsFromExcel(findElement("flagTextObject").getText(),"审核状态_yyzz");
	}
	
	public void operationLicense_Reset() throws Exception{
		//重置功能
		operationLicense_Search();
		findElement("resetBtnObject").click();
		Thread.sleep(2000);
		
		Assert.assertTrue(findElement("projectIdObject").getAttribute("value").isEmpty());
		Assert.assertTrue(findElement("storeNameObject").getAttribute("value").isEmpty());
		Assert.assertFalse(findElement("recordObject").getText().contains("显示第 1 到第 1 条记录，总共 1 条记录"));
	}
	
	public void operationLicense_ViewDetail() throws Exception{
	    //查看功能
		operationLicense_Search();
		findElement("checkBtnObject").click();
		Thread.sleep(1000);
		//验证是否相同
		AssertEqualsFromExcel(findElement("storeCheckTextObject").getText(),"门店名称_yyzz");	
		AssertEqualsFromExcel(findElement("brandCheckTextObject").getText(),"品牌_yyzz");	
		AssertEqualsFromExcel(findElement("idNameCheckTextObject").getText(),"证照名称_yyzz");
		AssertEqualsFromExcel(findElement("flagCheckTextObject").getText(),"审核状态_yyzz");
		findElement("licenceListBtnObject").click();
		Thread.sleep(1000);
		Assert.assertTrue(findElement("searchBtnObject").isDisplayed());
	}
	
	public void operationLicense_Change() throws Exception{
	   //修改功能
		operationLicense_Search();
		findElement("changeBtnObject").click();
		Thread.sleep(2000);
		//修改信息
		findElement("idNumInputObject").clear();	
		findElement("idNumInputObject").sendKeys(changeIdNum);	
		findElement("submitBtnObject").click();
		Thread.sleep(2000);
		//验证修改信息
		operationLicense_Search();
		Assert.assertEquals(findElement("idNumTextObject").getText(),changeIdNum);
		//恢复修改数据
		findElement("changeBtnObject").click();
		Thread.sleep(2000);
		findElement("idNumInputObject").clear();	
		findElement("idNumInputObject").sendKeys(getTestData("证照号码_yyzz"));	
		findElement("submitBtnObject").click();
		Thread.sleep(2000);
	}

	public void operationLicense_Add() throws Exception{
		//添加运营证照
		findElement("addBtnObject").click();
		Thread.sleep(1000);		
		//确定添加的门店
		findElement("storeInputObject").sendKeys(getTestData("门店名称2_yyzz"));	
		findElement("storeserchBtnObject").click();
		Thread.sleep(1000);		
		findElement("storeObject").click();
		Thread.sleep(1000);	
		//添加界面
		selectByVisibleTextFromExcel(findElement("idNameInputObject"),"证照名称2_yyzz");
		findElement("idNumInputObject").sendKeys(addIdNum);
		findElement("addpictureBtnObject").click();	
		Thread.sleep(1000);
//		String photoPath=System.getProperty("user.dir")+"\\src\\com\\test\\TestData\\"+"证照图片.png";
//		findElement("fileObject").sendKeys(photoPath);
//		findElement("uploadBtnObject").click();	测试机不连外网，无法上传图片
		Thread.sleep(1000);	 
		findElement("submitBtnObject").click();
		Thread.sleep(2000);	
		//验证是否添加成功
		findElement("storeNameObject").sendKeys(getTestData("门店名称2_yyzz"));	
		selectByVisibleTextFromExcel(findElement("certCategoryObject"),"证照名称2_yyzz");
		findElement("searchBtnObject").click();
		Thread.sleep(1000);		
		Assert.assertEquals(findElement("idNumTextObject").getText(),addIdNum);
		Assert.assertEquals(findElement("flagTextObject").getText(),"待审核");
	}
	
	public void operationLicense_Review_Adopt() throws Exception{
	//审核通过功能,调用添加，然后审核添加的那条记录
		operationLicense_Add();
		findElement("reviewBtnObject").click();
		Thread.sleep(4000);	
		//审核界面
		Assert.assertEquals(findElement("idNumReviewTextObject").getText(),addIdNum);
		findElement("passObject").click();
		findElement("viewBtnObject").click();
		Thread.sleep(2000);	
		//验证是否审核成功
		findElement("storeNameObject").sendKeys(getTestData("门店名称2_yyzz"));	
		selectByVisibleTextFromExcel(findElement("certCategoryObject"),"证照名称2_yyzz");
		findElement("searchBtnObject").click();
		Thread.sleep(1000);		
		Assert.assertEquals(findElement("idNumTextObject").getText(),addIdNum);
		Assert.assertEquals(findElement("flagTextObject").getText(),"已审核");
	}
	
/*	public void operationLicense_Review_Return() throws Exception{
	//审核退回功能，调用添加，然后审核添加的那条记录
		operationLicense_Add();
		findElement("reviewBtnObject").click();
		Thread.sleep(4000);	
		//审核界面
		Assert.assertEquals(findElement("idNumReviewTextObject").getText(),addIdNum);
		findElement("notpassObject").click();
		findElement("remarkObject").sendKeys("审核意见是不通过");
		findElement("viewBtnObject").click();
		Thread.sleep(2000);	
		//验证是否审核退回
		findElement("storeNameObject").sendKeys(getTestData("门店名称2_yyzz"));	
		selectByVisibleTextFromExcel(findElement("certCategoryObject"),"证照名称2_yyzz");
		findElement("searchBtnObject").click();
		Thread.sleep(1000);		
		Assert.assertEquals(findElement("idNumTextObject").getText(),addIdNum);
		Assert.assertEquals(findElement("flagTextObject").getText(),"退回");
	}*/
	
}
