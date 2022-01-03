package com.nopCommerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import environmentConfig.Environment;
import pageObjects.nopCommerce.user.UserAddressesPO;
import pageObjects.nopCommerce.user.UserChangePasswordPO;
import pageObjects.nopCommerce.user.UserCustomerInfoPO;
import pageObjects.nopCommerce.user.UserDashboardPO;
import pageObjects.nopCommerce.user.UserLoginPO;
import pageObjects.nopCommerce.user.UserMyProductReviewsPO;
import pageObjects.nopCommerce.user.UserProductDetailsPO;
import pageObjects.nopCommerce.user.UserProductReviewsPO;
import pageObjects.nopCommerce.user.UserRegisterPO;
import utilities.DataUtil;

public class User_My_Account_Testcases extends BaseTest {
	
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		data = DataUtil.getData();
		firstName = data.getFirstName();
		lastName = data.getLastName();
		emailAddress = data.getEmailAddress();
		password = data.getPassword();
		address_01 = data.getAddress();
		address_02 = data.getAddress();
		state = "California";
		cityName = data.getCityName();
		country = "United States";
		zipCode = data.getZipcode();
		phoneNumber = data.getPhoneNumber();
		faxNumber = data.getPhoneNumber();
		
		editFirstName = data.getFirstName();
		editLastName = data.getLastName();
		editEmailAddress = data.getEmailAddress();
		editCompanyName = "Automation FC";
		editPassword = data.getPassword();
		editDay = "1";
		editMonth = "November";
		editYear = "1999";
		
		String envName = System.getProperty("envMaven");
		ConfigFactory.setProperty("envOwner", envName);
		environment = ConfigFactory.create(Environment.class);
		
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' with URL='" + environment.appUrl() + "'");
		driver = getBaseTestDriver(browserName, environment.appUrl());
		userDashboardPage = PageGeneratorManager.getUserDashboardPage(driver);
		
		log.info("Pre-Condition - Step 02: Open Register page");
		userDashboardPage.openPageByNamePage(driver, "Register");
		userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
		
		log.info("Pre-Condition - Step 03: Input to Firstname textbox with value '" + firstName + "'");
		userRegisterPage.inputToTextboxByID(driver, "FirstName", firstName);
		
		log.info("Pre-Condition - Step 04: Input to Lastname textbox with value '" + lastName + "'");
		userRegisterPage.inputToTextboxByID(driver, "LastName", lastName);
		
		log.info("Pre-Condition - Step 05: Input to Email textbox with value '" + emailAddress + "'");
		userRegisterPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		log.info("Pre-Condition - Step 06: Input to Password textbox with value '" + password + "'");
		userRegisterPage.inputToTextboxByID(driver, "Password", password);
		
		log.info("Pre-Condition - Step 07: Input to Confirm password textbox with value '" + password + "'");
		userRegisterPage.inputToTextboxByID(driver, "ConfirmPassword", password);
		
		log.info("Pre-Condition - Step 08: Click to Register button");
		userRegisterPage.clickToRegisterButton();
		
