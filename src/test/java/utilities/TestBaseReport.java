package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public  class TestBaseReport {
    protected static ExtentReports extentReports; //Makes the initial assignment to the extent report
    protected static ExtentTest extentTest; // records  passed or failed test. Also used for screenshot
    protected static ExtentHtmlReporter extentHtmlReporter; // edits to Html report


    @BeforeTest(alwaysRun = true) // alwaysRun
    public void setUpTest() {
        extentReports = new ExtentReports(); // starts report
        //report way
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/test-output/Rapor" + date + ".html";
        // creating html format and defines  filePath
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);


        extentReports.setSystemInfo("Enviroment", "QA");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser")); // chrome, firefox
        extentReports.setSystemInfo("Automation Engineer", "Meltem");
        extentHtmlReporter.config().setDocumentTitle("TestNG Test");
        extentHtmlReporter.config().setReportName("TestNG Reports");
    }


    // After each test method, if there is an error in the test, take a screenshot and add it to the report.
    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) { // test fail
            String screenshotLocation = ReusableMethods.getScreenshot(result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.skip("Test Case is skipped: " + result.getName()); // test ignores
        }
        Driver.quitDriver();

    }


    // stops the reports
    @AfterTest(alwaysRun = true)
    public void tearDownTest() {

        extentReports.flush();
    }
}


