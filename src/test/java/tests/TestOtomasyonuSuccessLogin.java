package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class TestOtomasyonuSuccessLogin {

    TestOtomasyonuLoginPage testOtomasyonuLoginPage = new TestOtomasyonuLoginPage();
    @Test
    public void successLogin(){


        Driver.getDriver().get(ConfigReader.getProperty("toUrlUser"));

        ReusableMethods.bekle(1);
        testOtomasyonuLoginPage.username.sendKeys(ConfigReader.getProperty("toSuccessEmail"));
        testOtomasyonuLoginPage.password.sendKeys(ConfigReader.getProperty("toSuccessPassword"));
        ReusableMethods.bekle(1);
      //  scroll down
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,300)");
        ReusableMethods.bekle(2);

        testOtomasyonuLoginPage.loginButton.click();

        //  Ekranın üstündeki Search alanına 'samsung' yazip 'Ara' butonuna tıklayacak
        ReusableMethods.bekle(1);
       testOtomasyonuLoginPage.searchArea.sendKeys(ConfigReader.getProperty("toSearchingWord")+ Keys.ENTER);


        //5 Verify that search samsung results are displayed
        List<WebElement> searchResults = Driver.getDriver().findElements(By.cssSelector("ul.product.prod-grid-col4 > li"));
        Assert.assertFalse(searchResults.isEmpty(), "Search results are not displayed");

        //
    }

}
