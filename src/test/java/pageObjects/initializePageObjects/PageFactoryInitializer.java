/**
 *
 */
package pageObjects.initializePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import controllers.BrowserFactory;
import pageObjects.modules.*;

/**
 * Initialize ALL page objects here.
 */
public class PageFactoryInitializer extends BrowserFactory {


    public PageFactoryInitializer(){

    }
    public PageFactoryInitializer(WebDriver driver){
        this.driver = driver;
    }

    public NonSiteMinderEnvironmentLoginPage nonSiteMinderEnvironmentLoginPage() {
        return PageFactory.initElements(driver, NonSiteMinderEnvironmentLoginPage.class);
    }

    public SchoolSelectionPage schoolSelectionPage() {
        return PageFactory.initElements(driver, SchoolSelectionPage.class);
    }

    public DataValidationResultsSummaryPage dataValidationResultsSummaryPage() {
        return PageFactory.initElements(driver, DataValidationResultsSummaryPage.class);
    }

    public StudentDemographicDataPage studentDemographicDataPage() {
        return PageFactory.initElements(driver, StudentDemographicDataPage.class);
    }


    public StudentAchievementDataPage studentAchievementDataPage() {
        return PageFactory.initElements(driver, StudentAchievementDataPage.class);
    }


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
