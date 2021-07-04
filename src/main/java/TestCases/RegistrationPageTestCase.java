package TestCases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Base.Base;

public class RegistrationPageTestCase extends Base {




    @Test(priority = 0)
    public void registrationPageTestCases() {
        homePage.enterEmail();
        registrationPage.emailAndPhone();


    }



    // This method will execute once all the test execution is done

    @AfterClass
    public void endReport() {
        System.out.println("Inside EndReport(After Test) method");

        extent.flush();
        try {
            Thread.sleep(4000);
        } catch (final InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // This method will execute after every test method and status of the test case
    // will be captured by ItestResult object
    // and based on the status report is generated and captured in extent report
    // html file . If any fail will be there then
    // screenshot will be captured and will be included in the same html report with
    // failed status of the particular test
    @AfterMethod
    public void ReportLogging(final ITestResult result) throws IOException {
        test = extent.createTest(result.getMethod().getMethodName());
        utilities.LogReport(result, test);
        driver.quit();
    }


}
