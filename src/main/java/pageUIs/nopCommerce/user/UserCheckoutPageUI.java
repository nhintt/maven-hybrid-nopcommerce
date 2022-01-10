package pageUIs.nopCommerce.user;

public class UserCheckoutPageUI {
	public static final String SHIPPING_SAME_ADDRESS_CHECKBOX = "//input[@id='ShipToSameAddress']";
	public static final String PRODUCT_NAME = "//a[@class='product-name']";
	public static final String PRODUCT_PRICE = "//span[@class='product-unit-price']";
	public static final String PRODUCT_QUANTITY = "//span[@class='product-quantity']";
	public static final String PRODUCT_TOTAL_PRICE = "//span[@class='product-subtotal']";
	public static final String GIFT_WRAPPING_TEXT = "//div[@class='selected-checkout-attributes']";
	public static final String TOTAL_SUMMARY = "//span[@class='value-summary']/strong";
	public static final String ORDER_SUCCESS_MESSAGE = "//strong[text()='Your order has been successfully processed!']";
	public static final String ORDER_NUMBER = "//div[@class='order-number']/strong";
	public static final String BILLING_CONTINUE_BUTTON = "//div[@id='billing-buttons-container']/button[text()='Continue']";
	public static final String SHIPPING_CONTINUE_BUTTON = "//div[@id='shipping-buttons-container']/button[text()='Continue']";
	public static final String SHIPPING_METHOD_CONTINUE_BUTTON = "//div[@id='shipping-method-buttons-container']/button[text()='Continue']";
	public static final String PAYMENT_METHOD_CONTINUE_BUTTON = "//div[@id='payment-method-buttons-container']/button[text()='Continue']";
	public static final String PAYMENT_INFO_CONTINUE_BUTTON = "//div[@id='payment-info-buttons-container']/button[text()='Continue']";
	
	public static final String SHIPPING_METHOD_INPUT = "//label[text()='%s ($0.00)']/preceding-sibling::input";
	public static final String PAYMENT_METHOD_INPUT = "//label[text()='%s']/preceding-sibling::input";
	public static final String BILLING_INFO_BY_CLASSNAME = "//div[@class='billing-info']//li[@class='%s']";
	public static final String SHIPPING_INFO_BY_CLASSNAME = "//div[@class='shipping-info']//li[@class='%s']";
	public static final String PAYMENT_METHOD = "//li[@class='payment-method']/span[@class='value']";
	public static final String SHIPPING_METHOD = "//li[@class='shipping-method']/span[@class='value']";
}
