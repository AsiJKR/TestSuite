# TestSuite_ATG

The testing framework aims to provide a good way to write and run unit and functional tests for the ATG web application.

## ⚙️ How does this work?

This framework is created for both BDD & TDD test execution purposes using Java 12, Selenium 4, Cucumber 7, maven, and testNG.

For driver handling, I used `io.github.bonigarcia.webdrivermanager` which finds the relevant driver as per your installed browser & version (stores in cache).

For extent reports with cucumber + testNG, I used `extentreports-cucumber7-adapter` which lets you configure reports with many customizations.


## 💬 Walkthrough

### Usage

The most notable elements in the directory hierarchy could be listed below.

- `test-output `
contains the test results HTML and the screenshot if failed
- `run.sh `
uses to run tests directly in local or in CI/CD pipeline pass 1st argument as localhost. Refer to the below example for usage.

`./run.sh localhost` This will trigger suite in local machine. Also, you can use a remote host such as Jenkins or selenium grid for continuous execution with schedules

If you prefer triggering the suite from the IDE you can use`mvn clean install -Dhost=localhost`

### Explanation

Brief description of classes/directory and their purposes.

1. DriverHandler.java
    > Does all the functions related to driver initialization. changing `host` will enable to use of remote execution. `ThreadLocal`enables us to parallel execute tests. 


2. BaseFunctions.java
    > Contains `global functions` used for steps. If it can be generalized you can add the method here.   


3. ATGHomePage.feature
    > BDD tests are written using Gherkin in simple English. Every step is mapped to java methods which are bound with cucumber annotations.
    

4. TestRunner.java
    > Cucumber execution is handled here. Used TestNG instead of JUnit because of the variety of options such as parallel and dependency testing. We can enable parallel run with a `thread count` here itself.

4. steps directory
   > Contains page-specific functions which are mapped to feature file as above mentioned. We should always follow the `Page object model` when writing a new scenario.

4. pages directory
   > Contains page-specific operations and locators. I have tried to use XPaths as much as possible because of the speed in execution and readability. We can use global functions to reduce duplicate codes.

4. test-output directory
   > Will have extent report of the test run. Any failure and will store the screenshot.

### Test Scenario
1. Go to URL
2. Select Häst
3. Select V4
4. Make a coupon
5. Mark 4 horses on v4:1, Mark 1 horse on v4:2 Mark 2 horses on v4:3, Mark all horses on v4:4
6. Make sure that this test can run every day

Here I have added an `assertion` to check the total amount after and before selecting horses.

The above scenario is covered in BDD and will have the option to run in Jenkins or Selenium Grid using run.sh 

The schedulers can be added in Jenkins like this `10 06 * * *`.
Our suite will run every day in every month in every year at the 10th minute of the 6th hour (0610h).

After adding more scenarios we can use TestRunner to configure parallel runs using ThreadLocal driver.


Thank you!
