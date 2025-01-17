package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuHomePage;
import pages.TestOtomasyonuLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TestotomasyonuAccessSuccessTest {
    TestOtomasyonuHomePage testOtomasyonuHomePage = new TestOtomasyonuHomePage();
    TestOtomasyonuLoginPage testOtomasyonuLoginPage = new TestOtomasyonuLoginPage();

    @Test
    public void successHome() {
        //1 - https://www.heps"iburada.com/ adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //1- URL'nin doğru olduğunu doğrulayın
        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
       // Assert.assertEquals(actualUrl, expectedUrl, "URL adresi beklenenden farklı");
       Assert.assertTrue(actualUrl.contains(expectedUrl), "URL adresi beklenenden farklı");




        //2 - açılan menüde "Giriş Yap" butonuna tıklayın
//        WebElement loginRedirectionButton = Driver.getDriver().findElement(By.id("login"));
        testOtomasyonuHomePage.accountButton.click();
//




    }

}
