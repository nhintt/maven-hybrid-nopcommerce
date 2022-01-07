package pageUIs.nopCommerce.user;

public class UserBasePageUI {
	public static final String LOGO_IMG = "//img[@alt='nopCommerce demo store']";
	public static final String PAGE_TITLE = "//div[@class='page-title']/h1";
	public static final String EMPTY_MESSAGE = "//div[@class='no-data']";
	
	public static final String URL_BY_PAGENAME = "//a[text()='%s']";
	public static final String SIDEBAR_PAGE_BY_NAME = "//a[text()='%s']";
	public static final String PRODUCT_LINK = "//div[@class='item-box']//h2[@class='product-title']/a[text()='%s']";
	public static final String TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String FOOTER_PAGE_BY_NAME = "//div[@class='footer']//a[text()='%s']";
	public static final String DROPDOWN_BY_ID = "//select[@id='%s']";
	public static final String MENU_PAGE_BY_NAME = "//ul[@class='top-menu notmobile']//a[text()='%s ']";
	public static final String BUTTON_BY_TEXT = "//button[text()='%s']";
}
