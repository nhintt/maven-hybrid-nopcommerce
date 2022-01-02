package pageUIs.nopCommerce.user;

public class UserRegisterPageUI {
	// FIXED LOCATOR
	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
	public static final String REGISTER_SUCCESS_MSG = "//div[text()='Your registration completed']";
	public static final String REGISTER_ERROR_MSG = "//div[contains(@class, 'message-error')]//li[text()='The specified email already exists']";
	
	// DYNAMIC LOCATOR
	public static final String ERROR_MESSAGE_BY_ID = "//span[@id='%s']";
}
