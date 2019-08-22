package com.project1.webelements;

import static com.wma.framework.common.ByType.*;

import com.wma.framework.common.ByType;
import com.wma.framework.common.PageElement;

public enum WinAppElements implements PageElement {

	TAB_LAYOUT(NAME, "Layout"), 
	TAB_CONTROLS(NAME, "Controls"), 
	TAB_BUTTON(XPATH, "//*[@Name='Button' and @ClassName='TextBlock']"),
	BTN_CLICKME(NAME, "Click Me"), 
	TAB_PASSWORDBOX(NAME, "PasswordBox"),
	TXT_PASSWORDBOXTEXTBOX(CLASS_NAME, "PasswordBox"),
	TAB_CHECKBOX(NAME, "CheckBox"),
	BTN_CHECKBOX1(XPATH,"//*[@AutomationId='cb1']"),
	TAB_TABCONTROL(NAME, "TabControl"),
	FROMSCROLL(XPATH,"//*[@AutomationId='VerticalScrollBar']"),
	TOSCROLL(XPATH,"//*[@AutomationId='PART_LineDownButton']"),
	TAB_BACKGROUND(XPATH, "//*[@Name='Background' and @ClassName='TabItem']"),
	TAB_FOREGROUND(XPATH,"//*[@Name='Foreground' and @ClassName='TabItem']"),
	LABEL_FOREGROUNDMENU(XPATH,"//*[@Name='Foreground' and @ClassName='TextBlock']"),
	TAB_COMBOBOX(NAME,"ComboBox"),
	DRP_COMBOBOX(CLASS_NAME,"ComboBox"),
	OPT_COMBOBOX1(NAME,"Item1"),
	OPT_COMBOBOX2(NAME,"Item2"),	
	HEADER_SITE(XPATH,"//*[@AutomationId='HeaderSite']"),
	TAB_TOOL_TIP(NAME,"ToolTip"),
	TXT_TOOL_TIP(CLASS_NAME,"TextBox"),
	TAB_HYPERLINK(NAME,"Hyperlink"),
	LNK_HYPERLINK(NAME,"Navigate to MSDN"),
	;
	
	private final String EXPRESSION;
	private final ByType BY_TYPE;

	private WinAppElements(ByType byType, String expr) {
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
