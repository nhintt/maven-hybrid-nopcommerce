package pageUIs.nopCommerce.user;

public class UserCustomerInfoPageUI {
	//FIXED LOCATOR
	public static final String SAVE_BUTTON = "//button[@id='save-info-button']";
	
	// DYNAMIC LOCATOR
	public static final String RADIO_BUTTON_BY_ID = "//input[@id='gender-%s']";
	public static final String DROPDOWN_BY_NAME = "//select[@name='DateOfBirth%s']";
}
