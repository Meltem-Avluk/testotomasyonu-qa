package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    // Driver class will be the class where we will create the WebDriver object
    // and make the necessary settings

    // Whichever browser is selected from the target configuration properties
    // To create a class that will create that browser for us

    // In the Driver class, is  created getDriver() which  returns us the driver object.

    private Driver(){

    }

    public static WebDriver driver;

    public static WebDriver getDriver(){

        if (driver == null){
            String selectBrowser = ConfigReader.getProperty("browser"); // chrome

            switch (selectBrowser){

                case "firefox" :
                    driver = new FirefoxDriver();
                    break;

                case "edge" :
                    driver = new EdgeDriver();
                    break;

                case "safari" :
                    driver = new SafariDriver();
                    break;

                default:
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        }

        return driver;

    }


    public static void quitDriver(){
        driver.quit();
        driver =null;
    }
}
