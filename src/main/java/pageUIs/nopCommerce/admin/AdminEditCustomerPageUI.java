package pageUIs.nopCommerce.admin;

public class AdminEditCustomerPageUI {
	public static final String ADMIN_COMMENT_TEXTAREA = "//textarea[@id='AdminComment']";
	
	public static final String GENDER_RADIO_BUTTON_BY_NAME = "//label[contains(text(), '%s')]/preceding-sibling::input";
	public static final String CUSTOMER_ROLE = "//ul[@id='SelectedCustomerRoleIds_taglist']//li/span[not(@title)]";
}
