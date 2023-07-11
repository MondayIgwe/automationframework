package com.ivinternet.testdata;

import com.ivinternet.baseTest.Base;
import com.ivinternet.page.LoginPage;
import com.ivinternet.page.SigupPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Base {

    LoginPage loginPage;
    @BeforeMethod
    public void init(){
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTestRun(){
        loginPage.loginProcess(SigupPage.userID, SigupPage.passID);
    }
}
