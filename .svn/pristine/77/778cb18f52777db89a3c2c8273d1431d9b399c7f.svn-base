package com.libarary.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.libarary.Utils.ConfigDataUtil;


public class SingletonDriver {
   
   private static WebDriver driver;
   
   private static  WebDriver getDriverByBrowserName(String browser){
	   WebDriver driver=null;
     if(browser.equalsIgnoreCase("fireFox")){
    	 System.setProperty("webdriver.firefox.marionette",ConfigDataUtil.getConfig("Firefox_Path"));
    	 driver = new FirefoxDriver();
     }else if(browser.equalsIgnoreCase("chrome")){
    	 System.setProperty("webdriver.chrome.driver",ConfigDataUtil.getConfig("Chrome_Path"));
    	 driver = new ChromeDriver();
     }else{
    	 System.setProperty("webdriver.ie.driver",ConfigDataUtil.getConfig("IE_Path"));
    	 driver = new InternetExplorerDriver();
     }  
     return driver;
    }
    
    public static WebDriver getDriver() {
    	if(driver==null){
    	driver = getDriverByBrowserName(ConfigDataUtil.getConfig("Browser_Name"));
    	}
    	return driver;
    }
    
       
}
