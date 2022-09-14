package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//fara tag le ia pe toate
@CucumberOptions(features = "src/test/java/cucumber",glue ="cucumber.stepDefinition",
monochrome = true,tags="@Regression",plugin = {"html:Reports/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
