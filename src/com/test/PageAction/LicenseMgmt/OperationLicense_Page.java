package com.test.PageAction.LicenseMgmt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import com.test.PageAction.Login.BasePage;
import org.testng.Assert;

import com.test.PageAction.LoginLogout.BasePage;

public class OperationLicense_Page extends BasePage{
	
	String addIdNum="�Զ�������֤�պ���"+getDateTime();//����ʱ����֤�պ���
	String changeIdNum="�Զ����޸ĺ�֤�պ���"+getDateTime();//�޸ĺ�����֤�պ���

	public OperationLicense_Page(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public void operationLicense() throws Exception{
		// ����ҳ��
		implicitlyWait(1000);
		findElement("zzglObject").click();
		Thread.sleep(1000);
		findElement("yyzzObject").click();
		WebElement iframeElement =findElement("iframeObject");
		driver.switchTo().frame(iframeElement);
	}

	public void operationLicense_Search() throws Exception{
		//��ѯ����
		findElement("projectIdObject").sendKeys(getTestData("��Ŀ����_yyzz"));
		findElement("storeNameObject").sendKeys(getTestData("�ŵ�����_yyzz"));	
		selectByVisibleTextFromExcel(findElement("brandIdObject"),"Ʒ��_yyzz");
		selectByVisibleTextFromExcel(findElement("certCategoryObject"),"֤������_yyzz");
		selectByVisibleTextFromExcel(findElement("reviewFlagObject"),"���״̬_yyzz");
		findElement("searchBtnObject").click();
		Thread.sleep(1000);	
		
		AssertEqualsFromExcel(findElement("projectidTextObject").getText(),"��Ŀ����_yyzz");
		AssertEqualsFromExcel(findElement("storeTextObject").getText(),"�ŵ�����_yyzz");	
		AssertEqualsFromExcel(findElement("flagTextObject").getText(),"���״̬_yyzz");
	}
	
	public void operationLicense_Reset() throws Exception{
		//���ù���
		operationLicense_Search();
		findElement("resetBtnObject").click();
		Thread.sleep(2000);
		
		Assert.assertTrue(findElement("projectIdObject").getAttribute("value").isEmpty());
		Assert.assertTrue(findElement("storeNameObject").getAttribute("value").isEmpty());
		Assert.assertFalse(findElement("recordObject").getText().contains("��ʾ�� 1 ���� 1 ����¼���ܹ� 1 ����¼"));
	}
	
	public void operationLicense_ViewDetail() throws Exception{
	    //�鿴����
		operationLicense_Search();
		findElement("checkBtnObject").click();
		Thread.sleep(1000);
		//��֤�Ƿ���ͬ
		AssertEqualsFromExcel(findElement("storeCheckTextObject").getText(),"�ŵ�����_yyzz");	
		AssertEqualsFromExcel(findElement("brandCheckTextObject").getText(),"Ʒ��_yyzz");	
		AssertEqualsFromExcel(findElement("idNameCheckTextObject").getText(),"֤������_yyzz");
		AssertEqualsFromExcel(findElement("flagCheckTextObject").getText(),"���״̬_yyzz");
		findElement("licenceListBtnObject").click();
		Thread.sleep(1000);
		Assert.assertTrue(findElement("searchBtnObject").isDisplayed());
	}
	
	public void operationLicense_Change() throws Exception{
	   //�޸Ĺ���
		operationLicense_Search();
		findElement("changeBtnObject").click();
		Thread.sleep(2000);
		//�޸���Ϣ
		findElement("idNumInputObject").clear();	
		findElement("idNumInputObject").sendKeys(changeIdNum);	
		findElement("submitBtnObject").click();
		Thread.sleep(2000);
		//��֤�޸���Ϣ
		operationLicense_Search();
		Assert.assertEquals(findElement("idNumTextObject").getText(),changeIdNum);
		//�ָ��޸�����
		findElement("changeBtnObject").click();
		Thread.sleep(2000);
		findElement("idNumInputObject").clear();	
		findElement("idNumInputObject").sendKeys(getTestData("֤�պ���_yyzz"));	
		findElement("submitBtnObject").click();
		Thread.sleep(2000);
	}

	public void operationLicense_Add() throws Exception{
		//������Ӫ֤��
		findElement("addBtnObject").click();
		Thread.sleep(1000);		
		//ȷ�����ӵ��ŵ�
		findElement("storeInputObject").sendKeys(getTestData("�ŵ�����2_yyzz"));	
		findElement("storeserchBtnObject").click();
		Thread.sleep(1000);		
		findElement("storeObject").click();
		Thread.sleep(1000);	
		//���ӽ���
		selectByVisibleTextFromExcel(findElement("idNameInputObject"),"֤������2_yyzz");
		findElement("idNumInputObject").sendKeys(addIdNum);
		findElement("addpictureBtnObject").click();	
		Thread.sleep(1000);
//		String photoPath=System.getProperty("user.dir")+"\\src\\com\\test\\TestData\\"+"֤��ͼƬ.png";
//		findElement("fileObject").sendKeys(photoPath);
//		findElement("uploadBtnObject").click();	���Ի������������޷��ϴ�ͼƬ
		Thread.sleep(1000);	 
		findElement("submitBtnObject").click();
		Thread.sleep(2000);	
		//��֤�Ƿ����ӳɹ�
		findElement("storeNameObject").sendKeys(getTestData("�ŵ�����2_yyzz"));	
		selectByVisibleTextFromExcel(findElement("certCategoryObject"),"֤������2_yyzz");
		findElement("searchBtnObject").click();
		Thread.sleep(1000);		
		Assert.assertEquals(findElement("idNumTextObject").getText(),addIdNum);
		Assert.assertEquals(findElement("flagTextObject").getText(),"�����");
	}
	
	public void operationLicense_Review_Adopt() throws Exception{
	//���ͨ������,�������ӣ�Ȼ��������ӵ�������¼
		operationLicense_Add();
		findElement("reviewBtnObject").click();
		Thread.sleep(4000);	
		//��˽���
		Assert.assertEquals(findElement("idNumReviewTextObject").getText(),addIdNum);
		findElement("passObject").click();
		findElement("viewBtnObject").click();
		Thread.sleep(2000);	
		//��֤�Ƿ���˳ɹ�
		findElement("storeNameObject").sendKeys(getTestData("�ŵ�����2_yyzz"));	
		selectByVisibleTextFromExcel(findElement("certCategoryObject"),"֤������2_yyzz");
		findElement("searchBtnObject").click();
		Thread.sleep(1000);		
		Assert.assertEquals(findElement("idNumTextObject").getText(),addIdNum);
		Assert.assertEquals(findElement("flagTextObject").getText(),"�����");
	}
	
/*	public void operationLicense_Review_Return() throws Exception{
	//����˻ع��ܣ��������ӣ�Ȼ��������ӵ�������¼
		operationLicense_Add();
		findElement("reviewBtnObject").click();
		Thread.sleep(4000);	
		//��˽���
		Assert.assertEquals(findElement("idNumReviewTextObject").getText(),addIdNum);
		findElement("notpassObject").click();
		findElement("remarkObject").sendKeys("�������ǲ�ͨ��");
		findElement("viewBtnObject").click();
		Thread.sleep(2000);	
		//��֤�Ƿ�����˻�
		findElement("storeNameObject").sendKeys(getTestData("�ŵ�����2_yyzz"));	
		selectByVisibleTextFromExcel(findElement("certCategoryObject"),"֤������2_yyzz");
		findElement("searchBtnObject").click();
		Thread.sleep(1000);		
		Assert.assertEquals(findElement("idNumTextObject").getText(),addIdNum);
		Assert.assertEquals(findElement("flagTextObject").getText(),"�˻�");
	}*/
	
}