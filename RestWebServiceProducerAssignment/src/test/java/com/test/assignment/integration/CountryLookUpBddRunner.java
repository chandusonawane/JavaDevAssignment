package com.test.assignment.integration;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.test.assignment.integration"},
        features = {"classpath:features"},
        plugin = {"pretty", "html:cucumber-reports"}
)
public class CountryLookUpBddRunner {
}
