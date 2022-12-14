package com.ultimateqa.courses.testsuite;


import com.ultimateqa.courses.customlisteners.CustomListeners;
import com.ultimateqa.courses.pages.LoginPage;
import com.ultimateqa.courses.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {

        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity","regression"})
    public void userShouldNavigateToLoginPageSuccessfully() {
        loginPage.clickOnSignInLink();
        String expectedText = "Welcome Back!";
        String actualText = loginPage.getWelcomeMessage();
        Assert.assertEquals(actualText, expectedText, "correct text");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyTheErrorMessage() {
        loginPage.clickOnSignInLink();
        loginPage.enterUsername("test123@gmail.com");
        loginPage.enterPassword("test123");
        loginPage.clickonsignInButton();
        String expectedText = "Invalid email or password.";
        String actualText = loginPage.getErrorMessage();
        Assert.assertEquals(actualText, expectedText, "correct text");
    }


}
