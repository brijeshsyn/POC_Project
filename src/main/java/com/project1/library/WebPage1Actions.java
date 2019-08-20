package com.project1.library;


import org.openqa.selenium.WebDriver;

import com.project1.webelements.Page1Elements;
import com.wma.framework.common.CommonWebActions;

public class WebPage1Actions extends CommonWebActions<Page1Elements>{
	
	WebDriver driver;

	public WebPage1Actions(WebDriver driver) {
		super(driver);		
	}

	public void login() {		
		System.out.println("User logged in successfully");
	}

	public boolean verifySuccessfulLogin() {
		return false;
	}	

}
