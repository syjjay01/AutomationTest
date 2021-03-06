package com.test.PageAction.StoreMgmt;

//import org.openqa.selenium.JavascriptExecutor;

//import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.test.PageAction.LoginLogout.BasePage;

public class Renew_Page extends BasePage{
	
	String changeNote="自动化续约说明修改时间"+getDateTime();//修改
	String addNote="自动化续约说明新增时间"+getDateTime();//新增
	String addPhone=getTelPhone();//新增
	
	public Renew_Page(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public void renew() throws Exception{
		// 进入页面
		implicitlyWait(1000);
		findElement("mdglObject").click();
		Thread.sleep(1000);
		findElement("xyObject").click();
		Thread.sleep(1000);
		WebElement iframeElement =findElement("iframeObject");
		driver.switchTo().frame(iframeElement);
	}

	public void renew_Search() throws Exception{
		//查询功能
		findElement("projectIdObject").sendKeys(getTestData("项目编码_xy"));
		findElement("storeNameObject").sendKeys(getTestData("门店名称_xy"));	
		findElement("searchBtnObject").click();
		Thread.sleep(1000);	
		//验证查询
		AssertEqualsFromExcel(findElement("projectIdTextObject").getText(),"项目编码_xy");
		AssertEqualsFromExcel(findElement("stroreTextObject").getText(),"门店名称_xy");	
	}
	
	public void renew_Reset() throws Exception{
		//重置功能
		String oldRecordText=findElement("recordObject").getText();
		findElement("resetBtnObject").click();
		Thread.sleep(2000);
		Assert.assertTrue(findElement("projectIdObject").getAttribute("value").isEmpty());
		Assert.assertTrue(findElement("storeNameObject").getAttribute("value").isEmpty());
		String newRecordText=findElement("recordObject").getText();
		Assert.assertNotSame(oldRecordText, newRecordText);
	}
	
	  //查看功能
	public void renew_ViewDetail() throws Exception{
		renew_Search();	
		findElement("checkBtnObject").click();
		Thread.sleep(2000);
		AssertEqualsFromExcel(findElement("projectIdCheckObject").getText(),"项目编码_xy");
		findElement("renewListBtnObject").click();
		Thread.sleep(1000);
		Assert.assertTrue(findElement("searchBtnObject").isDisplayed());
	}	
	
	//修改功能
	public void renew_Change() throws Exception{
		renew_Search();
		findElement("changeBtnObject").click();
		Thread.sleep(2000);
		
		AssertEqualsFromExcel(findElement("changeNoteObject").getText(),"续约说明_xy");
		findElement("changeNoteObject").clear();	
		findElement("changeNoteObject").sendKeys(changeNote);	
		findElement("saveObject").click();
		Thread.sleep(2000);
		
		//验证修改
		renew_Search();
	    findElement("changeBtnObject").click();
	    Thread.sleep(2000);
		Assert.assertEquals(findElement("changeNoteObject").getText(),changeNote);
		//恢复修改数据
		findElement("changeNoteObject").clear();	
		findElement("changeNoteObject").sendKeys(getTestData("续约说明_xy"));
		findElement("saveObject").click();
		Thread.sleep(2000);		
    }
	
	
	
	
	
	//添加功能注释掉:服务器没办法链接外网，上传图片无法保存成功
//	public void renew_Add() throws Exception{
//		//添加功能
//		findElement("addNewObject").click();
//		Thread.sleep(1000);	
//		//选择门店
//		String storeNameSel = getWriteData("合同_ContractProcess");
//		findElement("storeInputObject").sendKeys(storeNameSel);	
//		findElement("serchBtn1Object").click();
//		Thread.sleep(1000);		
//		findElement("storeObject").click();
//		Thread.sleep(1000);		
//		//添加界面（必填项)
//		String roomStr=findElement("roomTextObject").getText();//获取原合同的立项房间数文本“xxx 间”
//		String[] roomNum=roomStr.split("\\s+");//以空格分割获取的文本
//		findElement("roomInpObject").sendKeys(roomNum[0]);//取数组的第一个值（即是文本中的数字“xxx”）,获取房间数后赋给立项房间数	
//		findElement("renewFeeInpObject").sendKeys(getTestData("续约加盟费标准_xy"));	
//		findElement("receieFeeInpObject").sendKeys(getTestData("应收加盟费_xy"));	
//		findElement("manageRateInpObject").sendKeys(getTestData("续约管理费率_xy"));	
//		//获取原合同的截止时间，新合同开始时间=原合同截止时间，新合同截止时间=新合同开始时间后一年
//		String startTime=findElement("dataTextObject").getText();
//		String[] dataGroup=startTime.split("\\-");
//		int year = Integer.valueOf(dataGroup[0]).intValue()+1;
//		String endTime = Integer.toString(year)+"-"+dataGroup[1]+"-"+dataGroup[2];
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].value=arguments[1]",findElement("startTimeObject"), startTime); 
//		js.executeScript("arguments[0].value=arguments[1]",findElement("endTimeObject"), endTime); 
//		
////		sendKeystoReadOnlyField(findElement("startTimeObject"), "续约开始时间_xy");
////		sendKeystoReadOnlyField(findElement("endTimeObject"), "续约截至时间_xy");
//		findElement("noteInpObject").sendKeys(addNote);	
//		findElement("signInpObject").sendKeys(getTestData("签约人/单位_xy"));	
//		selectByVisibleTextFromExcel(findElement("idTypeSelObject"),"证件类型_xy");	
//		findElement("idNoInpObject").sendKeys(getTestData("证件号_xy"));	
//		findElement("phoneInpObject").sendKeys(addPhone);	
//		selectByVisibleTextFromExcel(findElement("payModeSelObject"),"支付方式_xy");
//		findElement("remarkObject").sendKeys(getTestData("备注_xy"));		
//		findElement("contractBtnObject").click();	//点击附件
//		Thread.sleep(1000);
////		upLoad();//上传操作
//		String photoPath=System.getProperty("user.dir")+"\\src\\com\\test\\TestData\\"+"测试上传图片.jpg";
//		findElement("fileObject").sendKeys(photoPath);
//		findElement("uploadBtnObject").click();	//上传按钮
//		Thread.sleep(5000);	
//		findElement("saveBtnObject").click();	//保存
//		Thread.sleep(6000);
//	    //验证保存是否成功
//		findElement("storeNameObject").sendKeys(storeNameSel);
//		findElement("searchBtnObject").click();
//		Thread.sleep(1000);	
//		Assert.assertEquals(findElement("stroreTextObject").getText(),storeNameSel);
//		Assert.assertEquals(findElement("FlagTextObject").getText(), "待提交");
////		//进入界面继续提交
//		findElement("changeBtnObject").click();
//		Thread.sleep(1000);
//		findElement("sumbitBtnObject").click();
//		Thread.sleep(1000);
//		findElement("OKBtnObject").click();
//		Thread.sleep(5000);
//		findElement("storeNameObject").sendKeys(storeNameSel);
//		findElement("searchBtnObject").click();
//		//验证提交是否成功
//		Assert.assertEquals(findElement("stroreTextObject").getText(),storeNameSel);
//		Assert.assertEquals(findElement("FlagTextObject").getText(), "待审");
//	}

//	public void upLoad() throws Exception{
//	//上传文件函数
//	findElement("fileObject").click();
//	Thread.sleep(2000);
//	Runtime.getRuntime().exec("E:\\workspace\\Eclipseworkplace\\qqmdUIAutomation\\upload download\\续约合同附件.exe");
//	Thread.sleep(5000);
//}	
	
}
