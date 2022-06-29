package steps;

import common.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.HomePage;

public class HomePageFunctions {

    HomePage homePage = new HomePage();

    @Given("^As a User they navigate to Home Page$")
    public void navigateTo() {
        homePage.navigateTo(Constants.URL);
    }

    @And("^On Home Page user clicks on Horses Category$")
    public void selectCategoryHorse() {
        homePage.selectCategoryHorse();
    }

    @And("^On Home Page user clicks side menu panel$")
    public void selectSideMenuPanel() {
        homePage.selectSideMenuPanel();
    }

    @And("^On side panel user clicks All games dropdown$")
    public void selectAllGames() {
        homePage.selectAllGamesDropDown();
    }

    @And("^On side panel user clicks \"([^\"]*)\" as the game$")
    public void selectGameFromAllGames(String gameName) {
        homePage.selectGameFromAllGames(gameName);
    }

    @Given("As a User they navigate to Home ddd")
    public void asAUserTheyNavigateToHomeDdd() {
        homePage.navigateTo(Constants.URL);
    }
}
