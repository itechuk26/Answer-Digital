package com.practice.automation.pages;

import com.practice.automation.utility.Util;
import com.practice.automation.xlsreader.Xls_Reader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class Test4Page extends Util {
    @FindBy(xpath = "//a[@class='login']")
    WebElement _signin;
    @FindBy(xpath = "//input[@id='email_create']")
    WebElement _email;
    @FindBy(id = "SubmitCreate")
    WebElement _clickOnSubmitCreate;
    @FindBy(id = "customer_firstname")
    WebElement _firstname;
    @FindBy(id = "customer_lastname")
    WebElement _lastname;
    @FindBy(id = "passwd")
    WebElement _password;
    @FindBy(id = "address1")
    WebElement _address1;
    @FindBy(id = "city")
    WebElement _city;
    @FindBy(id = "id_state")
    WebElement _state;
    @FindBy(id = "postcode")
    WebElement _zipcode;
    @FindBy(id = "id_country")
    WebElement _country;
    @FindBy(id = "phone_mobile")
    WebElement _mobileno;
    @FindBy(id = "alias")
    WebElement _assignaddress;
    @FindBy(id = "submitAccount")
    WebElement _submitAccount;
    @FindBy(xpath = "//span[@class='navigation_page']")
    WebElement _verifyAccountCreation;
    @FindBy(xpath = "//a[@class='account']")
    WebElement _verifyAccountName;
    @FindBy(xpath = "//div[@class='alert alert-danger']")
    WebElement _errorMessage;

    public void clickOnSignInBtn() {
        clickOnElement(_signin);
    }

    public void enterEmail(String email) {

        sendTextToElement(_email, generateRandomNumber() + email);
    }

    public void clickOnSubmitCreateBtn() {
        mouseHoverAndClickToElement(_clickOnSubmitCreate);
    }

    static Xls_Reader reader;

    public static ArrayList<Object[]> getValidDataFromExcel() {
        ArrayList<Object[]> myData = new ArrayList<Object[]>();
        String projectPath = System.getProperty("user.dir");

        try {
            reader = new Xls_Reader(projectPath + "\\src\\main\\java\\com\\practice\\automation\\exceldata\\RegistrationData.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int rowCount = reader.getRowCount("RegValidData");
        for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
            String firstname = reader.getCellData("RegValidData", "firstname", rowNum);
            String lastname = reader.getCellData("RegValidData", "lastname", rowNum);
            String password = reader.getCellData("RegValidData", "password", rowNum);
            String address1 = reader.getCellData("RegValidData", "address", rowNum);
            String city = reader.getCellData("RegValidData", "city", rowNum);
            String state = reader.getCellData("RegValidData", "state", rowNum);
            String zipcode = reader.getCellData("RegValidData", "zipcode", rowNum);
            String country = reader.getCellData("RegValidData", "country", rowNum);
            String mobileno = reader.getCellData("RegValidData", "mobileno", rowNum);
            String assignaddress = reader.getCellData("RegValidData", "assignaddress", rowNum);

            Object[] ob = {firstname, lastname, password, address1, city, state, zipcode, country, mobileno, assignaddress};
            myData.add(ob);
        }
        return myData;
    }

    public void test4PageCopyData(String firstname, String lastname, String password, String address1, String city, String state,
                                  String zipcode, String country, String mobileno, String assignaddress) {
        sendTextToElement(_firstname, firstname);
        sendTextToElement(_lastname, lastname);
        sendTextToElement(_password, password);
        sendTextToElement(_address1, address1);
        sendTextToElement(_city, city);
        selectByVisibleTextFromDropDown(_state, state);
        sendTextToElement(_zipcode, zipcode);
        selectByVisibleTextFromDropDown(_country, country);
        sendTextToElement(_mobileno, mobileno);
        sendTextToElement(_assignaddress, assignaddress);
    }

    public static ArrayList<Object[]> getInValidDataFromExcel() {
        ArrayList<Object[]> myData = new ArrayList<Object[]>();
        String projectPath = System.getProperty("user.dir");

        try {
            reader = new Xls_Reader(projectPath + "\\src\\main\\java\\com\\practice\\automation\\exceldata\\RegistrationData.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int rowCount = reader.getRowCount("RegInvalidData");
        for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
            String firstname = reader.getCellData("RegInvalidData", "firstname", rowNum);
            String lastname = reader.getCellData("RegInvalidData", "lastname", rowNum);
            String password = reader.getCellData("RegInvalidData", "password", rowNum);
            String address1 = reader.getCellData("RegInvalidData", "address", rowNum);
            String city = reader.getCellData("RegInvalidData", "city", rowNum);
            String state = reader.getCellData("RegInvalidData", "state", rowNum);
            String zipcode = reader.getCellData("RegInvalidData", "zipcode", rowNum);
            String country = reader.getCellData("RegInvalidData", "country", rowNum);
            String mobileno = reader.getCellData("RegInvalidData", "mobileno", rowNum);
            String assignaddress = reader.getCellData("RegInvalidData", "assignaddress", rowNum);

            Object[] ob = {firstname, lastname, password, address1, city, state, zipcode, country, mobileno, assignaddress};
            myData.add(ob);
        }
        return myData;
    }


    public void clickOnSubmitAccountBtn() {
        mouseHoverAndClickToElement(_submitAccount);
    }

    public void verificationOfAccountName() {
        flash(_verifyAccountName, driver);
    }

    public String verificationOfAccountCreation() {
        return getTextFromElement(_verifyAccountCreation);
    }

    public boolean verificationOfAccountCreationWithInvalidData() {
        flash(_errorMessage, driver);
        return verifyThatElementIsDisplayed(_errorMessage);
    }

}
