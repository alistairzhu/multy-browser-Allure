package pageObjects.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import utils.RandomGenerator;

public class GMailMainPageObjects {

    @FindBy(css="a[title='Inbox']")
    private WebElement inboxButton;


    @FindBy(css="span[class='CJ']")
    private WebElement moreOrLessButton;


    @FindBy(css="span[class='CJ']")
    private WebElement lessButton;


    @Step("To Open Inbox")
    public void openInbox()
    {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, inboxButton);
        inboxButton.click();
    }

    public GMailMainPageObjects expandMore()
    {
        utils.FluentWaiting.waitUntillElementToBeClickable(30, 500, moreOrLessButton);
        /*Click More button to expand */
        moreOrLessButton.click();
        /*Assert More/Less button is flipped from More to Less */
        String displayText = moreOrLessButton.getText();
        Assert.assertEquals("Less", displayText);
        return this;
    }
}
