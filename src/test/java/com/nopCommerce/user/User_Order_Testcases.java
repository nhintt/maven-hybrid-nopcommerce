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
import pageObjects.nopCommerce.user.UserCheckoutPO;
import pageObjects.nopCommerce.user.UserCustomerInfoPO;
import pageObjects.nopCommerce.user.UserDashboardPO;
import pageObjects.nopCommerce.user.UserOrdersPO;
import pageObjects.nopCommerce.user.UserProductDetailsPO;
import pageObjects.nopCommerce.user.UserRegisterPO;
import pageObjects.nopCommerce.user.UserShoppingCartPO;
import utilities.DataUtil;

public class User_Order_Testcases extends BaseTest {
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		data = DataUtil.getData();
		registerFirstName = data.getFirstName();
		registerLastName = data.getLastName();
		registerEmailAddress = data.getEmailAddress();
		registerPassword = data.getPassword();
		
		billingFirstName = data.getFirstName();
		billingLastName = data.getLastName();
		billingEmail =  data.getEmailAddress();
		billingCountry = "Viet Nam";
		billingCity = data.getCityName();
		billingAddress = data.getAddress();
		billingZipCode = data.getZipcode();
		billingPhoneNumber = data.getPhoneNumber();
		
		shippingFirstName = data.getFirstName();
		shippingLastName = data.getLastName();
		shippingEmail =  data.getEmailAddress();
		shippingCountry = "Viet Nam";
		shippingCity = data.getCityName();
		shippingAddress = data.getAddress();
		shippingZipCode = data.getZipcode();
		shippingPhoneNumber = data.getPhoneNumber();
		
		processorValue = "2.2 GHz Intel Pentium Dual-Core E2200";
		ramValue = "8GB [+$60.00]";
		hddValue = "320 GB";
		osValue = "Vista Premium [+$60.00]";
		software01 = "Microsoft Office [+$50.00]";
		software02 = "Acrobat Reader [+$10.00]";
		software03 = "Total Commander [+$5.00]";
		
		editProcessor = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
		editRam = "2 GB";
		editHdd = "400 GB [+$100.00]";
		editOs = "Vista Home [+$50.00]";
		
		String envName = System.getProperty("envMaven");
		ConfigFactory.setProperty("envOwner", envName);
		environment = ConfigFactory.create(Environment.class);
		
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' with URL='" + environment.appUrl() + "'");
		driver = getBaseTestDriver(browserName, environment.appUrl());
		userDashboardPage = PageGeneratorManager.getUserDashboardPage(driver);
		
		log.info("Pre-Condition - Step 02: Open Register page");
		userDashboardPage.openPageByNamePage(driver, "Register");
		userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
		
		log.info("Pre-Condition - Step 03: Input to registerFirstName textbox with value '" + registerFirstName + "'");
		userRegisterPage.inputToTextboxByID(driver, "FirstName", registerFirstName);
		
		log.info("Pre-Condition - Step 04: Input to registerLastName textbox with value '" + registerLastName + "'");
		userRegisterPage.inputToTextboxByID(driver, "LastName", registerLastName);
		
		log.info("Pre-Condition - Step 05: Input to Email textbox with value '" + registerEmailAddress + "'");
		userRegisterPage.inputToTextboxByID(driver, "Email", registerEmailAddress);
		
		log.info("Pre-Condition - Step 06: Input to registerPassword textbox with value '" + registerPassword + "'");
		userRegisterPage.inputToTextboxByID(driver, "Password", registerPassword);
		
		log.info("Pre-Condition - Step 07: Input to Confirm registerPassword textbox with value '" + registerPassword + "'");
		userRegisterPage.inputToTextboxByID(driver, "ConfirmPassword", registerPassword);
		
		log.info("Pre-Condition - Step 08: Click to Register button");
		userRegisterPage.clickToRegisterButton();
		
		log.info("Pre-Condition - Step 09: Verify successful message display");
		verifyTrue(userRegisterPage.isSuccessfulMsgDisplayed());
		
		log.info("Pre-Condition - Step 10: Open Dashboard page");
		userDashboardPage = userRegisterPage.openDashboardPageByLogoImg(driver);
		
