// Bu class'in gorevi;
// Test method'larinda ihtiyac duyulan TEST DATALARI'ni
// configuration.properties dosyasinda bulup, test method'una getirmek



package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;

    static {// static block runs first

        String filePath= "configuration.properties";
        try {

            FileInputStream fis= new FileInputStream(filePath);
            properties= new Properties();
            properties.load(fis);


        } catch (IOException e) {
            System.out.println("can not readed properties file");
        }
    }

    public static String getProperty(String key){

        return properties.getProperty(key);

    }


}
