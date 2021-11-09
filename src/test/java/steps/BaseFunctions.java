package steps;

import common.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseFunctions {

    public BaseFunctions() {
    }

    public static void waitForElementToBeVisible(By by, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementToBeClickable(By by, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementToBeClickable(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static boolean isCookieAlertPresent(By by, WebDriver driver) {
        return driver.findElement(by).isDisplayed();
    }

    //scroll the viewport to the element top
    public static void scrollToView(WebElement element, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //move to the element wait 2 secs and click
    public static void moveToElementAndClick(By element, WebDriver driver) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(element)).pause(2000).click(driver.findElement(element)).perform();
    }

    public static void clickWithJavascript(WebElement element, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