		log.info("Pre-Condition - Step 11: Open Product detail page");
		userProductDetailPage = userDashboardPage.openProDetailByProName(driver, "Build your own computer");
	}
	
	@Test
	public void Order_01_Add_Product_To_Cart() {
		log.info("Order_01 - Step 01: Select '" + processorValue + "' in Processor dropdown");
		userProductDetailPage.selectProductAttrDropdownByAttrName("Processor", processorValue);
		
		log.info("Order_01 - Step 02: Select '" + ramValue + "' in RAM dropdown");
		userProductDetailPage.selectProductAttrDropdownByAttrName("RAM", ramValue);
		
		log.info("Order_01 - Step 03: Select '" + hddValue + "' in HDD radio button");
		userProductDetailPage.selectProductAttrCheckboxRadionBtn(hddValue);
		
		log.info("Order_01 - Step 04: Select '" + osValue + "' in OS radio button");
		userProductDetailPage.selectProductAttrCheckboxRadionBtn(osValue);
		
		log.info("Order_01 - Step 05: Select '" + software01 + "' in Software checkbox");
		userProductDetailPage.selectProductAttrCheckboxRadionBtn(software01);
		
		log.info("Order_01 - Step 06: Select '" + software02 + "' in Software checkbox");
		userProductDetailPage.selectProductAttrCheckboxRadionBtn(software02);
		
		log.info("Order_01 - Step 07: Select '" + software03 + "' in Software checkbox");
		userProductDetailPage.selectProductAttrCheckboxRadionBtn(software03);
		
		log.info("Order_01 - Step 08: Click to 'Add to cart' button");
		userProductDetailPage.clickToButtonByText(driver, "Add to cart");
		
		log.info("Order_01 - Step 09: Verify success message displayed");
		verifyTrue(userProductDetailPage.isAddToCartSuccessMsgDisplayed(driver));
		
		log.info("Order_01 - Step 10: Click to close success message");
		userProductDetailPage.clickToCloseMessageButton(driver);
		
		log.info("Order_01 - Step 11: Verify quantity at Shopping Cart header link");
		verifyEquals(userProductDetailPage.getQuantityAtShoppingCartHeaderLink(), "(1)");
		
		log.info("Order_01 - Step 12: Hover to 'Shopping Cart' header link");
		userProductDetailPage.hoverToShoppingCartHeaderLink();
		
		log.info("Order_01 - Step 13: Verify counting product message");
		verifyEquals(userProductDetailPage.getCountingMessage(), "There are 1 item(s) in your cart.");
		
		log.info("Order_01 - Step 14: Verify product info");
		verifyEquals(userProductDetailPage.getProductName(), "Build your own computer");
		verifyTrue(userProductDetailPage.isProductAttributesDisplayed());
		verifyEquals(userProductDetailPage.getUnitPrice(), "Unit price: $1,385.00");
		verifyEquals(userProductDetailPage.getQuantity(), "Quantity: 1");
		
		log.info("Order_01 - Step 15: Verify sub-total");
		verifyEquals(userProductDetailPage.getSubTotal(), "Sub-Total: $1,385.00");
	}
	
	@Test
	public void Order_02_Edit_Order() {
		log.info("Order_02 - Step 01: Open Shopping Cart page");
		userProductDetailPage.clickToButtonByText(driver, "Go to cart");
		userShoppingCartPage = PageGeneratorManager.getUserShoppingCartPage(driver);
		
		log.info("Order_02 - Step 02: Click to Edit link");
		userProductDetailPage = userShoppingCartPage.clickToEditLink();
		
		log.info("Order_02 - Step 03: Select '" + editProcessor + "' in Processor dropdown");
		userProductDetailPage.selectProductAttrDropdownByAttrName("Processor", editProcessor);
		
		log.info("Order_01 - Step 01: Select '" + editRam + "' in RAM dropdown");
		userProductDetailPage.selectProductAttrDropdownByAttrName("RAM", editRam);
		
		log.info("Order_01 - Step 01: Select '" + editHdd + "' in HDD radio button");
		userProductDetailPage.selectProductAttrCheckboxRadionBtn(editHdd);
		
		log.info("Order_01 - Step 01: Select '" + editOs + "' in OS radio button");
		userProductDetailPage.selectProductAttrCheckboxRadionBtn(editOs);
		
		log.info("Order_02 - Step - 2: Uncheck '" + software02 + "' in Software checkbox");
		userProductDetailPage.unSelectProductAttrCheckbox(software02);
		
		log.info("Order_02 - Step - 2: Uncheck '" + software03 + "' in Software checkbox");
		userProductDetailPage.unSelectProductAttrCheckbox(software03);
		
		log.info("Order_02 - Step - 2: Increase Quantity to 2");
		userProductDetailPage.changeQuantityValue("2");
		userProductDetailPage.sleepInSecond(3);
		
		log.info("Order_02 - Step - 2: Verify product price");
		verifyEquals(userProductDetailPage.getProductPrice(), "$1,415.00");
		
		log.info("Order_02 - Step - 2: Click to Update button");
		userProductDetailPage.clickToButtonByText(driver, "Update");
		
		log.info("Order_01 - Step 01: Verify success message displayed");
		verifyTrue(userProductDetailPage.isAddToCartSuccessMsgDisplayed(driver));
		
		log.info("Order_01 - Step 01: Click to close success message");
		userProductDetailPage.clickToCloseMessageButton(driver);
		
		log.info("Order_01 - Step 01: Verify quantity at Shopping Cart header link");
		verifyEquals(userProductDetailPage.getQuantityAtShoppingCartHeaderLink(), "(2)");
		
		log.info("Order_01 - Step 01: Hover to 'Shopping Cart' header link");
		userProductDetailPage.hoverToShoppingCartHeaderLink();
		
		log.info("Order_01 - Step 01: Verify counting product message");
		verifyEquals(userProductDetailPage.getCountingMessage(), "There are 2 item(s) in your cart.");
		
		log.info("Order_01 - Step 01: Verify product info");
		verifyEquals(userProductDetailPage.getProductName(), "Build your own computer");
		verifyTrue(userProductDetailPage.isProductAttributesEdited());
		verifyEquals(userProductDetailPage.getUnitPrice(), "Unit price: $1,415.00");
		verifyEquals(userProductDetailPage.getQuantity(), "Quantity: 2");
		
		log.info("Order_01 - Step 01: Verify sub-total");
		verifyEquals(userProductDetailPage.getSubTotal(), "Sub-Total: $2,830.00");
		
		log.info("Order_02 - Step - 1: Open Shopping Cart page");
		userProductDetailPage.clickToButtonByText(driver, "Go to cart");
		userShoppingCartPage = PageGeneratorManager.getUserShoppingCartPage(driver);
		
		log.info("Order_02 - Step - 1: Verify product info in Shopping Cart page");
		verifyEquals(userShoppingCartPage.getProductAttributes(), "Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]\nRAM: 2 GB\nHDD: 400 GB [+$100.00]\nOS: Vista Home [+$50.00]\nSoftware: Microsoft Office [+$50.00]");
		verifyEquals(userShoppingCartPage.getProductUnitPrice(), "$1,415.00");
		verifyEquals(userShoppingCartPage.getProductQuantity(), "2");
		verifyEquals(userShoppingCartPage.getProductTotalPrice(), "$2,830.00");
		
		log.info("Order_02 - Step - 1: Verify total summary in Shopping Cart page");
		verifyEquals(userShoppingCartPage.getTotalSummary(), "$2,830.00");
	}
	
	@Test
	public void Order_03_Remove_From_Cart() {
		log.info("Order_03 - Step 01: Click to Remove icon");
		userShoppingCartPage.removeProduct();
		
		log.info("Order_03 - Step 01: Verify empty message displayed");
		verifyEquals(userShoppingCartPage.getEmptyMessage(driver), "Your Shopping Cart is empty!");
		
		log.info("Order_03 - Step 01: Verify product does not exist in Shopping Cart anymore");
		verifyTrue(userShoppingCartPage.isProductUndisplayed("Build your own computer"));
	}
	
	@Test
	public void Order_04_Update_Shopping_Cart() {
		log.info("Order_04 - Step 01: Open Dashboard page");
		userDashboardPage = userShoppingCartPage.openDashboardPageByLogoImg(driver);
		
		log.info("Order_04 - Step 01: Open Product 'HTC One M8 Android L 5.0 Lollipop' details page");
		userProductDetailPage = userDashboardPage.openProDetailByProName(driver, "HTC One M8 Android L 5.0 Lollipop");
		
		log.info("Order_04 - Step 01: Add product to cart");
		userProductDetailPage.clickToButtonByText(driver, "Add to cart");
		
		log.info("Order_04 - Step 01: Verify success message display");
		userProductDetailPage.isAddToCartSuccessMsgDisplayed(driver);
		
		log.info("Order_04 - Step 01: Click to Close icon");
		userProductDetailPage.clickToCloseMessageButton(driver);
		
		log.info("Order_04 - Step 01: Open Shopping Cart page");
		userProductDetailPage.openPageByNamePage(driver, "Shopping cart");
		userShoppingCartPage = PageGeneratorManager.getUserShoppingCartPage(driver);
		
		log.info("Order_04 - Step 01: Increase product quantity to 5");
		userShoppingCartPage.changeProductQuantity("5");
		
		log.info("Order_04 - Step 01: Click to 'Update shopping cart' button");
		userShoppingCartPage.clickToButtonByText(driver, "Update shopping cart");
		
		log.info("Order_04 - Step 01: Verify product total price");
		verifyEquals(userShoppingCartPage.getProductTotalPrice(), "$1,225.00");
		
		log.info("Order_04 - Step 01: Click to Remove product icon");
		userShoppingCartPage.removeProduct();
	}
	
	@Test
	public void Order_05_Checkout() {
		log.info("Order_04 - Step 01: Open Dashboard page");
		userDashboardPage = userShoppingCartPage.openDashboardPageByLogoImg(driver);
		
		log.info("Order_04 - Step 01: Open Product 'Apple MacBook Pro 13-inch' details page");
		userProductDetailPage = userDashboardPage.openProDetailByProName(driver, "Apple MacBook Pro 13-inch");
		
		log.info("Order_04 - Step 01: Add product to cart");
		userProductDetailPage.clickToButtonByText(driver, "Add to cart");
		
		log.info("Order_04 - Step 01: Verify success message display");
		userProductDetailPage.isAddToCartSuccessMsgDisplayed(driver);
		
		log.info("Order_04 - Step 01: Click to Close icon");
		userProductDetailPage.clickToCloseMessageButton(driver);
		
		log.info("Order_04 - Step 01: Open Shopping Cart page");
		userProductDetailPage.openPageByNamePage(driver, "Shopping cart");
		userShoppingCartPage = PageGeneratorManager.getUserShoppingCartPage(driver);
		
		log.info("Order_04 - Step 01: Click to 'Estimate shipping' button");
		userShoppingCartPage.clickToEstimateShippingButton();
		
		log.info("Order_04 - Step 01: Select 'Viet Nam' in Contry dropdown");
		userShoppingCartPage.selectToItemInDropdownByID(driver, "CountryId", "Viet Nam");
		
		log.info("Order_04 - Step 01: Input to zipCode textbox with value '000'");
		userShoppingCartPage.inputToTextboxByID(driver, "ZipPostalCode", "000");
		
		log.info("Order_04 - Step 01: Select Ground in Shipping method");
		userShoppingCartPage.selectShippingMethod("Ground");
		
		log.info("Order_04 - Step 01: Click to Apply button");
		userShoppingCartPage.clickToButtonByText(driver, "Apply");
		
		log.info("Order_04 - Step 01: Select to agreement of policy checkbox");
		userShoppingCartPage.selectToAgreePolicyCheckbox();
		
		log.info("Order_04 - Step 01: Click to Checkout button");
		userShoppingCartPage.clickToButtonByText(driver, " Checkout ");
		userCheckoutPage = PageGeneratorManager.getUserCheckoutPage(driver);
		
		log.info("Order_04 - Step 01: Uncheck 'Ship to the same address checkbox'");
		userCheckoutPage.uncheckToShipSameAddressCheckbox();
		
		log.info("Order_04 - Step 01: Input to 'First name' textbox with value '" + billingFirstName + "'");
		userCheckoutPage.inputToTextboxByID(driver, "BillingNewAddress_FirstName", billingFirstName);
		
		log.info("Order_04 - Step 01: Input to 'Last name' textbox with value '" + billingLastName + "'");
		userCheckoutPage.inputToTextboxByID(driver, "BillingNewAddress_LastName", billingLastName);
		
		log.info("Order_04 - Step 01: Input to 'Email' textbox with value '" + billingEmail + "'");
		userCheckoutPage.inputToTextboxByID(driver, "BillingNewAddress_Email", billingEmail);
		
		log.info("Order_04 - Step 01: Select Country dropdown with value '" + billingCountry + "'");
		userCheckoutPage.selectToItemInDropdownByID(driver, "BillingNewAddress_CountryId", billingCountry);
		
		log.info("Order_04 - Step 01: Input to 'City' textbox with value '" + billingCity + "'");
		userCheckoutPage.inputToTextboxByID(driver, "BillingNewAddress_City", billingCity);
		
		log.info("Order_04 - Step 01: Input to 'Address 1' textbox with value '" + billingAddress + "'");
		userCheckoutPage.inputToTextboxByID(driver, "BillingNewAddress_Address1", billingAddress);
		
		log.info("Order_04 - Step 01: Input to 'Zip / postal code' textbox with value '" + billingZipCode + "'");
		userCheckoutPage.inputToTextboxByID(driver, "BillingNewAddress_ZipPostalCode", billingZipCode);
		
		log.info("Order_04 - Step 01: Input to 'Phone number' textbox with value '" + billingPhoneNumber + "'");
		userCheckoutPage.inputToTextboxByID(driver, "BillingNewAddress_PhoneNumber", billingPhoneNumber);
		
		log.info("Order_04 - Step 01: Click to Continue button");
		userCheckoutPage.clickToBillingContinueButton();
		
		log.info("Order_04 - Step 01: Select 'New address' in Shipping Adress");
		userCheckoutPage.selectToItemInDropdownByID(driver, "shipping-address-select", "New Address");
		
		log.info("Order_04 - Step 01: Input to 'First name' textbox with value '" + shippingFirstName + "'");
		userCheckoutPage.inputToTextboxByID(driver, "ShippingNewAddress_FirstName", shippingFirstName);
		
		log.info("Order_04 - Step 01: Input to 'Last name' textbox with value '" + shippingLastName + "'");
		userCheckoutPage.inputToTextboxByID(driver, "ShippingNewAddress_LastName", shippingLastName);
		
		log.info("Order_04 - Step 01: Input to 'Email' textbox with value '" + shippingEmail+ "'");
		userCheckoutPage.inputToTextboxByID(driver, "ShippingNewAddress_Email", shippingEmail);
		
		log.info("Order_04 - Step 01: Select Country dropdown with value '" + shippingCountry+ "'");
		userCheckoutPage.selectToItemInDropdownByID(driver, "ShippingNewAddress_CountryId", shippingCountry);
		
		log.info("Order_04 - Step 01: Input to 'City' textbox with value '" + shippingCity+ "'");
		userCheckoutPage.inputToTextboxByID(driver, "ShippingNewAddress_City", shippingCity);
		
		log.info("Order_04 - Step 01: Input to 'Address 1' textbox with value '" + shippingAddress + "'");
		userCheckoutPage.inputToTextboxByID(driver, "ShippingNewAddress_Address1", shippingAddress);
		
		log.info("Order_04 - Step 01: Input to 'Zip / postal code' textbox with value '" + shippingZipCode + "'");
		userCheckoutPage.inputToTextboxByID(driver, "ShippingNewAddress_ZipPostalCode", shippingZipCode);
		
		log.info("Order_04 - Step 01: Input to 'Phone number' textbox with value '" + shippingPhoneNumber + "'");
		userCheckoutPage.inputToTextboxByID(driver, "ShippingNewAddress_PhoneNumber", shippingPhoneNumber);
		
		log.info("Order_04 - Step 01: Click to Continue button");
		userCheckoutPage.clickToShippingContinueButton();
		
		log.info("Order_04 - Step 01: Select 'Ground' in Shipping method");
		userCheckoutPage.selectShippingMethod("Ground");
		
		log.info("Order_04 - Step 01: Click to Continue button");
		userCheckoutPage.clickToShippingMethodContinueButton();
		
		log.info("Order_04 - Step 01: Select 'Check / Money Order' in Payment method");
		userCheckoutPage.selectPaymentMethod("Check / Money Order");
		
		log.info("Order_04 - Step 01: Click to Continue button");
		userCheckoutPage.clickToPaymentMethodContinueButton();
		userCheckoutPage.clickToPaymentInfoContinueButton();
		
		log.info("Order_04 - Step 01: Verify Billing address info");
		verifyEquals(userCheckoutPage.getBillInfoByClassName("name"), billingFirstName + " " + billingLastName);
		verifyEquals(userCheckoutPage.getBillInfoByClassName("email"), "Email: " + billingEmail);
		verifyEquals(userCheckoutPage.getBillInfoByClassName("phone"), "Phone: " + billingPhoneNumber);
		verifyEquals(userCheckoutPage.getBillInfoByClassName("fax"), "Fax:");
		verifyEquals(userCheckoutPage.getBillInfoByClassName("address1"), billingAddress);
		verifyEquals(userCheckoutPage.getBillInfoByClassName("city-state-zip"), billingCity + "," + billingZipCode);
		verifyEquals(userCheckoutPage.getBillInfoByClassName("country"), billingCountry);
		
		log.info("Order_04 - Step 01: Verify Shipping address info");
		verifyEquals(userCheckoutPage.getShippingInfoByClassName("name"), shippingFirstName + " " + shippingLastName);
		verifyEquals(userCheckoutPage.getShippingInfoByClassName("email"), "Email: " + shippingEmail);
		verifyEquals(userCheckoutPage.getShippingInfoByClassName("phone"), "Phone: " + shippingPhoneNumber);
		verifyEquals(userCheckoutPage.getShippingInfoByClassName("fax"), "Fax:");
		verifyEquals(userCheckoutPage.getShippingInfoByClassName("address1"), shippingAddress);
		verifyEquals(userCheckoutPage.getShippingInfoByClassName("city-state-zip"), shippingCity + "," + shippingZipCode);
		verifyEquals(userCheckoutPage.getShippingInfoByClassName("country"), shippingCountry);
		
		log.info("Order_04 - Step 01: Verify Payment method");
		verifyEquals(userCheckoutPage.getPaymentMethod(), "Check / Money Order");
		
		log.info("Order_04 - Step 01: Verify Shipping method");
		verifyEquals(userCheckoutPage.getShippingMethod(), "Ground");
		
		log.info("Order_04 - Step 01: Verify Product info");
		verifyEquals(userCheckoutPage.getProductName(), "Apple MacBook Pro 13-inch");
		verifyEquals(userCheckoutPage.getProductUnitPrice(), "$1,800.00");
		verifyEquals(userCheckoutPage.getProductQuantity(), "2");
		verifyEquals(userCheckoutPage.getProductTotalPrice(), "$3,600.00");
		
		log.info("Order_04 - Step 01: Verify Gift wrapping");
		verifyEquals(userCheckoutPage.getGiftWrappingText(), "Gift wrapping: No");
		
		log.info("Order_04 - Step 01: Verify Total summary");
		verifyEquals(userCheckoutPage.getTotalSummary(), "$3,600.00");
		
		log.info("Order_04 - Step 01: Click to Confirm button");
		userCheckoutPage.clickToButtonByText(driver, "Confirm");
		
		log.info("Order_04 - Step 01: Verify order successfull message");
		verifyTrue(userCheckoutPage.isOrderSuccessMessageDisplayed());
		
		log.info("Order_04 - Step 01: Verify order number displayed");
		verifyTrue(userCheckoutPage.isOrderNumberDisplayed());
		
		log.info("Order_04 - Step 01: Open My account page");
		userCheckoutPage.openPageByNamePage(driver, "My account");
		userCustomerPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
		
		log.info("Order_04 - Step 01: Open Orders page");
		userCustomerPage.openSidebarPageByPageName(driver, "Orders");
		userOrdersPage = PageGeneratorManager.getOrdersPage(driver);
		
		log.info("Order_04 - Step 01: Open order details");
		userOrdersPage.clickToButtonByText(driver, "Details");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		closeBrowserAndDriver();
	}
	
	private Environment environment;
	private WebDriver driver;
	private DataUtil data;
	
	private UserDashboardPO userDashboardPage;
	private UserRegisterPO userRegisterPage;
	private UserProductDetailsPO userProductDetailPage;
	private UserShoppingCartPO userShoppingCartPage;
	private UserCheckoutPO userCheckoutPage;
	private UserCustomerInfoPO userCustomerPage;
	private UserOrdersPO userOrdersPage;
	
	private String registerFirstName, registerLastName, registerEmailAddress, registerPassword;
	private String billingFirstName, billingLastName, billingEmail, billingCountry, billingCity, billingAddress, billingZipCode, billingPhoneNumber; 
	private String shippingFirstName, shippingLastName, shippingEmail, shippingCountry, shippingCity, shippingAddress, shippingZipCode, shippingPhoneNumber; 
	private String processorValue, ramValue, hddValue, osValue, software01, software02, software03;
	private String editProcessor, editRam, editHdd, editOs;
}
