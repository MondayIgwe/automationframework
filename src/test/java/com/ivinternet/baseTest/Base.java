package com.ivinternet.baseTest;

import com.ivinternet.page.SigupPage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Base extends DriverManager {

    public static WebDriver driver;
    public static Logger logger;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void setUp(@Optional String browser, String url) throws InterruptedException {
        driver = getDriver(browser);
        SigupPage sigupPage = new SigupPage(driver);
        sigupPage.setEmailid(EMAIL, url);

        logger = Logger.getLogger("ebanking automation");
        PropertyConfigurator.configure("log4j.properties");
    }

    @AfterClass
    public void tearDown() {
        logger.info("Tear down");
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
