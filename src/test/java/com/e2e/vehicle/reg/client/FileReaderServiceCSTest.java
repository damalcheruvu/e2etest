package com.e2e.vehicle.reg.client;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author jeevand
 * Test Runner for feature files
 */
@RunWith(Cucumber.class)
@CucumberOptions(features="classpath:features/",
        plugin = {"pretty","html:target/cucumber-html-report"})
public class FileReaderServiceCSTest {
}
