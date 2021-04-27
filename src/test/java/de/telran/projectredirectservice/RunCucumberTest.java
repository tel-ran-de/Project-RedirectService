package de.telran.projectredirectservice;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, tags = "@unique_urls, @expirationDate_in_past @validation_url",
        features ="src/main/resources/de.telran.projectredirectservice" )
public class RunCucumberTest {
}
