package com.practice.automation.testbase;


import com.practice.automation.basepage.BasePage;
import com.practice.automation.browserselector.BrowserSelector;
import com.practice.automation.loadproperty.LoadProperty;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase extends BasePage {


    String browser = new LoadProperty().getProperty("browser");
    BrowserSelector browserSelector = new BrowserSelector();


    @BeforeMethod(alwaysRun = true )
    public void setUP(){
        browserSelector.selectBrowser(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
