package pageObjects.nopCommerce.admin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminAddNewCustomerPageUI;

public class AdminAddNewCustomerPO extends BasePage {
	private WebDriver driver;

	public AdminAddNewCustomerPO(WebDriver driver) {
		this.driver = driver;
	}

	public void checkToGenderRadioButton(String genderName) {
		waitForElementClickable(driver, AdminAddNewCustomerPageUI.GENDER_RADIO_BUTTON_BY_NAME, genderName);
		clickToElement(driver, AdminAddNewCustomerPageUI.GENDER_RADIO_BUTTON_BY_NAME, genderName);
	}

	public void removeAllTagsInCustomerRoles() {
		waitForAllElementVisible(driver, AdminAddNewCustomerPageUI.DELETE_BUTTON_TAGS_CUSTOMER_ROLE);
		List<WebElement> tagsList = getListWebElement(driver, AdminAddNewCustomerPageUI.DELETE_BUTTON_TAGS_CUSTOMER_ROLE);
		if (tagsList.size() > 0) {
			for (int i = 0; i < tagsList.size(); i++) {
				clickToElement(driver, AdminAddNewCustomerPageUI.DELETE_BUTTON_TAGS_CUSTOMER_ROLE);
			}
		}
	}

	public void selectItemInCustomerRoleDropdown(String expectedRole) {
		waitForElementVisible(driver, AdminAddNewCustomerPageUI.LISTBOX_PARENT);
		selectItemInDropdown(driver, AdminAddNewCustomerPageUI.LISTBOX_PARENT, AdminAddNewCustomerPageUI.LISTBOX_ITEM, expectedRole);
	}

	public void inputToAdminComment(String adminComment) {
		waitForElementVisible(driver, AdminAddNewCustomerPageUI.ADMIN_COMMENT_TEXTAREA);
		sendkeyToElement(driver, AdminAddNewCustomerPageUI.ADMIN_COMMENT_TEXTAREA, adminComment);
	}

}
