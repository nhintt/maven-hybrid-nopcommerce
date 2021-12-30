package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.user.UserDashboardPO;
import pageObjects.nopCommerce.user.UserRegisterPO;

public class PageGeneratorManager {

	public static UserDashboardPO getUserDashboardPage(WebDriver driver) {
		return new UserDashboardPO();
	}
	
	public static UserRegisterPO getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPO(driver);
	}
	
}
