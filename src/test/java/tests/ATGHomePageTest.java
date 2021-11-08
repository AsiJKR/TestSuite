//package tests;
//
//import common.Constants;
//import common.GameNames;
//import common.TestBase;
//import functions.ATGHomePageFunctions;
//import functions.V4PageFunctions;
//import org.testng.annotations.Test;
//
//public class ATGHomePageTest extends TestBase {
//
//    @Test
//    public void selectingV4HorsesTest() {
//
//        ATGHomePageFunctions.navigateTo(Constants.url);
//        ATGHomePageFunctions.selectCategoryHorse();
//        ATGHomePageFunctions.selectSideMenuPanel();
//        ATGHomePageFunctions.selectGameFromAllGames(GameNames.V4.getName());
//        V4PageFunctions.clickCouponButton();
//        V4PageFunctions.clickCreateNewCouponButton();
//
//        int beforeAmount = V4PageFunctions.getAmount(); //to capture total amount before selecting horses
//
//        V4PageFunctions.selectDesiredHorse(1, 4);
//        V4PageFunctions.selectDesiredHorse(2, 1);
//        V4PageFunctions.selectDesiredHorse(3, 2);
//        V4PageFunctions.selectAllHorses(4);
//
//        softAssert.assertNotEquals(V4PageFunctions.getAmount(), beforeAmount, "Amount after selecting horses is changed");
//        softAssert.assertAll();
//    }
//
//}
