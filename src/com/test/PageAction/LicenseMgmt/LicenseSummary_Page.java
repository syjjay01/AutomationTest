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
		// ����ҳ��
		implicitlyWait(1000);
		findElement("zzglObject").click();
		Thread.sleep(1000);
		findElement("zzqmbObject").click();
		WebElement iframeElement =findElement("iframeObject");
		driver.switchTo().frame(iframeElement);
	}

	public void licenseSummary_Search() throws Exception{
		//��ѯ����
		findElement("projectIdObject").sendKeys(getTestData("��Ŀ����_zzqmb"));
		findElement("storeNameObject").sendKeys(getTestData("�ŵ�����_zzqmb"));	
		selectByVisibleTextFromExcel(findElement("brandIdObject"),"Ʒ��_zzqmb");
		selectByVisibleTextFromExcel(findElement("brandTypeIdObject"),"����_zzqmb");
		selectByVisibleTextFromExcel(findElement("FlagObject"),"״̬_zzqmb");
		findElement("searchBtnObject").click();
		Thread.sleep(1000);	
		//��֤��ѯ����
		AssertEqualsFromExcel(findElement("projectIdTextObject").getText(),"��Ŀ����_zzqmb");
		AssertEqualsFromExcel(findElement("storeTextObject").getText(),"�ŵ�����_zzqmb");	
		AssertEqualsFromExcel(findElement("flagTextObject").getText(),"״̬_zzqmb");	
		AssertEqualsFromExcel(findElement("branIdTextObject").getText(),"Ʒ��_zzqmb");
		AssertEqualsFromExcel(findElement("branTypeTextObject").getText(),"����_zzqmb");
		Thread.sleep(1000);	
	}
	
	public void licenseSummary_Reset() throws Exception{
		//���ù���
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