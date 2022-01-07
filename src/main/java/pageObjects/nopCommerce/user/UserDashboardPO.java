package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserDashboardPageUI;

public class UserDashboardPO extends BasePage {
	private WebDriver driver;

	public UserDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public Boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, UserDashboardPageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserDashboardPageUI.MY_ACCOUNT_LINK);
	}
	
	public void clickToButtonByProductNameAndBtnName(String productName, String btnName) {
		waitForElementClickable(driver, UserDashboardPageUI.BUTTON_BY_PRONAME_AND_BTNNAME, productName, btnName);
		clickToElement(driver, UserDashboardPageUI.BUTTON_BY_PRONAME_AND_BTNNAME, productName, btnName);
	}

	public boolean isAddCompareSuccessMsgDisplayed() {
		waitForElementVisible(driver, UserDashboardPageUI.ADD_COMPARE_SUCCESS_MSG);
		return isElementDisplayed(driver, UserDashboardPageUI.ADD_COMPARE_SUCCESS_MSG);
	}

}
