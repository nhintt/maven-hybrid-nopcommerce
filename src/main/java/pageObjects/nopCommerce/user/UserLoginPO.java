package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserLoginPageUI;

public class UserLoginPO extends BasePage {
	WebDriver driver;

	public UserLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public UserDashboardPO clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserDashboardPage(driver);
	}

	public String getErrorMsgAtEmailTextbox() {
		waitForElementVisible(driver, UserLoginPageUI.ERROR_MESSAGE_AT_EMAIL_TEXTBOX);
		return getElementText(driver, UserLoginPageUI.ERROR_MESSAGE_AT_EMAIL_TEXTBOX);
	}
	
	public String getGenericErrorMsg() {
		waitForElementVisible(driver, UserLoginPageUI.LOGIN_ERROR_MSG);
		return getElementText(driver, UserLoginPageUI.LOGIN_ERROR_MSG);
	}
}
