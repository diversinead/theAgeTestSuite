package com.autoFramework.cucumber;

import com.autoFramework.pageObjects.theAge_homePage;
import com.autoFramework.webdriver.driverFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * Created by col on 6/1/2017.
 */
public class TheAgeStepDefs {
    private WebDriver driver;
    private theAge_homePage theAgeHomePage = new theAge_homePage();

    @Given("^the user launches the browser type as ([^\"]*)$")
    public void launchBrowser(String browserType) throws Throwable {
        driverFactory df = new driverFactory();
        driver = df.setBrowser(browserType);
    }

    @When("^the user enters the url in the browser$")
    public void navigateTo() throws Exception{
        theAgeHomePage.navigateToUrl(driver);
    }

    @Then("^The Age Homepage should be displayed$")
    public void pageDisplayed() throws Exception{
        String pageTitle = theAgeHomePage.getPageTitle(driver);
        Assert.assertTrue("title should start with Latest & Breaking", driver.getTitle().startsWith(pageTitle));
    }

    @When("^the user closes the browser$")
    public void closeBrowser() throws Exception{
        theAgeHomePage.tidyUp(driver);
    }
}
