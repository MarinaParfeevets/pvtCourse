package screenShotsReport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	public static void makeScreenShot(WebDriver driver) throws IOException {
		File fileScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(fileScreenShot, new File("D:\\ScreenShots\\" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			throw e;
		}
	}
}
