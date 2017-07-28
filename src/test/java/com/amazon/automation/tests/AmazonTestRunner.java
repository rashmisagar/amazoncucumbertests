package com.amazon.automation.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "json:target/cucumber-json"},
        features = "classpath:feature",
        glue = {"com.amazon.automation.tests"}
)

public class AmazonTestRunner {


}
