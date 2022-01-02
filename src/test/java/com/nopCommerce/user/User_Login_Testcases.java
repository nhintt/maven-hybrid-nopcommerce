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
import pageObjects.nopCommerce.user.UserLoginPO;
import pageObjects.nopCommerce.user.UserRegisterPO;
import utilities.DataUtil;

public class User_Login_Testcases extends BaseTest {

	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		data = DataUtil.getData();
		firstName = data.getFirstName();
		lastName = data.getLastName();
		emailAddress = data.getEmailAddress();
		password = data.getPassword();
		
		String environmentName = System.getProperty("envMaven");
		ConfigFactory.setProperty("envOwner", environmentName);
		environment = ConfigFactory.create(Environment.class);
		
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' with URL='" + environment.appUrl() + "'");
		driver = getBaseTestDriver(browserName, environment.appUrl());
		userDashboardPage = PageGeneratorManager.getUserDashboardPage(driver);
		
		log.info("Pre-Condition - Step 02: Open Register page");
		userDashboardPage.openPageByNamePage(driver, "Register");
		userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
		
		log.info("Pre-Condition - Step 03: Input to Firstname textbox with value '" + firstName + "'");
		userRegisterPage.inputToTextboxByID(null, "FirstName", firstName);
		
		log.info("Pre-Condition - Step 04: Input to Lastname textbox with value '" + lastName + "'");
		userRegisterPage.inputToTextboxByID(null, "LastName", lastName);
		
		log.info("Pre-Condition - Step 05: Input to Email textbox with value '" + emailAddress + "'");
		userRegisterPage.inputToTextboxByID(null, "Email", emailAddress);
		
		log.info("Pre-Condition - Step 06: Input to Password textbox with value '" + password + "'");
		userRegisterPage.inputToTextboxByID(null, "Password", password);
		
		log.info("Pre-Condition - Step 07: Input to Confirm password textbox with value '" + password + "'");
		userRegisterPage.inputToTextboxByID(null, "ConfirmPassword", password);
		
		log.info("Pre-Condition - Step 08: Click to Register button");
		userRegisterPage.clickToRegisterButton();
		
		log.info("Pre-Condition - Step 09: Verify successful message display");
		verifyTrue(userRegisterPage.isSuccessfulMsgDisplayed());
		
		log.info("Pre-Condition - Step 10: Click to Logout link");
		userRegisterPage.openPageByNamePage(driver, "Log out");
		userDashboardPage = PageGeneratorManager.getUserDashboardPage(driver);
	}
	
	@Test
	public void Login_01_With_Empty_Data() {
		log.info("Login_01 - Step 01: Open Login page");
		userDashboardPage.openPageByNamePage(driver, "Log in");
		userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
		
		log.info("Login_01 - Step 02: Click to Login button");
		userLoginPage.clickToLoginButton();
		
		log.info("Login_01 - Step 03: Verify error message displayed at Email textbox");
		verifyEquals(userLoginPage.getErrorMsgAtEmailTextbox(), "Please enter your email");
	}
	
	@Test
	public void Login_02_With_Invalid_Email() {
		log.info("Login_02 - Step 01: Open Login page");
		userDashboardPage.openPageByNamePage(driver, "Log in");
		userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
		
		log.info("Login_02 - Step 02: Input to Email textbox with value 'abc@abc@!#$'");
		userLoginPage.inputToTextboxByID(null, "Email", "abc@abc@!#$");
		
		log.info("Login_02 - Step 03: Input to Password textbox with value '" + password + "'");
		userLoginPage.inputToTextboxByID(null, "Password", password);
		
		log.info("Login_02 - Step 04: Click to Login button");
		userLoginPage.clickToLoginButton();
		
		log.info("Login_02 - Step 05: Verify error message displayed at Email textbox");
		verifyEquals(userLoginPage.getErrorMsgAtEmailTextbox(), "Wrong email");
	}
	
	@Test
	public void Login_03_With_Non_Existent_Email() {
		log.info("Login_03 - Step 01: Open Login page");
		userDashboardPage.openPageByNamePage(driver, "Log in");
		userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
		
		log.info("Login_03 - Step 02: Input to Email textbox with value 'automation@mail.vn'");
		userLoginPage.inputToTextboxByID(null, "Email", "automation@mail.vn");
		
		log.info("Login_03 - Step 03: Input to Password textbox with value '" + password + "'");
		userLoginPage.inputToTextboxByID(null, "Password", password);
		
		log.info("Login_03 - Step 04: Click to Login button");
		userLoginPage.clickToLoginButton();
		
		log.info("Login_03 - Step 05: Verify error message displayed");
		verifyEquals(userLoginPage.getGenericErrorMsg(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	
	@Test
	public void Login_04_With_Empty_Password() {
		log.info("Login_04 - Step 01: Open Login page");
		userDashboardPage.openPageByNamePage(driver, "Log in");
		userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
		
		log.info("Login_04 - Step 02: Input to Email textbox with value '" + emailAddress + "'");
		userLoginPage.inputToTextboxByID(null, "Email", emailAddress);
		
		log.info("Login_04 - Step 03: Click to Login button");
		userLoginPage.clickToLoginButton();
		
		log.info("Login_04 - Step 04: Verify error message displayed");
		verifyEquals(userLoginPage.getGenericErrorMsg(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_05_With_Wrong_Password(){
		log.info("Login_05 - Step 01: Open Login page");
		userDashboardPage.openPageByNamePage(driver, "Log in");
		userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
		
		log.info("Login_05 - Step 02: Input to Email textbox with value '" + emailAddress + "'");
		userLoginPage.inputToTextboxByID(null, "Email", emailAddress);
		
		log.info("Login_05 - Step 03: Input to Password textbox with value '123456'");
		userLoginPage.inputToTextboxByID(null, "Password", "123456");
		
		log.info("Login_05 - Step 04: Click to Login button");
		userLoginPage.clickToLoginButton();
		
		log.info("Login_05 - Step 05: Verify error message displayed");
		verifyEquals(userLoginPage.getGenericErrorMsg(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	
	@Test
	public void Login_06_Successfully() {
		log.info("Login_06 - Step 01: Open Login page");
		userDashboardPage.openPageByNamePage(driver, "Log in");
		userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
		
		log.info("Login_06 - Step 02: Input to Email textbox with value '" + emailAddress + "'");
		userLoginPage.inputToTextboxByID(null, "Email", emailAddress);
		
		log.info("Login_06 - Step 03: Input to Password textbox with value '" + password + "'");
		userLoginPage.inputToTextboxByID(null, "Password", password);
		
		log.info("Login_06 - Step 04: Click to Login button");
		userDashboardPage = userLoginPage.clickToLoginButton();
		
		log.info("Login_06 - Step 05: Verify My account link displayed");
		verifyTrue(userDashboardPage.isMyAccountLinkDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private Environment environment;
	private DataUtil data;
	
	private UserDashboardPO userDashboardPage;
	private UserRegisterPO userRegisterPage;
	private UserLoginPO userLoginPage;
	private String firstName, lastName, emailAddress, password;
}
