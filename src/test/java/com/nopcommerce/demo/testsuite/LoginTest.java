package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.TestBase;
import com.nopcommerce.demo.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Jay
 */
public class LoginTest extends TestBase {

    private static String email = "test" + Utility.generateRandomNumber() + "yahoo.com";

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();


    @Test
    public void verifyUserShouldNavigateToLoginPage(){
        homePage.clickOnLoginLink();
        String expectedMessage = "Welcome, Please Sign In";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void verifyUserShouldNotLoginWithInvalidCredentials(){
        homePage.clickOnLoginLink();
        loginPage.enterEmailId(email);
        loginPage.enterPassword("Abc123");
        loginPage.clickOnLoginButton();
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
