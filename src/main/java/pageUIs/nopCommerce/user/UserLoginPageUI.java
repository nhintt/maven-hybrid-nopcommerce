package pageUIs.nopCommerce.user;

public class UserLoginPageUI {
	public static final String LOGIN_BUTTON = "//button[text()='Log in']";
	public static final String ERROR_MESSAGE_AT_EMAIL_TEXTBOX= "//span[@id='Email-error']";
	public static final String LOGIN_ERROR_MSG = "//div[contains(@class, 'message-error')]";
	
	// DYNAMIC LOCATOR
	public static final String TEXTBOX_BY_ID = "//input[@id='%s']";
}
