package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserDashboardPageUI;
import pageUIs.nopCommerce.user.UserProductReviewsPageUI;

public class UserProductReviewsPO extends BasePage {
	private WebDriver driver;

	public UserProductReviewsPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSubmitButton() {
		waitForElementClickable(driver, UserProductReviewsPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, UserProductReviewsPageUI.SUBMIT_REVIEW_BUTTON);
	}

	public void inputToReviewText(String textValue) {
		waitForElementVisible(driver, UserProductReviewsPageUI.REVIEW_TEXTAREA);
		sendkeyToElement(driver, UserProductReviewsPageUI.REVIEW_TEXTAREA, textValue);
	}

}
