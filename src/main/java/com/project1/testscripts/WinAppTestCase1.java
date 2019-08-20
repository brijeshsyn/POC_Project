package com.project1.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.project1.library.WinAppPage1Actions;
import com.wma.framework.common.InitTest;
import com.wma.framework.report.TestRailAndExtentReporter;

import io.appium.java_client.windows.WindowsDriver;

public class WinAppTestCase1 extends InitTest {
private TestRailAndExtentReporter tcLogger;
	
	@Test
	@Parameters("TCTitle")
	public void test1(@Optional String tcTitle) {
		System.out.println("Inside test method");
		tcLogger = TestRailAndExtentReporter.getInstance(config(), tcTitle, "Sample Test Case");
		
		tcLogger.log(Status.INFO, "Step 1: Launch Application");
		WinAppPage1Actions p1 = new WinAppPage1Actions((WindowsDriver<WebElement>)getWebDriver());
		
		tcLogger.log(Status.INFO, "Step 1: Action 1");
		p1.action1();
		
		tcLogger.log(Status.INFO, "Step 2: Action 2");
		p1.action2();
		
		tcLogger.log(Status.PASS, "Test Case Passed");

	}
	
	@AfterClass
	public void afterClass() {
		tcLogger.flush();
	}
	
}
