package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestOtomasyonuMyCardPage {

    public TestOtomasyonuMyCardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@class='e-cart'])[2]")
    public WebElement myCardButton;

    @FindBy(xpath = "//button[@class='remove']")
    public WebElement removeButton;

    @FindBy(xpath = "//button[@class='swal2-confirm swal2-styled swal2-default-outline']")
    public WebElement confirmRemoveButton;

    @FindBy(xpath = "//a[@class='product-title text-center']")
    public WebElement selectedProduct;
}
