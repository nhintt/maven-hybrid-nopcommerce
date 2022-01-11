package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.nopCommerce.user.UserDashboardPO;
import pageObjects.nopCommerce.user.UserProductDetailsPO;
import pageObjects.nopCommerce.user.UserProductListPO;
import pageUIs.nopCommerce.admin.AdminBasePageUI;
import pageUIs.nopCommerce.user.UserBasePageUI;
import pageUIs.nopCommerce.user.UserChangePasswordPageUI;
import pageUIs.nopCommerce.user.UserDashboardPageUI;
import pageUIs.nopCommerce.user.UserProductDetailsPageUI;
import pageUIs.nopCommerce.user.UserWishlistPageUI;

public class BasePage {

	public static BasePage getBasePageObject() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Alert waitForAlertPrecence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPrecence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPrecence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPrecence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPrecence(driver).sendKeys(textValue);
	}

	public void closeAllTabWithoutParent(WebDriver driver, String parentPageID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentPageID)) {
				driver.switchTo().window(window);
				driver.close();
			}
		}
		driver.switchTo().window(parentPageID);
	}

	public void switchToWindowByTitle(WebDriver driver, String tabeTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
			if (driver.getTitle().equals(tabeTitle))
				break;
		}
	}

	public void switchToWindowByID(WebDriver driver, String pageID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(pageID)) {
				driver.switchTo().window(window);
			}
		}
	}

	private By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}

	private WebElement getWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElement(getByXpath(xpathLocator));
	}

	protected List<WebElement> getListWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElements(By.xpath(xpathLocator));
	}

	private List<WebElement> getListWebElement(WebDriver driver, String xpathLocator, String... params) {
		return driver.findElements(By.xpath(getDynamicLocator(xpathLocator, params)));
	}

	public String getDynamicLocator(String xpathLocator, String... params) {
		return String.format(xpathLocator, (Object[]) params);
	}

	public void clickToElement(WebDriver driver, String xpathLocator, String... params) {
		if (driver.toString().contains("internet explorer")) {
			clickToElementByJS(driver, getDynamicLocator(xpathLocator, params));
			sleepInSecond(2);
		} else {
			getWebElement(driver, getDynamicLocator(xpathLocator, params)).click();
		}
	}

	public void clickToElement(WebDriver driver, String xpathLocator) {
		if (driver.toString().contains("internet explorer")) {
			clickToElementByJS(driver, xpathLocator);
			sleepInSecond(2);
		} else {
			getWebElement(driver, xpathLocator).click();
		}
	}

	public void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue, String... params) {
		WebElement element = getWebElement(driver, getDynamicLocator(xpathLocator, params));
		element.clear();
		element.sendKeys(textValue);
	}

	public void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}

	public void selectItemInDropdownByValue(WebDriver driver, String xpathLocator, String textItem) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByValue(textItem);
	}

	public void selectItemInDropdownByText(WebDriver driver, String xpathLocator, String textItem, String... params) {
		Select select = new Select(getWebElement(driver, getDynamicLocator(xpathLocator, params)));
		select.selectByVisibleText(textItem);
	}

	public String getSelectedItemInDefaultDropdown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}

	public String getSelectedItemInDefaultDropdown(WebDriver driver, String xpathLocator, String... params) {
		Select select = new Select(getWebElement(driver, getDynamicLocator(xpathLocator, params)));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isMultipleDropdown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}

	public void selectItemInDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedTextItem) {
		getWebElement(driver, parentXpath).click();
		sleepInSecond(1);

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedTextItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}

	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName) {
		return getWebElement(driver, xpathLocator).getAttribute(attributeName);
	}

	public String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName, String... params) {
		return getWebElement(driver, getDynamicLocator(xpathLocator, params)).getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText();
	}

	public String getElementText(WebDriver driver, String xpathLocator, String... params) {
		return getWebElement(driver, getDynamicLocator(xpathLocator, params)).getText();
	}

	public String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {
		return getWebElement(driver, xpathLocator).getCssValue(propertyName);
	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(WebDriver driver, String xpathLocator) {
		return getListWebElement(driver, xpathLocator).size();
	}

	public int getElementSize(WebDriver driver, String xpathLocator, String... params) {
		return getListWebElement(driver, xpathLocator, params).size();
	}

	public void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator, String... params) {
		WebElement element = getWebElement(driver, getDynamicLocator(xpathLocator, params));
		if (!element.isSelected()) {
			if (driver.toString().contains("internet explorer")) {
				clickToElement(driver, getDynamicLocator(xpathLocator, params));
			} else {
				element.click();
			}
		}
	}

	public void uncheckToDefaultCheckbox(WebDriver driver, String xpathLocator, String... params) {
		WebElement element = getWebElement(driver, getDynamicLocator(xpathLocator, params));
		if (element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToDefaultCheckbox(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isDisplayed();
	}

	public boolean isElementDisplayed(WebDriver driver, String xpathLocator, String... params) {
		return getWebElement(driver, getDynamicLocator(xpathLocator, params)).isDisplayed();
	}

	public boolean isElementEnabled(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}

	public boolean isElementEnabled(WebDriver driver, String xpathLocator, String... params) {
		return getWebElement(driver, getDynamicLocator(xpathLocator, params)).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}

	public boolean isElementSelected(WebDriver driver, String xpathLocator, String... params) {
		return getWebElement(driver, getDynamicLocator(xpathLocator, params)).isSelected();
	}

	public void switchToFrameIframe(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathLocator)).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String xpathLocator, String... params) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, getDynamicLocator(xpathLocator, params))).perform();
	}

	public void pressKeyToElement(WebDriver driver, String xpathLocator, Keys key, String... params) {
		Actions action = new Actions(driver);
		WebElement element = getWebElement(driver, getDynamicLocator(xpathLocator, params));
		action.sendKeys(element, key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, xpathLocator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
	}

	public void scrollToElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathLocator));
	}

	public boolean isJQueryAjaxLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoaded = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return jQuery.active === 0;");
			}

		};
		return explicitWait.until(jQueryLoaded);
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
	}

	public boolean isImageLoaded(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, xpathLocator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String xpathLocator, String... params) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(xpathLocator, params))));
	}

	public void waitForElementVisible(WebDriver driver, String xpathLocator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
	}

	public void waitForAllElementVisible(WebDriver driver, String xpathLocator, String... params) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(getDynamicLocator(xpathLocator, params))));
	}

	public void waitForAllElementVisible(WebDriver driver, String xpathLocator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}

	public void waitForElementInvisible(WebDriver driver, String xpathLocator, String... params) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(xpathLocator, params))));
	}

	public void waitForElementInvisible(WebDriver driver, String xpathLocator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
	}

	public void waitForAllElementInvisible(WebDriver driver, String xpathLocator, String params) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, getDynamicLocator(xpathLocator, params))));
	}

	public void waitForAllElementInvisible(WebDriver driver, String xpathLocator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, xpathLocator)));
	}

	public void waitForElementClickable(WebDriver driver, String xpathLocator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	}

	public void waitForElementClickable(WebDriver driver, String xpathLocator, String... params) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(xpathLocator, params))));
	}

	public void overrideGlobalTimeout(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	public boolean isElementUndisplayed(WebDriver driver, String xpathLocator) {
		overrideGlobalTimeout(driver, shortTimeout);
		List<WebElement> listElements = getListWebElement(driver, xpathLocator);
		overrideGlobalTimeout(driver, longTimeout);

		if (listElements.size() == 0) {
			return true;
		} else if (listElements.size() > 0 && !listElements.get(0).isDisplayed()) {
			return true;
		} else
			return false;
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String xpathLocator, String... params) {
		overrideGlobalTimeout(driver, shortTimeout);
		List<WebElement> listElements = getListWebElement(driver, getDynamicLocator(xpathLocator, params));
		overrideGlobalTimeout(driver, longTimeout);
		
		if (listElements.size() == 0) {
			return true;
		} else if (listElements.size() > 0 && !listElements.get(0).isDisplayed()) {
			return true;
		} else
			return false;
	}

	public Set<Cookie> getCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}

	public void setCookies(WebDriver driver, Set<Cookie> allCookies) {
		for (Cookie cookie : allCookies) {
			driver.manage().addCookie(cookie);
		}
	}

	// ------------- USER -------------------------
	public void openPageByNamePage(WebDriver driver, String pageName) {
		waitForElementVisible(driver, UserBasePageUI.URL_BY_PAGENAME, pageName);
		clickToElement(driver, UserBasePageUI.URL_BY_PAGENAME, pageName);
	}
	
	public void openSidebarPageByPageName(WebDriver driver, String pageName) {
		waitForElementVisible(driver, UserBasePageUI.SIDEBAR_PAGE_BY_NAME, pageName);
		clickToElement(driver, UserBasePageUI.SIDEBAR_PAGE_BY_NAME, pageName);
	}

	public UserProductDetailsPO openProDetailByProName(WebDriver driver, String productName) {
		waitForElementVisible(driver, UserBasePageUI.PRODUCT_LINK, productName);
		clickToElement(driver, UserBasePageUI.PRODUCT_LINK, productName);
		return PageGeneratorManager.getUserProductDetailsPage(driver);
	}

	public void inputToTextboxByID(WebDriver driver, String textboxID, String textValue) {
		waitForElementVisible(driver, UserBasePageUI.TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, UserBasePageUI.TEXTBOX_BY_ID, textValue, textboxID);
	}

	public void openFooterPageByPageName(WebDriver driver, String pageName) {
		waitForElementVisible(driver, UserBasePageUI.FOOTER_PAGE_BY_NAME, pageName);
		clickToElement(driver, UserBasePageUI.FOOTER_PAGE_BY_NAME, pageName);
	}
	
	public void selectToItemInDropdownByID(WebDriver driver, String dropdownID, String itemText) {
		waitForElementVisible(driver, UserBasePageUI.DROPDOWN_BY_ID, dropdownID);
		selectItemInDropdownByText(driver, UserBasePageUI.DROPDOWN_BY_ID, itemText, dropdownID);
	}
	
	public UserProductListPO openSubMenuPageByPageName(WebDriver driver, String menuPageName, String subMenuPageName) {
		waitForElementVisible(driver, UserBasePageUI.MENU_PAGE_BY_NAME, menuPageName);
		hoverMouseToElement(driver, UserBasePageUI.MENU_PAGE_BY_NAME, menuPageName);
		waitForElementVisible(driver, UserBasePageUI.MENU_PAGE_BY_NAME, subMenuPageName);
		clickToElement(driver, UserBasePageUI.MENU_PAGE_BY_NAME, subMenuPageName);
		return PageGeneratorManager.getUserProductListPage(driver);
	}
	
	public UserDashboardPO openDashboardPageByLogoImg(WebDriver driver) {
		waitForElementVisible(driver, UserBasePageUI.LOGO_IMG);
		clickToElement(driver, UserBasePageUI.LOGO_IMG);
		return PageGeneratorManager.getUserDashboardPage(driver);
	}
	
	public void clickToButtonByText(WebDriver driver, String btnName) {
		waitForElementClickable(driver, UserBasePageUI.BUTTON_BY_TEXT, btnName);
		clickToElement(driver, UserBasePageUI.BUTTON_BY_TEXT, btnName);
	}

	public String getPageName(WebDriver driver) {
		waitForElementVisible(driver, UserBasePageUI.PAGE_TITLE);
		return getElementText(driver, UserBasePageUI.PAGE_TITLE);
	}

	public String getEmptyMessage(WebDriver driver) {
		waitForElementVisible(driver, UserBasePageUI.EMPTY_MESSAGE);
		return getElementText(driver, UserBasePageUI.EMPTY_MESSAGE);
	}
	
	public boolean isAddCompareSuccessMsgDisplayed(WebDriver driver) {
		waitForElementVisible(driver, UserBasePageUI.ADD_COMPARE_SUCCESS_MSG);
		return isElementDisplayed(driver, UserBasePageUI.ADD_COMPARE_SUCCESS_MSG);
	}

	public boolean isAddWishlistSuccessMsgDisplayed(WebDriver driver) {
		waitForElementVisible(driver, UserBasePageUI.ADD_WISHLIST_SUCCESS_MSG);
		return isElementDisplayed(driver, UserBasePageUI.ADD_WISHLIST_SUCCESS_MSG);
	}
	
	public boolean isAddToCartSuccessMsgDisplayed(WebDriver driver) {
		waitForElementVisible(driver, UserBasePageUI.ADD_TO_CART_SUCCESS_MSG);
		return isElementDisplayed(driver, UserBasePageUI.ADD_TO_CART_SUCCESS_MSG);
	}

	public void clickToCloseMessageButton(WebDriver driver) {
		waitForElementClickable(driver, UserBasePageUI.CLOSE_MSG_ICON);
		clickToElement(driver, UserBasePageUI.CLOSE_MSG_ICON);
	}
	
	// ================ ADMIN =====================

	public void openSideBarSubMenuAdmmin(WebDriver driver, String menuName, String subMenuName) {
		waitForElementVisible(driver, AdminBasePageUI.MENU_LINK_BY_NAME, menuName);
		clickToElement(driver, AdminBasePageUI.MENU_LINK_BY_NAME, menuName);
		
		waitForElementVisible(driver, AdminBasePageUI.SUBMENU_LINK_BY_NAME, subMenuName);
		clickToElement(driver, AdminBasePageUI.SUBMENU_LINK_BY_NAME, subMenuName);
	}
	
	private WebDriverWait explicitWait;
	private int longTimeout = 30;
	private int shortTimeout = 5;
}
