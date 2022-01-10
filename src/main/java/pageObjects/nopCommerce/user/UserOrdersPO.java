package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserOrdersPageUI;

public class UserOrdersPO extends BasePage{
	private WebDriver driver;

	public UserOrdersPO(WebDriver driver) {
		this.driver = driver;
	}

	public String getOrderNumber() {
		waitForElementVisible(driver, UserOrdersPageUI.ORDER_NUMBER);
		return getElementText(driver, UserOrdersPageUI.ORDER_NUMBER);
	}

	public String getOrderNumberInfo() {
		waitForElementVisible(driver, UserOrdersPageUI.ORDER_NUMBER_INFO);
		return getElementText(driver, UserOrdersPageUI.ORDER_NUMBER_INFO);
	}

}
