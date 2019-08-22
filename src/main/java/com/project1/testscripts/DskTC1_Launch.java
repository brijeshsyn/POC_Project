package com.project1.testscripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.project1.library.WinAppPage1Actions;
import com.wma.framework.common.InitTest;
import com.wma.framework.report.TestRailAndExtentReporter;

public class DskTC1_Launch extends InitTest {
private TestRailAndExtentReporter tcLogger;
	
	@Test
	@Parameters("TCTitle")
	public void test1(@Optional String tcTitle) {
		System.out.println("Inside test method");
		tcLogger = TestRailAndExtentReporter.getInstance(config(), tcTitle, "Sample Test Case");
		
		tcLogger.log(Status.INFO, "Step 1: Launch Application");
		WinAppPage1Actions p1 = new WinAppPage1Actions(getWebDriver());
		
		if(p1.verifyLaunch(getWebDriver()))
		{
			tcLogger.log(Status.PASS, "Application Launched Successfully...");
		}
		else
		{
			tcLogger.log(Status.FAIL, "Failed to Launch Application...");
		}
		
		tcLogger.log(Status.INFO, "DskTC1_Launch Executed Successfully ...");
		
	}
	
	@AfterClass
	public void afterClass() {
		tcLogger.flush();
	}
	
	@AfterTest
	public void tearDown() {
		quitDriver();
	}
	
}
