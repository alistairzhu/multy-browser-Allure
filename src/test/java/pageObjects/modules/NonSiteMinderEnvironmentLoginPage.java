package pageObjects.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import pageObjects.initializePageObjects.PageFactoryInitializer;


public class NonSiteMinderEnvironmentLoginPage extends PageFactoryInitializer{

    @FindBy(css="input[id='userName']")
    private WebElement userName;

    @FindBy(css="input[id='password']")
    private WebElement password;


    @FindBy(css="li[id='SMGOV_USERTYPE_0']")
    private WebElement bceid;

    @FindBy(css="li[id='SMGOV_USERTYPE_1']")
    private WebElement idir;

    @FindBy(css="input[value='Login']")
    private WebElement loginButton;


    @Step("Login")
    public SchoolSelectionPage login() throws Exception
    {
        utils.FluentWaiting.waitUntillElementToBeVisible(30, 500, userName);
        userName.sendKeys("MSCHOOLUSER");
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, password);
        password.sendKeys(" MSCHOOLUSER");
        Thread.sleep(5000);
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, loginButton);
        loginButton.click();
        return new PageFactoryInitializer(driver).schoolSelectionPage();
    }


}
