package run;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources", 
		glue = { "apiVKTest", "emailsTest" }, 
		dryRun = false, 
		strict = false)
public class RunTest {

}
