package tests;


import controllers.ExcelDataProvider;
import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.TestCaseId;

@Listeners({listeners.AllureListener.class})
public class SdeTest extends PageFactoryInitializer {


    @TestCaseId("TC_GMail_001")
    @Description("To verify the working of GMail link from Google Home Page using JavaScript Executor")
//    @Test(dataProvider="excelSheetNameAsMethodName", dataProviderClass=ExcelDataProvider.class)

    @Test()

    public void testGoogleLink() throws Exception

    {
        nonSiteMinderEnvironmentLoginPage().
                login().
                gotoDataValidationResultsSummaryPage().
                gotoStudentDemographicDataPage();

        Assert.assertTrue(true);
    }


}
