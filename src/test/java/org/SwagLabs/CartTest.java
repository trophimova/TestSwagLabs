package org.SwagLabs;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import io.qameta.allure.*;

@Story("Тестирование функционала  корзины")
public class CartTest extends AbstractTest{

    @Test
    @DisplayName("Проверка добавления товара в корзину")
    public void addToCartTest() throws InterruptedException {

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

        mainPage
                .clickAddToCartBackpack()
                .cart()
                .getCountCart();

        String countCart = mainPage.getCountCart();

        Assertions.assertEquals(countCart, "1");

        mainPage
                .removeBackpackVisibility()
                .clickRemoveBackpack();

       Thread.sleep(1000l);

    }

    @Test
    @DisplayName("Проверка удаления товара из корзины")
    public void removeFromCartTest() throws InterruptedException {

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

        mainPage
                .clickAddToCartBackpack()
                .cart()
                .getCountCart();


        String countCart = mainPage.getCountCart();

        Assertions.assertEquals(countCart, "1");

        mainPage
                .clickAddToCartBikeLight()
                .getCountCart();

       countCart = mainPage.getCountCart();
        Assertions.assertEquals(countCart, "2");

        mainPage
                .removeBackpackVisibility()
                .clickRemoveBackpack()
                .getCountCart();

       countCart = mainPage.getCountCart();
        Assertions.assertEquals(countCart, "1");

        Thread.sleep(1000l);

    }
}
