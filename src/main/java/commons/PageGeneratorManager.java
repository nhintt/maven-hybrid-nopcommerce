package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.admin.AdminAddNewAddressPO;
import pageObjects.nopCommerce.admin.AdminAddNewCustomerPO;
import pageObjects.nopCommerce.admin.AdminCustomersPO;
import pageObjects.nopCommerce.admin.AdminDashboardPO;
import pageObjects.nopCommerce.admin.AdminEditAddressPO;
import pageObjects.nopCommerce.admin.AdminEditCustomerPO;
import pageObjects.nopCommerce.admin.AdminLoginPO;
import pageObjects.nopCommerce.admin.AdminProductDetailPO;
import pageObjects.nopCommerce.admin.AdminProductsPO;
import pageObjects.nopCommerce.user.UserAddressesPO;
import pageObjects.nopCommerce.user.UserChangePasswordPO;
import pageObjects.nopCommerce.user.UserCheckoutPO;
import pageObjects.nopCommerce.user.UserCompareProductsPO;
import pageObjects.nopCommerce.user.UserCustomerInfoPO;
import pageObjects.nopCommerce.user.UserDashboardPO;
import pageObjects.nopCommerce.user.UserLoginPO;
import pageObjects.nopCommerce.user.UserMyProductReviewsPO;
import pageObjects.nopCommerce.user.UserOrdersPO;
import pageObjects.nopCommerce.user.UserProductDetailsPO;
import pageObjects.nopCommerce.user.UserProductListPO;
import pageObjects.nopCommerce.user.UserProductReviewsPO;
import pageObjects.nopCommerce.user.UserRecentlyViewedPO;
import pageObjects.nopCommerce.user.UserRegisterPO;
import pageObjects.nopCommerce.user.UserSearchPO;
import pageObjects.nopCommerce.user.UserShoppingCartPO;
import pageObjects.nopCommerce.user.UserWishlistPO;

public class PageGeneratorManager {

	public static UserDashboardPO getUserDashboardPage(WebDriver driver) {
		return new UserDashboardPO(driver);
	}
	
	public static UserRegisterPO getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPO(driver);
	}
	
	public static UserLoginPO getUserLoginPage(WebDriver driver) {
		return new UserLoginPO(driver);
	}
	
	public static UserCustomerInfoPO getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPO(driver);
	}
	
	public static UserAddressesPO getUserAddressesPage(WebDriver driver) {
		return new UserAddressesPO(driver);
	}
	
	public static UserChangePasswordPO getUserChangePassowrdPage(WebDriver driver) {
		return new UserChangePasswordPO(driver);
	}
	
	public static UserProductDetailsPO getUserProductDetailsPage(WebDriver driver) {
		return new UserProductDetailsPO(driver);
	}
	
	public static UserMyProductReviewsPO getUserMyProductReviewsPage(WebDriver driver) {
		return new UserMyProductReviewsPO(driver);
	}
	
	public static UserProductReviewsPO getUserProductReviewsPage(WebDriver driver) {
		return new UserProductReviewsPO(driver);
	}
	
	public static UserSearchPO getUserSearchPage(WebDriver driver) {
		return new UserSearchPO(driver);
	}
	
	public static UserProductListPO getUserProductListPage(WebDriver driver) {
		return new UserProductListPO(driver);
	}
	
	public static UserWishlistPO getUserWishlistPage(WebDriver driver) {
		return new UserWishlistPO(driver);
	}
	
	public static UserShoppingCartPO getUserShoppingCartPage(WebDriver driver) {
		return new UserShoppingCartPO(driver);
	}
	
	public static UserCompareProductsPO getUserCompareProductsPage(WebDriver driver) {
		return new UserCompareProductsPO(driver);
	}
	
	public static UserRecentlyViewedPO getUserRecentlyViewedPage(WebDriver driver) {
		return new UserRecentlyViewedPO(driver);
	}
	
	public static UserCheckoutPO getUserCheckoutPage(WebDriver driver) {
		return new UserCheckoutPO(driver);
	}
	
	public static UserOrdersPO getUserOrdersPage(WebDriver driver) {
		return new UserOrdersPO(driver);
	}
	
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}
	
	public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPO(driver);
	}
	
	public static AdminProductsPO getAdminProductsPage(WebDriver driver) {
		return new AdminProductsPO(driver);
	}
	
	public static AdminProductDetailPO getAdminProductDetailPage(WebDriver driver) {
		return new AdminProductDetailPO(driver);
	}
	
	public static AdminCustomersPO getAdminCustomersPage(WebDriver driver) {
		return new AdminCustomersPO(driver);
	}
	
	public static AdminAddNewCustomerPO getAdminAddNewCustomerPage(WebDriver driver) {
		return new AdminAddNewCustomerPO(driver);
	}
	
	public static AdminEditCustomerPO getAdminEditCustomerPage(WebDriver driver) {
		return new AdminEditCustomerPO(driver);
	}
	
	public static AdminAddNewAddressPO getAdminAddNewAddressPO(WebDriver driver) {
		return new AdminAddNewAddressPO(driver);
	}
	
	public static AdminEditAddressPO getAdminEditAddressPO(WebDriver driver) {
		return new AdminEditAddressPO(driver);
	}
	
}
