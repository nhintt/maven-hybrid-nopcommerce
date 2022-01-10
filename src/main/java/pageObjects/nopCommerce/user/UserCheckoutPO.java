package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserCheckoutPageUI;

public class UserCheckoutPO extends BasePage{
	private WebDriver driver;

	public UserCheckoutPO(WebDriver driver) {
		this.driver = driver;
	}

	public void uncheckToShipSameAddressCheckbox() {
		waitForElementClickable(driver, UserCheckoutPageUI.SHIPPING_SAME_ADDRESS_CHECKBOX);
		uncheckToDefaultCheckbox(driver, UserCheckoutPageUI.SHIPPING_SAME_ADDRESS_CHECKBOX);
	}

	public void selectShippingMethod(String methodName) {
		waitForElementClickable(driver, UserCheckoutPageUI.SHIPPING_METHOD_INPUT, methodName);
		checkToDefaultCheckboxRadio(driver, UserCheckoutPageUI.SHIPPING_METHOD_INPUT, methodName);
	}

	public void selectPaymentMethod(String methodName) {
		waitForElementClickable(driver, UserCheckoutPageUI.PAYMENT_METHOD_INPUT, methodName);
		checkToDefaultCheckboxRadio(driver, UserCheckoutPageUI.PAYMENT_METHOD_INPUT, methodName);
	}

	public String getBillInfoByClassName(String className) {
		waitForElementVisible(driver, UserCheckoutPageUI.BILLING_INFO_BY_CLASSNAME, className);
		return getElementText(driver, UserCheckoutPageUI.BILLING_INFO_BY_CLASSNAME, className);
	}

	public String getShippingInfoByClassName(String className) {
		waitForElementVisible(driver, UserCheckoutPageUI.SHIPPING_INFO_BY_CLASSNAME, className);
		return getElementText(driver, UserCheckoutPageUI.SHIPPING_INFO_BY_CLASSNAME, className);
	}

	public String getPaymentMethod() {
		waitForElementVisible(driver, UserCheckoutPageUI.PAYMENT_METHOD);
		return getElementText(driver, UserCheckoutPageUI.PAYMENT_METHOD);
	}
	
	public String getShippingMethod() {
		waitForElementVisible(driver, UserCheckoutPageUI.SHIPPING_METHOD);
		return getElementText(driver, UserCheckoutPageUI.SHIPPING_METHOD);
	}

	public String getProductName() {
		waitForElementVisible(driver, UserCheckoutPageUI.PRODUCT_NAME);
		return getElementText(driver, UserCheckoutPageUI.PRODUCT_NAME);
	}

	public String getProductUnitPrice() {
		waitForElementVisible(driver, UserCheckoutPageUI.PRODUCT_PRICE);
		return getElementText(driver, UserCheckoutPageUI.PRODUCT_PRICE);
	}

	public String getProductQuantity() {
		waitForElementVisible(driver, UserCheckoutPageUI.PRODUCT_QUANTITY);
		return getElementText(driver, UserCheckoutPageUI.PRODUCT_QUANTITY);
	}

	public String getProductTotalPrice() {
		waitForElementVisible(driver, UserCheckoutPageUI.PRODUCT_TOTAL_PRICE);
		return getElementText(driver, UserCheckoutPageUI.PRODUCT_TOTAL_PRICE);
	}

	public String getGiftWrappingText() {
		waitForElementVisible(driver, UserCheckoutPageUI.GIFT_WRAPPING_TEXT);
		return getElementText(driver, UserCheckoutPageUI.GIFT_WRAPPING_TEXT);
	}

	public String getTotalSummary() {
		waitForElementVisible(driver, UserCheckoutPageUI.TOTAL_SUMMARY);
		return getElementText(driver, UserCheckoutPageUI.TOTAL_SUMMARY);
	}

	public boolean isOrderSuccessMessageDisplayed() {
		waitForElementVisible(driver, UserCheckoutPageUI.ORDER_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, UserCheckoutPageUI.ORDER_SUCCESS_MESSAGE);
	}

	public boolean isOrderNumberDisplayed() {
		waitForElementVisible(driver, UserCheckoutPageUI.ORDER_NUMBER);
		return isElementDisplayed(driver, UserCheckoutPageUI.ORDER_NUMBER);
	}

	public String getOrderNumber() {
		waitForElementVisible(driver, UserCheckoutPageUI.ORDER_NUMBER);
		return getElementText(driver, UserCheckoutPageUI.ORDER_NUMBER);
	}

	public void clickToBillingContinueButton() {
		waitForElementClickable(driver, UserCheckoutPageUI.BILLING_CONTINUE_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.BILLING_CONTINUE_BUTTON);
	}
	
	public void clickToShippingContinueButton() {
		waitForElementClickable(driver, UserCheckoutPageUI.SHIPPING_CONTINUE_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.SHIPPING_CONTINUE_BUTTON);
	}
	
	public void clickToShippingMethodContinueButton() {
		waitForElementClickable(driver, UserCheckoutPageUI.SHIPPING_METHOD_CONTINUE_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.SHIPPING_METHOD_CONTINUE_BUTTON);
	}
	
	public void clickToPaymentMethodContinueButton() {
		waitForElementClickable(driver, UserCheckoutPageUI.PAYMENT_METHOD_CONTINUE_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.PAYMENT_METHOD_CONTINUE_BUTTON);
	}
	
	public void clickToPaymentInfoContinueButton() {
		waitForElementClickable(driver, UserCheckoutPageUI.PAYMENT_INFO_CONTINUE_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.PAYMENT_INFO_CONTINUE_BUTTON);
	}

}
