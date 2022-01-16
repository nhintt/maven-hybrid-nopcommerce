package com.nopCommerce.admin;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import environmentConfig.Environment;
import pageObjects.nopCommerce.admin.AdminAddNewAddressPO;
import pageObjects.nopCommerce.admin.AdminAddNewCustomerPO;
import pageObjects.nopCommerce.admin.AdminCustomersPO;
import pageObjects.nopCommerce.admin.AdminDashboardPO;
import pageObjects.nopCommerce.admin.AdminEditAddressPO;
import pageObjects.nopCommerce.admin.AdminEditCustomerPO;
import pageObjects.nopCommerce.admin.AdminLoginPO;
import utilities.DataUtil;

public class Admin_Customers_Testcases extends BaseTest {
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		data = DataUtil.getData();
		emailAddress = data.getEmailAddress();
		password = data.getPassword();
		firstName = data.getFirstName();
		lastName = data.getLastName();
		gender = "Female";
		dateOfBirth = "11/24/1999";
		companyName = "Automation FC";
		customerRole = "Guests";
		adminComment = "Add new customer (Guest)";
		city = data.getCityName();
		address = data.getAddress();
		zipCode = data.getZipcode();
		phoneNumber = data.getPhoneNumber();
		
		editEmailAddress = data.getEmailAddress();
		editFirstName = data.getFirstName();
		editLastName = data.getLastName();
		editDateOfBirth = "01/01/1990";
		editCompanyName = "Edit Automation FC";
		editAdminComment = "Edit customer (Guests)";
		editCity = data.getCityName();
		editAddress = data.getAddress();
		editZipCode = data.getZipcode();
		editPhoneNumber = data.getPhoneNumber();
		
		String envName = System.getProperty("envMaven");
		ConfigFactory.setProperty("envOwner", envName);
		environment = ConfigFactory.create(Environment.class);
		
