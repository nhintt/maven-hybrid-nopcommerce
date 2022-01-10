package commons;

import org.openqa.selenium.WebDriver;

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
	
	public static UserOrdersPO getOrdersPage(WebDriver driver) {
		return new UserOrdersPO(driver);
	}
	
}
