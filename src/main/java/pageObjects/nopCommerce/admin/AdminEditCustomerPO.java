package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminAddNewCustomerPageUI;
import pageUIs.nopCommerce.admin.AdminEditCustomerPageUI;

public class AdminEditCustomerPO extends BasePage {
	private WebDriver driver;

	public AdminEditCustomerPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isGenderSelectedByName(String gender) {
		waitForElementVisible(driver, AdminEditCustomerPageUI.GENDER_RADIO_BUTTON_BY_NAME, gender);
		return isElementSelected(driver, AdminEditCustomerPageUI.GENDER_RADIO_BUTTON_BY_NAME, gender);
	}

	public String getCustomerRole() {
		waitForElementVisible(driver, AdminEditCustomerPageUI.CUSTOMER_ROLE);
		return getElementText(driver, AdminEditCustomerPageUI.CUSTOMER_ROLE);
	}

	public String getAdminComment() {
		waitForElementVisible(driver, AdminEditCustomerPageUI.ADMIN_COMMENT_TEXTAREA);
		return getElementText(driver, AdminEditCustomerPageUI.ADMIN_COMMENT_TEXTAREA);
	}

	public void inputToAdminComment(String adminComment) {
		waitForElementVisible(driver, AdminEditCustomerPageUI.ADMIN_COMMENT_TEXTAREA);
		sendkeyToElement(driver, AdminEditCustomerPageUI.ADMIN_COMMENT_TEXTAREA, adminComment);
	}

}
