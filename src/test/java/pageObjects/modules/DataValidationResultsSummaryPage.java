package pageObjects.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;

public class DataValidationResultsSummaryPage extends PageFactoryInitializer{

    @FindBy(linkText="TRAX Demographic Data")
    private WebElement traxDemographicData;

    @Step("Goto DataValidationResultsSummary Page")
    public StudentDemographicDataPage gotoStudentDemographicDataPage() throws Exception
    {
        Thread.sleep(5000);
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, traxDemographicData);
        traxDemographicData.click();
        return new PageFactoryInitializer(driver).studentDemographicDataPage();
    }

}
