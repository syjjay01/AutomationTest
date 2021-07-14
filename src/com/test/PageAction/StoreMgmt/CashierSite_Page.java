package com.test.PageAction.StoreMgmt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.test.PageAction.LoginLogout.BasePage;

public class CashierSite_Page extends BasePage{
	
	String posName="�Զ�������������"+getDateTime();
	
	public CashierSite_Page(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public void cashierSite() throws Exception{
		// ����ҳ��
		implicitlyWait(1000);
		findElement("mdglObject").click();
		findElement("sydObject").click();
		WebElement iframeElement =findElement("iframeObject");
		driver.switchTo().frame(iframeElement);
	}

	public void cashierSite_Search() throws Exception{
		//��ѯ����
		findElement("storenameObject").sendKeys(getTestData("�ŵ�����_syd"));
		findElement("posnameObject").sendKeys(getTestData("����������_syd"));
		findElement("searchBtnObject").click();
		Thread.sleep(2000);
		AssertEqualsFromExcel(findElement("posnameTextObject").getText(),"����������_syd");
		AssertEqualsFromExcel(findElement("storenameTextObject").getText(),"�ŵ�����_syd");
	}
	
	public void cashierSite_Reset() throws Exception{
		//���ù���
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
		//�鿴����
		cashierSite_Search();
		findElement("viewBtnObject").click();
		Thread.sleep(1000);
		AssertEqualsFromExcel(findElement("posnameTextObject3").getText(),"����������_syd");
		findElement("postListBtnObject").click();
		Assert.assertTrue(findElement("searchBtnObject").isDisplayed());
	}
	
	public void cashierSite_Update() throws Exception{
	    //�޸Ĺ���
		cashierSite_Search();
		AssertEqualsFromExcel(findElement("posflagTextObject").getText(),"������״̬_syd");
		findElement("updateBtnObject").click();
		Thread.sleep(1000);
		selectByVisibleTextFromExcel(findElement("flagSelObject"), "������״̬2_syd");
		findElement("submitBtnObject").click();
		Thread.sleep(2000);
		cashierSite_Search();
		AssertEqualsFromExcel(findElement("posflagTextObject").getText(),"������״̬2_syd");
		//�ָ��޸�����
		findElement("updateBtnObject").click();
		Thread.sleep(1000);
		selectByVisibleTextFromExcel(findElement("flagSelObject"), "������״̬_syd");
		findElement("submitBtnObject").click();
		Thread.sleep(2000);
	}	

	public void cashierSite_Add() throws Exception{
		//����������
		findElement("addBtnObject").click();
		findElement("storenameTextObject2").click();
		findElement("posnameTextObject2").sendKeys(posName);
		selectByVisibleTextFromExcel(findElement("postypeTextObject2"), "����������_syd");
		findElement("submitBtnObject2").click();
		Thread.sleep(2000);
		findElement("posnameObject").sendKeys(posName);
		findElement("postypeObject").sendKeys(getTestData("����������_syd"));
		findElement("searchBtnObject").click();
		Thread.sleep(2000);
		Assert.assertEquals(findElement("posnameTextObject").getText(), posName);	
	}
	
//	public void cashierSite_Update() throws Exception{
//		//�޸Ĺ���
//		cashierSite_Search();
//		WebElement posflagElement=findElement("posflagTextObject");
//		if (!posflagElement.getText().equals(getTestData("������״̬_syd"))){
//			Thread.sleep(2000);
//			findElement("updateBtnObject").click();
//			selectByVisibleTextFromExcel(findElement("comboBoxObject"), "������״̬_syd");
//			findElement("submitBtnObject").click();
//			Thread.sleep(2000);
//			findElement("storenameObject").sendKeys(getTestData("�ŵ�����_syd"));
//			findElement("posnameObject").sendKeys(getTestData("����������_syd"));
//			findElement("searchBtnObject").click();
//			Thread.sleep(2000);
//			WebElement posflagElement2=findElement("posflagTextObject");
//			AssertEqualsFromExcel(posflagElement2.getText(), "������״̬_syd");
//		}else{
//			Thread.sleep(2000);
//			findElement("updateBtnObject").click();
//			selectByVisibleTextFromExcel(findElement("comboBoxObject"), "������״̬2_syd");
//			findElement("submitBtnObject").click();
//			Thread.sleep(2000);
//			findElement("storenameObject").sendKeys(getTestData("�ŵ�����_syd"));
//			findElement("posnameObject").sendKeys(getTestData("����������_syd"));
//			findElement("searchBtnObject").click();
//			Thread.sleep(2000);
//			WebElement posflagElement3=findElement("posflagTextObject");
//			AssertEqualsFromExcel(posflagElement3.getText(), "������״̬2_syd");
//		}	
//	}
	
	
}