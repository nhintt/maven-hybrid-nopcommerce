package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserBasePageUI;
import pageUIs.nopCommerce.user.UserCustomerInfoPageUI;

public class UserCustomerInfoPO extends BasePage {
	private WebDriver driver;

	public UserCustomerInfoPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRadioButton(String gender) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.RADIO_BUTTON_BY_ID, gender);
		checkToDefaultCheckboxRadio(driver, UserCustomerInfoPageUI.RADIO_BUTTON_BY_ID, gender);
	}

	public void selectToItemInDropdown(String dropdownName, String expectedItem) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.DROPDOWN_BY_NAME, dropdownName);
		selectItemInDropdownByText(driver, UserCustomerInfoPageUI.DROPDOWN_BY_NAME, expectedItem, dropdownName);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
	}

	public boolean isGenderRadioButtonSelected(String gender) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.RADIO_BUTTON_BY_ID, gender);
		return isElementSelected(driver, UserCustomerInfoPageUI.RADIO_BUTTON_BY_ID, gender);
	}

	public String getTextValueByID(String textboxID) {
		waitForElementVisible(driver, UserBasePageUI.TEXTBOX_BY_ID, textboxID);
		return getElementAttribute(driver, UserBasePageUI.TEXTBOX_BY_ID, "value", textboxID);
	}

	public String getTextItemInDropdownByName(String dropdownName) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.DROPDOWN_BY_NAME, dropdownName);
		return getSelectedItemInDefaultDropdown(driver, UserCustomerInfoPageUI.DROPDOWN_BY_NAME, dropdownName);
	}

}
