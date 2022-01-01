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

}
