package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserDashboardPageUI;
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

}