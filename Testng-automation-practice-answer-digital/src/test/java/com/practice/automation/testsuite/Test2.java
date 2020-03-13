package com.practice.automation.testsuite;

import com.practice.automation.pages.Test2Page;
import com.practice.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
As a user I want to select the "Summer dresses" option from navigation menu, so that I can view an item from the summer menu
Acceptance criteria
1) On mouse-Hover button woman sub navigation option will appear
2) Summer items only display in the search results
 */
public class Test2 extends TestBase {

    @Test
    public void test2(){
        new Test2Page().mousehoverToWomenBtn();
        new Test2Page().clickOnSummerDresses();
        String expectedText ="Summer Dresses";
        Assert.assertEquals(new Test2Page().verifySummerItemsResultSearch(),expectedText);
    }
}
