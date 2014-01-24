import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"./src/test/features/"},
        format = {"pretty", "html:BDD_test_report"}
//        tags = {"@coke"}, dryRun = true, glue = {}
)
public class RunCucumberTests {

}
