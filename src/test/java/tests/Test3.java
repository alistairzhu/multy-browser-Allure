package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.TestCaseId;


@Listeners({listeners.AllureListener.class})

public class Test3 extends PageFactoryInitializer {

    @TestCaseId("TC_GMail_003")
    @Test()
    public void testGmailLogin() throws Exception {
        googleHomePage().clickonGmailLink();
        gmailPage().signInGmail("canzhuanywhere@gmail.com", "!Asdf1234");
        gmailMainPage().expandMore();
    }

}
