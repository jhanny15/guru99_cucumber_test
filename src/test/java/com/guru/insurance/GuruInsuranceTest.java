package com.guru.insurance;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:report/cucumber.html", "json:report/cucumber-report.json"},
        features ={"src/test/java/features/GuruInsurance.feature"})
public class GuruInsuranceTest {
}
