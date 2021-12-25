package commons;

import java.io.File;

public class GlobalContants {
	public static final String PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "uploads" + File.separator;
	public static final String DOWNLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "downloads";
}
