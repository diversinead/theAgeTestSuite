package com.autoFramework.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import com.autoFramework.utilities.general;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by sdiver on 6/4/2017.
 */
public class TheAgeWeatherPage extends TheAgeBase {
    private String url = "http://weather.theage.com.au/local-forecast/vic/melbourne";
    private String pageTitle = "Melbourne local weather forecast";
    private By suburbSearch = By.id("search_locality");
    private By suburbTitle = By.className("ff_tilte");
    private general utilities = new general();

    WebDriver driver;

    public TheAgeWeatherPage(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToUrl(){
        driver.navigate().to(url);
    }

    public void isPageDisplayed() {
        Assert.assertTrue("Melbourne local weather forecast",driver.getTitle().startsWith(pageTitle));
    }

    public void searchBySuburb(String suburb){
        driver.findElement(suburbSearch).click();
        driver.findElement(suburbSearch).sendKeys(suburb);
        driver.findElement(suburbSearch).sendKeys(Keys.ENTER);

        utilities.waitForText(driver, suburbTitle, suburb, 10);
        //wait.until(ExpectedConditions.textToBePresentInElementLocated(suburbTitle, suburb));

        Assert.assertTrue(suburb, suburb.equals(driver.findElement(suburbTitle).getText()));
    }
    public String getPageTitle(){
        return driver.getTitle();
    }
    public String getURL(){
        return driver.getCurrentUrl();
    }

}
