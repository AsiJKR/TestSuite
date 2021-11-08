package pages;

import driver.DriverHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static steps.BaseFunctions.*;

public class ATGHomePage extends DriverHandler {

    private final WebDriver driver = getDriver();

    private final By ACCEPT_COOKIES = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    private final By CATEGORY_HORSE = By.xpath("//a[@testid='header-verticallink-horse']");
    private final By SIDE_MENU_PANEL = By.xpath("//div[@data-test-id='overlay-side-menu']");
    private final By SIDE_MENU_ALLGAMES_DROPDOWN = By.xpath("//div[@data-test-id='horse-left-menu-sub-menu-toggle-allaspel-new']");
    private String SIDE_MENU_ALLGAMES_SELECT_GAME = "//*[text()='GAMENAME']";
    private By SIDE_MENU_GRAND_SLAM_GAME = By.xpath("//a[@data-test-id='horse-left-menu-sub-menu-item-gs75']");
    public void navigateTo(String url) {
        driver.navigate().to(url);

        if(isCookieAlertPresent(ACCEPT_COOKIES, driver)){
            driver.findElement(ACCEPT_COOKIES).click();
        }
    }

    public void selectCategoryHorse(){
        waitForElementToBeClickable(CATEGORY_HORSE, getDriver());
        driver.findElement(CATEGORY_HORSE).click();
    }

    public void selectSideMenuPanel(){
        driver.findElement(SIDE_MENU_PANEL).click();
    }

    public void selectAllGamesDropDown(){
        driver.findElement(SIDE_MENU_ALLGAMES_DROPDOWN).click();
    }

    public void selectGameFromAllGames(String gameName){
        SIDE_MENU_ALLGAMES_SELECT_GAME = SIDE_MENU_ALLGAMES_SELECT_GAME.replace("GAMENAME",gameName);

        WebElement element = driver.findElement(SIDE_MENU_GRAND_SLAM_GAME);//get scroll point ready
        scrollToView(element, driver);
        driver.findElement(By.xpath(SIDE_MENU_ALLGAMES_SELECT_GAME)).click();
    }
}
