package com.autoFramework.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Created by sdiver on 5/19/2017.
 */
public class theAge_homePage {

    // Page Elements
    protected String url = "http://www.theage.com.au/";
    protected String pageTitle = "Latest & Breaking";
    private By search = By.className("form search-box search-box--primary");
    private By searchField = By.id("site-search-placeholder");

    public String getPageTitle(WebDriver driver)throws Exception {
        String title = null;
        try{
            title = driver.getTitle();
        } catch(Exception e){
            System.err.print(e);
        }

        return title;
    }

    // Page Methods
    public void navigateToUrl(WebDriver driver)throws Exception {
        try {
            driver.navigate().to(url);
        } catch(Exception e){
            System.err.print(e);
        }
    }

    public void searchFor(WebDriver driver)throws Exception {
        try{
            driver.findElement(search).click();
            driver.findElement(searchField).sendKeys("Sport");
            driver.findElement(searchField).sendKeys(Keys.ENTER);
        } catch(Exception e){
            System.err.print(e);
        }
    }

    public void tidyUp(WebDriver driver) throws Exception {
        try {
            if (driver != null) {
                driver.close();
            }
        }catch(Exception e){
            System.err.print(e);
        }
    }

}
