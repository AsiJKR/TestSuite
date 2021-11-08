package steps;

import common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseFunctions {

    public BaseFunctions() {
    }

    public static void waitForElementToBeVisible(By by, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.explicit_wait_time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementToBeClickable(By by, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.explicit_wait_time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static boolean isCookieAlertPresent(By by, WebDriver driver){
        return driver.findElement(by).isDisplayed();
    }

    public static void scrollToView(WebElement element, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
