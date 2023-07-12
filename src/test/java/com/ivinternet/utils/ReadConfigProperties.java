package com.ivinternet.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigProperties {
    static Properties properties;
    public static String URL;
    public static String EMAIL;
    static File sourcePropertiesFile = new File("src/test/resources/config.properties");

    public static void getPropertyData() {
        FileInputStream fileInputStream;
        properties = new Properties();
        try {
            fileInputStream = new FileInputStream(sourcePropertiesFile);
            try {
                properties.load(fileInputStream);
                URL = properties.getProperty("baseurl");
                EMAIL = properties.getProperty("emailaddress");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
