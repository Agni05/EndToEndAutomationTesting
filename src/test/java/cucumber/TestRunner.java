package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features={"src/test/java/cucumber/"}, glue={"stepDefination"},
 monochrome=true, plugin= {"html:report/cucumber.html"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
