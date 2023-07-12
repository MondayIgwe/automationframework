package com.ivinternet.testCases;

import com.ivinternet.baseTest.Base;
import com.ivinternet.page.LoginPage;
import static com.ivinternet.page.SigupPage.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
    Think forward, backward, upward, downward
 */
public class LoginTest extends Base {

    LoginPage loginPage;
    @BeforeMethod
    public void init(){
        logger.info("login Test");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTestRun(){
        // AAA Pattern
        loginPage.loginProcess(userID, passID);
        Assert.assertTrue(true);
    }
}
