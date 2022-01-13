package pageUIs.nopCommerce.admin;

public class AdminAddNewCustomerPageUI {
	public static final String DELETE_BUTTON_TAGS_CUSTOMER_ROLE = "//ul[@id='SelectedCustomerRoleIds_taglist']//li/span[@title='delete']";
	public static final String LISTBOX_PARENT = "//ul[@id='SelectedCustomerRoleIds_taglist']/parent::div/input";
	public static final String LISTBOX_ITEM = "//ul[@id='SelectedCustomerRoleIds_listbox']//li";
	public static final String ADMIN_COMMENT_TEXTAREA = "//textarea[@id='AdminComment']";
	
	public static final String GENDER_RADIO_BUTTON_BY_NAME = "//label[contains(text(), '%s')]/preceding-sibling::input";
}
