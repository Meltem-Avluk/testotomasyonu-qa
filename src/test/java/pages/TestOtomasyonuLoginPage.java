package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestOtomasyonuLoginPage {
    public TestOtomasyonuLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='email']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@id='submitlogin']")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@id='global-search']")
    public WebElement searchArea;

    @FindBy(xpath = "(//button[@class='button search-button'])[1]")
    public WebElement searchButton;


}
