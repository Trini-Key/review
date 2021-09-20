package com.udacity.jwdnd.c1.review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {

    @FindBy(id = "messageText")
    private WebElement messageField;

    @FindBy(id = "messageType")
    private WebElement messageTypeSelector;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    @FindBy(id = "logout")
    private WebElement logoutLink;

    public ChatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setMessageField(String string) {
        messageField.sendKeys(string);
    }

    public void sendMessage() {
        submitButton.click();
    }

    public void logout() {
        logoutLink.click();
    }
}
