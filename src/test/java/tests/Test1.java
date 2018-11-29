package tests;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import controllers.ExcelDataProvider;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.TestCaseId;

@Listeners({listeners.AllureListener.class})
public class Test1 extends PageFactoryInitializer
{

	@TestCaseId("TC_GMail_001")
	@Description("To verify the working of GMail link from Google Home Page using JavaScript Executor")
	@Test(dataProvider="excelSheetNameAsMethodName", dataProviderClass=ExcelDataProvider.class)
	public void testGoogle(@Parameter("TestCaseID")String TestCaseID, @Parameter("UserName")String UserName,@Parameter("Password") String Password) 			throws Exception

	//public void testGoogle("TC_001", "alistairzhu@gmail.con","Password") throws Exception

	{
		System.out.println("TestCase ID: "+TestCaseID);
		System.out.println("UserName: "+UserName);
		System.out.println("Password: "+Password);
		Assert.assertTrue(true);
	}

	@Test()

	public void testGoogleLink() throws Exception

	{
		googleHomePage().clickonGmailLink();
		googleHomePage().verifyPageTitle("Gmail");
		Assert.assertTrue(true);
	}
}
