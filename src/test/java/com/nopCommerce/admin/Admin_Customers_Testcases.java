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
import pageObjects.nopCommerce.admin.AdminAddNewCustomerPO;
import pageObjects.nopCommerce.admin.AdminCustomersPO;
import pageObjects.nopCommerce.admin.AdminDashboardPO;
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
		
		String evnName = System.getProperty("envMaven");
		ConfigFactory.setProperty("envOwner", evnName);
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
		
		log.info("Customers_01 - Step 01: Input to 'Email' textbox with value '" + emailAddress + "'");
		adminAddNewCustomerPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		log.info("Customers_01 - Step 01: Input to 'Password' textbox with value '" + password + "'");
		adminAddNewCustomerPage.inputToTextboxByID(driver, "Password", password);
		
		log.info("Customers_01 - Step 01: Input to 'First name' textbox with value '" + firstName + "'");
		adminAddNewCustomerPage.inputToTextboxByID(driver, "FirstName", firstName);
		
		log.info("Customers_01 - Step 01: Input to 'Last name' textbox with value '" + lastName + "'");
		adminAddNewCustomerPage.inputToTextboxByID(driver, "LastName", lastName);
		
		log.info("Customers_01 - Step 01: Select '" + gender + "' in Gender field");
		adminAddNewCustomerPage.checkToGenderRadioButton(gender);
		
		log.info("Customers_01 - Step 01: Input to 'Date of birth' textbox with value '" + dateOfBirth + "'");
		adminAddNewCustomerPage.inputToTextboxByID(driver, "DateOfBirth", dateOfBirth);
		
		log.info("Customers_01 - Step 01: Input to 'Company' textbox with value '" + companyName + "'");
		adminAddNewCustomerPage.inputToTextboxByID(driver, "Company", companyName);
		
		log.info("Customers_01 - Step 01: Remove all tags in 'Customer roles' if any");
		adminAddNewCustomerPage.removeAllTagsInCustomerRoles();
		
		log.info("Customers_01 - Step 01: Select '" + customerRole +  "'in 'Customer roles'");
		adminAddNewCustomerPage.selectItemInCustomerRoleDropdown(customerRole);
		
		log.info("Customers_01 - Step 01: Input to 'Admin comment' textarea with value '" + adminComment + "'");
		adminAddNewCustomerPage.inputToAdminComment(adminComment);
		
		log.info("Customers_01 - Step 01: Click to 'Save and Continue Edit' button");
		adminAddNewCustomerPage.clickToButtonByText(driver, "Save and Continue Edit");
		adminEditCustomerPage = PageGeneratorManager.getAdminEditCustomerPage(driver);
		
		log.info("Customers_01 - Step 01: Verify success message displayed");
		adminEditCustomerPage.clickToExpandPanelByName(driver, "Customer info");
		verifyEquals(adminEditCustomerPage.getAdminSuccessMessage(driver), "The new customer has been added successfully.");
		
		log.info("Customers_01 - Step 01: Verify Email displayed");
		verifyEquals(adminEditCustomerPage.getValueTextboxByID(driver, "Email"), emailAddress);
		
		log.info("Customers_01 - Step 01: Verify First name displayed");
		verifyEquals(adminEditCustomerPage.getValueTextboxByID(driver, "FirstName"), firstName);
		
		log.info("Customers_01 - Step 01: Verify Last name displayed");
		verifyEquals(adminEditCustomerPage.getValueTextboxByID(driver, "LastName"), lastName);
		
		log.info("Customers_01 - Step 01: Verify Female is selected");
		verifyTrue(adminEditCustomerPage.isGenderSelectedByName("Female"));
		
		log.info("Customers_01 - Step 01: Verify Date of birth displayed");
		verifyEquals(adminEditCustomerPage.getValueTextboxByID(driver, "DateOfBirth"), dateOfBirth);
		
		log.info("Customers_01 - Step 01: Verify Company displayed");
		verifyEquals(adminEditCustomerPage.getValueTextboxByID(driver, "Company"), companyName);
		
		log.info("Customers_01 - Step 01: Verify Guest displayed");
		verifyEquals(adminEditCustomerPage.getCustomerRole(), customerRole);
		
		log.info("Customers_01 - Step 01: Verify Admin comment displayed");
		verifyEquals(adminEditCustomerPage.getAdminComment(), adminComment);
		
		log.info("Customers_01 - Step 01: Click to 'back to customer list' link");
		adminEditCustomerPage.openPageByNamePage(driver, "back to customer list");
		adminCustomersPage = PageGeneratorManager.getAdminCustomersPage(driver);
		
		log.info("Customers_01 - Step 01: Remove all tags in 'Customer roles' if any");
		adminCustomersPage.removeAllTagsInCustomerRoles();
		
		log.info("Customers_01 - Step 01: Select 'Guest' in 'Customer roles'");
		adminCustomersPage.selectItemInCustomerRoleDropdown(customerRole);
		
		log.info("Customers_01 - Step 01: Click to 'Search' button");
		adminCustomersPage.clickToButtonByText(driver, "Search");
		
		log.info("Customers_01 - Step 01: Verify Customer info displayed");
		verifyEquals(adminCustomersPage.getCellValueByColumnNameAndRowIndex(driver, "8", "Email", "customers-grid"), emailAddress);
		verifyEquals(adminCustomersPage.getCellValueByColumnNameAndRowIndex(driver, "8", "Name", "customers-grid"), firstName + " " + lastName);
		verifyEquals(adminCustomersPage.getCellValueByColumnNameAndRowIndex(driver, "8", "Customer roles", "customers-grid"), customerRole);
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
	
	private String emailAddress, password, firstName, lastName, gender, dateOfBirth, companyName, customerRole, adminComment;
}
