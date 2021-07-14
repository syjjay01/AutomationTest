package com.test.PageAction.StoreMgmt;

//import org.openqa.selenium.JavascriptExecutor;

//import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.test.PageAction.LoginLogout.BasePage;

public class Renew_Page extends BasePage{
	
	String changeNote="�Զ�����Լ˵���޸�ʱ��"+getDateTime();//�޸�
	String addNote="�Զ�����Լ˵������ʱ��"+getDateTime();//����
	String addPhone=getTelPhone();//����
	
	public Renew_Page(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public void renew() throws Exception{
		// ����ҳ��
		implicitlyWait(1000);
		findElement("mdglObject").click();
		Thread.sleep(1000);
		findElement("xyObject").click();
		Thread.sleep(1000);
		WebElement iframeElement =findElement("iframeObject");
		driver.switchTo().frame(iframeElement);
	}

	public void renew_Search() throws Exception{
		//��ѯ����
		findElement("projectIdObject").sendKeys(getTestData("��Ŀ����_xy"));
		findElement("storeNameObject").sendKeys(getTestData("�ŵ�����_xy"));	
		findElement("searchBtnObject").click();
		Thread.sleep(1000);	
		//��֤��ѯ
		AssertEqualsFromExcel(findElement("projectIdTextObject").getText(),"��Ŀ����_xy");
		AssertEqualsFromExcel(findElement("stroreTextObject").getText(),"�ŵ�����_xy");	
	}
	
	public void renew_Reset() throws Exception{
		//���ù���
		String oldRecordText=findElement("recordObject").getText();
		findElement("resetBtnObject").click();
		Thread.sleep(2000);
		Assert.assertTrue(findElement("projectIdObject").getAttribute("value").isEmpty());
		Assert.assertTrue(findElement("storeNameObject").getAttribute("value").isEmpty());
		String newRecordText=findElement("recordObject").getText();
		Assert.assertNotSame(oldRecordText, newRecordText);
	}
	
	  //�鿴����
	public void renew_ViewDetail() throws Exception{
		renew_Search();	
		findElement("checkBtnObject").click();
		Thread.sleep(2000);
		AssertEqualsFromExcel(findElement("projectIdCheckObject").getText(),"��Ŀ����_xy");
		findElement("renewListBtnObject").click();
		Thread.sleep(1000);
		Assert.assertTrue(findElement("searchBtnObject").isDisplayed());
	}	
	
	//�޸Ĺ���
	public void renew_Change() throws Exception{
		renew_Search();
		findElement("changeBtnObject").click();
		Thread.sleep(2000);
		
		AssertEqualsFromExcel(findElement("changeNoteObject").getText(),"��Լ˵��_xy");
		findElement("changeNoteObject").clear();	
		findElement("changeNoteObject").sendKeys(changeNote);	
		findElement("saveObject").click();
		Thread.sleep(2000);
		
		//��֤�޸�
		renew_Search();
	    findElement("changeBtnObject").click();
	    Thread.sleep(2000);
		Assert.assertEquals(findElement("changeNoteObject").getText(),changeNote);
		//�ָ��޸�����
		findElement("changeNoteObject").clear();	
		findElement("changeNoteObject").sendKeys(getTestData("��Լ˵��_xy"));
		findElement("saveObject").click();
		Thread.sleep(2000);		
    }
	
	
	
	
	
	//���ӹ���ע�͵�:������û�취�����������ϴ�ͼƬ�޷�����ɹ�
//	public void renew_Add() throws Exception{
//		//���ӹ���
//		findElement("addNewObject").click();
//		Thread.sleep(1000);	
//		//ѡ���ŵ�
//		String storeNameSel = getWriteData("��ͬ_ContractProcess");
//		findElement("storeInputObject").sendKeys(storeNameSel);	
//		findElement("serchBtn1Object").click();
//		Thread.sleep(1000);		
//		findElement("storeObject").click();
//		Thread.sleep(1000);		
//		//���ӽ��棨������)
//		String roomStr=findElement("roomTextObject").getText();//��ȡԭ��ͬ����������ı���xxx �䡱
//		String[] roomNum=roomStr.split("\\s+");//�Կո�ָ��ȡ���ı�
//		findElement("roomInpObject").sendKeys(roomNum[0]);//ȡ����ĵ�һ��ֵ�������ı��е����֡�xxx����,��ȡ�������󸳸��������	
//		findElement("renewFeeInpObject").sendKeys(getTestData("��Լ���˷ѱ�׼_xy"));	
//		findElement("receieFeeInpObject").sendKeys(getTestData("Ӧ�ռ��˷�_xy"));	
//		findElement("manageRateInpObject").sendKeys(getTestData("��Լ��������_xy"));	
//		//��ȡԭ��ͬ�Ľ�ֹʱ�䣬�º�ͬ��ʼʱ��=ԭ��ͬ��ֹʱ�䣬�º�ͬ��ֹʱ��=�º�ͬ��ʼʱ���һ��
//		String startTime=findElement("dataTextObject").getText();
//		String[] dataGroup=startTime.split("\\-");
//		int year = Integer.valueOf(dataGroup[0]).intValue()+1;
//		String endTime = Integer.toString(year)+"-"+dataGroup[1]+"-"+dataGroup[2];
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].value=arguments[1]",findElement("startTimeObject"), startTime); 
//		js.executeScript("arguments[0].value=arguments[1]",findElement("endTimeObject"), endTime); 
//		
////		sendKeystoReadOnlyField(findElement("startTimeObject"), "��Լ��ʼʱ��_xy");
////		sendKeystoReadOnlyField(findElement("endTimeObject"), "��Լ����ʱ��_xy");
//		findElement("noteInpObject").sendKeys(addNote);	
//		findElement("signInpObject").sendKeys(getTestData("ǩԼ��/��λ_xy"));	
//		selectByVisibleTextFromExcel(findElement("idTypeSelObject"),"֤������_xy");	
//		findElement("idNoInpObject").sendKeys(getTestData("֤����_xy"));	
//		findElement("phoneInpObject").sendKeys(addPhone);	
//		selectByVisibleTextFromExcel(findElement("payModeSelObject"),"֧����ʽ_xy");
//		findElement("remarkObject").sendKeys(getTestData("��ע_xy"));		
//		findElement("contractBtnObject").click();	//�������
//		Thread.sleep(1000);
////		upLoad();//�ϴ�����
//		String photoPath=System.getProperty("user.dir")+"\\src\\com\\test\\TestData\\"+"�����ϴ�ͼƬ.jpg";
//		findElement("fileObject").sendKeys(photoPath);
//		findElement("uploadBtnObject").click();	//�ϴ���ť
//		Thread.sleep(5000);	
//		findElement("saveBtnObject").click();	//����
//		Thread.sleep(6000);
//	    //��֤�����Ƿ�ɹ�
//		findElement("storeNameObject").sendKeys(storeNameSel);
//		findElement("searchBtnObject").click();
//		Thread.sleep(1000);	
//		Assert.assertEquals(findElement("stroreTextObject").getText(),storeNameSel);
//		Assert.assertEquals(findElement("FlagTextObject").getText(), "���ύ");
////		//�����������ύ
//		findElement("changeBtnObject").click();
//		Thread.sleep(1000);
//		findElement("sumbitBtnObject").click();
//		Thread.sleep(1000);
//		findElement("OKBtnObject").click();
//		Thread.sleep(5000);
//		findElement("storeNameObject").sendKeys(storeNameSel);
//		findElement("searchBtnObject").click();
//		//��֤�ύ�Ƿ�ɹ�
//		Assert.assertEquals(findElement("stroreTextObject").getText(),storeNameSel);
//		Assert.assertEquals(findElement("FlagTextObject").getText(), "����");
//	}

//	public void upLoad() throws Exception{
//	//�ϴ��ļ�����
//	findElement("fileObject").click();
//	Thread.sleep(2000);
//	Runtime.getRuntime().exec("E:\\workspace\\Eclipseworkplace\\qqmdUIAutomation\\upload download\\��Լ��ͬ����.exe");
//	Thread.sleep(5000);
//}	
	
}