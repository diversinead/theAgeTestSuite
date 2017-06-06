package com.autoFramework.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by sdiver on 5/30/2017.
 */
public class driverFactory {
    private static WebDriver driver = null;

    public static WebDriver setBrowser(String browserType) {

        String driverType;
        String driverExe;

        if (browserType.equals("Firefox")){
            driverType = "webdriver.gecko.driver";
            driverExe = "C:\\Selenium\\drivers\\geckodriver.exe";
            System.setProperty(driverType, driverExe);
            driver = new FirefoxDriver();
        }else if (browserType.equals("Chrome")) {
            driverType = "webdriver.chrome.driver";
            driverExe = "C:\\Selenium\\drivers\\chromedriver.exe";
            System.setProperty(driverType, driverExe);
            driver = new ChromeDriver();
        }else if (browserType.equals("IE")){
            driverExe = "C:\\Selenium\\drivers\\IEDriverServer.exe";
            driverType = "webdriver.ie.driver";
            System.setProperty(driverType, driverExe);
            driver = new InternetExplorerDriver();
        }
        return driver;
    }

    public void navigateToUrl(String url)throws Exception {
        try {
            driver.navigate().to(url);
        } catch(Exception e){
            System.err.print(e);
        }
    }

    public static String getTitle(){
        return driver.getTitle();
    }

    public void tidyUp() throws Exception {
        try {
            if (driver != null) {
                driver.close();
            }
        }catch(Exception e){
            System.err.print(e);
        }
    }
}
