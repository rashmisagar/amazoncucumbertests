package com.amazon.automation.tests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        format = {"pretty", "json:target/cucumber-json"},
        features = "classpath:feature",
        glue = {"com.amazon.automation.tests"}
)
public class RunAmazonTestNG extends AbstractTestNGCucumberTests{

    @Parameters("browser")
    @BeforeClass
    // Passing Browser parameter from TestNG xml
    public void beforeTest(String browser) {

        AmazonStepDefs.browserType = browser;

    }

}
