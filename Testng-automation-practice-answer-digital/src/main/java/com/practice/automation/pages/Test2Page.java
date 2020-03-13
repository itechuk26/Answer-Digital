package com.practice.automation.pages;

import com.practice.automation.utility.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Test2Page extends Util {
    @FindBy(xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
    WebElement _womenBtn;
    @FindBy(xpath = "//ul[@class='submenu-container clearfix first-in-line-xs']//li//ul//a[contains(text(),'Summer Dresses')]")
    WebElement _summerDresses;
    @FindBy(xpath = "//span[@class='category-name']")
    WebElement _verifySummerItemsResults;

    public void mousehoverToWomenBtn(){
       mouseHoverToElement(_womenBtn);
    }
    public void clickOnSummerDresses(){
        clickOnElement(_summerDresses);
    }
    public String verifySummerItemsResultSearch(){
        return getTextFromElement(_verifySummerItemsResults);
    }

}
