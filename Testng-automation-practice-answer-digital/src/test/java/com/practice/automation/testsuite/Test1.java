package com.practice.automation.testsuite;

import com.practice.automation.pages.Test1Page;
import com.practice.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
   As a user if there is an item already inside my basket, I want to be able to delete the item from the basket page so
   that i can see the basket is empty
   Acceptance criteria :
   1) shopping cart has delete button
   2) item is removed from basket
   3) Banner must display "your shopping cart is empty"
    */

public class Test1 extends TestBase {

    @Test()
    public void test1()  {
        new Test1Page().selectItem();
        new Test1Page().addItem();
        new Test1Page().checkout();
        new Test1Page().containElement();
        new Test1Page().clickOnDeleteBtn();
        Assert.assertTrue(new Test1Page().verifyBanner());
    }
}
