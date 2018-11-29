package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.TestCaseId;


@Listeners({listeners.AllureListener.class})

public class Test3 extends PageFactoryInitializer {

    /**
     * This test is to Login function in Gmail.
     * Steps:
     * 1. Open Google homepage and click the Gmail button
     * 2. Fill username and password and signin
     * 3. Click More to expand mail folders
     * 4. Continue...
     */

    @TestCaseId("TC_GMail_004")
    @Test()
    public void testGmailLogin() throws Exception {
        googleHomePage().clickonGmailLink();
        gmailPage().signInGmail("canzhuanywhere@gmail.com", "!Asdf1234");
        gmailMainPage().expandMore();

    }

}
