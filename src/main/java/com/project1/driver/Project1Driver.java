package com.project1.driver;

import com.wma.framework.common.ConfigProvider;
import com.wma.framework.driver.DriverScript;

public class Project1Driver {

	public static void main(String[] args) {
		DriverScript driver = new DriverScript(ConfigProvider.getInstance(), "com.project1.testscripts");
		driver.startExecution();
	}

}
