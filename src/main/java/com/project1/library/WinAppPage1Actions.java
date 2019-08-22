package com.project1.library;

import static com.project1.webelements.WinAppElements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.project1.webelements.WinAppElements;
import com.wma.framework.common.CommonWebActions;
import com.wma.framework.report.TestRailAndExtentReporter;

public class WinAppPage1Actions extends CommonWebActions<WinAppElements> {
	public WinAppPage1Actions(WebDriver driver) {
		super(driver);
	}

	
	/*************************************************
	* Function to click Layout & Control tabs on home screen
	* 
	*/
		
	public String GetAttributeValue(WebElement element, String AttributeName)
	{
		String gettext = element.getAttribute(AttributeName);
		System.out.println(gettext);
		return gettext;
	}

	public boolean verifyLaunch(WebDriver driver)
	{
		WebElement element = driver.findElement(By.name("Layout"));
		String attribute_name = GetAttributeValue(element,"Name");
		if(attribute_name.equalsIgnoreCase("layout"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	/*************************************************
	* Function to click Layout & Control tabs on home screen
	* 
	*/
	public void verifyLayout(TestRailAndExtentReporter tcLogger) {
		// click on layout option
		//tcLogger.log(Status.INFO, "Verifying layout option");
		click(TAB_LAYOUT);
		tcLogger.log(Status.PASS, "Successfully clicked on Layout and options listed down");
	}
	public void verifyControl(TestRailAndExtentReporter tcLogger) {
		// click on control option
		tcLogger.log(Status.INFO, "Verified control option Successfully");
		click(TAB_CONTROLS);		
		tcLogger.log(Status.PASS, "Successfully clicked on CONTROLS and options listed down");
		waitExplicity(1000);
	}
	
	/*************************************************
	* Function to click 'Click me' button from 'button' menu opttion
	* 
	*/

	public void clickMe(TestRailAndExtentReporter tcLogger) {
		tcLogger.log(Status.INFO, "Verifying button option");

		click(TAB_BUTTON);
		tcLogger.log(Status.PASS, "Clicked on Button Menu");

		click(BTN_CLICKME);
		tcLogger.log(Status.PASS, "Clicked on <b> CLICKME </b>Button");
		waitExplicity(1000);
	}

	/*************************************************
	* Function to enter password in 'PasswordBox' 
	* 
	*/
	public void enterPassword(TestRailAndExtentReporter tcLogger) {
		tcLogger.log(Status.INFO, "Verifying passwordbox option");

		click(TAB_PASSWORDBOX);
		tcLogger.log(Status.PASS, "Clicked on <b> PASSWORDBOX </b> Menu");
		sendKeys(TXT_PASSWORDBOXTEXTBOX, "Password");
		tcLogger.log(Status.PASS, "Entered <b> Password </b> in passwordbox");
		waitExplicity(1000);
	}

	/*************************************************
	* Function to scroll and select 'TabControl' from menu option and traverse among tabs
	* 
	*/
	public void tabControl(WebDriver driver, TestRailAndExtentReporter tcLogger) {
		click(TAB_BUTTON);
		// By locator= By.xpath(TAB_TABCONTROL.getExpression());
		By locator = By.name(TAB_TABCONTROL.getExpression());
		scrollToElement(driver, locator);

		tcLogger.log(Status.INFO, "Verifying scroll option");
		Actions act = new Actions(driver);

		click(TAB_TABCONTROL);
		tcLogger.log(Status.PASS, "Clicked on TabControl Menu");
		click(TAB_BACKGROUND);
		tcLogger.log(Status.PASS, "Clicked on Background tab");

		click(TAB_FOREGROUND);
		tcLogger.log(Status.PASS, "Clicked on Foreground tab");

		WebElement From = driver.findElement(By.xpath(FROMSCROLL.getExpression()));
		WebElement To = driver.findElement(By.xpath(TOSCROLL.getExpression()));

		act.dragAndDrop(From, To).build().perform();
		System.out.println("Scroll Bar Completed");
		waitExplicity(1000);
	}
	
	/*************************************************
	* Function to click 'checkbox' and  tick
	* 
	*/
	public void checkBox(TestRailAndExtentReporter tcLogger) {
		tcLogger.log(Status.INFO, "Verifying checkBox option");
		click(TAB_CHECKBOX);
		tcLogger.log(Status.PASS, "Clicked on <b> checkBox </b> Option");
		click(BTN_CHECKBOX1);
		tcLogger.log(Status.PASS, "Clicked on <b> checkBox icon</b> Button");
		waitExplicity(1000);
	}
	
	/*************************************************
	* Function to click 'Combobox' and select value
	* 
	*/
	public void comboBox(TestRailAndExtentReporter tcLogger) {
		tcLogger.log(Status.INFO, "Verifying comboBox option");
		click(TAB_COMBOBOX);
		tcLogger.log(Status.PASS, "Clicked on <b> comboBox </b> Option");
		click(DRP_COMBOBOX);
		tcLogger.log(Status.PASS, "Clicked on <b> comboBox icon</b> Button");
		click(OPT_COMBOBOX1);
		tcLogger.log(Status.PASS, "select on <b> item 1 </b> of comboBox");
		waitExplicity(1000);
	}

	/*************************************************
	* Function to scroll till expected element
	* 
	*/
	public static void scrollToElement(WebDriver driver, By el) {
		boolean flag = true;
		int scrollCount = 15;
		while (flag && scrollCount > 0) {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			System.out.println("Scrolled :" + scrollCount);
			try {
//				WebElement locator =  driver.findElement(el);
//				System.out.println(locator);
//				if (locator.isEnabled())
//				{
//					flag = false;
//					System.out.println("Element present");
//				}
			} catch (Exception ex) {
//				System.out.println("exception");
			}
			scrollCount--;
		}

	}
	
	public void hyperlink(TestRailAndExtentReporter tcLogger) {
		tcLogger.log(Status.INFO, "On Hyperlink Screen...");
		click(TAB_HYPERLINK);
		tcLogger.log(Status.PASS, "Clicked on hyperlink menu option under control section...");

		click(LNK_HYPERLINK);
		tcLogger.log(Status.PASS, "User navigated to the present hyperlink successfully... On MSDN Screen...");
		
	}
	
	public boolean tooltip(WebDriver driver,TestRailAndExtentReporter tcLogger) {
		
		tcLogger.log(Status.INFO, "On ToolTip Screen...");
		click(TAB_BUTTON);
		By locator = By.name(TAB_TABCONTROL.getExpression());
		scrollToElement(driver, locator);
		click(TAB_TOOL_TIP);
		tcLogger.log(Status.PASS, "Clicked on ToolTip menu option under control section...");
		WebElement element = driver.findElement(By.name("Layout"));
		String attribute_name = GetAttributeValue(element,"HelpText");
		
		tcLogger.log(Status.PASS, "Tool tip present is : ");
		System.out.print(attribute_name);
		
		if(attribute_name.equalsIgnoreCase("useful information goes here"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	

} // End of class
