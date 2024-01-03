package com.sergii.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"src/test/java/com/sergii/stepdef"},
        plugin = {"pretty", "html:target/cucumber-report.html"})


public class Runner extends AbstractTestNGCucumberTests {
}
