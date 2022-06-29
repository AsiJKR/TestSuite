package pages;

import driver.DriverHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

import static steps.BaseFunctions.*;

public class ATGHomePage extends DriverHandler {

    private final WebDriver driver = getDriver();

    private final By ACCEPT_COOKIES = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    private final By CATEGORY_HORSE = By.xpath("//a[@testid='header-verticallink-horse']");
    private final By SIDE_MENU_PANEL = By.xpath("//div[@data-test-id='overlay-side-menu']");
    private final By SIDE_MENU_ALLGAMES_DROPDOWN = By.xpath("//div[@data-test-id='horse-left-menu-sub-menu-toggle-allaspel-new']");
    private String SIDE_MENU_ALLGAMES_SELECT_GAME = "//a[@data-test-id='horse-left-menu-sub-menu-item-GAMENAME']";

    public void navigateTo(String url) {
        driver.navigate().to(url);

        if (isCookieAlertPresent(ACCEPT_COOKIES, driver)) {
            driver.findElement(ACCEPT_COOKIES).click();
        }
    }

    public void selectCategoryHorse() {
        waitForElementToBeClickable(CATEGORY_HORSE, getDriver());
        driver.findElement(CATEGORY_HORSE).click();
    }

    public void selectSideMenuPanel() {
        waitForElementToBeClickable(SIDE_MENU_PANEL, driver);
        driver.findElement(SIDE_MENU_PANEL).click();
    }

    public void selectAllGamesDropDown() {
        waitForElementToBeClickable(SIDE_MENU_ALLGAMES_DROPDOWN, driver);
        driver.findElement(SIDE_MENU_ALLGAMES_DROPDOWN).click();
    }

    public void selectGameFromAllGames(String gameName) {
        gameName = gameName.toLowerCase(Locale.ROOT).replace(" ", "-");//will make name lowercase and replace spaces
        SIDE_MENU_ALLGAMES_SELECT_GAME = SIDE_MENU_ALLGAMES_SELECT_GAME.replace("GAMENAME", gameName);//replaces xpath with the provided name
        moveToElementAndClick(By.xpath(SIDE_MENU_ALLGAMES_SELECT_GAME), driver);
    }
}
