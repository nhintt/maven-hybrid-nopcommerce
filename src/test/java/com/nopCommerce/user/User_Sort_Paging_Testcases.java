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
import pageObjects.nopCommerce.user.UserProductListPO;

public class User_Sort_Paging_Testcases extends BaseTest {
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		String envName = System.getProperty("envMaven");
		ConfigFactory.setProperty("envOwner", envName);
		environment = ConfigFactory.create(Environment.class);
		
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' with URL='" + environment.appUrl() + "'");
		driver = getBaseTestDriver(browserName, environment.appUrl());
		userDashboardPage = PageGeneratorManager.getUserDashboardPage(driver);
		
		log.info("Pre-Condition - Step 02: Open list of products in Notebooks category");
		userDashboardPage.openSubMenuPageByPageName(driver, "Computers", "Notebooks");
		userProductListPage = PageGeneratorManager.getUserProductListPage(driver);
	}
	
	@Test
	public void Sort_01_Name_AZ() {
		log.info("Sort_01 - Step 01: Select 'Name A to Z' option in Sort dropdown");
		userProductListPage.selectToItemInDropdownByID(driver, "products-orderby", "Name: A to Z");
		
		log.info("Sort_01 - Step 02: Verify list of products sorted correctly");
		verifyTrue(userProductListPage.isProductNameSortedAscending());
	}
	
	@Test
	public void Sort_02_Name_ZA() {
		log.info("Sort_02 - Step 01: Select 'Name Z to A' option in Sort dropdown");
		userProductListPage.selectToItemInDropdownByID(driver, "products-orderby", "Name: Z to A");
		
		log.info("Sort_02 - Step 02: Verify list of products sorted correctly");
		verifyTrue(userProductListPage.isProductNameSortedDescending());
	}
	
	@Test
	public void Sort_03_Price_Low_To_High() {
		log.info("Sort_03 - Step 01: Select 'Price: Low to High' option in Sort dropdown");
		userProductListPage.selectToItemInDropdownByID(driver, "products-orderby", "Price: Low to High");
		
		log.info("Sort_03 - Step 02: Verify list of products sorted correctly");
		verifyTrue(userProductListPage.isProductPriceSortedAscending());
	}
	
	@Test
	public void Sort_04_Price_High_To_Low() {
		log.info("Sort_04 - Step 01: Select 'Price: High to Low' option in Sort dropdown");
		userProductListPage.selectToItemInDropdownByID(driver, "products-orderby", "Price: High to Low");
		
		log.info("Sort_04 - Step 02: Verify list of products sorted correctly");
		verifyTrue(userProductListPage.isProductPriceSortedDescending());
	}
	
	@Test
	public void Sort_05_Display_3_Items() {
		log.info("Sort_04 - Step 01: Select '3' option in Display dropdown");
		userProductListPage.selectToItemInDropdownByID(driver, "products-pagesize", "3");
		
		log.info("Sort_04 - Step 02: Verify page displayed 3 or less than 3 items");
		verifyTrue(userProductListPage.isItemDisplayedMatchWithPageSize(3));
		
		log.info("Sort_04 - Step 02: Verify Next icon displayed");
		verifyTrue(userProductListPage.isArowIconDisplayed("Next"));
		
		log.info("Sort_04 - Step 02: Click to Page 2");
		userProductListPage.clickToPageNumber("2");
		
		log.info("Sort_04 - Step 02: Verify Previous icon displayed");
		verifyTrue(userProductListPage.isArowIconDisplayed("Previous"));
	}
	
	@Test
	public void Sort_06_Display_6_Items() {
		log.info("Sort_04 - Step 01: Select '6' option in Display dropdown");
		userProductListPage.selectToItemInDropdownByID(driver, "products-pagesize", "6");
		
		log.info("Sort_04 - Step 02: Verify page displayed 6 or less than 6 items");
		verifyTrue(userProductListPage.isItemDisplayedMatchWithPageSize(6));
		
		log.info("Sort_04 - Step 02: Verify Page Container does not display");
		verifyTrue(userProductListPage.isPageContainerInvisible());
	}
	
	@Test
	public void Sort_07_Display_9_Items() {
		log.info("Sort_04 - Step 01: Select '6' option in Display dropdown");
		userProductListPage.selectToItemInDropdownByID(driver, "products-pagesize", "9");
		
		log.info("Sort_04 - Step 02: Verify page displayed 9 or less than 9 items");
		verifyTrue(userProductListPage.isItemDisplayedMatchWithPageSize(9));
		
		log.info("Sort_04 - Step 02: Verify Page Container does not display");
		verifyTrue(userProductListPage.isPageContainerInvisible());
	}
	
	@AfterClass
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		closeBrowserAndDriver();
	}
	
	private WebDriver driver;
	private Environment environment;
	
	private UserProductListPO userProductListPage;
	private UserDashboardPO userDashboardPage;
}
