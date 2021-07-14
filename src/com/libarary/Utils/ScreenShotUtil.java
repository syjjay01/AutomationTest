package com.libarary.Utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShotUtil {
//	protected WebDriver driver;
	
	//获取当前时间
	public static String getDateTime(){
	    Date currentDate = new Date();
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
	    return dataFormat.format(currentDate);
	    }
	
	
	public static String createDir(String dirName){
		File dir = new File(dirName);
		if(dir.exists()){
			return dirName;
		}else{
			dir.mkdir();
			return dirName;
		}
	}


	public static void takeScreenshot(TakesScreenshot driver, String testCaseName){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			String screenShotDir=System.getProperty("user.dir")+"\\screenshots\\"+testCaseName+"\\";
			createDir(screenShotDir);
			String fileName=testCaseName+"_"+getDateTime()+".png";
			FileUtils.copyFile(scrFile,new File(screenShotDir+fileName));
			}catch(Exception e){
				System.out.println("Can't save screenshot");
				e.printStackTrace();
			}
	}
}
