package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserSearchPageUI;

public class UserSearchPO extends BasePage {
	private WebDriver driver;

	public UserSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, UserSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, UserSearchPageUI.SEARCH_BUTTON);
	}

	public boolean isWarningMessageDisplayed() {
		waitForElementVisible(driver, UserSearchPageUI.WARNING_MESSAGE);
		return isElementDisplayed(driver, UserSearchPageUI.WARNING_MESSAGE);
	}
	
	public boolean isNoResultMessageDisplayed() {
		waitForElementVisible(driver, UserSearchPageUI.NO_RESULT_MESSAGE);
		return isElementDisplayed(driver, UserSearchPageUI.NO_RESULT_MESSAGE);
	}

	public String getSearchResultQuantity(String expectedItem) {
		waitForAllElementVisible(driver, UserSearchPageUI.SEARCH_RESULT_QUANTITY, expectedItem);
		return String.valueOf(getElementSize(driver, UserSearchPageUI.SEARCH_RESULT_QUANTITY, expectedItem));
	}

	public void selectToCheckboxByID(String checkboxID) {
		waitForElementVisible(driver, UserSearchPageUI.CHECKBOX_BY_ID, checkboxID);
		checkToDefaultCheckboxRadio(driver, UserSearchPageUI.CHECKBOX_BY_ID, checkboxID);
	}
	
}
