package com.project1.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.project1.library.WebPage1Actions;
import com.wma.framework.common.InitTest;
import com.wma.framework.report.TestRailAndExtentReporter;

public class WebPageTestCase1 extends InitTest {
	private TestRailAndExtentReporter tcLogger;
	WebDriver driver=getWebDriver();
	@Test
	@Parameters("TCTitle")
	public void test1(@Optional String tcTitle) {
		
		boolean executeStatus = false;
		try {
			System.out.println("Inside test method");
			tcLogger = TestRailAndExtentReporter.getInstance(config(), tcTitle, "Sample Test Case");

			WebPage1Actions p1 = new WebPage1Actions(driver);

			tcLogger.log(Status.INFO, "Step 1: Launch application");
			p1.launchApplication(getWebDriver());
			
			tcLogger.log(Status.INFO, "Step 2: Login into the application");
			p1.login(driver,tcLogger);
			
			if (p1.verifySuccessfulLogin())
				tcLogger.log(Status.PASS, "User logged in successfully");
			else
				tcLogger.log(Status.FAIL, "Login Failed");

			executeStatus = true;
		} catch (Exception e) {
			tcLogger.log(Status.FAIL, "Failed due to below exception<br/>" + e.getMessage());
		} finally {
			finallyMethod(tcTitle, null, null, executeStatus, tcLogger);
		}
	}

//	@AfterClass
//	public void afterClass() {
//		tcLogger.flush();
//	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
