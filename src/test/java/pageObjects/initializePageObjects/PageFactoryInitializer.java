/**
 *
 */
package pageObjects.initializePageObjects;

import org.openqa.selenium.support.PageFactory;

import controllers.BrowserFactory;
import pageObjects.modules.GMailMainPageObjects;
import pageObjects.modules.GMailPageObjects;
import pageObjects.modules.GoogleHomePageObjects;

/**
 * Initialize ALL page objects here.
 */
public class PageFactoryInitializer extends BrowserFactory {

    public GoogleHomePageObjects googleHomePage() {
        return PageFactory.initElements(driver, GoogleHomePageObjects.class);
    }

    public GMailPageObjects gmailPage() {

        return PageFactory.initElements(driver, GMailPageObjects.class);
    }

    public GMailMainPageObjects gmailMainPage() {

        return PageFactory.initElements(driver, GMailMainPageObjects.class);
    }


}