		log.info("Pre-Condition - Step 01: Open browser " + browserName + " with URL=" + environment.appAdminUrl());
		driver = getBaseTestDriver(browserName, environment.appAdminUrl());
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		log.info("Pre-Condition - Step 01: Login to System");
		adminLoginPage.inputToTextboxByID(driver, "Email", "admin@yourstore.com");
		adminLoginPage.inputToTextboxByID(driver, "Password", "admin");
		adminLoginPage.clickToButtonByText(driver, "Log in");
		adminDashboardPage = PageGeneratorManager.getAdminDashboardPage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		log.info("Before method: Open Customers page");
		adminDashboardPage.openSideBarSubMenuAdmmin(driver, "Customers", "Customers");
		adminCustomersPage = PageGeneratorManager.getAdminCustomersPage(driver);
	}
	
	@Test
	public void Customers_01_Create_New_Customer() {
		log.info("Customers_01 - Step 01: Click to 'Add new' button");
		adminCustomersPage.openPageByNamePage(driver, "Add new");
		adminAddNewCustomerPage = PageGeneratorManager.getAdminAddNewCustomerPage(driver);
		
		log.info("Customers_01 - Step 02: Input to 'Email' textbox with value '" + emailAddress + "'");
		adminAddNewCustomerPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		log.info("Customers_01 - Step 03: Input to 'Password' textbox with value '" + password + "'");
		adminAddNewCustomerPage.inputToTextboxByID(driver, "Password", password);
		
		log.info("Customers_01 - Step 04: Input to 'First name' textbox with value '" + firstName + "'");
		adminAddNewCustomerPage.inputToTextboxByID(driver, "FirstName", firstName);
		
		log.info("Customers_01 - Step 05: Input to 'Last name' textbox with value '" + lastName + "'");
		adminAddNewCustomerPage.inputToTextboxByID(driver, "LastName", lastName);
		
		log.info("Customers_01 - Step 06: Select '" + gender + "' in Gender field");
		adminAddNewCustomerPage.checkToGenderRadioButton(gender);
		
		log.info("Customers_01 - Step 07: Input to 'Date of birth' textbox with value '" + dateOfBirth + "'");
		adminAddNewCustomerPage.inputToTextboxByID(driver, "DateOfBirth", dateOfBirth);
		
		log.info("Customers_01 - Step 08: Input to 'Company' textbox with value '" + companyName + "'");
		adminAddNewCustomerPage.inputToTextboxByID(driver, "Company", companyName);
		
		log.info("Customers_01 - Step 09: Remove all tags in 'Customer roles' if any");
		adminAddNewCustomerPage.removeAllTagsInCustomerRoles();
		
		log.info("Customers_01 - Step 10: Select '" + customerRole +  "'in 'Customer roles'");
		adminAddNewCustomerPage.selectItemInCustomerRoleDropdown(customerRole);
		
		log.info("Customers_01 - Step 11: Input to 'Admin comment' textarea with value '" + adminComment + "'");
		adminAddNewCustomerPage.inputToAdminComment(adminComment);
		
		log.info("Customers_01 - Step 12: Click to 'Save and Continue Edit' button");
		adminAddNewCustomerPage.clickToButtonByText(driver, "Save and Continue Edit");
		adminEditCustomerPage = PageGeneratorManager.getAdminEditCustomerPage(driver);
		
		log.info("Customers_01 - Step 13: Verify success message displayed");
		verifyTrue(adminEditCustomerPage.getAdminSuccessMessage(driver).contains("The new customer has been added successfully."));
		adminEditCustomerPage.clickToExpandPanelByName(driver, "Customer info");
		
		log.info("Customers_01 - Step 14: Verify Email displayed");
		verifyEquals(adminEditCustomerPage.getValueTextboxByID(driver, "Email"), emailAddress);
		
		log.info("Customers_01 - Step 15: Verify First name displayed");
		verifyEquals(adminEditCustomerPage.getValueTextboxByID(driver, "FirstName"), firstName);
		
		log.info("Customers_01 - Step 16: Verify Last name displayed");
		verifyEquals(adminEditCustomerPage.getValueTextboxByID(driver, "LastName"), lastName);
		
		log.info("Customers_01 - Step 17: Verify Female is selected");
		verifyTrue(adminEditCustomerPage.isGenderSelectedByName("Female"));
		
		log.info("Customers_01 - Step 18: Verify Date of birth displayed");
		verifyEquals(adminEditCustomerPage.getValueTextboxByID(driver, "DateOfBirth"), dateOfBirth);
		
		log.info("Customers_01 - Step 19: Verify Company displayed");
		verifyEquals(adminEditCustomerPage.getValueTextboxByID(driver, "Company"), companyName);
		
		log.info("Customers_01 - Step 20: Verify Guest displayed");
		verifyEquals(adminEditCustomerPage.getCustomerRole(), customerRole);
		
		log.info("Customers_01 - Step 21: Verify Admin comment displayed");
		verifyEquals(adminEditCustomerPage.getAdminComment(), adminComment);
		
		log.info("Customers_01 - Step 22: Click to 'back to customer list' link");
		adminEditCustomerPage.openPageByNamePage(driver, "back to customer list");
		adminCustomersPage = PageGeneratorManager.getAdminCustomersPage(driver);
		
		log.info("Customers_01 - Step 23: Remove all tags in 'Customer roles' if any");
		adminCustomersPage.removeAllTagsInCustomerRoles();
		
		log.info("Customers_01 - Step 24: Select 'Guest' in 'Customer roles'");
		adminCustomersPage.selectItemInCustomerRoleDropdown(customerRole);
		
		log.info("Customers_01 - Step 25: Click to 'Search' button");
		adminCustomersPage.clickToButtonByText(driver, "Search");
		
		log.info("Customers_01 - Step 26: Verify Customer info displayed");
		verifyEquals(adminCustomersPage.getCellValueByColumnNameAndRowIndex(driver, "8", "Email", "customers-grid"), emailAddress);
		verifyEquals(adminCustomersPage.getCellValueByColumnNameAndRowIndex(driver, "8", "Name", "customers-grid"), firstName + " " + lastName);
		verifyEquals(adminCustomersPage.getCellValueByColumnNameAndRowIndex(driver, "8", "Customer roles", "customers-grid"), customerRole);
	}
	
