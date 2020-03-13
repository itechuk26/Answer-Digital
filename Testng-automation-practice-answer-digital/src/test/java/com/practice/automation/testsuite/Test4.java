package com.practice.automation.testsuite;

import com.practice.automation.pages.Test4Page;
import com.practice.automation.testbase.TestBase;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;

/*
As a user I want to open new account so I can start buying items using my personal account
Acceptance criteria
1) Form can only accept valid information
2) Invalid Information can give an error message
3) Completing register will take user take to "My Account" page
4) User can see account name on top right
 */
public class Test4 extends TestBase {

    @DataProvider
    public Iterator<Object[]> getValidTestData() {
        ArrayList<Object[]> testData = Test4Page.getValidDataFromExcel();
        return testData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> getInValidTestData() {
        ArrayList<Object[]> testData = Test4Page.getInValidDataFromExcel();
        return testData.iterator();
    }

    // This test - accept valid data,navigate to My account page, highlights account name
    @Test(dataProvider = "getTestData")
    public void test4WithValidData(String firstname, String lastname, String password, String address1, String city, String state,
                                   String zipcode, String country, String mobileno, String assignaddress) {
        new Test4Page().clickOnSignInBtn();
        new Test4Page().enterEmail("jennifer@gmail.com");
        new Test4Page().clickOnSubmitCreateBtn();
        new Test4Page().test4PageCopyData(firstname, lastname, password, address1, city, state, zipcode,
                country, mobileno, assignaddress);
        new Test4Page().clickOnSubmitAccountBtn();
        new Test4Page().verificationOfAccountName();
        String expectedText = "My account";
        Assert.assertEquals(new Test4Page().verificationOfAccountCreation(), expectedText);
    }

    // This test - not accept invalid data, highlights error message
    @Test(dataProvider = "getInValidTestData")
    public void test4WithInValidData(String firstname, String lastname, String password, String address1, String city, String state,
                                     String zipcode, String country, String mobileno, String assignaddress) {
        new Test4Page().clickOnSignInBtn();
        new Test4Page().enterEmail("jennifer@gmail.com");
        new Test4Page().clickOnSubmitCreateBtn();
        new Test4Page().test4PageCopyData(firstname, lastname, password, address1, city, state, zipcode,
                                                                                 country, mobileno, assignaddress);
        new Test4Page().clickOnSubmitAccountBtn();
        Assert.assertTrue(new Test4Page().verificationOfAccountCreationWithInvalidData());
    }

}

