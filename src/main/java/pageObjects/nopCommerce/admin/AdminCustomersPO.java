package pageObjects.nopCommerce.admin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.PageGeneratorManager;
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
		selectItemInEditableDropdown(driver, AdminCustomersPageUI.LISTBOX_PARENT, AdminCustomersPageUI.LISTBOX_ITEM, expectedRole);
	}

	public int getCustomerQuantitySearchResult() {
		waitForElementVisible(driver, AdminCustomersPageUI.QUANTITY_CUSTOMER_SEARCH_RESULT);
		return getElementSize(driver, AdminCustomersPageUI.QUANTITY_CUSTOMER_SEARCH_RESULT);
	}

	public AdminEditCustomerPO clickToEditButton(String emailAddress) {
		waitForElementVisible(driver, AdminCustomersPageUI.EDIT_BUTTON_BY_EMAIL, emailAddress);
		clickToElement(driver, AdminCustomersPageUI.EDIT_BUTTON_BY_EMAIL, emailAddress);;
		return PageGeneratorManager.getAdminEditCustomerPage(driver);
	}
}
