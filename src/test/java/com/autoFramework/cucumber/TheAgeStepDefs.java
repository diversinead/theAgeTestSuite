package com.autoFramework.cucumber;

import com.autoFramework.pageObjects.TheAgeBase;
import com.autoFramework.pageObjects.TheAgeHomePage;
import com.autoFramework.pageObjects.TheAgeWeatherPage;
import com.autoFramework.webdriver.driverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


/**
 * Created by sdiver on 6/1/2017.
 */
public class TheAgeStepDefs {
    private WebDriver driver;
    private driverFactory df = new driverFactory();
    private TheAgeBase theAgeBase;
    private TheAgeHomePage theAgeHomePage;
    private TheAgeWeatherPage theAgeWeatherPage;

    private static final String BROWSER = "browser";
    private String browserType = System.getProperty(BROWSER, "Firefox");


    // Constructor
    public TheAgeStepDefs(){
        theAgeHomePage = new TheAgeHomePage();
        theAgeWeatherPage = new TheAgeWeatherPage();
    }
    @Before
    public void before(Scenario scenario) {
        theAgeHomePage.before(scenario);
        theAgeWeatherPage.before(scenario);
    }

    @Given("^the user launches the browser$")
    public void launchBrowser() throws Throwable {
        driver = df.setBrowser(browserType);
    }

    @When("^the user enters the home page url in the browser$")
    public void navigateToHome() throws Exception{
        theAgeHomePage.navigateToUrl(driver);
    }

    @When("^the user enters the weather page url in the browser$")
    public void navigateToWeather() throws Exception{
        theAgeWeatherPage.navigateToUrl(driver);
    }

    @Then("^The Age Homepage is displayed$")
    public void homePageDisplayed() throws Exception{
        theAgeHomePage.isPageDisplayed(driver);
    }

    @Then("^The Age Weather page is displayed$")
    public void weatherPageDisplayed() throws Exception{
        theAgeWeatherPage.isPageDisplayed(driver);
    }

    @Then("^the user searches on suburb as ([^\"]*)$")
    public void searchWeatherBySuburb(String suburb) throws Exception{
        theAgeWeatherPage.searchBySuburb(driver,suburb);
    }

    @When("^the user closes the browser$")
    public void closeBrowser() throws Exception{
        df.tidyUp();
    }
}
