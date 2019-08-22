package com.project1.webelements;

import static com.wma.framework.common.ByType.ID;
import static com.wma.framework.common.ByType.XPATH;

import org.openqa.selenium.By;

import com.wma.framework.common.ByFactory;
import com.wma.framework.common.ByType;
import com.wma.framework.common.PageElement;

public enum Page1Elements implements PageElement {
	ELEMENT1(ID, "elementId"),
	ELEMENT2(XPATH, "element2Xpath")
	;
	
	private final ByType BY_TYPE;
	private final String EXPRESSION;
	
	private Page1Elements(ByType byType, String expression) {
		this.BY_TYPE = byType;
		this.EXPRESSION = expression;
	}
	
	public By getBy(String... arg0) {
		return ByFactory.getBy(BY_TYPE, EXPRESSION, arg0);
	}

	public String getExpression() {
		return EXPRESSION;
	}

	public ByType getType() {
		return BY_TYPE;
	}

}
