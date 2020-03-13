package com.practice.automation.testsuite;

import com.practice.automation.pages.Test2Page;
import com.practice.automation.pages.Test3Page;
import com.practice.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;

/*
As a user when searching for a summer dress, I want to change price range to £16-£20 so i see a search result change
Acceptance criteria
1) slider changes the price range
2) search result are updated
3) item returned are within the price range
 */
public class Test3 extends TestBase {

    @Test
    public void test3() throws ParseException {
        new Test2Page().mousehoverToWomenBtn();
        new Test2Page().clickOnSummerDresses();
        new Test3Page().moveSliderTo20Dollar();
        Assert.assertTrue(new Test3Page().checkProductRange());
    }
}
/*
Answer : Bugs in web Application
      -- While changing price range $16-$20, page continuously loading but search result is not updating
 */
