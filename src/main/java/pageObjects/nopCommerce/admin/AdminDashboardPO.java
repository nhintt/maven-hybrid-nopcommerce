package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AdminDashboardPO extends BasePage {
	private WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}
}
