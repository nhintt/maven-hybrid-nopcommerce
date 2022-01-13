package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminProductsPageUI;

public class AdminProductsPO extends BasePage {
	private WebDriver driver;

	public AdminProductsPO(WebDriver driver) {
		this.driver = driver;
	}

	public int getProductSearchResult() {
		waitForElementInvisible(driver, AdminProductsPageUI.AJAX_BUSY_ICON);
		waitForElementVisible(driver, AdminProductsPageUI.PRODUCT_ROWS);
		return getElementSize(driver, AdminProductsPageUI.PRODUCT_ROWS);
	}

	public boolean isEmptyMessageDisplayed() {
		waitForElementVisible(driver, AdminProductsPageUI.EMPTY_MESSAGE);
		return isElementDisplayed(driver, AdminProductsPageUI.EMPTY_MESSAGE);
	}

	public void checkToSeachSubCategoriesCheckbox() {
		waitForElementClickable(driver, AdminProductsPageUI.SEARCH_SUBCATEGORIES_CHECKBOX);
		clickToElement(driver, AdminProductsPageUI.SEARCH_SUBCATEGORIES_CHECKBOX);
	}
}
