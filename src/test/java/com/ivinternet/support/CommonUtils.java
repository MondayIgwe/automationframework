package com.ivinternet.support;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {

    public static String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        return simpleDateFormat.format(new Date());
    }

    public static String getSystemProperty(String key) {
        return System.getProperty("user.dir") + "\\" + key +"\\";
    }

    public static void captureScreenshot(WebDriver driver, String testname) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File target = new File(getSystemProperty("screenshots") + testname + ".png");
        FileUtils.copyFile(source,target);
        System.out.println("SCREENSHOT CAPTURED");
    }
}
