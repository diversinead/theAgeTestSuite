package com.autoFramework.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.autoFramework.pageObjects.theAge_homePage;
import com.autoFramework.webdriver.driverFactory;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class theAge {

    private WebDriver driver;
    private theAge_homePage theAgeHomePage;
    private String browserType = "Firefox"; // Set in pom - pass in thru Jenkins?

    @Before
    public void setUP() throws Exception{
        driverFactory df = new driverFactory();
        driver = df.setBrowser(browserType);
    }

    @After
    public void tearDown() throws Exception {
        theAgeHomePage.tidyUp(driver);
    }

    @Test
    public void runTest()throws Exception{
        try{
            theAgeHomePage = new theAge_homePage();
            theAgeHomePage.navigateToUrl(driver);

        }catch(Exception e){
            System.err.print(e);
        }

    }
}
