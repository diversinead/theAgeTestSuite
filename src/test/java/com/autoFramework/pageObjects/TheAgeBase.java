package com.autoFramework.pageObjects;

import com.autoFramework.webdriver.driverFactory;
import cucumber.api.Scenario;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * Created by sdiver on 6/4/2017.
 */
public abstract class TheAgeBase {

    protected Scenario scenario = null;

    //Constructor
    public TheAgeBase(){
    }

    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    public abstract void isPageDisplayed();
    public abstract void navigateToUrl();

}
