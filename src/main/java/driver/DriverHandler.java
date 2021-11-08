package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverHandler {

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    protected static String host = "localhost"; //change this to your server for remote execution
    protected static String browser = System.getProperty("Browser", "Chrome");

    public DriverHandler() {
        if (driver == null) {
            initialize();
        }
    }

    public void initialize() {

        if (host.equalsIgnoreCase("localhost")) {
            switch (browser) {
                case "Chrome":

                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver(options));
                    break;
                case "Firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                default:
                    break;

            }
            driver.get().manage().window().maximize();
        } else {
            try {
                driver.set(new RemoteWebDriver(new URL(host), new DesiredCapabilities()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void tearDown() {
        getDriver().quit();
    }

}