		log.info("Pre-Condition - Step 09: Verify successful message display");
		verifyTrue(userRegisterPage.isSuccessfulMsgDisplayed());
	}
	
	@Test
	public void My_Account_01_Update_Customer_Info() {
		log.info("My_Account_01 - Step 01: Open Customer Info page");
		userRegisterPage.openPageByNamePage(driver, "My account");
		userCustomerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
		
		log.info("My_Account_01 - Step 02: Select to 'female' radio button");
		userCustomerInfoPage.clickToRadioButton("female");
		
		log.info("My_Account_01 - Step 03: Input to First name textbox with value '" + editFirstName + "'");
		userCustomerInfoPage.inputToTextboxByID(driver, "FirstName", editFirstName);
		
		log.info("My_Account_01 - Step 04: Input to Last name textbox with value '" + editLastName + "'");
		userCustomerInfoPage.inputToTextboxByID(driver, "LastName", editLastName);
		
		log.info("My_Account_01 - Step 05: Select item in Day dropdown");
		userCustomerInfoPage.selectToItemInDropdown("Day", editDay);
		
		log.info("My_Account_01 - Step 06: Select item in Month dropdown");
		userCustomerInfoPage.selectToItemInDropdown("Month", editMonth);
		
		log.info("My_Account_01 - Step 07: Select item in Year dropdown");
		userCustomerInfoPage.selectToItemInDropdown("Year", editYear);
		
		log.info("My_Account_01 - Step 08: Input to Email textbox with value '" + editEmailAddress + "'");
		userCustomerInfoPage.inputToTextboxByID(driver, "Email", editEmailAddress);
		
		log.info("My_Account_01 - Step 09: Input to Company textbox with value '" + editCompanyName + "'");
		userCustomerInfoPage.inputToTextboxByID(driver, "Company", editCompanyName);
		
		log.info("My_Account_01 - Step 10: Click to Save button");
		userCustomerInfoPage.clickToSaveButton();
		
		log.info("My_Account_01 - Step 11: Verify Gender updated successfully");
		verifyTrue(userCustomerInfoPage.isGenderRadioButtonSelected("female"));
		
		log.info("My_Account_01 - Step 12: Verify First name updated successfully");
		verifyEquals(userCustomerInfoPage.getTextValueByID("FirstName"), editFirstName);
		
		log.info("My_Account_01 - Step 13: Verify Last name updated successfully");
		verifyEquals(userCustomerInfoPage.getTextValueByID("LastName"), editLastName);
		
		log.info("My_Account_01 - Step 14: Verify Day dropdown updated successfully");
		verifyEquals(userCustomerInfoPage.getTextItemInDropdownByName("Day"), editDay);
		
		log.info("My_Account_01 - Step 15: Verify Month dropdown updated successfully");
		verifyEquals(userCustomerInfoPage.getTextItemInDropdownByName("Month"), editMonth);
		
		log.info("My_Account_01 - Step 16: Verify Year dropdown updated successfully");
		verifyEquals(userCustomerInfoPage.getTextItemInDropdownByName("Year"), editYear);
		
		log.info("My_Account_01 - Step 17: Verify Email updated successfully");
		verifyEquals(userCustomerInfoPage.getTextValueByID("Email"), editEmailAddress);
		
		log.info("My_Account_01 - Step 18: Verify Company updated successfully");
		verifyEquals(userCustomerInfoPage.getTextValueByID("Company"), editCompanyName);
	}

	@Test
	public void My_Account_02_Add_Address_Info() {
		log.info("My_Account_02 - Step 01: Open Address page");
		userCustomerInfoPage.openSidebarPageByPageName(driver, "Addresses");
		userAddressesPage = PageGeneratorManager.getUserAddressesPage(driver);
		
		log.info("My_Account_02 - Step 01: Click to Add New button");
		userAddressesPage.clickToAddNewButton();
		
		log.info("My_Account_02 - Step 02: Input to First name textbox with value '" + firstName + "'");
		userAddressesPage.inputToTextboxByID(driver, "Address_FirstName", firstName);
		
		log.info("My_Account_02 - Step 03: Input to Last name textbox with value '" + lastName + "'");
		userAddressesPage.inputToTextboxByID(driver, "Address_LastName", lastName);
		
		log.info("My_Account_02 - Step 04: Input to Email textbox with value '" + emailAddress + "'");
		userAddressesPage.inputToTextboxByID(driver, "Address_Email", emailAddress);
		
		log.info("My_Account_02 - Step 05: Input to Company textbox with value '" + editCompanyName + "'");
		userAddressesPage.inputToTextboxByID(driver, "Address_Company", editCompanyName);
		
		log.info("My_Account_02 - Step 07: Input to Country textbox with value '" + country + "'");
		userAddressesPage.selectToItemInDropdownByID(driver, "Address_CountryId", country);
		
		log.info("My_Account_02 - Step 08: Input to State/ Province textbox with value '" + state + "'");
		userAddressesPage.waitForWaitingIconInvisible();
		userAddressesPage.selectToItemInDropdownByID(driver, "Address_StateProvinceId", state);
				
		log.info("My_Account_02 - Step 06: Input to Country textbox with value '" + cityName + "'");
		userAddressesPage.inputToTextboxByID(driver, "Address_City", cityName);
		
		log.info("My_Account_02 - Step 09: Input to Address 1 textbox with value '" + address_01 + "'");
		userAddressesPage.inputToTextboxByID(driver, "Address_Address1", address_01);
		
		log.info("My_Account_02 - Step 10: Input to Address 2 textbox with value '" + address_02 + "'");
		userAddressesPage.inputToTextboxByID(driver, "Address_Address2", address_02);
		
		log.info("My_Account_02 - Step 11: Input to Zip/ portal code textbox with value '" + zipCode + "'");
		userAddressesPage.inputToTextboxByID(driver, "Address_ZipPostalCode", zipCode);
		
		log.info("My_Account_02 - Step 12: Input to Phone number textbox with value '" + phoneNumber + "'");
		userAddressesPage.inputToTextboxByID(driver, "Address_PhoneNumber", phoneNumber);
		
		log.info("My_Account_02 - Step 13: Input to Zip/ portal code textbox with value '" + faxNumber + "'");
		userAddressesPage.inputToTextboxByID(driver, "Address_FaxNumber", faxNumber);
		
		log.info("My_Account_02 - Step 14: Click to Save button");
		userAddressesPage.clickToSaveButton();
		
		log.info("My_Account_02 - Step 15: Verify Full name added");
		verifyEquals(userAddressesPage.getTextValueByClass("name"), firstName + " " + lastName);
		
		log.info("My_Account_02 - Step 16: Verify Email added");
		verifyEquals(userAddressesPage.getTextValueByClass("email"), "Email: " + emailAddress);
		
		log.info("My_Account_02 - Step 17: Verify Phone number added");
		verifyEquals(userAddressesPage.getTextValueByClass("phone"), "Phone number: " + phoneNumber);
		
		log.info("My_Account_02 - Step 18: Verify Fax number added");
		verifyEquals(userAddressesPage.getTextValueByClass("fax"), "Fax number: " + faxNumber);
		
		log.info("My_Account_02 - Step 19: Verify Company name added");
		verifyEquals(userAddressesPage.getTextValueByClass("company"), editCompanyName);
		
		log.info("My_Account_02 - Step 20: Verify Address 1 added");
		verifyEquals(userAddressesPage.getTextValueByClass("address1"), address_01);
		
		log.info("My_Account_02 - Step 21: Verify Address 2 added");
		verifyEquals(userAddressesPage.getTextValueByClass("address2"), address_02);
		
		log.info("My_Account_02 - Step 22: Verify City state zip added");
		verifyEquals(userAddressesPage.getTextValueByClass("city-state-zip"), cityName + ", " + state + ", " + zipCode);
		
		log.info("My_Account_02 - Step 23: Verify Country name added");
		verifyEquals(userAddressesPage.getTextValueByClass("country"), country);
	}
	
	@Test
	public void My_Account_03_Change_Password() {
		log.info("My_Account_03 - Step 01: Open Change Password page");
		userAddressesPage.openSidebarPageByPageName(driver, "Change password");
		userChangePwdPage = PageGeneratorManager.getUserChangePassowrdPage(driver);
		
		log.info("My_Account_03 - Step 02: Input to Old password textbox with value '" + password + "'");
		userChangePwdPage.inputToTextboxByID(driver, "OldPassword", password);
		
		log.info("My_Account_03 - Step 03: Input to New password textbox with value '" + editPassword + "'");
		userChangePwdPage.inputToTextboxByID(driver, "NewPassword", editPassword);
		
		log.info("My_Account_03 - Step 04: Input to Confirm password textbox with value '" + editPassword + "'");
		userChangePwdPage.inputToTextboxByID(driver, "ConfirmNewPassword", editPassword);
		
		log.info("My_Account_03 - Step 05: Click to Change Password button");
		userChangePwdPage.clickToChangePwdButton();
		
		log.info("My_Account_03 - Step 05: Click to Close icon");
		userChangePwdPage.clickToCloseMessageButton();
		
		log.info("My_Account_03 - Step 06: Click to Log out link");
		userChangePwdPage.openPageByNamePage(driver, "Log out");
		userDashboardPage = PageGeneratorManager.getUserDashboardPage(driver);
		
		log.info("My_Account_03 - Step 07: Open Login page");
		userDashboardPage.openPageByNamePage(driver, "Log in");
		userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
		
		log.info("My_Account_03 - Step 08: Input to Email textbox with value '" + editEmailAddress + "'");
		userLoginPage.inputToTextboxByID(driver, "Email", editEmailAddress);
		
		log.info("My_Account_03 - Step 09: Input to Password textbox with value '" + editPassword + "'");
		userLoginPage.inputToTextboxByID(driver, "Password", editPassword);
		
		log.info("My_Account_03 - Step 10: Click to Login button");
		userDashboardPage = userLoginPage.clickToLoginButton();
		
		log.info("My_Account_03 - Step 11: Verify My account link displayed");
		verifyTrue(userDashboardPage.isMyAccountLinkDisplayed());
	}
	
	@Test
	public void My_Account_04_My_Product_Reviews() {
		log.info("My_Account_04 - Step 01: Open Product Details");
		userProductDetailsPage = userDashboardPage.openProDetailByProName(driver, "Build your own computer");
	
		log.info("My_Account_04 - Step 02: Click to Add Review button");
		userProductReviewsPage = userProductDetailsPage.clickToAddReview();
		
		log.info("My_Account_04 - Step 03: Input to Review Title textbox with value 'It's really good'");
		userProductReviewsPage.inputToTextboxByID(driver, "AddProductReview_Title", "It's really good");
		
		log.info("My_Account_04 - Step 04: Input to Review Text area with value 'It's really good'");
		userProductReviewsPage.inputToReviewText("It's really good");
		
		log.info("My_Account_04 - Step 05: Click to Submit button");
		userProductReviewsPage.clickToSubmitButton();
		
		log.info("My_Account_04 - Step 06: Open My account page");
		userProductReviewsPage.openPageByNamePage(driver, "My account");
		userCustomerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
		
		log.info("My_Account_04 - Step 07: Open My product reviews page");
		userCustomerInfoPage.openSidebarPageByPageName(driver, "My product reviews");
		userMyProductReviewsPage = PageGeneratorManager.getUserMyProductReviewsPage(driver);
		
		log.info("My_Account_04 - Step 08: Verify Review Title displayed");
		verifyEquals(userMyProductReviewsPage.getTextValueByClassName("review-title"), "It's really good");
		
		log.info("My_Account_04 - Step 09: Verify Review Text displayed");
		verifyEquals(userMyProductReviewsPage.getTextValueByClassName("review-text"), "It's really good");
	}
	
	@AfterClass
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		closeBrowserAndDriver();
	}
	
	private Environment environment;
	private WebDriver driver;
		
	private DataUtil data;
	private UserDashboardPO userDashboardPage;
	private UserRegisterPO userRegisterPage;
	private UserCustomerInfoPO userCustomerInfoPage;
	private UserAddressesPO userAddressesPage;
	private UserChangePasswordPO userChangePwdPage;
	private UserProductDetailsPO userProductDetailsPage;
	private UserProductReviewsPO userProductReviewsPage;
	private UserMyProductReviewsPO userMyProductReviewsPage;
	private UserLoginPO userLoginPage;
	
	private String firstName, lastName, emailAddress, password, address_01, address_02, state, country, zipCode, phoneNumber, faxNumber, cityName;
	private String editFirstName, editLastName, editEmailAddress ,editPassword, editDay, editMonth, editYear, editCompanyName;
}
