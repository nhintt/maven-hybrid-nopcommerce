package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserAddressesPageUI;
import pageUIs.nopCommerce.user.UserRecentlyViewedPageUI;

public class UserRecentlyViewedPO extends BasePage {
	private WebDriver driver;

	public UserRecentlyViewedPO(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForWaitingIconInvisible() {
		waitForElementInvisible(driver, UserAddressesPageUI.WAITING_ICON);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, UserAddressesPageUI.SAVE_BUTTON);
		clickToElement(driver, UserAddressesPageUI.SAVE_BUTTON);
	}

	public String getTextValueByClass(String className) {
		waitForElementVisible(driver, UserAddressesPageUI.TEXT_VALUE_BY_CLASSNAME, className);
		return getElementText(driver, UserAddressesPageUI.TEXT_VALUE_BY_CLASSNAME, className);
	}

	public void clickToAddNewButton() {
		waitForElementClickable(driver, UserAddressesPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, UserAddressesPageUI.ADD_NEW_BUTTON);
	}

	public String getProductTitle(String itemIndex) {
		waitForElementVisible(driver, UserRecentlyViewedPageUI.PRODUCT_TITLE_BY_INDEX, itemIndex);
		return getElementText(driver, UserRecentlyViewedPageUI.PRODUCT_TITLE_BY_INDEX, itemIndex);
	}
}
