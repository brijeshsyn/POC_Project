package com.project1.testscripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.project1.library.WebPage1Actions;
import com.wma.framework.common.InitTest;
import com.wma.framework.report.TestRailAndExtentReporter;

public class WebPageTestCase1 extends InitTest {
	private TestRailAndExtentReporter tcLogger;
	
	@Test
	@Parameters("TCTitle")
	public void test1(@Optional String tcTitle) {
		System.out.println("Inside test method");
		tcLogger = TestRailAndExtentReporter.getInstance(config(), tcTitle, "Sample Test Case");
		
		tcLogger.log(Status.INFO, "Step 1: Launch application");
		WebPage1Actions p1 = new WebPage1Actions(getWebDriver());
		
		tcLogger.log(Status.INFO, "Step 2: Login into the application");
		p1.login();
		
		tcLogger.log(Status.INFO, "Step 3: Verify user logged in successfully");
		if(p1.verifySuccessfulLogin())
			tcLogger.log(Status.PASS, "User logged in successfully");
		else
			tcLogger.log(Status.FAIL, "Login Failed");

	}
	
	@AfterClass
	public void afterClass() {
		tcLogger.flush();
	}
	
}
