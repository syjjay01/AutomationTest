package com.libarary.Utils;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.libarary.Base.SingletonDriver;
import com.test.TestCase.LoginLogout.BaseTestCase;


public class ScreenShotListener extends TestListenerAdapter {
    protected ITestContext testContext = null;
    WebDriver driver;

    @Override
    public void onTestSuccess(ITestResult tr) {
    	driver = SingletonDriver.getDriver();
        super.onTestSuccess(tr);
        driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
        takeScreenShot(tr);
    }
  

    @Override
    public void onTestFailure(ITestResult tr) {
    	driver = SingletonDriver.getDriver();
        super.onTestFailure(tr);
        driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
        takeScreenShot(tr);
    }

    private void takeScreenShot(ITestResult tr) {
        BaseTestCase testCase = (BaseTestCase) tr.getInstance();
        testCase.takeScreenShot();
    }
}