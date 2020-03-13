package com.practice.automation.pages;

import com.practice.automation.utility.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import static java.lang.Double.*;
import static java.lang.Double.parseDouble;
import static java.lang.Double.valueOf;

public class Test3Page extends Util {

    boolean check_product_range;

    @FindBy(xpath = "//a[(@class='ui-slider-handle ui-state-default ui-corner-all') and (@style ='left: 100%;')]")
    WebElement _slider100;
    @FindBy(xpath = "//span[@itemprop ='price']")
    WebElement _price;

    public  void moveSliderTo20Dollar() throws ParseException {


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,700)");
        Actions action = new Actions(driver);
        action.dragAndDropBy(_slider100, -182, 0).build().perform();


        List<WebElement> itemPrices = driver.findElements(By.xpath("//span[@itemprop ='price']"));

        for (WebElement itemPrice : itemPrices) {
            String price = "";
            price = itemPrice.getText();


            System.out.println(price);
            price = price.replace("$", "");

            try {
                Float temp = Float.parseFloat(price);

                if((temp >= 16)   && (temp <=20))
                    check_product_range = true;
                else
                    check_product_range = false;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean checkProductRange() {
       return check_product_range;
    }

}


