package pageObjects.nopCommerce.admin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminCustomersPageUI;

public class AdminCustomersPO extends BasePage {
	private WebDriver driver;

	public AdminCustomersPO(WebDriver driver) {
		this.driver = driver;
	}

	public void removeAllTagsInCustomerRoles() {
		waitForAllElementVisible(driver, AdminCustomersPageUI.DELETE_BUTTON_TAGS_CUSTOMER_ROLE);
		List<WebElement> tagsList = getListWebElement(driver, AdminCustomersPageUI.DELETE_BUTTON_TAGS_CUSTOMER_ROLE);
		if (tagsList.size() > 0) {
			for (int i = 0; i < tagsList.size(); i++) {
				clickToElement(driver, AdminCustomersPageUI.DELETE_BUTTON_TAGS_CUSTOMER_ROLE);
			}
		}
	}

	public void selectItemInCustomerRoleDropdown(String expectedRole) {
		waitForElementVisible(driver, AdminCustomersPageUI.LISTBOX_PARENT);
		selectItemInDropdown(driver, AdminCustomersPageUI.LISTBOX_PARENT, AdminCustomersPageUI.LISTBOX_ITEM, expectedRole);
	}
}
