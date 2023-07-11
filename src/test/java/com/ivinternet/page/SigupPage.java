package com.ivinternet.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static constants.ICommonData.URL;


public class SigupPage {

    WebDriver driver;

    public SigupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private @FindBy(name = "emailid")
    WebElement emailid;
    private @FindBy(name = "btnLogin")
    WebElement loginBtn;

    public static String userID;
    public static String passID;
    private @FindBy(xpath = "//tr/td[contains(text(),'User ID')]/following-sibling::*") WebElement userId;
    private @FindBy(xpath = "//tr/td[contains(text(),'Password')]/following-sibling::*") WebElement passId;

    public void setEmailid(String email) throws InterruptedException {
        emailid.sendKeys(email);
        loginBtn.click();

        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.guru99.com/access.php?uid=mngr514323%20&%20pass=EgUhyhU%20&%20email=sam@gmail.com");


        // get credentials
        if (userId != null) {
            userID = userId.getText();
        }
        if (passId != null) {
            passID = passId.getText();

        }

        // navigate to login page
        driver.get(URL + "v4");
        Thread.sleep(5000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.guru99.com/v4/");
    }
}
