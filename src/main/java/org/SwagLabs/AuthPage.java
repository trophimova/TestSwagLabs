package org.SwagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthPage extends AbstractPage{

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//input[@id='user-name']")
    private WebElement loginField;

    @FindBy(xpath = ".//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = ".//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = ".//div[@class='error-message-container error']")
    private WebElement errorMessage;



    private By errorButton = By.xpath(".//button[@class='error-button']");



    public AuthPage clicklLogin() {
        loginField.click();
        return this;
    }

    public AuthPage validLogin() {
        loginField.sendKeys("standard_user");
        return this;
    }

    public AuthPage validPassword() {
        passwordField.sendKeys("secret_sauce");
        return this;
    }

    public AuthPage invalidLogin() {
        loginField.sendKeys("test");
        return this;
    }

    public AuthPage invalidPassword() {
        passwordField.sendKeys("test");
        return this;
    }

    public AuthPage clickPassword() {
        passwordField.click();
        return this;
    }

    public AuthPage emptyPassword() {
        passwordField.sendKeys("");
        return this;
    }

    public AuthPage emptyLogin() {
        loginField.sendKeys("");
        return this;
    }

    public AuthPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public AuthPage errorButton() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(errorButton));
        return this;
    }



    public String getErrorMessage() {
        String textError = errorMessage.findElement(By.cssSelector("h3")).getText();
        return textError;
    }



}
