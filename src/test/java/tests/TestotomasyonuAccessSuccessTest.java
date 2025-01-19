package tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.TestOtomasyonuHomePage;
import pages.TestOtomasyonuLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelReport;
import utilities.TestBaseReport;

import java.io.IOException;

@Listeners(ExcelReport.class)
public class TestotomasyonuAccessSuccessTest extends TestBaseReport {
    TestOtomasyonuHomePage testOtomasyonuHomePage = new TestOtomasyonuHomePage();
    TestOtomasyonuLoginPage testOtomasyonuLoginPage = new TestOtomasyonuLoginPage();
    ExcelReport excelReport=new ExcelReport();

    @Test
    public void successHome() {
        //1 - Clicks https://www.testotomasyonucom/
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //1- Confirms HomePage
        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

       // Assert.assertEquals(actualUrl, expectedUrl, "URL adress different");
       Assert.assertTrue(actualUrl.contains(expectedUrl), "URL adress is different");

    }


    @AfterSuite
    public void ExcelReport() {
        try {
            excelReport.saveReport(System.getProperty("user.dir") + "/test-output/TestReport.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
