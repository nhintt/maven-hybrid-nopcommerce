package pageUIs.nopCommerce.admin;

public class AdminBasePageUI {
	public static final String SUCCESS_MESSAGE = "//div[contains(@class, 'alert-success')]";
	
	public static final String MENU_LINK_BY_NAME = "//ul[@role='menu']/li/a/p[contains(text(), '%s')]";
	public static final String SUBMENU_LINK_BY_NAME = "//li[contains(@class, 'menu-open')]//ul[@class='nav nav-treeview']//p[contains(text(), '%s')]";
	public static final String EXPAND_PANEL_ICON = "//div[string()='%s']/following-sibling::div/button/i";
	public static final String CELL_VALUE_BY_ROW_INDEX_COLUMN_NAME = "//table[@id='%s']//tbody/tr[%s]/td[%s]";
	public static final String PRECEDING_SIBLING_COLUMN_BY_NAME = "//th[text()='%s']/preceding-sibling::th";
}