//	@Test
	public void Customers_02_Search_With_Email() {
		log.info("Customers_02 - Step 01: Input to 'Email' textbox with value '" + emailAddress + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchEmail", emailAddress);
		
		log.info("Customers_02 - Step 02: Remove all tags in 'Customer roles' if any");
		adminCustomersPage.removeAllTagsInCustomerRoles();
		
		log.info("Customers_02 - Step 03: Select '" + customerRole + "' in 'Customer roles'");
		adminCustomersPage.selectItemInCustomerRoleDropdown(customerRole);
		
		log.info("Customers_02 - Step 04: Click to 'Search' button");
		adminCustomersPage.clickToButtonByText(driver, "Search");
		
		log.info("Customers_02 - Step 05: Verify there is only 1 customer found");
		verifyEquals(adminCustomersPage.getCustomerQuantitySearchResult(), 1);
		
		log.info("Customers_02 - Step 06: Verify Customer role displayed correctly");
		verifyEquals(adminCustomersPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Customer roles", "customers-grid"), customerRole);
	}
	
//	@Test
	public void Customers_03_Search_With_FirstName_LastName() {
		log.info("Customers_03 - Step 01: Input to 'First name' textbox with value '" + firstName + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchFirstName", firstName);
		
		log.info("Customers_03 - Step 02: Input to 'Last name' textbox with value '" + lastName + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchLastName", lastName);
		
		log.info("Customers_03 - Step 03: Remove all tags in 'Customer roles' if any");
		adminCustomersPage.removeAllTagsInCustomerRoles();
		
		log.info("Customers_03 - Step 04: Select '" + customerRole + "' in 'Customer roles'");
		adminCustomersPage.selectItemInCustomerRoleDropdown(customerRole);
		
		log.info("Customers_03 - Step 05: Click to 'Search' button");
		adminCustomersPage.clickToButtonByText(driver, "Search");
		
		log.info("Customers_03 - Step 06: Verify there is only 1 customer found");
		verifyEquals(adminCustomersPage.getCustomerQuantitySearchResult(), 1);
		
		log.info("Customers_03 - Step 07: Verify Customer role displayed correctly");
		verifyEquals(adminCustomersPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Customer roles", "customers-grid"), customerRole);
		
		log.info("Customers_03 - Step 08: Verify Customer name displayed correctly");
		verifyEquals(adminCustomersPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Name", "customers-grid"), firstName + " " + lastName);
	}
	
//	@Test
	public void Customers_04_Search_With_Company() {
		log.info("Customers_04 - Step 01: Input to 'Company' textbox with value '" + companyName + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchCompany", companyName);
		
		log.info("Customers_04 - Step 02: Remove all tags in 'Customer roles' if any");
		adminCustomersPage.removeAllTagsInCustomerRoles();
		
		log.info("Customers_04 - Step 03: Select '" + customerRole + "' in 'Customer roles'");
		adminCustomersPage.selectItemInCustomerRoleDropdown(customerRole);
		
		log.info("Customers_04 - Step 04: Click to 'Search' button");
		adminCustomersPage.clickToButtonByText(driver, "Search");
		
		log.info("Customers_04 - Step 05: Verify there is only 1 customer found");
		verifyEquals(adminCustomersPage.getCustomerQuantitySearchResult(), 1);
		
		log.info("Customers_04 - Step 06: Verify Customer role displayed correctly");
		verifyEquals(adminCustomersPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Customer roles", "customers-grid"), customerRole);
		
		log.info("Customers_04 - Step 07: Verify Company name displayed correctly");
		verifyEquals(adminCustomersPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Company name", "customers-grid"), companyName);
	}
	
//	@Test
	public void Customers_05_Search_With_Full_Data() {
		log.info("Customers_05 - Step 01: Input to 'Email' textbox with value '" + emailAddress + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchEmail", emailAddress);
		
		log.info("Customers_05 - Step 02: Input to 'First name' textbox with value '" + firstName + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchFirstName", firstName);
		
		log.info("Customers_05 - Step 03: Input to 'Last name' textbox with value '" + lastName + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchLastName", lastName);
		
		log.info("Customers_05 - Step 04: Select '11' in 'Month' dropdown");
		adminCustomersPage.selectToItemInDropdownByID(driver, "SearchMonthOfBirth", "11");
		
		log.info("Customers_05 - Step 05: Select '24' in 'Day' dropdown");
		adminCustomersPage.selectToItemInDropdownByID(driver, "SearchDayOfBirth", "24");
		
		log.info("Customers_05 - Step 06: Input to 'Company' textbox with value '" + companyName + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchCompany", companyName);
		
		log.info("Customers_05 - Step 07: Remove all tags in 'Customer roles' if any");
		adminCustomersPage.removeAllTagsInCustomerRoles();
		
		log.info("Customers_05 - Step 08: Select '" + customerRole + "' in 'Customer roles'");
		adminCustomersPage.selectItemInCustomerRoleDropdown(customerRole);
		
		log.info("Customers_05 - Step 09: Click to 'Search' button");
		adminCustomersPage.clickToButtonByText(driver, "Search");
		
		log.info("Customers_05 - Step 10: Verify there is only 1 customer found");
		verifyEquals(adminCustomersPage.getCustomerQuantitySearchResult(), 1);
		
		log.info("Customers_05 - Step 11: Verify Customer name displayed correctly");
		verifyEquals(adminCustomersPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Name", "customers-grid"), firstName + " " + lastName);
		
		log.info("Customers_05 - Step 12: Verify Customer role displayed correctly");
		verifyEquals(adminCustomersPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Customer roles", "customers-grid"), customerRole);
		
		log.info("Customers_05 - Step 13: Verify Company name displayed correctly");
		verifyEquals(adminCustomersPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Company name", "customers-grid"), companyName);
	}
	
//	@Test
	public void Customers_06_Edit_Customer() {
		log.info("Customers_06 - Step 01: Input to 'Email' textbox with value '" + emailAddress + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchEmail", emailAddress);
		
		log.info("Customers_06 - Step 02: Input to 'First name' textbox with value '" + firstName + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchFirstName", firstName);
		
		log.info("Customers_06 - Step 03: Input to 'Last name' textbox with value '" + lastName + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchLastName", lastName);
		
		log.info("Customers_06 - Step 04: Select '11' in 'Month' dropdown");
		adminCustomersPage.selectToItemInDropdownByID(driver, "SearchMonthOfBirth", "11");
		
		log.info("Customers_06 - Step 05: Select '24' in 'Day' dropdown");
		adminCustomersPage.selectToItemInDropdownByID(driver, "SearchDayOfBirth", "24");
		
		log.info("Customers_06 - Step 06: Input to 'Company' textbox with value '" + companyName + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchCompany", companyName);
		
		log.info("Customers_06 - Step 07: Remove all tags in 'Customer roles' if any");
		adminCustomersPage.removeAllTagsInCustomerRoles();
		
		log.info("Customers_06 - Step 08: Select '" + customerRole + "' in 'Customer roles'");
		adminCustomersPage.selectItemInCustomerRoleDropdown(customerRole);
		
		log.info("Customers_06 - Step 09: Click to 'Search' button");
		adminCustomersPage.clickToButtonByText(driver, "Search");
		
		log.info("Customers_06 - Step 09: Click to 'Edit' button");
		adminEditCustomerPage = adminCustomersPage.clickToEditButton(emailAddress);
		
		log.info("Customers_06 - Step 10: Input to 'Email' textbox with value '" + editEmailAddress + "'");
		adminEditCustomerPage.inputToTextboxByID(driver, "Email", editEmailAddress);
		
		log.info("Customers_06 - Step 11: Input to 'First name' textbox with value '" + editFirstName + "'");
		adminEditCustomerPage.inputToTextboxByID(driver, "FirstName", editFirstName);
		
		log.info("Customers_06 - Step 12: Input to 'Last name' textbox with value '" + editLastName + "'");
		adminEditCustomerPage.inputToTextboxByID(driver, "LastName", editLastName);
		
		log.info("Customers_06 - Step 13: Input to 'Date of birth' textbox with value '" + editDateOfBirth + "'");
		adminEditCustomerPage.inputToTextboxByID(driver, "DateOfBirth", editDateOfBirth);
		
		log.info("Customers_06 - Step 14: Input to 'Company' textbox with value '" + editCompanyName + "'");
		adminEditCustomerPage.inputToTextboxByID(driver, "Company", editCompanyName);
		
		log.info("Customers_06 - Step 15: Input to 'Admin comment' textarea with value '" + editAdminComment + "'");
		adminEditCustomerPage.inputToAdminComment(editAdminComment);
		
		log.info("Customers_06 - Step 16: Click to 'Save' button");
		adminEditCustomerPage.clickToButtonByText(driver, "Save");
		adminCustomersPage = PageGeneratorManager.getAdminCustomersPage(driver);
		
		log.info("Customers_06 - Step 17: Verify success message displayed");
		verifyEquals(adminCustomersPage.getAdminSuccessMessage(driver), "The new customer has been updated successfully.");
		
		log.info("Customers_06 - Step 18: Input to 'Email' textbox with value '" + editEmailAddress + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchEmail", editEmailAddress);
		
		log.info("Customers_06 - Step 19: Input to 'First name' textbox with value '" + editFirstName + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchFirstName", editFirstName);
		
		log.info("Customers_06 - Step 20: Input to 'Last name' textbox with value '" + editLastName + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchLastName", editLastName);
		
		log.info("Customers_06 - Step 21: Select '11' in 'Month' dropdown");
		adminCustomersPage.selectToItemInDropdownByID(driver, "SearchMonthOfBirth", "1");
		
		log.info("Customers_06 - Step 22: Select '24' in 'Day' dropdown");
		adminCustomersPage.selectToItemInDropdownByID(driver, "SearchDayOfBirth", "1");
		
		log.info("Customers_06 - Step 23: Input to 'Company' textbox with value '" + editCompanyName + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchCompany", editCompanyName);
		
		log.info("Customers_06 - Step 24: Remove all tags in 'Customer roles' if any");
		adminCustomersPage.removeAllTagsInCustomerRoles();
		
		log.info("Customers_06 - Step 25: Select '" + customerRole + "' in 'Customer roles'");
		adminCustomersPage.selectItemInCustomerRoleDropdown(customerRole);
		
		log.info("Customers_06 - Step 26: Click to 'Search' button");
		adminCustomersPage.clickToButtonByText(driver, "Search");
		
		log.info("Customers_06 - Step 27: Verify there is only 1 customer found");
		verifyEquals(adminCustomersPage.getCustomerQuantitySearchResult(), 1);
		
		log.info("Customers_06 - Step 28: Verify Customer name displayed correctly");
		verifyEquals(adminCustomersPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Name", "customers-grid"), editFirstName + " " + editLastName);
		
		log.info("Customers_06 - Step 29: Verify Customer role displayed correctly");
		verifyEquals(adminCustomersPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Customer roles", "customers-grid"), customerRole);
		
		log.info("Customers_06 - Step 30: Verify Company name displayed correctly");
		verifyEquals(adminCustomersPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Company name", "customers-grid"), editCompanyName);
	}

//	@Test
	public void Customers_07_Add_New_Address() {
		log.info("Customers_07 - Step 01: Input to 'Email' textbox with value '" + editEmailAddress + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchEmail", editEmailAddress);
		
		log.info("Customers_07 - Step 02: Input to 'First name' textbox with value '" + editFirstName + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchFirstName", editFirstName);
		
		log.info("Customers_07 - Step 03: Input to 'Last name' textbox with value '" + editLastName + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchLastName", editLastName);
		
		log.info("Customers_07 - Step 04: Select '11' in 'Month' dropdown");
		adminCustomersPage.selectToItemInDropdownByID(driver, "SearchMonthOfBirth", "1");
		
		log.info("Customers_07 - Step 05: Select '24' in 'Day' dropdown");
		adminCustomersPage.selectToItemInDropdownByID(driver, "SearchDayOfBirth", "1");
		
		log.info("Customers_07 - Step 06: Input to 'Company' textbox with value '" + editCompanyName + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchCompany", editCompanyName);
		
		log.info("Customers_07 - Step 07: Remove all tags in 'Customer roles' if any");
		adminCustomersPage.removeAllTagsInCustomerRoles();
		
		log.info("Customers_07 - Step 08: Select '" + customerRole + "' in 'Customer roles'");
		adminCustomersPage.selectItemInCustomerRoleDropdown(customerRole);
		
		log.info("Customers_07 - Step 09: Click to 'Search' button");
		adminCustomersPage.clickToButtonByText(driver, "Search");
		
		log.info("Customers_07 - Step 10: Click to 'Edit' button");
		adminCustomersPage.openPageByNamePage(driver, "Edit");
		adminEditCustomerPage = PageGeneratorManager.getAdminEditCustomerPage(driver);
		
		log.info("Customers_07 - Step 11: Click to expand Addresses panel");
		adminEditCustomerPage.clickToExpandPanelByName(driver, "Addresses");
		
		log.info("Customers_07 - Step 12: Click to 'Add new address' button");
		adminEditCustomerPage.clickToButtonByText(driver, "Add new address");
		adminAddNewAddressPage = PageGeneratorManager.getAdminAddNewAddressPO(driver);
		
		log.info("Customers_07 - Step 13: Input to 'First name' textbox with value '" + firstName + "'");
		adminAddNewAddressPage.inputToTextboxByID(driver, "Address_FirstName", firstName);
		
		log.info("Customers_07 - Step 14: Input to 'Last name' textbox with value '" + lastName + "'");
		adminAddNewAddressPage.inputToTextboxByID(driver, "Address_LastName", lastName);
		
		log.info("Customers_07 - Step 15: Input to 'Email' textbox with value '" + emailAddress + "'");
		adminAddNewAddressPage.inputToTextboxByID(driver, "Address_Email", emailAddress);
		
		log.info("Customers_07 - Step 16: Input to 'City' textbox with value '" + city + "'");
		adminAddNewAddressPage.inputToTextboxByID(driver, "Address_City", city);
		
		log.info("Customers_07 - Step 17: Input to 'Address 1' textbox with value '" + address + "'");
		adminAddNewAddressPage.inputToTextboxByID(driver, "Address_Address1", address);
		
		log.info("Customers_07 - Step 18: Input to 'Zip / postal code' textbox with value '" + zipCode + "'");
		adminAddNewAddressPage.inputToTextboxByID(driver, "Address_ZipPostalCode", zipCode);
		
		log.info("Customers_07 - Step 19: Input to 'Phone number' textbox with value '" + phoneNumber + "'");
		adminAddNewAddressPage.inputToTextboxByID(driver, "Address_PhoneNumber", phoneNumber);
		
		log.info("Customers_07 - Step 20: Click to 'Save' button");
		adminAddNewAddressPage.clickToButtonByText(driver, "Save");
		adminEditAddressPage = PageGeneratorManager.getAdminEditAddressPO(driver);
		
		log.info("Customers_07 - Step 21: Verify success message displayed");
		verifyEquals(adminEditAddressPage.getAdminSuccessMessage(driver), "The new address has been added successfully.");
		
		log.info("Customers_07 - Step 22: Verify 'First name' textbox value");
		verifyEquals(adminEditAddressPage.getValueTextboxByID(driver, "Address_FirstName"), firstName);
		
		log.info("Customers_07 - Step 23: Verify 'Last name' textbox value");
		verifyEquals(adminEditAddressPage.getValueTextboxByID(driver, "Address_LastName"), lastName);
		
		log.info("Customers_07 - Step 24: Verify 'Email' textbox value");
		verifyEquals(adminEditAddressPage.getValueTextboxByID(driver, "Address_Email"), emailAddress);
		
		log.info("Customers_07 - Step 25: Verify 'City' textbox value");
		verifyEquals(adminEditAddressPage.getValueTextboxByID(driver, "Address_City"), city);
		
		log.info("Customers_07 - Step 26: Verify 'Address 1' textbox value");
		verifyEquals(adminEditAddressPage.getValueTextboxByID(driver, "Address_Address1"), address);
		
		log.info("Customers_07 - Step 27: Verify 'Zip / postal code' textbox value");
		verifyEquals(adminEditAddressPage.getValueTextboxByID(driver, "Address_ZipPostalCode"), zipCode);
		
		log.info("Customers_07 - Step 28: Verify 'Phone number' textbox value");
		verifyEquals(adminEditAddressPage.getValueTextboxByID(driver, "Address_PhoneNumber"), phoneNumber);
		
		log.info("Customers_07 - Step 29: Click to 'back to customer details' link");
		adminEditAddressPage.openPageByNamePage(driver, "back to customer details");
		adminEditCustomerPage = PageGeneratorManager.getAdminEditCustomerPage(driver);
		
		log.info("Customers_07 - Step 30: Click to expand Addresses panel");
		adminEditCustomerPage.clickToExpandPanelByName(driver, "Addresses");
		
		log.info("Customers_07 - Step 31: Verify address info");
		verifyEquals(adminEditCustomerPage.getCellValueByColumnNameAndRowIndex(driver, "1", "First name", "customer-addresses-grid"), firstName);
		verifyEquals(adminEditCustomerPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Last name", "customer-addresses-grid"), lastName);
		verifyEquals(adminEditCustomerPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Email", "customer-addresses-grid"), emailAddress);
		verifyEquals(adminEditCustomerPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Phone number", "customer-addresses-grid"), phoneNumber);
		verifyEquals(adminEditCustomerPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Address", "customer-addresses-grid"), address + "\n" + city + "," + zipCode);
	}

	
	public void Customers_08_Edit_Address() {
		log.info("Customers_08 - Step 01: Input to 'Email' textbox with value '" + editEmailAddress + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchEmail", editEmailAddress);
		
		log.info("Customers_08 - Step 02: Input to 'First name' textbox with value '" + editFirstName + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchFirstName", editFirstName);
		
		log.info("Customers_08 - Step 03: Input to 'Last name' textbox with value '" + editLastName + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchLastName", editLastName);
		
		log.info("Customers_08 - Step 04: Select '11' in 'Month' dropdown");
		adminCustomersPage.selectToItemInDropdownByID(driver, "SearchMonthOfBirth", "1");
		
		log.info("Customers_08 - Step 05: Select '24' in 'Day' dropdown");
		adminCustomersPage.selectToItemInDropdownByID(driver, "SearchDayOfBirth", "1");
		
		log.info("Customers_08 - Step 06: Input to 'Company' textbox with value '" + editCompanyName + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchCompany", editCompanyName);
		
		log.info("Customers_08 - Step 07: Remove all tags in 'Customer roles' if any");
		adminCustomersPage.removeAllTagsInCustomerRoles();
		
		log.info("Customers_08 - Step 08: Select '" + customerRole + "' in 'Customer roles'");
		adminCustomersPage.selectItemInCustomerRoleDropdown(customerRole);
		
		log.info("Customers_08 - Step 09: Click to 'Search' button");
		adminCustomersPage.clickToButtonByText(driver, "Search");
		
		log.info("Customers_08 - Step 10: Click to 'Edit' button");
		adminCustomersPage.openPageByNamePage(driver, "Edit");
		adminEditCustomerPage = PageGeneratorManager.getAdminEditCustomerPage(driver);
		
		log.info("Customers_08 - Step 11: Click to expand Addresses panel");
		adminEditCustomerPage.clickToExpandPanelByName(driver, "Addresses");
		
		log.info("Customers_08 - Step 12: Click to 'Edit' button");
		adminEditCustomerPage.openPageByNamePage(driver, "Edit");
		adminEditAddressPage = PageGeneratorManager.getAdminEditAddressPO(driver);
		
		log.info("Customers_08 - Step 13: Input to 'First name' textbox with value '" + editFirstName + "'");
		adminEditAddressPage.inputToTextboxByID(driver, "Address_FirstName", editFirstName);
		
		log.info("Customers_08 - Step 14: Input to 'Last name' textbox with value '" + editLastName + "'");
		adminEditAddressPage.inputToTextboxByID(driver, "Address_LastName", editLastName);
		
		log.info("Customers_08 - Step 15: Input to 'Email' textbox with value '" + editEmailAddress + "'");
		adminEditAddressPage.inputToTextboxByID(driver, "Address_Email", editEmailAddress);
		
		log.info("Customers_08 - Step 16: Input to 'City' textbox with value '" + editCity + "'");
		adminEditAddressPage.inputToTextboxByID(driver, "Address_City", editCity);
		
		log.info("Customers_08 - Step 17: Input to 'Address 1' textbox with value '" + editAddress + "'");
		adminEditAddressPage.inputToTextboxByID(driver, "Address_Address1", editAddress);
		
		log.info("Customers_08 - Step 18: Input to 'Zip / postal code' textbox with value '" + editZipCode + "'");
		adminEditAddressPage.inputToTextboxByID(driver, "Address_ZipPostalCode", editZipCode);
		
		log.info("Customers_08 - Step 19: Input to 'Phone number' textbox with value '" + editPhoneNumber + "'");
		adminEditAddressPage.inputToTextboxByID(driver, "Address_PhoneNumber", editPhoneNumber);
		
		log.info("Customers_08 - Step 20: Click to 'Save' button");
		adminEditAddressPage.clickToButtonByText(driver, "Save");
		
		log.info("Customers_08 - Step 21: Verify success message displayed");
		verifyEquals(adminEditAddressPage.getAdminSuccessMessage(driver), "The address has been updated successfully.");
		
		log.info("Customers_08 - Step 22: Verify 'First name' textbox value");
		verifyEquals(adminEditAddressPage.getValueTextboxByID(driver, "Address_FirstName"), editFirstName);
		
		log.info("Customers_08 - Step 23: Verify 'Last name' textbox value");
		verifyEquals(adminEditAddressPage.getValueTextboxByID(driver, "Address_LastName"), editLastName);
		
		log.info("Customers_08 - Step 24: Verify 'Email' textbox value");
		verifyEquals(adminEditAddressPage.getValueTextboxByID(driver, "Address_Email"), editEmailAddress);
		
		log.info("Customers_08 - Step 25: Verify 'City' textbox value");
		verifyEquals(adminEditAddressPage.getValueTextboxByID(driver, "Address_City"), editCity);
		
		log.info("Customers_08 - Step 26: Verify 'Address 1' textbox value");
		verifyEquals(adminEditAddressPage.getValueTextboxByID(driver, "Address_Address1"), editAddress);
		
		log.info("Customers_08 - Step 27: Verify 'Zip / postal code' textbox value");
		verifyEquals(adminEditAddressPage.getValueTextboxByID(driver, "Address_ZipPostalCode"), editZipCode);
		
		log.info("Customers_08 - Step 28: Verify 'Phone number' textbox value");
		verifyEquals(adminEditAddressPage.getValueTextboxByID(driver, "Address_PhoneNumber"), editPhoneNumber);
		
		log.info("Customers_08 - Step 29: Click to 'back to customer details' link");
		adminEditAddressPage.openPageByNamePage(driver, "back to customer details");
		adminEditCustomerPage = PageGeneratorManager.getAdminEditCustomerPage(driver);
		
		log.info("Customers_08 - Step 30: Click to expand Addresses panel");
		adminEditCustomerPage.clickToExpandPanelByName(driver, "Addresses");
		
		log.info("Customers_08 - Step 31: Verify address info");
		verifyEquals(adminEditCustomerPage.getCellValueByColumnNameAndRowIndex(driver, "1", "First name", "customer-addresses-grid"), editFirstName);
		verifyEquals(adminEditCustomerPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Last name", "customer-addresses-grid"), editLastName);
		verifyEquals(adminEditCustomerPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Email", "customer-addresses-grid"), editEmailAddress);
		verifyEquals(adminEditCustomerPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Phone number", "customer-addresses-grid"), editPhoneNumber);
		verifyEquals(adminEditCustomerPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Address", "customer-addresses-grid"), editAddress + "\n" + editCity + "," + editZipCode);
	}
	
//	@Test
	public void Customers_09_Delete_Address() {
		log.info("Customers_09 - Step 01: Input to 'Email' textbox with value '" + editEmailAddress + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchEmail", editEmailAddress);
		
		log.info("Customers_09 - Step 02: Input to 'First name' textbox with value '" + editFirstName + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchFirstName", editFirstName);
		
		log.info("Customers_09 - Step 03: Input to 'Last name' textbox with value '" + editLastName + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchLastName", editLastName);
		
		log.info("Customers_09 - Step 04: Select '11' in 'Month' dropdown");
		adminCustomersPage.selectToItemInDropdownByID(driver, "SearchMonthOfBirth", "1");
		
		log.info("Customers_09 - Step 05: Select '24' in 'Day' dropdown");
		adminCustomersPage.selectToItemInDropdownByID(driver, "SearchDayOfBirth", "1");
		
		log.info("Customers_09 - Step 06: Input to 'Company' textbox with value '" + editCompanyName + "'");
		adminCustomersPage.inputToTextboxByID(driver, "SearchCompany", editCompanyName);
		
		log.info("Customers_09 - Step 07: Remove all tags in 'Customer roles' if any");
		adminCustomersPage.removeAllTagsInCustomerRoles();
		
		log.info("Customers_09 - Step 08: Select '" + customerRole + "' in 'Customer roles'");
		adminCustomersPage.selectItemInCustomerRoleDropdown(customerRole);
		
		log.info("Customers_09 - Step 09: Click to 'Search' button");
		adminCustomersPage.clickToButtonByText(driver, "Search");
		
		log.info("Customers_09 - Step 10: Click to 'Edit' button");
		adminCustomersPage.openPageByNamePage(driver, "Edit");
		adminEditCustomerPage = PageGeneratorManager.getAdminEditCustomerPage(driver);
		
		log.info("Customers_09 - Step 11: Click to expand Addresses panel");
		adminEditCustomerPage.clickToExpandPanelByName(driver, "Addresses");
		
		log.info("Customers_09 - Step 12: Click to 'Delete' button");
		adminEditCustomerPage.openPageByNamePage(driver, "Delete");
		
		log.info("Customers_09 - Step 13: Accept alert");
		adminEditCustomerPage.acceptAlert(driver);
		
		log.info("Customers_09 - Step 14: Verify empty message displayed");
		verifyEquals(adminEditCustomerPage.getEmptyMessage(driver), "No data available in table");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		closeBrowserAndDriver();
	}
	
	private WebDriver driver;
	private Environment environment;
	private DataUtil data;
	
	private AdminLoginPO adminLoginPage;
	private AdminDashboardPO adminDashboardPage;
	private AdminCustomersPO adminCustomersPage;
	private AdminAddNewCustomerPO adminAddNewCustomerPage;
	private AdminEditCustomerPO adminEditCustomerPage;
	private AdminAddNewAddressPO adminAddNewAddressPage;
	private AdminEditAddressPO adminEditAddressPage;
	
	private String emailAddress, password, firstName, lastName, gender, dateOfBirth, companyName, customerRole, adminComment, city, address, zipCode, phoneNumber;
	private String editEmailAddress, editFirstName, editLastName, editDateOfBirth, editCompanyName, editAdminComment, editCity, editAddress, editZipCode, editPhoneNumber;
}
