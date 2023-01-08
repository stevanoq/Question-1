package StepsDefinition;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/Resource/Features", glue = {"StepsDefinition"},
monochrome = true,
plugin = {"pretty", "junit:target/Reports/xmlReport.xml",
                    "json:target/Reports/jsonReport.json",
                    "html:target/Reports/htmlReport.html"}
, tags = "@login"
)

public class TestRuner {
    
}
