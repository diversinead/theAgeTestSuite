package com.autoFramework.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sdiver on 5/19/2017.
 */
public class TheAgeHomePage extends TheAgeBase {

    WebDriver driver;
    private String url = "http://www.theage.com.au/";
    private String pageTitle = "Latest & Breaking";

    @FindBy(id = "site-search-placeholder")
    private WebElement searchField;

    @FindBy(id = "fm-id-6")
    private WebElement search;

    public TheAgeHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToUrl(){
        driver.navigate().to(url);
    }

    public void isPageDisplayed() {
        Assert.assertTrue("title should start with Latest & Breaking", driver.getTitle().startsWith(pageTitle));
    }

    public String getPageTitle()throws Exception {
        String title = null;
        try{
            title = driver.getTitle();
        } catch(Exception e){
            System.err.print(e);
        }

        return title;
    }

    public void searchFor(String searchStr)throws Exception {
        try{
            search.click();
            searchField.sendKeys(searchStr);
            searchField.sendKeys(Keys.ENTER);
        } catch(Exception e){
            System.err.print(e);
        }
    }



}
