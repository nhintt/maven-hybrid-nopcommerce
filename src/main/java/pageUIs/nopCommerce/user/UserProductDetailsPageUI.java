package pageUIs.nopCommerce.user;

public class UserProductDetailsPageUI {
	public static final String ADD_REVIEW_LINK = "//a[text()='Add your review']";
	public static final String CART_QUANTITY = "//span[@class='cart-qty']";
	public static final String SHOPPING_CART_HEADER_LINK = "//a[@class='ico-cart']";
	public static final String COUNTING_MSG = "//div[@class='count' and contains(string(), 'There are 1 item(s) in your cart.')]";
	public static final String COUNTING_MSG_TEST = "//div[@class='count']";
	public static final String PRODUCT_NAME = "//div[@class='item first']//div[@class='name']";
	public static final String PRODUCT_PRICE = "//div[@class='product-price']/span";
	public static final String PRODUCT_UNIT_PRICE = "//div[@class='item first']//div[@class='price']";
	public static final String PRODUCT_QUANTITY = "//div[@class='item first']//div[@class='quantity']";
	public static final String CART_TOTALS = "//div[@class='totals']";
	public static final String PRODUCT_ATTRIBUTES = "//div[@class='attributes' and contains(string(), 'Processor: 2.2 GHz Intel Pentium Dual-Core E2200RAM: 8GB [+$60.00]HDD: 320 GBOS: Vista Premium [+$60.00]Software: Microsoft Office [+$50.00]Software: Acrobat Reader [+$10.00]Software: Total Commander [+$5.00]')]";
	public static final String PRODUCT_ATTRIBUTES_EDITED = "//div[@class='attributes' and contains(string(), 'Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]RAM: 2 GBHDD: 400 GB [+$100.00]OS: Vista Home [+$50.00]Software: Microsoft Office [+$50.00]')]";
	public static final String QUANTITY_INPUT = "//label[text()='Qty:']/following-sibling::input";
	
	public static final String ATTR_DROPDOWN_BY_NAME = "//label[contains(text(), '%s')]/parent::dt/following-sibling::dd[1]/select";
	public static final String RADIO_CHECKBOX_BTN_BY_LABEL = "//label[text()='%s']/preceding-sibling::input";
}
