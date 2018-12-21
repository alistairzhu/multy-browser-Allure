package pageObjects.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;

public class SchoolSelectionPage extends PageFactoryInitializer{

    @FindBy(linkText="Oak Bay Secondary")
    private WebElement firstSchool;

    @Step("Goto DataValidationResultsSummary Page")
    public DataValidationResultsSummaryPage gotoDataValidationResultsSummaryPage() throws Exception
    {
        Thread.sleep(5000);
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, firstSchool);
        firstSchool.click();
        return new PageFactoryInitializer(driver).dataValidationResultsSummaryPage();
    }

}
