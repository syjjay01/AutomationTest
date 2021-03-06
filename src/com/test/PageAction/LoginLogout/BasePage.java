package com.test.PageAction.LoginLogout;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.libarary.Base.Locator;
import com.libarary.Utils.ConfigDataUtil;
import com.libarary.Utils.ExcelUtil;
import com.libarary.Utils.LocatorXMLUtil;


public class BasePage {
	protected WebDriver driver;
	HashMap<String, Locator> locatorMap;
	static Map<String, String> usersDataMap;
	static Map<String, String> userPasswordMap;
	static Map<String, String> testDataMap;
	String path;	
    static String ExcelFileName = ConfigDataUtil.getConfig("testDataFileName");
    static String ExcelPath = System.getProperty("user.dir") + "\\src\\com\\test\\TestData\\" + ExcelFileName;
    static String WriteExcelPath = System.getProperty("user.dir") + "\\src\\com\\test\\TestData\\qqmd_WriteData.xlsx";
    public static String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");  
    
	protected BasePage(WebDriver driver) throws Exception {
		this.driver = driver;
		path = System.getProperty("user.dir") + "\\src\\com\\test\\Object\\" + this.getClass().getSimpleName()+ ".xml";
		locatorMap = LocatorXMLUtil.readLocatorXMLDocument(path);
	}

	 
	 public static String getTestData(String testDataKey) throws IOException {
		  String testData = ExcelUtil.readTestData(ExcelPath, "TestData").get(testDataKey);
		  return testData;
		  }	
	  
	 
	  public static String getUsersData(String userDataID) throws IOException{
		  String userPassword = ExcelUtil.readLoginUserData(ExcelPath, "Users").get(userDataID);
		return userPassword;
	  }
  
	  public static String getUserPassword(String userName) throws IOException{
		  String password = ExcelUtil.readLoginUserPassword(ExcelPath, "Users").get(userName);
		return password;		  
	  }
	  
	  //??????????excel, rowNum????excel?????????????????????????? writeData????????????????
	  public static void writeExcel(String writeData, int rowNum) throws IOException{
	      ExcelUtil.writeExcel(writeData, rowNum);
	  }
	  
	  //????????excel??????
	  public static String getWriteData(String writeDataKey) throws IOException{
		  String writeData = ExcelUtil.readTestData(WriteExcelPath, "TestData").get(writeDataKey);
		  return writeData; 
	  }
	      
	
	//????locator??????????
	public Locator getLocator(String locatorName) throws IOException {
		Locator locator = new Locator(locatorName);
		//????locatorMap????????????????????locatorName??
		if (locatorMap != null) {
			locator = locatorMap.get(locatorName);
		} else {
			locator = new Locator(locatorName);
		}
		return locator;
	}
	
	//????????????
	public WebElement findElement(Locator sourceLocator) throws Exception {
	    Locator locator = sourceLocator;
		WebElement e;
		switch (locator.getBy()) {
		case id:
			e = driver.findElement(By.id(locator.getElement()));
			break;
		case xpath:
			e = driver.findElement(By.xpath(locator.getElement()));
			break;
		case name:
			e = driver.findElement(By.name(locator.getElement()));
			break;
		case cssSelector:
			e = driver.findElement(By.cssSelector(locator.getElement()));
			break;
		case className:
			e = driver.findElement(By.className(locator.getElement()));
			break;
		case tagName:
			e = driver.findElement(By.tagName(locator.getElement()));
			break;
		case linkText:
			e = driver.findElement(By.linkText(locator.getElement()));
			break;
		case partialLinkText:
			e = driver.findElement(By.partialLinkText(locator.getElement()));
			break;
		default:
			e = driver.findElement(By.id(locator.getElement()));
		}
		return e;
		
	}

	
	public 	WebElement findElement(String locatorName) throws Exception{
		return findElement(getLocator(locatorName));
	}
	
	
	//????sendKeys????
//	public void sendKeys(WebElement element, String testData) throws Exception{
//		element.sendKeys(testData);
//	}

//	public void sendKeys(WebElement element, String testData) throws Exception{
//		element.sendKeys(getTestData(testData));
//	}
	
	//????pageLoadTimeout????????????????????
	public void pageLoadTimeout(long time) throws Exception{
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

   
	//????implicitlyWait????????????????????????????????????????????NoSuchElement????
	public void implicitlyWait(long time) throws Exception{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	//??????????????????
	public void selectByVisibleText(WebElement element, String value) throws Exception{
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}
	
	//??????????????????
		public void selectByVisibleTextFromExcel(WebElement element, String valueKey) throws Exception{
			Select sel = new Select(element);
			sel.selectByVisibleText(getTestData(valueKey));
		}
	
	//????????????
	public static String getDateTime(){
	    Date currentDate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
	    return simpleDateFormat.format(currentDate);
	    }
	
	//????????????
	public static String getCurrentDate(){
		Date currentDate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
		return simpleDateFormat.format(currentDate);
	}
	
	
	//????????????????
	 public static int getNum(int start,int end) {  
         return (int)(Math.random()*(end-start+1)+start);  
     }  
	 
	
	public static String getTelPhone() {  
        int index=getNum(0,telFirst.length-1);  
        String first=telFirst[index];  
        String second=String.valueOf(getNum(1,888)+10000).substring(1);  
        String thrid=String.valueOf(getNum(1,9100)+10000).substring(1);  
        return first+second+thrid;  
    }  
	
	
	//????????????????????????
	public static String getRandomString(int length) {
	    //??????????????????????
	    String KeyString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    StringBuffer sb = new StringBuffer();
	    int len = KeyString.length();
	    for (int i = 0; i < length; i++) {
	       sb.append(KeyString.charAt((int) Math.round(Math.random() * (len - 1))));
	    }
	    return sb.toString();
	}
	
	//????????????????????????
	public static String getSpecifyNum(int min, int max) {
		Random random = new Random();
		int i = random.nextInt(max) % (max - min + 1) + min;
		String s = Integer.toString(i);
		return s;
		}	
	
	//????Assert.assertEquals????,????????????????excel??????
    public void AssertEqualsFromExcel(String text, String valueKey) throws Exception{
    	String value = getTestData(valueKey);
    	Assert.assertEquals(text, value);
    }
    
    //????Assert.assertNotSame????????????????excel??????
    public void AssertNotSameFromExcel(String text, String valueKey) throws Exception{
    	String value = getTestData(valueKey);
    	Assert.assertNotSame(text, value);
    }
	
    //????readonly??????input??????????????????????excel??????
    public void sendKeystoReadOnlyField(WebElement element, String valueKey) throws Exception{
    	String value = getTestData(valueKey);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1]",element, value);   
        
    }
    
    //????????isElementPresent??????????????????
    public boolean isElementPresent(String locatorName) throws Exception{
    	boolean flag = false;
    	try{
    		WebElement element = findElement(locatorName);
    		flag = null!=element;
    	}catch(NoSuchElementException e){
    		System.out.println(this.getClass().getSimpleName() + "??????????????");
    	}
		return flag;
    }
	
    
    //??????????????
    public void switchToWindow(int windowId) throws Exception{  
		Set<String> winHandels = driver.getWindowHandles();
		List<String> it = new ArrayList<String>(winHandels);
		Thread.sleep(500);
		driver.switchTo().window(it.get(windowId));
    }
	
	
	
	

}