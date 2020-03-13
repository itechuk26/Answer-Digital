package com.practice.automation.pages;

import com.practice.automation.utility.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Test1Page extends Util {
    @FindBy(xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-item-of-mobile-line']//a[@class='product-name'][contains(text(),'Blouse')]")
    WebElement _item;
    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    WebElement _addItem;
    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    WebElement _checkOut;
    @FindBy(xpath = "//td[@class='cart_delete text-center']//div")
    WebElement _deleteBtn;
    @FindBy(xpath = "//p[@class='alert alert-warning']")
    WebElement _bannerMessage;

    public void selectItem(){
        clickOnElement(_item);
    }
    public void addItem(){
        mouseHoverAndClickToElement(_addItem);
    }
    public void checkout(){
        clickOnElement(_checkOut);
    }
    public void containElement()  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _deleteBtn.isDisplayed();
        flash(_deleteBtn,driver);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void clickOnDeleteBtn(){
        clickOnElement(_deleteBtn);
    }
    public boolean verifyBanner()  {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flash(_bannerMessage,driver);
        return verifyThatElementIsDisplayed(_bannerMessage);

    }

}
