package myRunTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/myFeaturePack",
		glue = "myStepDefination",
		tags = "@Test",
		monochrome = true,
		strict = true,
		plugin = {"json:target/cucumber.json"})
public class AdminTest {

}
