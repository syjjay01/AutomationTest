package com.test.PageAction.StoreMgmt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.test.PageAction.LoginLogout.BasePage;

public class Store_Page extends BasePage{
		
	public Store_Page(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public void store() throws Exception{
		// 进入页面
		implicitlyWait(1000);
		findElement("mdglObject").click();
		findElement("mdObject").click();
		WebElement iframeElement =findElement("iframeObject");
		driver.switchTo().frame(iframeElement);
	}
	
	public void store_Search() throws Exception{
		//查询功能
		Thread.sleep(5000);
		findElement("projectObject").sendKeys(getTestData("项目编码_md"));
		findElement("storeObject").sendKeys(getTestData("门店名称_md"));
		findElement("searchBtnObject").click();
		Thread.sleep(2000);
		AssertEqualsFromExcel(findElement("storeTextObject").getText(),"门店名称_md");
		AssertEqualsFromExcel(findElement("projectTextObject").getText(),"项目编码_md");		
	}
	
	public void store_Reset() throws Exception{
		//重置功能
		store_Search();
		String oldRecordText=findElement("recordObject").getText();
		findElement("resetBtnObject").click();
		Thread.sleep(5000);
		Assert.assertTrue(findElement("projectObject").getAttribute("value").isEmpty());
		Assert.assertTrue(findElement("storeObject").getAttribute("value").isEmpty());
		String newRecordText=findElement("recordObject").getText();
		Assert.assertNotSame(oldRecordText, newRecordText);
		findElement("resetBtnObject").click();
		Thread.sleep(5000);
	}
	
	public void store_ViewDetail() throws Exception{
		//查看功能
		store_Search();
		findElement("viewBtnObject").click();
		implicitlyWait(3000);
		AssertEqualsFromExcel(findElement("storeTextObject2").getText(),"门店名称_md");
		AssertEqualsFromExcel(findElement("projectTextObject2").getText(),"项目编码_md");	
		findElement("mdlbBtnObject").click();
		Assert.assertTrue(findElement("searchBtnObject").isDisplayed());
	}
	
	public void store_Change() throws Exception{
	//修改功能
		store_Search();
		findElement("updateBtnObject").click();
		Thread.sleep(3000);
		selectByVisibleTextFromExcel(findElement("currencySelObject"), "币种2_md");
		findElement("submitBtnObject").click();
		Thread.sleep(3000);
		findElement("mdlbBtnObject").click();
		store_Search();
		findElement("viewBtnObject").click();
		//验证是否修改成功
		AssertEqualsFromExcel(findElement("currencyTextObject").getText(), "币种2_md");
		//修改回原来的值
		findElement("mdlbBtnObject").click();
		Thread.sleep(3000);	
		store_Search();
		findElement("updateBtnObject").click();
		Thread.sleep(3000);
		selectByVisibleTextFromExcel(findElement("currencySelObject"), "币种1_md");
		findElement("submitBtnObject").click();
		Thread.sleep(3000);
		findElement("mdlbBtnObject").click();
		Thread.sleep(3000);
		store_Search();
		findElement("viewBtnObject").click();
		//验证是否修改回原值
		AssertEqualsFromExcel(findElement("currencyTextObject").getText(), "币种1_md");
		findElement("mdlbBtnObject").click();
		Thread.sleep(3000);
}
	
	public void store_CancelNewProduct() throws Exception{
		//取消新品功能
		findElement("projectObject").sendKeys(getTestData("项目编码2_md"));
		findElement("storeObject").sendKeys(getTestData("门店名称2_md"));
		findElement("searchBtnObject").click();
		Thread.sleep(1000);
		findElement("newProductBtnObject").click();
		Thread.sleep(1000);
		findElement("OKBtnObject").click();
		Thread.sleep(2000);
		Assert.assertTrue(findElement("warnObject").isDisplayed());
		//Assert.assertTrue(findElement("tipObject").getText().contains("申请已推送OA审批"));
		findElement("warnObject").click();
		Thread.sleep(2000);
		findElement("closewarnObject").click();
	}
	
	public void store_UpgradeNewProduct() throws Exception{
		//升级新品功能
		findElement("projectObject").sendKeys(getTestData("项目编码3_md"));
		findElement("storeObject").sendKeys(getTestData("门店名称3_md"));
		findElement("searchBtnObject").click();
		Thread.sleep(1000);
		findElement("newProductBtnObject").click();
		Thread.sleep(1000);
		findElement("OKBtnObject").click();
		Thread.sleep(2000);
		Assert.assertTrue(findElement("warnObject").isDisplayed());
		//Assert.assertTrue(findElement("tipObject").getText().contains("申请已推送OA审批"));
		findElement("warnObject").click();
		Thread.sleep(2000);
		findElement("closewarnObject").click();
	}
	

//	public void store_Change() throws Exception{
//		//修改功能
//		Thread.sleep(1000);
//		findElement("projectObject").sendKeys(getTestData("项目编码_md"));
//		findElement("storeObject").sendKeys(getTestData("门店名称_md"));
//		findElement("searchBtnObject").click();
//		Thread.sleep(1000);
//		WebElement natureElement=findElement("natureTextObject");
//		//如果门店性质不等于表格中的“门店性质_md”，则修改成表格数据，如果等于表格中的数据，则修改成表格中的“门店性质2_md”
//		if (!natureElement.getText().equals(getTestData("门店性质_md"))){
//			Thread.sleep(2000);
//			findElement("updateBtnObject").click();
//			selectByVisibleTextFromExcel(findElement("comboBoxObject"), "门店性质_md");
//			findElement("submitBtnObject").click();
//			Thread.sleep(2000);
//			findElement("projectObject").sendKeys(getTestData("项目编码_md"));
//			findElement("storeObject").sendKeys(getTestData("门店名称_md"));
//			findElement("searchBtnObject").click();
//			Thread.sleep(2000);
//			WebElement natureElement1=findElement("natureTextObject");
//			AssertEqualsFromExcel(natureElement1.getText(), "门店性质_md");
//		}else{
//			Thread.sleep(2000);
//			findElement("updateBtnObject").click();
//			selectByVisibleTextFromExcel(findElement("comboBoxObject"), "门店性质2_md");
//			findElement("submitBtnObject").click();
//			Thread.sleep(2000);
//			findElement("projectObject").sendKeys(getTestData("项目编码_md"));
//			findElement("storeObject").sendKeys(getTestData("门店名称_md"));
//			findElement("searchBtnObject").click();
//			Thread.sleep(2000);
//			WebElement natureElement2=findElement("natureTextObject");
//			AssertEqualsFromExcel(natureElement2.getText(), "门店性质2_md");
//		}	
//	}

}
