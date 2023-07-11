package com.ivinternet.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    // Page object model or Page Factory model
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    @FindBy(name="uid")
    WebElement username;
    @FindBy(name="password")
    WebElement pass;
    private @FindBy(name = "btnLogin")
    WebElement loginBtn;

    public void loginProcess(String user, String passcode){
        username.sendKeys(user);
        pass.sendKeys(passcode);
        loginBtn.click();
    }
}
