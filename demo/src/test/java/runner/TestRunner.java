package test.java.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "test.java.stepDefinitions",
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    dryRun = false,
    monochrome = true,
    tags = "@getUser"


)
public class TestRunner extends AbstractTestNGCucumberTests {
}