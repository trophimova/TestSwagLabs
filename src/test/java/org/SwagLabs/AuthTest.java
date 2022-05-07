package org.SwagLabs;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Story("Тестирование авторизации на сайте")
public class AuthTest extends AbstractTest {

    static Logger logger = LoggerFactory.getLogger(AuthTest.class);

    @Test
    @DisplayName("Проверка авторизации c пустым полем Password")
    @Link("https://www.saucedemo.com")
    public void passwordEmptyFieldTest() throws InterruptedException {

        logger.info("Тест на проверку авторизации с пустым полем Password запущен");

        AuthPage authPage = new AuthPage(getDriver());

        authPage
                .clicklLogin()
                .validLogin()
                .clickPassword()
                .emptyPassword()
                .clickLoginButton()
                .errorButton()
                .getErrorMessage();

        String textError = authPage.getErrorMessage();

       Assertions.assertEquals(textError, "Epic sadface: Password is required");

        logger.info("Тест на проверку авторизации с пустым полем Password закончен");
        Thread.sleep(1000l);

    }

    @Test
    @DisplayName("Проверка авторизации c пустым полем Username")
    public void userNameEmptyFieldTest() throws InterruptedException {


        AuthPage authPage = new AuthPage(getDriver());

        authPage
                .clicklLogin()
                .emptyLogin()
                .clickPassword()
                .validPassword()
                .clickLoginButton()
                .errorButton()
                .getErrorMessage();

        String textError = authPage.getErrorMessage();

        Assertions.assertEquals(textError, "Epic sadface: Username is required");
        Thread.sleep(1000l);

    }

    @Test
    @DisplayName("Проверка авторизации с валидными данными")
    public void validAuthTest() throws InterruptedException {

        AuthPage authPage = new AuthPage(getDriver());
        MainPage mainPage = new MainPage(getDriver());

        authPage
                .clicklLogin()
                .validLogin()
                .clickPassword()
                .validPassword()
                .clickLoginButton();

        mainPage
                .title()
                .getNameTitle();


        String nameTitle = mainPage.getNameTitle();
        Assertions.assertEquals(nameTitle, "PRODUCTS");
        Thread.sleep(1000l);

    }

    @Test
    @DisplayName("Проверка авторизации с невалидными данными")
    public void invalidAuthTest() throws InterruptedException {

        AuthPage authPage = new AuthPage(getDriver());

        authPage
                .clicklLogin()
                .invalidLogin()
                .clickPassword()
                .invalidPassword()
                .clickLoginButton()
                .errorButton()
                .getErrorMessage();


        String textError = authPage.getErrorMessage();

        Assertions.assertEquals(textError, "Epic sadface: Username and password do not match any user in this service");
        Thread.sleep(1000l);

    }

}


























