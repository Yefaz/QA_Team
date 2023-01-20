


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
*/
 @CucumberOptions(
            features = "src/test/resources/features/Cases.feature",
            glue = {"src/test/java/Steps/Cases.java"},
            plugin = {"pretty","html:test-output"},
            monochrome = true)
    public class runner extends AbstractTestNGCucumberTests {
    }

