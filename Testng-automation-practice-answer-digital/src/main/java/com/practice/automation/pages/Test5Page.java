package com.practice.automation.pages;

import com.practice.automation.utility.Util;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Test5Page extends Util {
    @FindBy(xpath = "//a[contains(text(),'Our stores')]")
    WebElement _stores;
    @FindBy(xpath = "//button[@class='dismissButton']")
    WebElement _okAndDismiss;
    @FindBy(xpath = "//button[(@draggable ='false')and (@title='Zoom out')]")
    WebElement _zoomOut;

    String projectPath = System.getProperty("user.dir");

    public void clickOnOurStores() {
        clickOnElement(_stores);
    }

    public void clickOnOk() {
        clickOnElement(_okAndDismiss);
    }
    public void mouseHoverAndClickOnZoomOut() {
        mouseHoverAndClickToElement(_zoomOut);
        mouseHoverAndClickToElement(_zoomOut);
        mouseHoverAndClickToElement(_zoomOut);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // mouseHoverAndClickToElement(_zoomOut);
    }
    public void takeScreenShot(String fileName) {
        // Take screenshot and store as a file format
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // now copy the screenshot to desired location using copyFile //method
        try {

            FileUtils.copyFile(src, new File(projectPath + "\\src\\main\\java\\com\\practice\\automation\\screenshots" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
