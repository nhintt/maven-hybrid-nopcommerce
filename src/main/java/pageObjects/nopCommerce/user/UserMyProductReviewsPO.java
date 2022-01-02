package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserDashboardPageUI;
import pageUIs.nopCommerce.user.UserMyProductReviewsPageUI;

public class UserMyProductReviewsPO extends BasePage {
	private WebDriver driver;

	public UserMyProductReviewsPO(WebDriver driver) {
		this.driver = driver;
	}

	public String getTextValueByClassName(String className) {
		waitForElementVisible(driver, UserMyProductReviewsPageUI.TEXT_VALUE_BY_CLASSNAME, className);
		return getElementText(driver, UserMyProductReviewsPageUI.TEXT_VALUE_BY_CLASSNAME, className);
	}

}
