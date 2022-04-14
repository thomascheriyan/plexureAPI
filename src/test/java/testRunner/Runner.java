package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/feature",
glue={"stepDefinition"},
plugin = { "pretty", "html:target/htmlreports" },
monochrome = true)

public class Runner{
	
}
