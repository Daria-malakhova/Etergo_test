package com.Runner;


import Pages.BasePage;
import cucumber.api.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/java/com/features/HomePage.feature",
        glue = "com.stepDefinitions",
        format = "html:Output",
        plugin = "com.cucumber.listener.ExtentCucumberFormatter:output/report.html",
        tags = "@HomePage",//Please provide tags for Running Selected Scenario
        monochrome = true,
        dryRun = false,
        strict = true)

public class EtergoTestRunner {

    @AfterClass
    public static void tearDown(){

        BasePage.driver.quit();
    }
}
