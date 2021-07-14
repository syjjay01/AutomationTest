package com.test.PageAction.StoreMgmt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.test.PageAction.LoginLogout.BasePage;

public class RoomNumber_Page extends BasePage{
	
	String addRoomNumber = "AUTOADD"+getRandomString(5);//新增时自动生成房号
	String changeRoomNumber="AUTOCHANGE"+getRandomString(6);//修改时自动生成房号
	
	public RoomNumber_Page(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public void roomNumber() throws Exception{
		// 进入页面
		implicitlyWait(1000);
		Thread.sleep(1000);
		findElement("mdglObject").click();
		findElement("fhObject").click();
		WebElement iframeElement =findElement("iframeObject");
		driver.switchTo().frame(iframeElement);
		//选择门店
		findElement("projectIdTextObject").sendKeys(getTestData("项目编号_fh"));
		findElement("serchBtnObject").click();
		Thread.sleep(1000);
		findElement("storeObject").click();
		Thread.sleep(2000);
	}

	//房号列表：按按楼栋楼层 或 按房型
	public void roomNumber_List() throws Exception{
		//查询功能
		findElement("floorRioObject").click();//按楼层查询
		AssertEqualsFromExcel(findElement("roomNumTextObject").getText(),"按楼栋楼层_fh");
		findElement("roomTypeRioObject").click();//按房型查询

		AssertEqualsFromExcel(findElement("roomNumTextObject").getText(),"按房型_fh");	
	}
	
	//房号变更申请：验证页面正常打开
	public void roomNumber_Apply() throws Exception{
		findElement("roomNumApplyBtnObject").click();
		Thread.sleep(1000);
		Assert.assertTrue(isElementPresent("addRoomNumTabObject"));
	}

	//房号变更历史：验证查看功能
	public void roomNumber_History() throws Exception{
		findElement("roomNumHisBtnObject").click(); 
		Thread.sleep(1000);
		findElement("checkBtnObject").click();
		Thread.sleep(1000);
		Assert.assertTrue(findElement("roomNumTitleObject").getText().contains("房号变更申请"));
		findElement("roomNumHisBtnObject").click(); 
		Thread.sleep(1000);
		Assert.assertTrue(findElement("roomNumTitleObject").getText().contains("房号变更历史"));
	}
	
/*	public void roomNumHistory_Verify(String changeContent,String changeTpye) throws Exception{
		findElement("roomNumHisBtnObject").click();
		Thread.sleep(1000);	
		//验证变更历史界面是否存在操作的记录
	    Assert.assertEquals(findElement("changeContentTextObject").getText(),changeContent);
	    Assert.assertEquals(findElement("changeTypeTextObject").getText(),changeTpye);
	    //验证有记录后，撤销记录
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
	
	public void roomNumHistory_Check() throws Exception{
		//变更历史查看功能
		//进入变更历史界面
		findElement("roomNumHisBtnObject").click();
		Thread.sleep(1000);	
	    //查看记录	
		String changeTypeCheck=findElement("changeTypeTextObject").getText();
		String peopleCheck=findElement("timeTextObject").getText();
		String flagCheck=findElement("flagTextObject").getText();
		findElement("checkBtnObject").click();
		Thread.sleep(2000);			
		//验证查看
		Assert.assertTrue(findElement("peopleCheckObject").getText().contains(peopleCheck));
		Assert.assertEquals(findElement("changeTypeCheckObject").getText(),changeTypeCheck);
		Assert.assertEquals(findElement("flagCheckObject").getText(),flagCheck);	
   }
	
	public void roomNumber_Add() throws Exception{
		//添加房号
		findElement("roomNumApplyBtnObject").click();
		findElement("addRoomNumTabObject").click();
		//添加tab页
		selectByVisibleText(findElement("addBuildObject"), "B栋");
		selectByVisibleText(findElement("addFloorObject"), "2层");
		selectByVisibleText(findElement("addRoomTypeBaseObject"), "双床房");
		findElement("addRoomNumObject").sendKeys(addRoomNumber);
		findElement("addReasonObject").sendKeys("申请新增房号原因");
		findElement("addBtnObject").click();
		Thread.sleep(2000);	
		findElement("submitBtnObject").click();
		Thread.sleep(2000);	
		roomNumHistory_Verify(addRoomNumber,"添加房号（1间）");//验证变更历史存在记录
	}
	
	public void roomNumber_Change() throws Exception{
		//修改房号
		findElement("roomNumApplyBtnObject").click();
		findElement("changeRoomNumTabObject").click();
		//修改tab页面（选中具体需要修改的房号）
		findElement("roomNumSelBtnObject").click();		
		findElement("roomNumChangeBoxObject").click();
		String changeRoomNumBefor=findElement("roomNumChangeTextObject").getText();	
		findElement("roomNumOKBtnObject").click();
		Thread.sleep(1000);
		//填写修改后的房号和原因以及提交
		findElement("changeRoomNumObject").sendKeys(changeRoomNumber);
		findElement("changeReasonObject").sendKeys("申请修改房号原因");
	    findElement("changeBtnObject").click();
		Thread.sleep(2000);	
		findElement("submitBtnObject").click();
		Thread.sleep(2000);	
		roomNumHistory_Verify(changeRoomNumBefor,"修改房号（1间）");//验证变更历史存在记录
	}
	
	public void roomNumber_Delete() throws Exception{
		//删除房号
		findElement("roomNumApplyBtnObject").click();
		findElement("deleteRoomNumTabObject").click();
		//删除tab页面
		findElement("roomNumDelBoxObject").click();
		String deleteRoomNum=findElement("roomNumDelTextObject").getText();	
		findElement("deleteReasonObject").sendKeys("申请删除房号的原因");
	    findElement("deleteBtnObject").click();
		Thread.sleep(2000);	
		findElement("submitBtnObject").click();
		Thread.sleep(2000);	
		roomNumHistory_Verify(deleteRoomNum,"删除房号（1间）");//验证变更历史存在记录
	}
	
	public void roomNumber_recover() throws Exception{
		//恢复房号
		findElement("roomNumApplyBtnObject").click();
		findElement("recoverRoomNumTabObject").click();
		//回复房号tab页面
		findElement("roomNumRecBoxObject").click();
		String recoverRoomNum=findElement("roomNumRecTextObject").getText();	
	    findElement("recoverBtnObject").click();
		Thread.sleep(2000);	
		findElement("submitBtnObject").click();
		Thread.sleep(2000);	
		roomNumHistory_Verify(recoverRoomNum,"恢复房号（1间）");//验证变更历史存在记录
	}
	*/
}
