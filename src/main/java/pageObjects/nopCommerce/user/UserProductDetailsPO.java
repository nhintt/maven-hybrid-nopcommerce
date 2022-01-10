package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserProductDetailsPageUI;

public class UserProductDetailsPO extends BasePage {
	private WebDriver driver;

	public UserProductDetailsPO(WebDriver driver) {
		this.driver = driver;
	}

	public UserProductReviewsPO clickToAddReview() {
		waitForElementClickable(driver, UserProductDetailsPageUI.ADD_REVIEW_LINK);
		clickToElement(driver, UserProductDetailsPageUI.ADD_REVIEW_LINK);
		return PageGeneratorManager.getUserProductReviewsPage(driver);
	}

	public void selectProductAttrDropdownByAttrName(String dropdownName, String itemValue) {
		waitForElementVisible(driver, UserProductDetailsPageUI.ATTR_DROPDOWN_BY_NAME, dropdownName);
		selectItemInDropdownByText(driver, UserProductDetailsPageUI.ATTR_DROPDOWN_BY_NAME, itemValue, dropdownName);
	}

	public void selectProductAttrCheckboxRadionBtn(String textValue) {
		waitForElementClickable(driver, UserProductDetailsPageUI.RADIO_CHECKBOX_BTN_BY_LABEL, textValue);
		checkToDefaultCheckboxRadio(driver, UserProductDetailsPageUI.RADIO_CHECKBOX_BTN_BY_LABEL, textValue);
	}

	public String getQuantityAtShoppingCartHeaderLink() {
		waitForElementVisible(driver, UserProductDetailsPageUI.CART_QUANTITY);
		return getElementText(driver, UserProductDetailsPageUI.CART_QUANTITY);
	}

	public void hoverToShoppingCartHeaderLink() {
		waitForElementVisible(driver, UserProductDetailsPageUI.SHOPPING_CART_HEADER_LINK);
		hoverMouseToElement(driver, UserProductDetailsPageUI.SHOPPING_CART_HEADER_LINK);
	}

	public boolean isCountingMsgDisplayedCorrect() {
		waitForElementVisible(driver, UserProductDetailsPageUI.COUNTING_MSG);
		return isElementDisplayed(driver, UserProductDetailsPageUI.COUNTING_MSG);
	}

	public String getProductName() {
		waitForElementVisible(driver, UserProductDetailsPageUI.PRODUCT_NAME);
		return getElementText(driver, UserProductDetailsPageUI.PRODUCT_NAME);
	}

	public boolean isProductAttributesDisplayed() {
		waitForElementVisible(driver, UserProductDetailsPageUI.PRODUCT_ATTRIBUTES);
		return isElementDisplayed(driver, UserProductDetailsPageUI.PRODUCT_ATTRIBUTES);
	}

	public String getUnitPrice() {
		waitForElementVisible(driver, UserProductDetailsPageUI.PRODUCT_UNIT_PRICE);
		return getElementText(driver, UserProductDetailsPageUI.PRODUCT_UNIT_PRICE);
	}

	public String getQuantity() {
		waitForElementVisible(driver, UserProductDetailsPageUI.PRODUCT_QUANTITY);
		return getElementText(driver, UserProductDetailsPageUI.PRODUCT_QUANTITY);
	}

	public String getSubTotal() {
		waitForElementVisible(driver, UserProductDetailsPageUI.CART_TOTALS);
		return getElementText(driver, UserProductDetailsPageUI.CART_TOTALS);
	}

	public void unSelectProductAttrCheckbox(String checkboxValue) {
		waitForElementVisible(driver, UserProductDetailsPageUI.RADIO_CHECKBOX_BTN_BY_LABEL, checkboxValue);
		uncheckToDefaultCheckbox(driver, UserProductDetailsPageUI.RADIO_CHECKBOX_BTN_BY_LABEL, checkboxValue);
	}

	public void changeQuantityValue(String quantityValue) {
		waitForElementVisible(driver, UserProductDetailsPageUI.QUANTITY_INPUT);
		sendkeyToElement(driver, UserProductDetailsPageUI.QUANTITY_INPUT, quantityValue);
	}

	public String getProductPrice() {
		waitForElementVisible(driver, UserProductDetailsPageUI.PRODUCT_PRICE);
		return getElementText(driver, UserProductDetailsPageUI.PRODUCT_PRICE);
	}

	public String getCountingMessage() {
		waitForElementVisible(driver, UserProductDetailsPageUI.COUNTING_MSG_TEST);
		return getElementText(driver, UserProductDetailsPageUI.COUNTING_MSG_TEST);
	}

	public boolean isProductAttributesEdited() {
		waitForElementVisible(driver, UserProductDetailsPageUI.PRODUCT_ATTRIBUTES_EDITED);
		return isElementDisplayed(driver, UserProductDetailsPageUI.PRODUCT_ATTRIBUTES_EDITED);
	}

}
