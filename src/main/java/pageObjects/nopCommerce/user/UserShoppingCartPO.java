package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserShoppingCartPageUI;

public class UserShoppingCartPO extends BasePage {
	private WebDriver driver;

	public UserShoppingCartPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductAddedSuccessfully(String productName) {
		waitForElementVisible(driver, UserShoppingCartPageUI.PRODUCT_TITLE_BY_NAME, productName);
		return isElementDisplayed(driver, UserShoppingCartPageUI.PRODUCT_TITLE_BY_NAME, productName);
	}

	public UserProductDetailsPO clickToEditLink() {
		waitForElementVisible(driver, UserShoppingCartPageUI.EDIT_LINK);
		clickToElement(driver, UserShoppingCartPageUI.EDIT_LINK);
		return PageGeneratorManager.getUserProductDetailsPage(driver);
	}

//	public void isProductAttributesEdited() {
//		waitForElementVisible(driver, UserShoppingCartPageUI.PRODUCT_ATTRIBUTES_EDITED);
//		isElementDisplayed(driver, UserShoppingCartPageUI.PRODUCT_ATTRIBUTES_EDITED);
//	}
	
	public String getProductAttributes() {
		waitForElementVisible(driver, UserShoppingCartPageUI.PRODUCT_ATTRIBUTES_EDITED);
		return getElementText(driver, UserShoppingCartPageUI.PRODUCT_ATTRIBUTES_EDITED);
	}

	public String getProductTotalPrice() {
		waitForElementVisible(driver, UserShoppingCartPageUI.PRODUCT_TOTAL_PRICE);
		return getElementText(driver, UserShoppingCartPageUI.PRODUCT_TOTAL_PRICE);
	}

	public String getProductQuantity() {
		waitForElementVisible(driver, UserShoppingCartPageUI.PRODUCT_QUANTITY_INPUT);
		return getElementAttribute(driver, UserShoppingCartPageUI.PRODUCT_QUANTITY_INPUT, "value");
	}

	public String getProductUnitPrice() {
		waitForElementVisible(driver, UserShoppingCartPageUI.PRODUCT_UNIT_PRICE);
		return getElementText(driver, UserShoppingCartPageUI.PRODUCT_UNIT_PRICE);
	}

	public Object getTotalSummary() {
		waitForElementVisible(driver, UserShoppingCartPageUI.TOTAL_SUMMARY);
		return getElementText(driver, UserShoppingCartPageUI.TOTAL_SUMMARY);
	}

	public void removeProduct() {
		waitForElementVisible(driver, UserShoppingCartPageUI.REMOVE_PRODUCT_ICON);
		clickToElement(driver, UserShoppingCartPageUI.REMOVE_PRODUCT_ICON);
	}

	public boolean isProductUndisplayed(String productName) {
		waitForElementInvisible(driver, UserShoppingCartPageUI.PRODUCT_TITLE_BY_NAME, productName);
		return isElementUndisplayed(driver, UserShoppingCartPageUI.PRODUCT_TITLE_BY_NAME, productName);
	}

	public void changeProductQuantity(String productQuantity) {
		waitForElementVisible(driver, UserShoppingCartPageUI.PRODUCT_QUANTITY_INPUT);
		sendkeyToElement(driver, UserShoppingCartPageUI.PRODUCT_QUANTITY_INPUT, productQuantity);
	}

	public void selectShippingMethod(String methodName) {
		waitForElementVisible(driver, UserShoppingCartPageUI.SHIPPING_METHOD, methodName);
		clickToElement(driver, UserShoppingCartPageUI.SHIPPING_METHOD, methodName);
	}

	public void selectToAgreePolicyCheckbox() {
		waitForElementClickable(driver, UserShoppingCartPageUI.AGREEMENT_POLICY_CHECKBOX);
		checkToDefaultCheckboxRadio(driver, UserShoppingCartPageUI.AGREEMENT_POLICY_CHECKBOX);
	}

	public void clickToEstimateShippingButton() {
		waitForElementVisible(driver, UserShoppingCartPageUI.ESTIMATE_SHIPPING_BUTTON);
		clickToElement(driver, UserShoppingCartPageUI.ESTIMATE_SHIPPING_BUTTON);
	}

}
