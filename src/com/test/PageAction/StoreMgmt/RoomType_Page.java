package com.test.PageAction.StoreMgmt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.test.PageAction.LoginLogout.BasePage;

public class RoomType_Page extends BasePage{
	
	String addRoomName = "自动化自编房" + getDateTime();//添加时自动生成房型名称
	String addRoomCode = "AUTO"+getRandomString(5);//添加时自动生成房型编码
	String changeRoomName= "自动化变更房" + getDateTime();//变更时自动生成房型名称
	
	public RoomType_Page(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public void roomType() throws Exception{
		// 进入页面
		implicitlyWait(1000);
		Thread.sleep(2000);
		findElement("mdglObject").click();
		Thread.sleep(1000);
		findElement("fxObject").click();
		WebElement iframeElement =findElement("iframeObject");
		driver.switchTo().frame(iframeElement);
	}

	//房型列表
	public void roomTypeList_Search() throws Exception{
		//查询功能
		findElement("TypeNameObject").sendKeys(getTestData("房型名称_fx"));
		findElement("RoomTypeCodeObject").sendKeys(getTestData("房型编码_fx"));
		selectByVisibleTextFromExcel(findElement("RoomTypeObject"),"房型类型_fx");
		findElement("searchBtnObject").click();
		Thread.sleep(2000);
		AssertEqualsFromExcel(findElement("roomNameTextObject").getText(),"房型名称_fx");
		AssertEqualsFromExcel(findElement("roomCodeTextObject").getText(),"房型编码_fx");
	}
	
	//房型列表
	public void roomTypeList_Reset() throws Exception{
		//重置功能
		roomTypeList_Search();
		String oldRecordText=findElement("recordObject").getText();
		findElement("resetBtnObject").click();
		Thread.sleep(2000);
		Assert.assertTrue(findElement("TypeNameObject").getAttribute("value").isEmpty());
		Assert.assertTrue(findElement("RoomTypeCodeObject").getAttribute("value").isEmpty());
		String newRecordText=findElement("recordObject").getText();
		Assert.assertNotSame(oldRecordText, newRecordText);
	}
	
	//房型变更申请：验证页面正常打开
	public void roomType_Apply() throws Exception{
		findElement("roomTypeApplyBtnObject").click();
		Thread.sleep(1000);
		Assert.assertEquals(findElement("roomTypeTitleObject").getText(),"房型变更申请");
	}

	//房型变更历史: 进入页面，点击查看按钮，返回历史界面
	public void roomType_History() throws Exception{
		findElement("roomTypeHisBtnObject").click(); 
		Thread.sleep(1000);
		findElement("checkBtnObject").click();
		Thread.sleep(1000);
		Assert.assertTrue(findElement("roomTypeTitleObject").getText().contains("房型变更申请"));
		findElement("roomTypeHisBtnObject").click(); 
		Thread.sleep(1000);
		Assert.assertTrue(findElement("roomTypeTitleObject").getText().contains("房型变更历史"));
	}

	
	
	/*
	
	public void roomTypeHistory_Verify(String changeContent,String changeTpye) throws Exception{
		//验证函数
		findElement("roomTypeHisBtnObject").click();
		Thread.sleep(1000);	
		//验证变更历史界面是否存在操作的记录
	    Assert.assertEquals(findElement("chageContentTextObject").getText(),changeContent);
	    Assert.assertEquals(findElement("chageTypeTextObject").getText(),changeTpye);
	   //验证存在记录后，进行撤销
	  	if (findElement("revokeBtnObject").isDisplayed()){
	  		findElement("revokeBtnObject").click();
	  		Thread.sleep(2000);	
	  		findElement("revokeOkBtnObject").click();
	  		Thread.sleep(1000);	
	  		findElement("successTextObject").click();
	  		Thread.sleep(1000);	
	  		findElement("closeObject").click();
	  		Thread.sleep(2000);	
	  		//验证是否撤销成功
	  		Assert.assertEquals(findElement("timeTextObject").getAttribute("class"),"gray");		
	  	}else{
	  		System.out.println("没有撤销按钮，不可撤销操作");
	  	}  
	}
	
	public void roomTypeHistory_Check() throws Exception{
		//变更历史查看功能
		//进入变更历史界面
		findElement("roomTypeHisBtnObject").click();
		Thread.sleep(1000);	
	    //查看记录	
		if(findElement("checkBtnObject").getAttribute("title").equals("查看")){
			String changeTypeCheck=findElement("chageTypeTextObject").getText();
			String changeContentCheck=findElement("chageContentTextObject").getText();
			findElement("checkBtnObject").click();
			Thread.sleep(2000);			
			//验证查看
			Assert.assertTrue(findElement("roomTypeNameCheckObject").getText().contains(changeContentCheck));
			Assert.assertTrue(changeTypeCheck.contains(findElement("chageTypeCheckObject").getText()));
		}else{
			System.out.println("没有查看按钮，不可查看操作");
		}		
    }

	public void roomType_Add() throws Exception{
		//添加房型
		findElement("roomTypeApplyBtnObject").click();
		findElement("addRoomTypeTabObject").click();
		//添加tab页面
		findElement("addRoomTypeNameObject").sendKeys(addRoomName);
		findElement("addRoomTypeCodeObject").sendKeys(addRoomCode);
		selectByVisibleText(findElement("addRoomTypeObject"), "基础房型");
		findElement("addReasonObject").sendKeys("申请新增房型原因");
		findElement("addBtnObject").click();
		Thread.sleep(2000);
		findElement("submitBtnObject").click();
		Thread.sleep(2000);	
		findElement("closeBtnObject").click();
		Thread.sleep(1000);	
		roomTypeHistory_Verify(addRoomName,"添加房型（1间）");//验证变更历史存在记录		
	}
	
	public void roomType_Change() throws Exception{
		//变更房型名称
		findElement("roomTypeApplyBtnObject").click();
		findElement("changeRoomTypeTabObject").click();
		//变更房型tab页面
		findElement("changeBoxObject").click();
		findElement("nextBtnObject").click();
		Thread.sleep(2000);
		findElement("changeRoomTypeObject").sendKeys(changeRoomName);
		findElement("changeReasonObject").sendKeys("申请变更房型名称原因");
	    findElement("changeBtnObject").click();
		Thread.sleep(2000);	
		findElement("submitBtnObject").click();
		Thread.sleep(2000);	
		findElement("closeBtnObject").click();
		Thread.sleep(1000);	
		roomTypeHistory_Verify(changeRoomName,"修改房型（1间）");//验证变更历史存在记录
	}
	
	public void roomType_Delete() throws Exception{
		//删除房型
		findElement("roomTypeApplyBtnObject").click();
		findElement("deleteRoomTypeTabObject").click();
		//删除房型tab页面
		findElement("deleteBoxObject").click();
		String roomTypeNameDel=findElement("deleteRoomTypeObject").getText();	
		findElement("deleteReasonObject").sendKeys("申请删除房型的原因");
	    findElement("deleteBtnObject").click();
		Thread.sleep(2000);	
		findElement("submitBtnObject").click();
		Thread.sleep(2000);	
		findElement("closeBtnObject").click();
		Thread.sleep(1000);	
		roomTypeHistory_Verify(roomTypeNameDel,"删除房型（1间）");//验证变更历史存在记录
	}
	
	public void roomType_Shield() throws Exception{
		//屏蔽房型
		findElement("roomTypeApplyBtnObject").click();
		findElement("shieldRoomTypeTabObject").click();
		//屏蔽房型tab页面
		findElement("shieldBoxObject").click();
		String roomTypeNameShie=findElement("shieldRoomTypeObject").getText();	
		findElement("shieldReasonObject").sendKeys("申请屏蔽房型的原因");
	    findElement("shieldBtnObject").click();
		Thread.sleep(2000);	
		findElement("submitBtnObject").click();
		Thread.sleep(2000);	
		findElement("closeBtnObject").click();
		Thread.sleep(1000);	
		roomTypeHistory_Verify(roomTypeNameShie,"屏蔽房型（1间）");//验证变更历史存在记录
	}
	
	public void roomType_Delrecover() throws Exception{
		//恢复删除房型
		findElement("roomTypeApplyBtnObject").click();
		findElement("recoverRoomTypeTabObject").click();
		Thread.sleep(4000);	
		findElement("deleteRecObject").click();
		//恢复删除房型tab页面
		Thread.sleep(4000);	
		findElement("recoverDelBoxObject").click();
		String roomTypeNameDelRev=findElement("roomTypeDelObject").getText();	
	    findElement("recoverDelBtnObject").click();
		Thread.sleep(2000);	
		findElement("submitBtnObject").click();
		Thread.sleep(2000);	
		findElement("closeBtnObject").click();
		Thread.sleep(1000);	
		roomTypeHistory_Verify(roomTypeNameDelRev,"恢复房型（1间）");//验证变更历史存在记录
	}
	
	public void roomType_Shierecover() throws Exception{
		//恢复屏蔽房型
		findElement("roomTypeApplyBtnObject").click();
		findElement("recoverRoomTypeTabObject").click();
		findElement("shieldRecObject").click();
		//恢复删除房型tab页面
		findElement("recoverShieBoxObject").click();
		String roomTypeNameShieRev=findElement("roomTypeShieObject").getText();	
	    findElement("recoverShieBtnObject").click();
		Thread.sleep(2000);	
		findElement("submitBtnObject").click();
		Thread.sleep(2000);	
		findElement("closeBtnObject").click();
		Thread.sleep(1000);	
		roomTypeHistory_Verify(roomTypeNameShieRev,"恢复房型（1间）");//验证变更历史存在记录	
	}
		*/	
}
