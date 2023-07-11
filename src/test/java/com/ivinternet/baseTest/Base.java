package com.ivinternet.baseTest;

import com.ivinternet.page.SigupPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static constants.ICommonData.EMAIL;
import static constants.ICommonData.URL;

public class Base extends DriverManager {

    public static WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = getDriver("chrome");
        SigupPage sigupPage = new SigupPage(driver);
        sigupPage.setEmailid(EMAIL);

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
