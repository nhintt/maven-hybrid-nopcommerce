package pageObjects.nopCommerce.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserProductListPageUI;

public class UserProductListPO extends BasePage {
	private WebDriver driver;

	public UserProductListPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductNameSortedAscending() {
		waitForElementInvisible(driver, UserProductListPageUI.AJAX_BUSY_ICON);
		List<WebElement> productList = getListWebElement(driver, UserProductListPageUI.PRODUCT_NAME_LIST);
		List<String> productNameList = new ArrayList<String>();
		
		for (WebElement product : productList) {
			productNameList.add(product.getText());
		}
		
		List<String> productNameListClone = new ArrayList<String>(productNameList);
		Collections.sort(productNameListClone);
		return productNameList.equals(productNameListClone);
	}

	public boolean isProductNameSortedDescending() {
		waitForElementInvisible(driver, UserProductListPageUI.AJAX_BUSY_ICON);
		List<WebElement> productList = getListWebElement(driver, UserProductListPageUI.PRODUCT_NAME_LIST);
		List<String> productNameList = new ArrayList<String>();
		
		for (WebElement product : productList) {
			productNameList.add(product.getText());
		}
		
		System.out.println(productNameList);
		
		List<String> productNameListClone = new ArrayList<String>(productNameList);
		Collections.sort(productNameListClone);
		Collections.reverse(productNameListClone);
		return productNameList.equals(productNameListClone);
	}

	public boolean isProductPriceSortedAscending() {
		waitForElementInvisible(driver, UserProductListPageUI.AJAX_BUSY_ICON);
		List<WebElement> productList = getListWebElement(driver, UserProductListPageUI.PRODUCT_PRICE_LIST);
		List<Float> productPriceList = new ArrayList<Float>();
		
		for (WebElement product : productList) {
			productPriceList.add(Float.valueOf(product.getText().replace("$", "").replace(",", "")));
		}
		
		List<Float> productPriceListClone = new ArrayList<Float>(productPriceList);
		Collections.sort(productPriceListClone);
		return productPriceList.equals(productPriceListClone);
	}
	
	public boolean isProductPriceSortedDescending() {
		waitForElementInvisible(driver, UserProductListPageUI.AJAX_BUSY_ICON);
		List<WebElement> productList = getListWebElement(driver, UserProductListPageUI.PRODUCT_PRICE_LIST);
		List<Float> productPriceList = new ArrayList<Float>();
		
		for (WebElement product : productList) {
			productPriceList.add(Float.valueOf(product.getText().replace("$", "").replace(",", "")));
		}
		
		List<Float> productPriceListClone = new ArrayList<Float>(productPriceList);
		Collections.sort(productPriceListClone);
		Collections.reverse(productPriceListClone);
		return productPriceList.equals(productPriceListClone);
	}

	public boolean isItemDisplayedMatchWithPageSize(int pageSize) {
		waitForElementInvisible(driver, UserProductListPageUI.AJAX_BUSY_ICON);
		List<WebElement> productList = getListWebElement(driver, UserProductListPageUI.PRODUCT_NAME_LIST);
		return productList.size() <= pageSize;
	}

	public void clickToPageNumber(String pageNumber) {
//		waitForElementInvisible(driver, UserProductListPageUI.AJAX_BUSY_ICON);
		waitForElementVisible(driver, UserProductListPageUI.PAGE_NUMBER, pageNumber);
		clickToElement(driver, UserProductListPageUI.PAGE_NUMBER, pageNumber);
	}

	public boolean isArowIconDisplayed(String iconName) {
		waitForElementVisible(driver, UserProductListPageUI.PAGE_NUMBER, iconName);
		return isElementDisplayed(driver, UserProductListPageUI.PAGE_NUMBER, iconName);
	}

	public boolean isPageContainerInvisible() {
		waitForElementInvisible(driver, UserProductListPageUI.AJAX_BUSY_ICON);
		return isElementUndisplayed(driver, UserProductListPageUI.AJAX_BUSY_ICON);
	}

}
