# TestSuite_ATG

The aim of the testing framework is to provide a good way to write and run unit and functional tests for the ATG web application.

## ⚙️ How does this works?

This framework is created for both BDD & TDD test execution purpose using Java 12 , Selenium 4, Cucumber 7, maven and testNG.

For driver handling I used `io.github.bonigarcia.webdrivermanager` which finds the relevant driver as per your installed browser & version and store in cache.

For extent reports with cucumber + testNG, I used `extentreports-cucumber7-adapter` which lets you configure report with many customizations.


## 💬 Walkthrough

### Usage

The most notable elements in the directory hierarchy could be listed as below.

- `test-output `
contains the test results HTML and the screenshot if failed
- `run.sh `
uses to run tests directly in local or in CI/CD pipeline pass 1st argument as localhost. Refer below example for usage.

`./run.sh localhost` This will trigger suite in local machine. Also you can use remote host such as jenkins or selenium grid for continuous execution with schedules

If you prefer triggering the suite from the IDE you can use`mvn clean install -Dhost=localhost`

### Explanation

Brief description of classes/directory and their purposes.

1. DriverHandler.java
    > Does all the functions related to driver initialization. changing `host` will enable to use remote execution. `ThreadLocal`enables us to parallel execute tests. 


2. BaseFunctions.java
    > Contains `global functions` used for steps. If it can be generalized you can add the method here.   


3. ATGHomePage.feature
    > BDD tests are written using Gherkin in simple English. Every step is mapped to java methods which is bind with cucumber annotations.
    

4. TestRunner.java
    > Cucumber execution is handled here. Used testNG instead of JUnit because of the variety of options such as parallel and dependency testing. We can enable parallel run with a `thread count` here itself.

4. steps directory
   > Contains page specific functions which are mapped to feature file as above mentioned. We should always follow `page object model` when writing a new scenario.

4. pages directory
   > Contains page specific operations and locators. I have tried to use XPaths as much as possible because of the speed in execution and readability. We can use global functions to reduce duplicate codes.

4. test-output directory
   > Will have extent report of the test run. Any failure and this will store the screenshot.




