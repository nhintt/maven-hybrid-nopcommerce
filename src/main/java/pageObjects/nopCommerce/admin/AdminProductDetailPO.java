package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminProductDetailPageUI;

public class AdminProductDetailPO extends BasePage {
	private WebDriver driver;

	public AdminProductDetailPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPageNameDisplayed() {
		waitForElementVisible(driver, AdminProductDetailPageUI.PAGE_NAME);
		return isElementDisplayed(driver, AdminProductDetailPageUI.PAGE_NAME);
	}

	public String getProductName() {
		waitForElementVisible(driver, AdminProductDetailPageUI.PRODUCT_NAME);
		return getElementAttribute(driver, AdminProductDetailPageUI.PRODUCT_NAME, "value");
	}

}
