package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class InitialPage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	private static final int LINK_PRESENSE_TIMEOUT = 20;

	public InitialPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT);
	}

	public WebDriver setInitialProperty() {
		driver.manage().window().maximize();
		return driver;
	}
}
