package com.mag.poc;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/mag/poc/stepDefs",
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner {
}