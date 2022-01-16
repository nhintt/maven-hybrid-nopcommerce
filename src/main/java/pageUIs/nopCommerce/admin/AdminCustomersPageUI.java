package pageUIs.nopCommerce.admin;

public class AdminCustomersPageUI {
	public static final String DELETE_BUTTON_TAGS_CUSTOMER_ROLE = "//ul[@id='SelectedCustomerRoleIds_taglist']//li/span[@title='delete']";
	public static final String LISTBOX_PARENT = "//ul[@id='SelectedCustomerRoleIds_taglist']/parent::div";
	public static final String LISTBOX_ITEM = "//ul[@id='SelectedCustomerRoleIds_listbox']//li";
	public static final String QUANTITY_CUSTOMER_SEARCH_RESULT = "//table[@id='customers-grid']/tbody/tr";
	
	public static final String EDIT_BUTTON_BY_EMAIL = "//td[text()='%s']/following-sibling::td/a";
}
