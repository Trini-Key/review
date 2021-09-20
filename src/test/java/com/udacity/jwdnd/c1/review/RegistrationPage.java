package com.udacity.jwdnd.c1.review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    @FindBy(id = "inputFirstName")
    private WebElement inputFirstNameField;

    @FindBy(id = "inputLastName")
    private WebElement inputLastNameField;

    @FindBy(id = "inputUsername")
    private WebElement inputUsernameField;

    @FindBy(id = "inputPassword")
    private WebElement inputPasswordField;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setInputUsernameField(String string){
        inputUsernameField.sendKeys(string);
    }

    public void setInputFirstNameField(String string){
        inputFirstNameField.sendKeys(string);
    }

    public void setInputLastNameField(String string){
        inputLastNameField.sendKeys(string);
    }

    public void setInputPasswordField(String string){
        inputPasswordField.sendKeys(string);
    }

    public void signUp() {
        submitButton.click();
    }
}

