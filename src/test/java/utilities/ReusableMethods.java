package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static void wait(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }



    public static void wholePageScreenshot(WebDriver driver){

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dateSigned = ldt.format(dateFormat);

        // 1.TakeScreenshot object
        TakesScreenshot tss = (TakesScreenshot) driver;


        // 2. extent file as jpg, jpeg, png
        //   file path  target/screenshots

        File wholePageScreenshot = new File("target/screenshots/screen"+dateSigned+".png");

        // 3.Screenshot Whole Page

        File temporaryFile = tss.getScreenshotAs(OutputType.FILE);

        // 4.Pass the temporaryFile to realPage

        try {
            FileUtils.copyFile(temporaryFile,wholePageScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void wholePageScreenshot(WebDriver driver, String reportName) {
        // 1.Create TakeScreenshot object
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.Creates got screenshot to filepath
        File wholePageScreenshot = new File("target/screenshots/"+reportName+".png");

        // 3. take a photo of the page and upload it to a temporary file.
        File temporaryFile = tss.getScreenshotAs(OutputType.FILE);

        // 4.Pass the temporaryFile to realPage
        try {
            FileUtils.copyFile(temporaryFile,wholePageScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void webElementScreenshot(WebElement screenShotWebElement){

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dateSigned = ldt.format(dateFormat);


        File webElementSS = new File("target/screenshots/webElementSS"+dateSigned+".png");


        File geciciDosya = screenShotWebElement.getScreenshotAs(OutputType.FILE);


        try {
            FileUtils.copyFile(geciciDosya,webElementSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

}
