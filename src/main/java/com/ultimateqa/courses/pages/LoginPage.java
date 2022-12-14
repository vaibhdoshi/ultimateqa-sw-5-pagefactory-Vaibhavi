package com.ultimateqa.courses.pages;

import com.ultimateqa.courses.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage extends Utility {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Sign In']")
    WebElement signInLink ;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Welcome Back!']")
    WebElement welcomeMessage ;

    @CacheLookup
    @FindBy(id = "user[email]")
    WebElement usernameField ;

    @CacheLookup
    @FindBy(id = "user[password]")
    WebElement passwordField ;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Sign in']")
    WebElement signInButton ;

    @CacheLookup
    @FindBy(xpath = "//div[@id='notice']//ul[1]//li[1]")
    WebElement errorMessage ;

    public void clickOnSignInLink() {
        Reporter.log("Clicking on sign in link" +signInLink.toString());
        clickOnElement(signInLink);
    }

    public String getWelcomeMessage() {
        Reporter.log("Get welcome message" +welcomeMessage.toString());
        return getTextFromElement(welcomeMessage);

    }

    public void enterUsername(String username) {
        Reporter.log("Enter username " + username + " to username field " + usernameField.toString());
        sendTextToElement(usernameField, username);
    }

    public void enterPassword(String password) {
        Reporter.log("Enter password" + password + "to password field " + passwordField.toString());
        sendTextToElement(passwordField, password);
    }

    public void clickonsignInButton(){
        Reporter.log("Clicking on signin button" +signInButton.toString());
        clickOnElement(signInButton);
    }

    public String getErrorMessage(){
        Reporter.log("Get user error message" +errorMessage.toString());
        return getTextFromElement(errorMessage);
    }
}
