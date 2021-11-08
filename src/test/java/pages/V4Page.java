package pages;

import driver.DriverHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static steps.BaseFunctions.*;

public class V4Page extends DriverHandler {

    private final WebDriver driver = getDriver();

    private final By NEW_COUPON_BTN = By.xpath("//button[@data-test-id='new-coupon']");
    private final By CREATE_NEW_COUPON_BTN = By.xpath("//button[contains(@class,'NewCouponDialog')]");
    private String SELECT_HORSE = "//div[@data-test-id='coupon-race-ROW']//button[@data-start-number='HORSE_NUMBER']";
    private String SELECT_ALL_HORSES = "//button[@data-test-id='leg-ROW-toggle-all']";
    private final By AMOUNT = By.xpath("//span[contains(@class,'amount')]");

    public V4Page() {
    }

    public void clickCouponButton(){
        waitForElementToBeClickable(NEW_COUPON_BTN, driver);
        driver.findElement(NEW_COUPON_BTN).click();
        waitForElementToBeClickable(CREATE_NEW_COUPON_BTN, driver);
    }

    public void clickCreateNewCouponButton(){
        waitForElementToBeVisible(CREATE_NEW_COUPON_BTN, driver);
        driver.findElement(CREATE_NEW_COUPON_BTN).click();
        waitForElementToBeClickable(NEW_COUPON_BTN, driver);
    }

    public void selectDesiredHorse(int row,int count){
        for (int i=1; i<=count; i++){
            String horse = SELECT_HORSE.replace("ROW",String.valueOf(row)).replace("HORSE_NUMBER",String.valueOf(i));
            driver.findElement(By.xpath(horse)).click();
        }
    }

    public void selectAllHorses(int row){
        driver.findElement(By.xpath(SELECT_ALL_HORSES.replace("ROW",String.valueOf(row)))).click();
    }

    public int getAmount(){
        return Integer.parseInt(driver.findElement(AMOUNT).getText().split(",")[0]);
    }
}
