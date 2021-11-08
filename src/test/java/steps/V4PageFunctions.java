package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.V4Page;

public class V4PageFunctions {

     V4Page v4Page = new V4Page();

    @And("^On V4 game page user clicks on coupon button$")
    public void clickCouponButton(){
        v4Page.clickCouponButton();
    }

    @And("^On coupon popup user clicks New coupon$")
    public void clickCreateNewCouponButton(){
        v4Page.clickCreateNewCouponButton();
    }

    @And("^On game page user selects \"([^\"]*)\" as horse leg and \"([^\"]*)\" as horse count$")
    public void selectDesiredHorse(int horseLeg, int horseCount){
        v4Page.selectDesiredHorse(horseLeg, horseCount);
    }

    @And("^On game page user clicks All button for \"([^\"]*)\" horse leg$")
    public void selectAllHorses(int horseLeg){
        v4Page.selectAllHorses(horseLeg);
    }

    @Then("^On game page user verifies if the total amount is changed$")
    public void verifyIfAmountIsIncreased(){
       int finalAmount = v4Page.getAmount();
        Assert.assertTrue(finalAmount > 0, "Amount after selecting horses is changed");
    }
}
