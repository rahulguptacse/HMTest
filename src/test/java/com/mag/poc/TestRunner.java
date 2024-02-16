package com.mag.poc;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.connect_group.adobe.com.mag.poc.stepDefs",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner {
}