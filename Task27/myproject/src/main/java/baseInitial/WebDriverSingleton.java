package baseInitial;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton extends ChromeDriver {
	private static WebDriverSingleton webDriverSingleton;

	private WebDriverSingleton() {

	}

	public static WebDriverSingleton getDriver() {
		if (webDriverSingleton == null) {
			webDriverSingleton = new WebDriverSingleton();
		}
		return webDriverSingleton;
	}

	public static void quitDriver() {
		if (webDriverSingleton != null) {
			webDriverSingleton.quit();
		}
		webDriverSingleton = null;
	}
}
