package pageUIs.nopCommerce.user;

public class UserShoppingCartPageUI {
	public static final String EDIT_LINK = "//a[text()='Edit']";
	public static final String PRODUCT_ATTRIBUTES_EDITED = "(//div[@class='order-summary-content']//div[@class='attributes'])[last()]";
	public static final String PRODUCT_QUANTITY_INPUT = "(//tbody//label[text()='Qty.:']/following-sibling::input)[last()]";
	public static final String PRODUCT_TOTAL_PRICE = "(//span[@class='product-subtotal'])[last()]";
	public static final String PRODUCT_UNIT_PRICE = "(//span[@class='product-unit-price'])[last()]";
	public static final String TOTAL_SUMMARY = "//span[@class='value-summary']/strong";
	public static final String REMOVE_PRODUCT_ICON = "//input[@name='removefromcart']/following-sibling::button";
	public static final String AGREEMENT_POLICY_CHECKBOX = "//input[@id='termsofservice']";
	public static final String ESTIMATE_SHIPPING_BUTTON = "//a[@id='open-estimate-shipping-popup']";
	
	// and string()='Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]RAM: 2 GBHDD: 400 GB [+$100.00]OS: Vista Home [+$50.00]Software: Microsoft Office [+$50.00]']
	public static final String PRODUCT_TITLE_BY_NAME = "//div[@class='order-summary-content']//a[text()='%s']";
	public static final String SHIPPING_METHOD = "//div[text()='%s']";
}
