package com.practice.automation.testsuite;


import com.practice.automation.pages.Test5Page;
import com.practice.automation.testbase.TestBase;
import org.testng.annotations.Test;

/*
As a user when browsing the our stores page, I want to drag the map to see a store from west palm beach, so that I can take
a screen shot for future reference
Acceptance criteria
1) User can scroll through the map
2) West palm beach must within the screenshot
 */
public class Test5 extends TestBase {

    @Test
    public void test5(){
        new Test5Page().clickOnOurStores();
        new Test5Page().clickOnOk();
        new Test5Page().mouseHoverAndClickOnZoomOut();
        new Test5Page().takeScreenShot("West palm beach pic");
    }

}
