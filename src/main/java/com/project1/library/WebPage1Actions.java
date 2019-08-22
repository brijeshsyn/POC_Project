package com.project1.library;

import static com.project1.webelements.ClearSightElements.BTN_CLAIMS_ADMINISTRATION;
import static com.project1.webelements.ClearSightElements.BTN_DASHBOARD;
import static com.project1.webelements.ClearSightElements.BTN_LOGIN;
import static com.project1.webelements.ClearSightElements.LNK_CLEARSIGHT_E321TEST_TR_AUTO;
import static com.project1.webelements.ClearSightElements.TAB_MY_CLAIMS;
import static com.project1.webelements.ClearSightElements.TXT_PASSWORD;
import static com.project1.webelements.ClearSightElements.TXT_USERNAME;
import static com.project1.webelements.ClearSightElements.iFRAME_MYCLAIMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.project1.webelements.ClearSightElements;
import com.wma.framework.common.ByFactory;
import com.wma.framework.common.CommonWebActions;
import com.wma.framework.report.TestRailAndExtentReporter;

public class WebPage1Actions extends CommonWebActions<ClearSightElements> {

	WebDriver driver;

	public WebPage1Actions(WebDriver driver) {
		super(driver);
	}

	public void launchApplication(WebDriver driver) {
		driver.get("https://trauto-clearsight.cs19.force.com/community");
	}

	public void login(WebDriver driver, TestRailAndExtentReporter tcLogger) {
		click(TXT_USERNAME);
		sendKeys(TXT_USERNAME, "automation1@STARS-NET.COM");
		tcLogger.log(Status.PASS, "Enter Username");

		click(TXT_PASSWORD);
		sendKeys(TXT_PASSWORD, "Welcome!5");
		tcLogger.log(Status.PASS, "Enter Password");

		click(BTN_LOGIN);
		tcLogger.log(Status.PASS, "Clicked Login button");
		waitExplicity(3000);
		click(LNK_CLEARSIGHT_E321TEST_TR_AUTO);

		waitExplicity(4000);
		WebElement frame_outer = driver.findElement(By.id("canvas-outer-_:Automation_TR:j_id0:j_id123:canvasapp"));
		driver.switchTo().frame(frame_outer);
		WebElement frame_inner = driver.findElement(By.id("canvas-inner-_:Automation_TR:j_id0:j_id123:canvasapp"));
		driver.switchTo().frame(frame_inner);

		click(BTN_DASHBOARD);

		waitExplicity(4000);
		click(BTN_CLAIMS_ADMINISTRATION);

		WebElement myClaims = driver.findElement(By.linkText(TAB_MY_CLAIMS.getExpression()));
		waitForElement(myClaims);
		driver.switchTo().frame(iFRAME_MYCLAIMS.getExpression());
		click(TAB_MY_CLAIMS);

	}

	public boolean verifySuccessfulLogin() {

		return true;
	}

	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));

	}

}
