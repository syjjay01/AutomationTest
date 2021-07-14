package com.test.PageAction.StoreMgmt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.test.PageAction.LoginLogout.BasePage;

public class RoomType_Page extends BasePage{
	
	String addRoomName = "�Զ����Ա෿" + getDateTime();//����ʱ�Զ����ɷ�������
	String addRoomCode = "AUTO"+getRandomString(5);//����ʱ�Զ����ɷ��ͱ���
	String changeRoomName= "�Զ��������" + getDateTime();//���ʱ�Զ����ɷ�������
	
	public RoomType_Page(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public void roomType() throws Exception{
		// ����ҳ��
		implicitlyWait(1000);
		Thread.sleep(2000);
		findElement("mdglObject").click();
		Thread.sleep(1000);
		findElement("fxObject").click();
		WebElement iframeElement =findElement("iframeObject");
		driver.switchTo().frame(iframeElement);
	}

	//�����б�
	public void roomTypeList_Search() throws Exception{
		//��ѯ����
		findElement("TypeNameObject").sendKeys(getTestData("��������_fx"));
		findElement("RoomTypeCodeObject").sendKeys(getTestData("���ͱ���_fx"));
		selectByVisibleTextFromExcel(findElement("RoomTypeObject"),"��������_fx");
		findElement("searchBtnObject").click();
		Thread.sleep(2000);
		AssertEqualsFromExcel(findElement("roomNameTextObject").getText(),"��������_fx");
		AssertEqualsFromExcel(findElement("roomCodeTextObject").getText(),"���ͱ���_fx");
	}
	
	//�����б�
	public void roomTypeList_Reset() throws Exception{
		//���ù���
		roomTypeList_Search();
		String oldRecordText=findElement("recordObject").getText();
		findElement("resetBtnObject").click();
		Thread.sleep(2000);
		Assert.assertTrue(findElement("TypeNameObject").getAttribute("value").isEmpty());
		Assert.assertTrue(findElement("RoomTypeCodeObject").getAttribute("value").isEmpty());
		String newRecordText=findElement("recordObject").getText();
		Assert.assertNotSame(oldRecordText, newRecordText);
	}
	
	//���ͱ�����룺��֤ҳ��������
	public void roomType_Apply() throws Exception{
		findElement("roomTypeApplyBtnObject").click();
		Thread.sleep(1000);
		Assert.assertEquals(findElement("roomTypeTitleObject").getText(),"���ͱ������");
	}

	//���ͱ����ʷ: ����ҳ�棬����鿴��ť��������ʷ����
	public void roomType_History() throws Exception{
		findElement("roomTypeHisBtnObject").click(); 
		Thread.sleep(1000);
		findElement("checkBtnObject").click();
		Thread.sleep(1000);
		Assert.assertTrue(findElement("roomTypeTitleObject").getText().contains("���ͱ������"));
		findElement("roomTypeHisBtnObject").click(); 
		Thread.sleep(1000);
		Assert.assertTrue(findElement("roomTypeTitleObject").getText().contains("���ͱ����ʷ"));
	}

	
	
	/*
	
	public void roomTypeHistory_Verify(String changeContent,String changeTpye) throws Exception{
		//��֤����
		findElement("roomTypeHisBtnObject").click();
		Thread.sleep(1000);	
		//��֤�����ʷ�����Ƿ���ڲ����ļ�¼
	    Assert.assertEquals(findElement("chageContentTextObject").getText(),changeContent);
	    Assert.assertEquals(findElement("chageTypeTextObject").getText(),changeTpye);
	   //��֤���ڼ�¼�󣬽��г���
	  	if (findElement("revokeBtnObject").isDisplayed()){
	  		findElement("revokeBtnObject").click();
	  		Thread.sleep(2000);	
	  		findElement("revokeOkBtnObject").click();
	  		Thread.sleep(1000);	
	  		findElement("successTextObject").click();
	  		Thread.sleep(1000);	
	  		findElement("closeObject").click();
	  		Thread.sleep(2000);	
	  		//��֤�Ƿ����ɹ�
	  		Assert.assertEquals(findElement("timeTextObject").getAttribute("class"),"gray");		
	  	}else{
	  		System.out.println("û�г�����ť�����ɳ�������");
	  	}  
	}
	
	public void roomTypeHistory_Check() throws Exception{
		//�����ʷ�鿴����
		//��������ʷ����
		findElement("roomTypeHisBtnObject").click();
		Thread.sleep(1000);	
	    //�鿴��¼	
		if(findElement("checkBtnObject").getAttribute("title").equals("�鿴")){
			String changeTypeCheck=findElement("chageTypeTextObject").getText();
			String changeContentCheck=findElement("chageContentTextObject").getText();
			findElement("checkBtnObject").click();
			Thread.sleep(2000);			
			//��֤�鿴
			Assert.assertTrue(findElement("roomTypeNameCheckObject").getText().contains(changeContentCheck));
			Assert.assertTrue(changeTypeCheck.contains(findElement("chageTypeCheckObject").getText()));
		}else{
			System.out.println("û�в鿴��ť�����ɲ鿴����");
		}		
    }

	public void roomType_Add() throws Exception{
		//���ӷ���
		findElement("roomTypeApplyBtnObject").click();
		findElement("addRoomTypeTabObject").click();
		//����tabҳ��
		findElement("addRoomTypeNameObject").sendKeys(addRoomName);
		findElement("addRoomTypeCodeObject").sendKeys(addRoomCode);
		selectByVisibleText(findElement("addRoomTypeObject"), "��������");
		findElement("addReasonObject").sendKeys("������������ԭ��");
		findElement("addBtnObject").click();
		Thread.sleep(2000);
		findElement("submitBtnObject").click();
		Thread.sleep(2000);	
		findElement("closeBtnObject").click();
		Thread.sleep(1000);	
		roomTypeHistory_Verify(addRoomName,"���ӷ��ͣ�1�䣩");//��֤�����ʷ���ڼ�¼		
	}
	
	public void roomType_Change() throws Exception{
		//�����������
		findElement("roomTypeApplyBtnObject").click();
		findElement("changeRoomTypeTabObject").click();
		//�������tabҳ��
		findElement("changeBoxObject").click();
		findElement("nextBtnObject").click();
		Thread.sleep(2000);
		findElement("changeRoomTypeObject").sendKeys(changeRoomName);
		findElement("changeReasonObject").sendKeys("��������������ԭ��");
	    findElement("changeBtnObject").click();
		Thread.sleep(2000);	
		findElement("submitBtnObject").click();
		Thread.sleep(2000);	
		findElement("closeBtnObject").click();
		Thread.sleep(1000);	
		roomTypeHistory_Verify(changeRoomName,"�޸ķ��ͣ�1�䣩");//��֤�����ʷ���ڼ�¼
	}
	
	public void roomType_Delete() throws Exception{
		//ɾ������
		findElement("roomTypeApplyBtnObject").click();
		findElement("deleteRoomTypeTabObject").click();
		//ɾ������tabҳ��
		findElement("deleteBoxObject").click();
		String roomTypeNameDel=findElement("deleteRoomTypeObject").getText();	
		findElement("deleteReasonObject").sendKeys("����ɾ�����͵�ԭ��");
	    findElement("deleteBtnObject").click();
		Thread.sleep(2000);	
		findElement("submitBtnObject").click();
		Thread.sleep(2000);	
		findElement("closeBtnObject").click();
		Thread.sleep(1000);	
		roomTypeHistory_Verify(roomTypeNameDel,"ɾ�����ͣ�1�䣩");//��֤�����ʷ���ڼ�¼
	}
	
	public void roomType_Shield() throws Exception{
		//���η���
		findElement("roomTypeApplyBtnObject").click();
		findElement("shieldRoomTypeTabObject").click();
		//���η���tabҳ��
		findElement("shieldBoxObject").click();
		String roomTypeNameShie=findElement("shieldRoomTypeObject").getText();	
		findElement("shieldReasonObject").sendKeys("�������η��͵�ԭ��");
	    findElement("shieldBtnObject").click();
		Thread.sleep(2000);	
		findElement("submitBtnObject").click();
		Thread.sleep(2000);	
		findElement("closeBtnObject").click();
		Thread.sleep(1000);	
		roomTypeHistory_Verify(roomTypeNameShie,"���η��ͣ�1�䣩");//��֤�����ʷ���ڼ�¼
	}
	
	public void roomType_Delrecover() throws Exception{
		//�ָ�ɾ������
		findElement("roomTypeApplyBtnObject").click();
		findElement("recoverRoomTypeTabObject").click();
		Thread.sleep(4000);	
		findElement("deleteRecObject").click();
		//�ָ�ɾ������tabҳ��
		Thread.sleep(4000);	
		findElement("recoverDelBoxObject").click();
		String roomTypeNameDelRev=findElement("roomTypeDelObject").getText();	
	    findElement("recoverDelBtnObject").click();
		Thread.sleep(2000);	
		findElement("submitBtnObject").click();
		Thread.sleep(2000);	
		findElement("closeBtnObject").click();
		Thread.sleep(1000);	
		roomTypeHistory_Verify(roomTypeNameDelRev,"�ָ����ͣ�1�䣩");//��֤�����ʷ���ڼ�¼
	}
	
	public void roomType_Shierecover() throws Exception{
		//�ָ����η���
		findElement("roomTypeApplyBtnObject").click();
		findElement("recoverRoomTypeTabObject").click();
		findElement("shieldRecObject").click();
		//�ָ�ɾ������tabҳ��
		findElement("recoverShieBoxObject").click();
		String roomTypeNameShieRev=findElement("roomTypeShieObject").getText();	
	    findElement("recoverShieBtnObject").click();
		Thread.sleep(2000);	
		findElement("submitBtnObject").click();
		Thread.sleep(2000);	
		findElement("closeBtnObject").click();
		Thread.sleep(1000);	
		roomTypeHistory_Verify(roomTypeNameShieRev,"�ָ����ͣ�1�䣩");//��֤�����ʷ���ڼ�¼	
	}
		*/	
}