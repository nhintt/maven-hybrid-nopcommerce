package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
	private WebDriver driver;
	
	public UserRegisterPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
	}

	public String getErrorMessageByID(String messageID) {
		waitForElementVisible(driver, UserRegisterPageUI.ERROR_MESSAGE_BY_ID, messageID);
		return getElementText(driver, UserRegisterPageUI.ERROR_MESSAGE_BY_ID, messageID);
	}

	public void inputToTextboxByID(String textboxID, String textValue) {
		waitForElementVisible(driver, UserRegisterPageUI.TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, UserRegisterPageUI.TEXTBOX_BY_ID, textValue, textboxID);
	}

	public boolean isSuccessfulMsgDisplayed() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MSG);
		return isElementDisplayed(driver, UserRegisterPageUI.REGISTER_SUCCESS_MSG);
	}
	
	public boolean isErrorMsgDisplayed() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTER_ERROR_MSG);
		return isElementDisplayed(driver, UserRegisterPageUI.REGISTER_ERROR_MSG);
	}

}
