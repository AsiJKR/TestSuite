package runner;

import driver.DriverHandler;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"src/test/resources/features/ATGHomePage.feature"},
        glue = {"steps", "runner"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "summary"},
        publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    public DriverHandler driverHandler = new DriverHandler();

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeMethod
    public void setup() {
        driverHandler.initialize();
    }

    @After
    public void cleanUp(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenshot
            final byte[] screenshot = ((TakesScreenshot) driverHandler.getDriver()).getScreenshotAs(OutputType.BYTES);
            // embed it in the report
            scenario.attach(screenshot, "image/png", "failure screenshot");
        }
        driverHandler.tearDown();//quite driver
    }
}
