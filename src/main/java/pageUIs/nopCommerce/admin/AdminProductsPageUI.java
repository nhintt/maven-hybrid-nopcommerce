package pageUIs.nopCommerce.admin;

public class AdminProductsPageUI {
	public static final String PRODUCT_ROWS = "//table[@id='products-grid']//tbody/tr";
	public static final String EMPTY_MESSAGE = "//td[text()='No data available in table']";
	public static final String AJAX_BUSY_ICON = "//div[@id='ajaxBusy']";
	
	public static final String CELL_VALUE_BY_ROW_INDEX_COLUMN_NAME = "//table[@id='products-grid']//tbody/tr[%s]/td[%s]";
	public static final String PRECEDING_SIBLING_COLUMN_BY_NAME = "//th[text()='%s']/preceding-sibling::th";
	public static final String SEARCH_SUBCATEGORIES_CHECKBOX = "//input[@id='SearchIncludeSubCategories']";
}
