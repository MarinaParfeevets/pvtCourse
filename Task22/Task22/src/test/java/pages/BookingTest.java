package pages;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java", 
		glue = "pages", 
		tags = "@filterFeature, @mainPageIsOpened", 
		dryRun = false, 
		strict = false)
public class BookingTest {

}