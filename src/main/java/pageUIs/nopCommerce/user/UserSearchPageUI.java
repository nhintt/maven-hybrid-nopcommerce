package pageUIs.nopCommerce.user;

public class UserSearchPageUI {
	public static final String SEARCH_BUTTON = "//div[@class='page-body']//button[text()='Search']";
	public static final String WARNING_MESSAGE = "//div[text()='Search term minimum length is 3 characters']";
	public static final String NO_RESULT_MESSAGE = "//div[text()='No products were found that matched your criteria.']";
	public static final String SEARCH_RESULT_QUANTITY = "//div[@class='details']//a[contains(text(), '%s')]";
	
	public static final String CHECKBOX_BY_ID = "//input[@id='%s']";
}
