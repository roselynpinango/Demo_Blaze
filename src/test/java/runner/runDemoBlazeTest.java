package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "",
				features = {"src/test/resources/features/order.feature"},
				glue = {"step_definitions"},
				plugin = {})
public class runDemoBlazeTest extends AbstractTestNGCucumberTests {

}

