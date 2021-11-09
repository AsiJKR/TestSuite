Feature: V4 Horse journey

  Scenario: Guest user plays V4 game
    Given As a User they navigate to ATG Home ddd
    And On Home Page user clicks on Horses Category
    And On Home Page user clicks side menu panel
    And On side panel user clicks All games dropdown
    And On side panel user clicks "V4" as the game
    And On V4 game page user clicks on coupon button
    And On coupon popup user clicks New coupon
    And On game page user selects "1" as horse leg and "4" as horse count
    And On game page user selects "2" as horse leg and "1" as horse count
    And On game page user selects "3" as horse leg and "2" as horse count
    And On game page user clicks All button for "4" horse leg
    Then On game page user verifies if the total amount is changed
