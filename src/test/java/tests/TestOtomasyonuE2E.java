package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuAddCardPage;
import pages.TestOtomasyonuHomePage;
import pages.TestOtomasyonuLoginPage;
import pages.TestOtomasyonuMyCardPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import java.time.Duration;
import java.util.List;

public class TestOtomasyonuE2E extends TestBaseReport {

    TestOtomasyonuLoginPage testOtomasyonuLoginPage = new TestOtomasyonuLoginPage();
    TestOtomasyonuAddCardPage testOtomasyonuAddCardPage = new TestOtomasyonuAddCardPage();
    TestOtomasyonuHomePage testOtomasyonuHomePage=new TestOtomasyonuHomePage();
    TestOtomasyonuMyCardPage testOtomasyonuMyCardPage=new TestOtomasyonuMyCardPage();

    @Test
    public void successTest() {

        //1-TestOtomasyonuAccessSuccessTest passed

        //2 -User opens Login screen and signs in with user

        Driver.getDriver().get(ConfigReader.getProperty("toUrlUser"));

        ReusableMethods.wait(2);

        testOtomasyonuHomePage.accountButton.click();
        testOtomasyonuLoginPage.username.sendKeys(ConfigReader.getProperty("toSuccessEmail"));
        testOtomasyonuLoginPage.password.sendKeys(ConfigReader.getProperty("toSuccessPassword"));
        ReusableMethods.wait(1);

        //  scroll down
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,300)");
        ReusableMethods.wait(2);

        testOtomasyonuLoginPage.loginButton.click();


        // 3-  Clicks  Search button while typing 'samsung'
        ReusableMethods.wait(1);
        testOtomasyonuLoginPage.searchArea.sendKeys(ConfigReader.getProperty("toSearchingWord") + Keys.ENTER);

        // 4- Select the phone from the menu and then click on the mobile phone (there is no case compatibility on this site)


        //5 -Verify that search samsung results are displayed

        List<WebElement> searchResults = Driver.getDriver().findElements(By.cssSelector("ul.product.prod-grid-col4 > li"));
        Assert.assertFalse(searchResults.isEmpty(), "Search results are not displayed");

        //6- case not avaliable for this Website)

        //7- Clicks 3rd product


        JavascriptExecutor jm = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,300)");
        ReusableMethods.wait(2);
        testOtomasyonuAddCardPage.product.click();


        //8-Clicks likebutton of productdetail

        testOtomasyonuAddCardPage.likeButton.click();

        //9-Product add to wishlist successfully message control)

        ReusableMethods.wait(2);

        // Wait for the success message to appear
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='retro-notify-content']")));

        // Verify the success message is displayed
        Assert.assertTrue(successMessage.isDisplayed(), "Success message is not displayed");

        // Wait for the message to disappear
        ReusableMethods.wait(2); // Adjust the wait time as needed
        Assert.assertFalse(successMessage.isDisplayed());

        //10-Click liked from top of the page

        testOtomasyonuAddCardPage.wishListButton.click();

        //11-Verifies liked product

        List<WebElement> searchLikedResults = Driver.getDriver().findElements(By.xpath("//tr[@class='wishlist-tr']"));//liked project in the wishlist
        Assert.assertFalse(searchLikedResults.isEmpty(), "Search results are not displayed");

        // buy now cart

        testOtomasyonuAddCardPage.buyNow.click();



        //12-Liked product to add into basket
        //scroll

        JavascriptExecutor jk = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,300)");
        ReusableMethods.wait(2);
        testOtomasyonuAddCardPage.addCartButton.click();

        //13-Controls successly added product to basket

        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        WebElement successAddCardMessage = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='retro-notify-content']")));

        //14-Access to my card pages

         ReusableMethods.wait(2);
        // Scroll to the top of the page

        JavascriptExecutor jUp = (JavascriptExecutor) Driver.getDriver();
        jUp.executeScript("window.scrollTo(0, 0);");


        // Ensure the element(myCardButton) is in view

        WebElement myCardButton = testOtomasyonuMyCardPage.myCardButton;
        jUp.executeScript("arguments[0].scrollIntoView(true);", myCardButton);
        ReusableMethods.wait(2);


        testOtomasyonuMyCardPage.myCardButton.click();

        //15-This product added to the cart will be entered and the 'Remove' button will be pressed and it will be removed from my cart.

        testOtomasyonuMyCardPage.removeButton.click();
        ReusableMethods.wait(3);
        testOtomasyonuMyCardPage.confirmRemoveButton.click();
        ReusableMethods.wait(12);

        //16. Confirm that this product is no longer in the cart.

        try {
            Assert.assertFalse(testOtomasyonuMyCardPage.selectedProduct.isDisplayed(), "The product is still displayed in the cart.");
        } catch (NoSuchElementException e) {
            // If the element is not found, it means the product is not in the cart, which is the expected outcome
            Assert.assertTrue(true, "The product is not displayed in the cart, as expected.");
        }

    }
}