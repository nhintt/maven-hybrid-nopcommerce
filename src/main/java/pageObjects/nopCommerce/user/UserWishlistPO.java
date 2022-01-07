package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserWishlistPageUI;

public class UserWishlistPO extends BasePage{
	private WebDriver driver;

	public UserWishlistPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductAddedSuccessfully(String productName) {
		waitForElementVisible(driver, UserWishlistPageUI.PRODUCT_TITLE_BY_NAME, productName);
		return isElementDisplayed(driver, UserWishlistPageUI.PRODUCT_TITLE_BY_NAME, productName);
	}

	public void clickToSharingWishlistURL() {
		waitForElementVisible(driver, UserWishlistPageUI.SHARING_WISHLIST_URL);
		clickToElement(driver, UserWishlistPageUI.SHARING_WISHLIST_URL);
	}

	public void clickToRemoveProductIcon() {
		waitForElementVisible(driver, UserWishlistPageUI.REMOVE_PRODUCT_ICON);
		clickToElement(driver, UserWishlistPageUI.REMOVE_PRODUCT_ICON);
	}

	public void clickCheckboxInTableByProductName(String productName) {
		waitForElementClickable(driver, UserWishlistPageUI.CHECKBOX_BY_PRODUCT_NAME, productName);
		clickToElement(driver, UserWishlistPageUI.CHECKBOX_BY_PRODUCT_NAME, productName);
	}

	public boolean isProductRemovedSuccessfully(String productName) {
		waitForElementInvisible(driver, UserWishlistPageUI.PRODUCT_TITLE_BY_NAME, productName);
		return isElementUndisplayed(driver, UserWishlistPageUI.PRODUCT_TITLE_BY_NAME, productName);
	}
}
