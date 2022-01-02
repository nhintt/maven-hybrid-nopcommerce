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
import pageObjects.nopCommerce.user.UserDashboardPO;
import pageObjects.nopCommerce.user.UserRegisterPO;
import utilities.DataUtil;

public class User_Register_Testcases extends BaseTest {
	Environment environment;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		String environmentName = System.getProperty("envMaven");
		ConfigFactory.setProperty("envOwner", environmentName);
		environment = ConfigFactory.create(Environment.class);
		
		log.info("Pre-Condition: Open browser'" + browserName + "' with URL = '" + environment.appUrl() + "'");
		driver = getBaseTestDriver(browserName, environment.appUrl());
		userDashboardPage = PageGeneratorManager.getUserDashboardPage(driver);
		
		data = DataUtil.getData();
		firstName = data.getFirstName();
		lastName = data.getLastName();
		emailAddress = data.getEmailAddress();
		password = data.getPassword();
	}
	
	@Test
	public void Register_01_Register_With_Empty_Data() {
		log.info("Register_01 - Step 01: Open Register page");
		userDashboardPage.openPageByNamePage(driver, "Register");
		userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
		
		log.info("Register_01 - Step 02: Click to Register button");
		userRegisterPage.clickToRegisterButton();
		
		log.info("Register_01 - Step 03: Verify error message display at First Name textbox");
		verifyEquals(userRegisterPage.getErrorMessageByID("FirstName-error"), "First name is required.");
		
		log.info("Register_01 - Step 04: Verify error message display at Last Name textbox");
		verifyEquals(userRegisterPage.getErrorMessageByID("LastName-error"), "Last name is required.");
		
		log.info("Register_01 - Step 05: Verify error message display at Email textbox");
		verifyEquals(userRegisterPage.getErrorMessageByID("Email-error"), "Email is required.");
		
		log.info("Register_01 - Step 06: Verify error message display at Password textbox");
		verifyEquals(userRegisterPage.getErrorMessageByID("Password-error"), "Password is required.");
		
		log.info("Register_01 - Step 07: Verify error message display at Confirm Password textbox");
		verifyEquals(userRegisterPage.getErrorMessageByID("ConfirmPassword-error"), "Password is required.");
	}
	
	
	@Test
	public void Register_02_Register_With_Invalid_Email() {
		log.info("Register_02 - Step 01: Open Register page");
		userDashboardPage.openPageByNamePage(driver, "Register");
		userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
		
		log.info("Register_02 - Step 02: Input to Firstname textbox with value '" + firstName + "'");
		userRegisterPage.inputToTextboxByID(null, "FirstName", firstName);
		
		log.info("Register_02 - Step 03: Input to Lastname textbox with value '" + lastName + "'");
		userRegisterPage.inputToTextboxByID(null, "LastName", lastName);
		
		log.info("Register_02 - Step 04: Input to Email textbox with value 'abc@abc!'");
		userRegisterPage.inputToTextboxByID(null, "Email", "abc@abc!");
		
		log.info("Register_02 - Step 05: Input to Password textbox with value '" + password + "'");
		userRegisterPage.inputToTextboxByID(null, "Password", password);
		
		log.info("Register_02 - Step 06: Input to Confirm password textbox with value '" + password + "'");
		userRegisterPage.inputToTextboxByID(null, "ConfirmPassword", password);
		
		log.info("Register_02 - Step 07: Click to Register button");
		userRegisterPage.clickToRegisterButton();
		
		log.info("Register_02 - Step 08: Verify error message display at Email textbox");
		verifyEquals(userRegisterPage.getErrorMessageByID("Email-error"), "Wrong email");
	}
	
	@Test
	public void Register_03_Register_Successfully() {
		log.info("Register_03 - Step 01: Open Register page");
		userDashboardPage.openPageByNamePage(driver, "Register");
		userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
		
		log.info("Register_03 - Step 02: Input to Firstname textbox with value '" + firstName + "'");
		userRegisterPage.inputToTextboxByID(null, "FirstName", firstName);
		
		log.info("Register_03 - Step 03: Input to Lastname textbox with value '" + lastName + "'");
		userRegisterPage.inputToTextboxByID(null, "LastName", lastName);
		
		log.info("Register_03 - Step 04: Input to Email textbox with value '" + emailAddress + "'");
		userRegisterPage.inputToTextboxByID(null, "Email", emailAddress);
		
		log.info("Register_03 - Step 05: Input to Password textbox with value '" + password + "'");
		userRegisterPage.inputToTextboxByID(null, "Password", password);
		
		log.info("Register_03 - Step 06: Input to Confirm password textbox with value '" + password + "'");
		userRegisterPage.inputToTextboxByID(null, "ConfirmPassword", password);
		
		log.info("Register_03 - Step 07: Click to Register button");
		userRegisterPage.clickToRegisterButton();
		
		log.info("Register_03 - Step 08: Verify successful message display");
		verifyTrue(userRegisterPage.isSuccessfulMsgDisplayed());
		
		log.info("Register_03 - Step 09: Click to Logout link");
		userRegisterPage.openPageByNamePage(driver, "Log out");
	}
	
	@Test
	public void Register_04_Register_With_Existed_Email() {
		log.info("Register_04 - Step 01: Open Register page");
		userDashboardPage.openPageByNamePage(driver, "Register");
		userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
		
		log.info("Register_04 - Step 02: Input to Firstname textbox with value '" + firstName + "'");
		userRegisterPage.inputToTextboxByID(null, "FirstName", firstName);
		
		log.info("Register_04 - Step 03: Input to Lastname textbox with value '" + lastName + "'");
		userRegisterPage.inputToTextboxByID(null, "LastName", lastName);
		
		log.info("Register_04 - Step 04: Input to Email textbox with value '" + emailAddress + "'");
		userRegisterPage.inputToTextboxByID(null, "Email", emailAddress);
		
		log.info("Register_04 - Step 05: Input to Password textbox with value '" + password + "'");
		userRegisterPage.inputToTextboxByID(null, "Password", password);
		
		log.info("Register_04 - Step 06: Input to Confirm password textbox with value '" + password + "'");
		userRegisterPage.inputToTextboxByID(null, "ConfirmPassword", password);
		
		log.info("Register_04 - Step 07: Click to Register button");
		userRegisterPage.clickToRegisterButton();
		
		log.info("Register_04 - Step 08: Verify error message display");
		verifyTrue(userRegisterPage.isErrorMsgDisplayed());
	}
	
	@Test
	public void Register_05_Register_With_Pwd_Less_Than_6_Chars() {
		log.info("Register_05 - Step 01: Open Register page");
		userDashboardPage.openPageByNamePage(driver, "Register");
		userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
		
		log.info("Register_05 - Step 02: Input to Firstname textbox with value '" + firstName + "'");
		userRegisterPage.inputToTextboxByID(null, "FirstName", firstName);
		
		log.info("Register_05 - Step 03: Input to Lastname textbox with value '" + lastName + "'");
		userRegisterPage.inputToTextboxByID(null, "LastName", lastName);
		
		log.info("Register_05 - Step 04: Input to Email textbox with value '" + emailAddress + "'");
		userRegisterPage.inputToTextboxByID(null, "Email", emailAddress);
		
		log.info("Register_05 - Step 05: Input to Password textbox with value '12345'");
		userRegisterPage.inputToTextboxByID(null, "Password", "12345");
		
		log.info("Register_05 - Step 06: Input to Confirm password textbox with value '12345'");
		userRegisterPage.inputToTextboxByID(null, "ConfirmPassword", "12345");
		
		log.info("Register_05 - Step 07: Click to Register button");
		userRegisterPage.clickToRegisterButton();
		
		log.info("Register_05 - Step 08: Verify error message display at Password textbox");
		verifyEquals(userRegisterPage.getErrorMessageByID("Password-error"), "Password must meet the following rules:\nmust have at least 6 characters");
	}
	
	@Test
	public void Register_06_Register_With_Incorrect_Confirm_Pwd() {
		log.info("Register_04 - Step 01: Open Register page");
		userDashboardPage.openPageByNamePage(driver, "Register");
		userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
		
		log.info("Register_04 - Step 02: Input to Firstname textbox with value '" + firstName + "'");
		userRegisterPage.inputToTextboxByID(null, "FirstName", firstName);
		
		log.info("Register_04 - Step 03: Input to Lastname textbox with value '" + lastName + "'");
		userRegisterPage.inputToTextboxByID(null, "LastName", lastName);
		
		log.info("Register_04 - Step 04: Input to Email textbox with value '" + emailAddress + "'");
		userRegisterPage.inputToTextboxByID(null, "Email", emailAddress);
		
		log.info("Register_04 - Step 05: Input to Password textbox with value '" + password + "'");
		userRegisterPage.inputToTextboxByID(null, "Password", password);
		
		log.info("Register_04 - Step 06: Input to Confirm password textbox with value '123456'");
		userRegisterPage.inputToTextboxByID(null, "ConfirmPassword", "123456");
		
		log.info("Register_04 - Step 07: Click to Register button");
		userRegisterPage.clickToRegisterButton();
		
		log.info("Register_04 - Step 08: Verify error message display at Confirm Password textbox");
		verifyEquals(userRegisterPage.getErrorMessageByID("ConfirmPassword-error"), "The password and confirmation password do not match.");
	}
	
	@AfterClass
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		closeBrowserAndDriver();
	}
	
	private WebDriver driver;
	private UserDashboardPO userDashboardPage;
	private UserRegisterPO userRegisterPage;
	private String emailAddress, password, firstName, lastName;
	DataUtil data;
}
