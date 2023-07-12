package com.ivinternet.baseTest;

import com.ivinternet.utils.ReadConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static com.ivinternet.utils.ReadConfigProperties.URL;
import java.util.concurrent.TimeUnit;


public class DriverManager extends ReadConfigProperties {
    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                System.out.println("default browser");
        }
        getPropertyData();

        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
}
