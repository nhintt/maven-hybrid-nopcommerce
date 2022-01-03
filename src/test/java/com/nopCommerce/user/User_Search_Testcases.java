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
import pageObjects.nopCommerce.user.UserSearchPO;

public class User_Search_Testcases extends BaseTest {

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		relativeItem = "Lenovo";
		absoluteItem = "Lenovo IdeaCentre 600 All-in-One PC";
		
		String envName = System.getProperty("envMaven");
		ConfigFactory.setProperty("envOwner", envName);
		environment = ConfigFactory.create(Environment.class);
		
		log.info("Pre-Condition - Step 01: Open browser'" + browserName + "' with URL = '" + environment.appUrl() + "'");
		driver = getBaseTestDriver(browserName, environment.appUrl());
		userDashboardPage = PageGeneratorManager.getUserDashboardPage(driver);
		
		log.info("Pre-Condition - Step 02: Open Search page");
		userDashboardPage.openFooterPageByPageName(driver, "Search");
		userSearchPage = PageGeneratorManager.getUserSearchPage(driver);
	}
	
	@Test
	public void Search_01_Empty_Data() {
		log.info("Search_01 - Step 01: Click to Search button");
		userSearchPage.clickToSearchButton();
		
		log.info("Search_01 - Step 02: Verify error message displayed");
		verifyTrue(userSearchPage.isWarningMessageDisplayed());
	}
	
	@Test
	public void Search_02_Data_Not_Exist() {
		log.info("Search_02 - Step 01: Input to Search textbox with value 'Macbook pro 2005'");
		userSearchPage.inputToTextboxByID(driver, "q", "Macbook pro 2005");
		
		log.info("Search_02 - Step 02: Click to Search button");
		userSearchPage.clickToSearchButton();
		
		log.info("Search_02 - Step 03: Verify no result message displayed");
		verifyTrue(userSearchPage.isNoResultMessageDisplayed());
	}
	
	@Test
	public void Search_03_Relative_Data() {
		log.info("Search_03 - Step 01: Input to Search textbox with value '" + relativeItem + "'");
		userSearchPage.inputToTextboxByID(driver, "q", relativeItem);
		
		log.info("Search_03 - Step 02: Click to Search button");
		userSearchPage.clickToSearchButton();
		
		log.info("Search_03 - Step 03: Verify result displayed correctly");
		verifyEquals(userSearchPage.getSearchResultQuantity(relativeItem), "2");
	}
	
	@Test
	public void Search_04_Absolute_Data() {
		log.info("Search_04 - Step 01: Input to Search textbox with value '" + absoluteItem + "'");
		userSearchPage.inputToTextboxByID(driver, "q", absoluteItem);
		
		log.info("Search_04 - Step 02: Click to Search button");
		userSearchPage.clickToSearchButton();
		
		log.info("Search_04 - Step 03: Verify result displayed correctly");
		verifyEquals(userSearchPage.getSearchResultQuantity(absoluteItem), "1");
	}
	
	@Test
	public void Search_05_Parent_Categories() {
		log.info("Search_05 - Step 01: Input to Search textbox with value 'Apple Macbook Pro'");
		userSearchPage.inputToTextboxByID(driver, "q", "Apple Macbook Pro");
		
		log.info("Search_05 - Step 02: Click to 'Advanced search' checkbox");
		userSearchPage.selectToCheckboxByID("advs");
		
		log.info("Search_05 - Step 03: Select 'Computers' in Categories");
		userSearchPage.selectToItemInDropdownByID(driver, "cid", "Computers");
		
		log.info("Search_05 - Step 04: Click to Search button");
		userSearchPage.clickToSearchButton();
		
		log.info("Search_05 - Step 05: Verify no result message displayed");
		verifyTrue(userSearchPage.isNoResultMessageDisplayed());
	}

	@Test
	public void Search_06_Sub_Categories() {
		log.info("Search_06 - Step 01: Input to Search textbox with value 'Apple Macbook Pro'");
		userSearchPage.inputToTextboxByID(driver, "q", "Apple MacBook Pro");
		
		log.info("Search_06 - Step 02: Click to 'Advanced search' checkbox");
		userSearchPage.selectToCheckboxByID("advs");
		
		log.info("Search_06 - Step 03: Select 'Computers' in Categories");
		userSearchPage.selectToItemInDropdownByID(driver, "cid", "Computers");

		log.info("Search_06 - Step 04: Click to 'Automatically search sub categories' checkbox");
		userSearchPage.selectToCheckboxByID("isc");
		
		log.info("Search_06 - Step 05: Click to Search button");
		userSearchPage.clickToSearchButton();
		
		log.info("Search_06 - Step 06: Verify result displayed correctly");
		verifyEquals(userSearchPage.getSearchResultQuantity("Apple MacBook Pro"), "1");
	}

	@Test
	public void Search_07_Incorrect_Manufacturer() {
		log.info("Search_07 - Step 01: Input to Search textbox with value 'Apple Macbook Pro'");
		userSearchPage.inputToTextboxByID(driver, "q", "Apple MacBook Pro");
		
		log.info("Search_07 - Step 02: Click to 'Advanced search' checkbox");
		userSearchPage.selectToCheckboxByID("advs");
		
		log.info("Search_07 - Step 03: Select 'Computers' in Categories");
		userSearchPage.selectToItemInDropdownByID(driver, "cid", "Computers");

		log.info("Search_07 - Step 04: Click to 'Automatically search sub categories' checkbox");
		userSearchPage.selectToCheckboxByID("isc");
		
		log.info("Search_07 - Step 05: Select 'HP' in Manufacturer");
		userSearchPage.selectToItemInDropdownByID(driver, "mid", "HP");
		
		log.info("Search_07 - Step 08: Click to Search button");
		userSearchPage.clickToSearchButton();
		
		log.info("Search_07 - Step 07: Verify no result message displayed");
		verifyTrue(userSearchPage.isNoResultMessageDisplayed());
	}
	
	@Test
	public void Search_08_Correct_Manufacturer() {
		log.info("Search_08 - Step 01: Input to Search textbox with value 'Apple Macbook Pro'");
		userSearchPage.inputToTextboxByID(driver, "q", "Apple MacBook Pro");
		
		log.info("Search_08 - Step 02: Click to 'Advanced search' checkbox");
		userSearchPage.selectToCheckboxByID("advs");
		
		log.info("Search_08 - Step 03: Select 'Computers' in Categories");
		userSearchPage.selectToItemInDropdownByID(driver, "cid", "Computers");
		
		log.info("Search_08 - Step 04: Click to 'Automatically search sub categories' checkbox");
		userSearchPage.selectToCheckboxByID("isc");
		
		log.info("Search_08 - Step 05: Select 'Apple' in Manufacturer");
		userSearchPage.selectToItemInDropdownByID(driver, "mid", "Apple");
		
		log.info("Search_08 - Step 06: Click to Search button");
		userSearchPage.clickToSearchButton();
		
		log.info("Search_08 - Step 07: Verify result displayed correctly");
		verifyEquals(userSearchPage.getSearchResultQuantity("Apple MacBook Pro"), "1");
	}
	
	@AfterClass
	public void afterClass() {
		log.info("Post-Condition - Close browser");
		closeBrowserAndDriver();
	}
	
	private Environment environment;
	private WebDriver driver;
	private String relativeItem, absoluteItem;
	
	private UserSearchPO userSearchPage;
	private UserDashboardPO userDashboardPage;
}
