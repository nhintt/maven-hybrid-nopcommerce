package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserChangePasswordPageUI;

public class UserChangePasswordPO extends BasePage{
	private WebDriver driver;

	public UserChangePasswordPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToChangePwdButton() {
		waitForElementClickable(driver, UserChangePasswordPageUI.CHANGE_PWD_BUTTON);
		clickToElement(driver, UserChangePasswordPageUI.CHANGE_PWD_BUTTON);
	}

	public void clickToCloseMessageButton() {
		waitForElementClickable(driver, UserChangePasswordPageUI.CLOSE_MSG_ICON);
		clickToElement(driver, UserChangePasswordPageUI.CLOSE_MSG_ICON);
	}
}
