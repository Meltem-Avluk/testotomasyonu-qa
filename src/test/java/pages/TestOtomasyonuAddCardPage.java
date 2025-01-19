package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestOtomasyonuAddCardPage {

    public TestOtomasyonuAddCardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "(//a[@class=\"prod-title mb-3 \" ])[3]")
    public WebElement product;

    @FindBy (xpath = "//button[@class='btn-add-to-wishlist d-flex justify-content-center']")
    public WebElement likeButton;

    @FindBy(xpath = "(//*[@class='menu-icon-text'])[2]")
    public  WebElement wishListButton;

    @FindBy(xpath = "//*[@class='button-purple btn-sm ']")
    public WebElement buyNow;

    @FindBy(xpath = "//*[@class='add-to-cart']")
    public WebElement addCartButton;


}
