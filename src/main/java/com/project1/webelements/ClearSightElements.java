package com.project1.webelements;

import static com.wma.framework.common.ByType.*;

import com.wma.framework.common.ByType;
import com.wma.framework.common.PageElement;

public enum ClearSightElements implements PageElement {

	TXT_USERNAME(NAME,"j_id0:loginForm:username"),
	TXT_PASSWORD(NAME,"j_id0:loginForm:password"),
	BTN_LOGIN(NAME,"j_id0:loginForm:j_id110"),
	
	//Home screen
	LNK_CLEARSIGHT_E321TEST_TR_AUTO(XPATH,"//*[@href=\"https://trauto-clearsight.cs19.force.com/community/app/la0029000003oQBKAA2?ref=https://trauto-clearsight.cs19.force.com/community\"]"),
	
	//DASHBOARD screen
	iFRAME_DASHBOARD_outer(NAME,"canvas-outer-hidden-form-_:Automation_TR:j_id0:j_id123:canvasapp"),
	iFRAME_DASHBOARD_inner(ID,"canvas-inner-_:Automation_TR:j_id0:j_id123:canvasapp"),
	BTN_DASHBOARD(ID,"app_launcher-button"),
	BTN_CLAIMS_ADMINISTRATION(XPATH,"//*[@id=\"Storms.ClaimsAdmin-title\"]/a"),
	
	//CLAIMS Administration screen
	iFRAME_MYCLAIMS(ID,"Storms.ClaimsAdmin"),
	TAB_MY_CLAIMS(LINK_TEXT,"My Claims "),
	
	//My Claims screen
	
	
	

	
	
	
	;
	
	private final String EXPRESSION;
	private final ByType BY_TYPE;

	private ClearSightElements(ByType byType, String expr) {
		this.BY_TYPE = byType;
		this.EXPRESSION = expr;
	}

	public ByType getType() {
		return BY_TYPE;
	}

	public String getExpression() {
		return EXPRESSION;
	}

}
