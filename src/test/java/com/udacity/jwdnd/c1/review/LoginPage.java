package com.udacity.jwdnd.c1.review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "inputUsername")
    private WebElement inputUsernameField;

    @FindBy(id = "inputPassword")
    private WebElement inputPasswordField;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    @FindBy(id = "signup-link")
    private WebElement signupLink;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setInputUsernameField(String string){
        inputUsernameField.sendKeys(string);
    }

    public void setInputPasswordField(String string){
        inputPasswordField.sendKeys(string);
    }

    public void signIn() {
        submitButton.click();
    }

    public void signUp(){
        signupLink.click();
    }
}








