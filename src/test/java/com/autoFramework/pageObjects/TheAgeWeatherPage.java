package com.autoFramework.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import com.autoFramework.utilities.general;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by sdiver on 6/4/2017.
 */
public class TheAgeWeatherPage extends TheAgeBase {

    WebDriver driver;
    private String url = "http://weather.theage.com.au/local-forecast/vic/melbourne";
    private String pageTitle = "Melbourne local weather forecast";

    @FindBy(id = "search_locality")
    private WebElement suburbSearch;

    @FindBy(className = "ff_tilte")
    private WebElement suburbTitle;

    private general utilities = new general();

    public TheAgeWeatherPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToUrl(){
        driver.navigate().to(url);
    }

    public void isPageDisplayed() {
        Assert.assertTrue("Melbourne local weather forecast",driver.getTitle().startsWith(pageTitle));
    }

    public void searchBySuburb(String suburb){
        suburbSearch.click();
        suburbSearch.sendKeys(suburb);
        suburbSearch.sendKeys(Keys.ENTER);

        utilities.waitForText(driver, suburbTitle, suburb, 10);
        //wait.until(ExpectedConditions.textToBePresentInElementLocated(suburbTitle, suburb));

        Assert.assertTrue(suburb, suburb.equals(suburbTitle.getText()));
    }
    public String getPageTitle(){
        return driver.getTitle();
    }
    public String getURL(){
        return driver.getCurrentUrl();
    }

}
