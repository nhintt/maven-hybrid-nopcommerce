package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserCompareProductsPageUI;

public class UserCompareProductsPO extends BasePage {
	private WebDriver driver;

	public UserCompareProductsPO(WebDriver driver) {
		this.driver = driver;
	}

	public String getValueInTableByColumnIndexAndRowName(String rowName, String columnIndex) {
		waitForElementVisible(driver, UserCompareProductsPageUI.TABLE_VALUE_BY_COLUMN_INDEX_ROW_NAME, rowName, columnIndex);
		return getElementText(driver, UserCompareProductsPageUI.TABLE_VALUE_BY_COLUMN_INDEX_ROW_NAME, rowName, columnIndex);
	}

	public void clickToClearListButton() {
		waitForElementClickable(driver, UserCompareProductsPageUI.CLEAR_LIST_BUTTON);
		clickToElement(driver, UserCompareProductsPageUI.CLEAR_LIST_BUTTON);
	}

	public boolean isCompareTableUndisplayed() {
		waitForElementInvisible(driver, UserCompareProductsPageUI.COMPARE_PRODUCT_TABLE);
		return isElementUndisplayed(driver, UserCompareProductsPageUI.COMPARE_PRODUCT_TABLE);
	}

}
