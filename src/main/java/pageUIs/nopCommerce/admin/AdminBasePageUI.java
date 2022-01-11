package pageUIs.nopCommerce.admin;

public class AdminBasePageUI {
	public static final String MENU_LINK_BY_NAME = "//ul[@role='menu']/li/a/p[contains(text(), '%s')]";
	public static final String SUBMENU_LINK_BY_NAME = "//li[contains(@class, 'menu-open')]//p[contains(text(), '%s')]";
}
