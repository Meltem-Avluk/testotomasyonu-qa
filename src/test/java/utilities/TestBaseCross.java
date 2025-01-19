package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBaseCross {



        protected WebDriver driver;
        @Parameters("toUseBrowser")
        @BeforeMethod
        public void setUp(@Optional String toUseBrowser){
            driver= DriverCross.getDriver(toUseBrowser);
        }
        @AfterMethod
        public void tearDown(){
            DriverCross.quitDriver();
        }

}
