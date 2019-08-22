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

public class WinAppTestCase1 extends InitTest {
private TestRailAndExtentReporter tcLogger;
	
	@Test
	@Parameters("TCTitle")
	public void test1(@Optional String tcTitle) {
		System.out.println("Inside test method");
		tcLogger = TestRailAndExtentReporter.getInstance(config(), tcTitle, "Sample Test Case");
		
		tcLogger.log(Status.INFO, "Step 1: Launch Application");
		WinAppPage1Actions p1 = new WinAppPage1Actions(getWebDriver());
		
		tcLogger.log(Status.INFO, "Verifying layout option");
		p1.verifyLayout(tcLogger);
		
		tcLogger.log(Status.INFO, "Verifying Control option");
		p1.verifyControl(tcLogger);
		
		tcLogger.log(Status.INFO, "Click me option");
		p1.clickMe(tcLogger);

		tcLogger.log(Status.INFO,"Verify CheckBox option");
		p1.checkBox(tcLogger);
		
		// verifying dropdown tick.
		tcLogger.log(Status.INFO,"Verify ComboBox option");
		p1.comboBox(tcLogger);
		
		tcLogger.log(Status.INFO,"Verify Passwordbox option");
		p1.enterPassword(tcLogger);
		
		// contains scroll to element, vertical scroll and traverse among tabs.
		tcLogger.log(Status.INFO,"Verify Tabcontrol option");
		p1.tabControl(getWebDriver(),tcLogger);
		
		tcLogger.log(Status.PASS, "Test Case Passed");

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
