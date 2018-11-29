/**
 * 
 */
package pageObjects.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;
import utils.RandomGenerator;

import static controllers.CommonConstants.*;

/**
 * @author Gladson Antony
 * @date Sep 17, 2016
 * 
 */
public class GMailPageObjects extends PageFactoryInitializer
{
	@FindBy(xpath="//input[@class='whsOnd zHQkBf']")
	private WebElement emailIDTextBox;

	@FindBy(css="input[type='password']")
	private WebElement passwordIDTextBox;
	
	@FindBy(css="span[class='RveJvd snByac']")
	private WebElement nextButton;

	@Step("To Enter Email ID and Click Next Button")
	public void enterEmailID() 
	{
		utils.FluentWaiting.waitUntillElementToBeClickable(elementLoadingTimeInSeconds, pollingTimeInMilliseconds, emailIDTextBox);
		emailIDTextBox.sendKeys(RandomGenerator.GenerateRandomEMAILIDs("google.com"));	
		nextButton.click();
	}

	public void enterEmailIdAndClickNext(String emaiId)
	{
		utils.FluentWaiting.waitUntillElementToBeVisible(elementLoadingTimeInSeconds, pollingTimeInMilliseconds, emailIDTextBox);
		emailIDTextBox.sendKeys(emaiId);
		nextButton.click();
	}

	public void enterPasswordAndClickNext(String passWord)
	{
		utils.FluentWaiting.waitUntillElementToBeVisible(elementLoadingTimeInSeconds, pollingTimeInMilliseconds, passwordIDTextBox);
		passwordIDTextBox.sendKeys(passWord);
		nextButton.click();

	}

	public GMailMainPageObjects signInGmail(String emaiId, String passWord) throws Exception
	{
		enterEmailIdAndClickNext(emaiId);
		Thread.sleep(3000);
		enterPasswordAndClickNext(passWord);
		return gmailMainPage();
	}
}
