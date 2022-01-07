package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserShoppingCartPageUI;

public class UserShoppingCartPO extends BasePage {
	private WebDriver driver;

	public UserShoppingCartPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductAddedSuccessfully(String productName) {
		waitForElementVisible(driver, UserShoppingCartPageUI.PRODUCT_TITLE_BY_NAME, productName);
		return isElementDisplayed(driver, UserShoppingCartPageUI.PRODUCT_TITLE_BY_NAME, productName);
	}
}
