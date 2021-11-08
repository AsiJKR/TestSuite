package runner;

import driver.DriverHandler;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;


@CucumberOptions(
        features = {"src/test/resources/features/ATGHomePage.feature"},
        glue = {"steps"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","summary"},
        publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    DriverHandler driverHandler = new DriverHandler();

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeMethod
    public void setup() {
        driverHandler.initialize();
    }

    @AfterSuite
    public void sc(Scenario scenario) throws IOException {
                if (scenario.isFailed()){
        File screenshot = ((TakesScreenshot) driverHandler.getDriver()).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
        scenario.attach(fileContent, "image/png", "screenshot");
        }
        driverHandler.tearDown();
    }

//    @AfterMethod
    public void tearDown()  {
        driverHandler.tearDown();
    }


}
