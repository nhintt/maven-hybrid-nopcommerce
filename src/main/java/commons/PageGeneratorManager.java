package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.user.UserDashboardPO;
import pageObjects.nopCommerce.user.UserLoginPO;
import pageObjects.nopCommerce.user.UserRegisterPO;

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
	
}
