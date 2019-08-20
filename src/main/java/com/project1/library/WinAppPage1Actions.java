package com.project1.library;

import org.openqa.selenium.WebElement;

import com.wma.framework.common.CommonWebActions;
import com.wma.framework.common.WinAppElements;

import io.appium.java_client.windows.WindowsDriver;

public class WinAppPage1Actions extends CommonWebActions<WinAppElements> {

	public WinAppPage1Actions(WindowsDriver<WebElement> driver) {
		super(driver);
	}
	
	public void action1() {
		System.out.println("Performing Action 1");
	}
	
	public void action2() {
		System.out.println("Performing Action 2");
	}

}
