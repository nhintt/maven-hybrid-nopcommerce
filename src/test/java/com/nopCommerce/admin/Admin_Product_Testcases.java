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
import pageObjects.nopCommerce.admin.AdminLoginPO;
import pageObjects.nopCommerce.admin.AdminProductDetailPO;
import pageObjects.nopCommerce.admin.AdminProductsPO;

public class Admin_Product_Testcases extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		productName = "Lenovo IdeaCentre 600 All-in-One PC";
		
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
		adminDashboardPage = PageGeneratorManager.getAdminLoginPage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		log.info("Before test: Open Products page");
		adminDashboardPage.openSideBarSubMenuAdmmin(driver, "Catalog", "Products");
		adminProductsPage = PageGeneratorManager.getAdminProductsPage(driver);
	}
	
	@Test
	public void Products_01_Search_With_Product_Name() {
		log.info("Product_01 - Step 01: Input to 'Product name' textbox with value '" + productName + "'");
		adminProductsPage.inputToTextboxByID(driver, "SearchProductName", productName);
		
		log.info("Product_01 - Step 02: Click to 'Search' button");
		adminProductsPage.clickToButtonByText(driver, "Search");
		
		log.info("Product_01 - Step 03: Verify there is only 1 product displaying");
		verifyEquals(adminProductsPage.getProductSearchResult(), 1);
		
		log.info("Product_01 - Step 04: Verify product name");
		verifyEquals(adminProductsPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Product name"), productName);
	}
	
	@Test
	public void Products_02_Search_With_Product_Name_Parent_Category_Checked() {
		log.info("Products_02 - Step 01: Input to 'Product name' textbox with value '" + productName + "'");
		adminProductsPage.inputToTextboxByID(driver, "SearchProductName", productName);
		
		log.info("Products_02 - Step 02: Select 'Computers' in Category dropdown");
		adminProductsPage.selectToItemInDropdownByID(driver, "SearchCategoryId", "Computers");
		
		log.info("Products_02 - Step 03: Click to 'Search' button");
		adminProductsPage.clickToButtonByText(driver, "Search");
		
		log.info("Products_02 - Step 04: Verify empty message displayed");
		verifyTrue(adminProductsPage.isEmptyMessageDisplayed());
	}
	
	@Test
	public void Products_03_Search_With_Product_Name_Parent_Category_Unchecked() {
		log.info("Products_03 - Step 01: Input to 'Product name' textbox with value '" + productName + "'");
		adminProductsPage.inputToTextboxByID(driver, "SearchProductName", productName);
		
		log.info("Products_03 - Step 02: Select 'Computers' in Category dropdown");
		adminProductsPage.selectToItemInDropdownByID(driver, "SearchCategoryId", "Computers");
		
		log.info("Products_03 - Step 03: Select 'Computers' in Category dropdown");
		adminProductsPage.checkToSeachSubCategoriesCheckbox();
		
		log.info("Products_03 - Step 04: Click to 'Search' button");
		adminProductsPage.clickToButtonByText(driver, "Search");
		
		log.info("Products_03 - Step 05: Verify there is only 1 product displaying");
		verifyEquals(adminProductsPage.getProductSearchResult(), 1);
		
		log.info("Products_03 - Step 06: Verify product name");
		verifyEquals(adminProductsPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Product name"), productName);
	}
	
	@Test
	public void Products_04_Search_With_Product_Name_Child_Category() {
		log.info("Products_04 - Step 01: Input to 'Product name' textbox with value '" + productName + "'");
		adminProductsPage.inputToTextboxByID(driver, "SearchProductName", productName);
		
		log.info("Products_04 - Step 02: Select 'Computers >> Desktops' in Category dropdown");
		adminProductsPage.selectToItemInDropdownByID(driver, "SearchCategoryId", "Computers >> Desktops");
		
		log.info("Products_04 - Step 03: Click to 'Search' button");
		adminProductsPage.clickToButtonByText(driver, "Search");
		
		log.info("Products_04 - Step 04: Verify there is only 1 product displaying");
		verifyEquals(adminProductsPage.getProductSearchResult(), 1);
		
		log.info("Products_04 - Step 05: Verify product name");
		verifyEquals(adminProductsPage.getCellValueByColumnNameAndRowIndex(driver, "1", "Product name"), productName);
	}
	
	@Test
	public void Products_05_Goto_Directly_To_Product_SKU() {
		log.info("Products_04 - Step 01: Input to 'Go directly to product SKU' textbox with value 'LE_IC_600'");
		adminProductsPage.inputToTextboxByID(driver, "GoDirectlyToSku", "LE_IC_600");
		
		log.info("Products_04 - Step 03: Click to 'Go' button");
		adminProductsPage.clickToButtonByText(driver, "Go");
		adminProductDetailPage = PageGeneratorManager.getAdminProductDetailPage(driver);
		
		log.info("Products_04 - Step 04: Verify open 'Product detail' successfully");
		verifyTrue(adminProductDetailPage.isPageNameDisplayed());
		
		log.info("Products_04 - Step 05: Verify product name");
		verifyEquals(adminProductDetailPage.getProductName(), productName);
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		closeBrowserAndDriver();
	}
	
	private Environment environment;
	private WebDriver driver;
	
	private AdminLoginPO adminLoginPage;
	private AdminLoginPO adminDashboardPage;
	private AdminProductsPO adminProductsPage;
	private AdminProductDetailPO adminProductDetailPage;
	private String productName;
}
