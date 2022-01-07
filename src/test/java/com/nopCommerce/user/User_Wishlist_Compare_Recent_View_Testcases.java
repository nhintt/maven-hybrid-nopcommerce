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
import pageObjects.nopCommerce.user.UserCompareProductsPO;
import pageObjects.nopCommerce.user.UserDashboardPO;
import pageObjects.nopCommerce.user.UserProductDetailsPO;
import pageObjects.nopCommerce.user.UserProductListPO;
import pageObjects.nopCommerce.user.UserRecentlyViewedPO;
import pageObjects.nopCommerce.user.UserRegisterPO;
import pageObjects.nopCommerce.user.UserShoppingCartPO;
import pageObjects.nopCommerce.user.UserWishlistPO;
import utilities.DataUtil;

public class User_Wishlist_Compare_Recent_View_Testcases extends BaseTest {
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		data = DataUtil.getData();
		firstName = data.getFirstName();
		lastName = data.getLastName();
		emailAddress = data.getEmailAddress();
		password = data.getPassword();
		
//		String envName = System.getProperty("envMaven");
		ConfigFactory.setProperty("envOwner", "dev");
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
		
		log.info("Pre-Condition - Step 10: Open Dashboard page");
		userDashboardPage = userRegisterPage.openDashboardPageByLogoImg(driver);
	}
	
	@Test
	public void Wishlist_01_Add_To_Wishlist() {
		log.info("Wishlist_01 - Step 01: Open Product Details");
		userProductDetailsPage = userDashboardPage.openProDetailByProName(driver, "Apple MacBook Pro 13-inch");
		
		log.info("Wishlist_01 - Step 02: Add product to Wishlist");
		userProductDetailsPage.clickToButtonByText(driver, "Add to wishlist");
		
		log.info("Wishlist_01 - Step 03: Verify success message displayed");
		verifyTrue(userProductDetailsPage.isAddWishlistSuccessMsgDisplayed());
		
		log.info("Wishlist_01 - Step 04: Open Wishlist page");
		userProductDetailsPage.openPageByNamePage(driver, "wishlist");
		userWishlistPage = PageGeneratorManager.getUserWishlistPage(driver);
		
		log.info("Wishlist_01 - Step 05: Verify product is added to Wishlist successful");
		verifyTrue(userWishlistPage.isProductAddedSuccessfully("Apple MacBook Pro 13-inch"));
		
		log.info("Wishlist_01 - Step 06: Click to Sharing Wishlist URL");
		userWishlistPage.clickToSharingWishlistURL();
		
		log.info("Wishlist_01 - Step 07: Verify title of Sharing Wishlist URL");
		verifyEquals(userWishlistPage.getPageName(driver), "Wishlist of " + firstName + " " + lastName);
		
		log.info("Wishlist_01 - Step 08: Verify product is added to Wishlist successful");
		verifyTrue(userWishlistPage.isProductAddedSuccessfully("Apple MacBook Pro 13-inch"));
	}
	
	@Test
	public void Wishlist_02_Remove_Product_From_Wishlist() {
		log.info("Wishlist_02 - Step 01: Open Product Details");
		userDashboardPage = userWishlistPage.openDashboardPageByLogoImg(driver);
		userProductDetailsPage = userDashboardPage.openProDetailByProName(driver, "Apple MacBook Pro 13-inch");
		
		log.info("Wishlist_02 - Step 02: Add product to Wishlist");
		userProductDetailsPage.clickToButtonByText(driver, "Add to wishlist");
		
		log.info("Wishlist_02 - Step 03: Verify success message displayed");
		verifyTrue(userProductDetailsPage.isAddWishlistSuccessMsgDisplayed());
		
		log.info("Wishlist_02 - Step 04: Open Wishlist page");
		userProductDetailsPage.openPageByNamePage(driver, "wishlist");
		userWishlistPage = PageGeneratorManager.getUserWishlistPage(driver);
		
		log.info("Wishlist_02 - Step 05: Verify product is added to Wishlist successful");
		verifyTrue(userWishlistPage.isProductAddedSuccessfully("Apple MacBook Pro 13-inch"));
		
		log.info("Wishlist_02 - Step 06: Click Remove Icon");
		userWishlistPage.clickToRemoveProductIcon();
		
		log.info("Wishlist_02 - Step 07: Verify empty message displayed");
		verifyEquals(userWishlistPage.getEmptyMessage(driver), "The wishlist is empty!");
		
		log.info("Wishlist_02 - Step 08: Verify product is added to Wishlist successful");
		verifyTrue(userWishlistPage.isProductRemovedSuccessfully("Apple MacBook Pro 13-inch"));
	}
	
	@Test
	public void Wishlist_03_Add_To_Cart_From_Wishlist() {
		log.info("Wishlist_03 - Step 01: Open Product Details");
		userDashboardPage = userWishlistPage.openDashboardPageByLogoImg(driver);
		userProductDetailsPage = userDashboardPage.openProDetailByProName(driver, "Apple MacBook Pro 13-inch");
		
		log.info("Wishlist_03 - Step 02: Add product to Wishlist");
		userProductDetailsPage.clickToButtonByText(driver, "Add to wishlist");
		
		log.info("Wishlist_03 - Step 03: Verify success message displayed");
		verifyTrue(userProductDetailsPage.isAddWishlistSuccessMsgDisplayed());
		
		log.info("Wishlist_03 - Step 04: Open Wishlist page");
		userProductDetailsPage.openPageByNamePage(driver, "wishlist");
		userWishlistPage = PageGeneratorManager.getUserWishlistPage(driver);
		
		log.info("Wishlist_03 - Step 05: Verify product is added to Wishlist successful");
		verifyTrue(userWishlistPage.isProductAddedSuccessfully("Apple MacBook Pro 13-inch"));
		
		log.info("Wishlist_03 - Step 06: Select to checkbox in Wishlist table");
		userWishlistPage.clickCheckboxInTableByProductName("Apple MacBook Pro 13-inch");
		
		log.info("Wishlist_03 - Step 07: Click to Add to cart button");
		userWishlistPage.clickToButtonByText(driver, "Add to cart");
		userShoppingCartPage = PageGeneratorManager.getUserShoppingCartPage(driver);
		
		log.info("Wishlist_03 - Step 07: Verify Shopping Cart page title displayed");
		verifyEquals(userShoppingCartPage.getPageName(driver), "Shopping cart");
		
		log.info("Wishlist_03 - Step 08: Verify product is added successfully");
		verifyTrue(userShoppingCartPage.isProductAddedSuccessfully("Apple MacBook Pro 13-inch"));
		
		log.info("Wishlist_03 - Step 08: Open Wishlist page");
		userShoppingCartPage.openPageByNamePage(driver, "Wishlist");
		userWishlistPage = PageGeneratorManager.getUserWishlistPage(driver);
		
		log.info("Wishlist_03 - Step 08: Open Wishlist page");
		verifyTrue(userWishlistPage.isProductRemovedSuccessfully("Apple MacBook Pro 13-inch"));
	}
	
	@Test
	public void Wishlist_04_Add_Product_To_Compare_List() {
		log.info("Compare_04 - Step 01: Open Dashboard page");
		userDashboardPage = userWishlistPage.openDashboardPageByLogoImg(driver);
		
		log.info("Compare_04 - Step 01: Add product 'Build your own computer' to compare list");
		userDashboardPage.clickToButtonByProductNameAndBtnName("Build your own computer", "Add to compare list");
		
		log.info("Compare_04 - Step 01: Verify success message displayed");
		verifyTrue(userDashboardPage.isAddCompareSuccessMsgDisplayed());
		
		log.info("Compare_04 - Step 01: Add product 'Apple MacBook Pro 13-inch' to compare list");
		userDashboardPage.clickToButtonByProductNameAndBtnName("Apple MacBook Pro 13-inch", "Add to compare list");
		userDashboardPage.sleepInSecond(2);
		
		log.info("Compare_04 - Step 01: Verify success message displayed");
		verifyTrue(userDashboardPage.isAddCompareSuccessMsgDisplayed());
		
		log.info("Compare_04 - Step 01: Open Compare list page");
		userDashboardPage.openPageByNamePage(driver, "product comparison");
		userCompareProductsPage = PageGeneratorManager.getUserCompareProductsPage(driver);
		
		log.info("Compare_04 - Step 01: Verify product info displayed");
		verifyEquals(userCompareProductsPage.getValueInTableByColumnIndexAndRowName("product-name", "2"), "Apple MacBook Pro 13-inch");
		verifyEquals(userCompareProductsPage.getValueInTableByColumnIndexAndRowName("product-name", "3"), "Build your own computer");
		verifyEquals(userCompareProductsPage.getValueInTableByColumnIndexAndRowName("product-price", "2"), "$1,800.00");
		verifyEquals(userCompareProductsPage.getValueInTableByColumnIndexAndRowName("product-price", "3"), "$1,200.00");
		
		log.info("Compare_04 - Step 01: Click to Clear list button");
		userCompareProductsPage.clickToClearListButton();
		
		log.info("Compare_04 - Step 01: Verify no-items message displayed");
		verifyEquals(userCompareProductsPage.getEmptyMessage(driver), "You have no items to compare.");
		
		log.info("Compare_04 - Step 01: Verify products do not exist anymore");
		verifyTrue(userCompareProductsPage.isCompareTableUndisplayed());
	}
	
	@Test
	public void Wishlist_05_Verify() {
		log.info("Recent_View_05 - Step 01: Open 5 products randomly");
		userCompareProductsPage.sleepInSecond(2);
		userProductListPage = userCompareProductsPage.openSubMenuPageByPageName(driver, "Computers", "Notebooks");
		userProductListPage.sleepInSecond(2);
		userProductDetailsPage = userProductListPage.openProDetailByProName(driver, "Apple MacBook Pro 13-inch");
		
		userProductListPage = userProductDetailsPage.openSubMenuPageByPageName(driver, "Computers", "Notebooks");
		userProductDetailsPage = userProductListPage.openProDetailByProName(driver, "Asus N551JK-XO076H Laptop");
		
		userProductListPage = userProductDetailsPage.openSubMenuPageByPageName(driver, "Computers", "Notebooks");
		userProductDetailsPage = userProductListPage.openProDetailByProName(driver, "Samsung Series 9 NP900X4C Premium Ultrabook");
		
		userProductListPage = userProductDetailsPage.openSubMenuPageByPageName(driver, "Computers", "Notebooks");
		userProductDetailsPage = userProductListPage.openProDetailByProName(driver, "HP Spectre XT Pro UltraBook");
		
		userProductListPage = userProductDetailsPage.openSubMenuPageByPageName(driver, "Computers", "Notebooks");
		userProductDetailsPage = userProductListPage.openProDetailByProName(driver, "Lenovo Thinkpad X1 Carbon Laptop");
		
		log.info("Recent_View_05 - Step 01: Open Rencently viewed products");
		userProductDetailsPage.openFooterPageByPageName(driver, "Recently viewed products");
		userRecentlyViewedPage = PageGeneratorManager.getUserRecentlyViewedPage(driver);
		
		log.info("Recent_View_05 - Step 01: Verify page displayed correctly the last 3 product viewed");
		verifyEquals(userRecentlyViewedPage.getProductTitle("2"), "HP Spectre XT Pro UltraBook");
		verifyEquals(userRecentlyViewedPage.getProductTitle("1"), "Lenovo Thinkpad X1 Carbon Laptop");
		verifyEquals(userRecentlyViewedPage.getProductTitle("3"), "Samsung Series 9 NP900X4C Premium Ultrabook");
	}
	
	@AfterClass
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		closeBrowserAndDriver();
	}
	
	private Environment environment;
	private WebDriver driver;
	private DataUtil data;
	private String firstName, lastName, emailAddress, password;
	
	private UserDashboardPO userDashboardPage;
	private UserRegisterPO userRegisterPage;
	private UserProductDetailsPO userProductDetailsPage;
	private UserWishlistPO userWishlistPage;
	private UserShoppingCartPO userShoppingCartPage;
	private UserCompareProductsPO userCompareProductsPage;
	private UserProductListPO userProductListPage;
	private UserRecentlyViewedPO userRecentlyViewedPage;
}
