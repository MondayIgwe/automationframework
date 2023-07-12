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
    @FindBy(name = "btnLogin")
    WebElement loginBtn;

    // hOW - BUSINESS LOGIC - ACTIONS - IMPLEMENTATION - DO IT - PRACTICAL
    public void loginProcess(String user, String passcode){
        username.click();
        username.sendKeys(user);
        pass.click();
        pass.sendKeys(passcode);
        loginBtn.click();
    }
}
