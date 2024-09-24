import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * @author SQA_DIKA
 * @date 24/09/2024
 */

@CucumberOptions(
        features = {"src/main/resources/features/"},
        glue = {"org.example"},
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber-report.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {


}
