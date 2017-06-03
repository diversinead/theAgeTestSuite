package com.autoFramework.cucumber;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Created by sdiver on 5/31/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.autoFramework"},
        features = {"src/test/resources/features"},
        plugin = { "json:target/cucumber-junit.json" },
        monochrome = true
)
public class TheAgeRunTests {
}
