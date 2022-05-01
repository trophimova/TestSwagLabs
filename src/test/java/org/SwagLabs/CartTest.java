package org.SwagLabs;

import org.junit.Assert;
import org.junit.jupiter.api.*;


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
        Assert.assertEquals(nameTitle, "PRODUCTS");

        mainPage
                .clickAddToCartBackpack()
                .cart()
                .getCountCart();

        String countCart = mainPage.getCountCart();

        Assert.assertEquals(countCart, "1");

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
        Assert.assertEquals(nameTitle, "PRODUCTS");

        mainPage
                .clickAddToCartBackpack()
                .cart()
                .getCountCart();


        String countCart = mainPage.getCountCart();

        Assert.assertEquals(countCart, "1");

        mainPage
                .clickAddToCartBikeLight()
                .getCountCart();

       countCart = mainPage.getCountCart();
        Assert.assertEquals(countCart, "2");

        mainPage
                .removeBackpackVisibility()
                .clickRemoveBackpack()
                .getCountCart();

       countCart = mainPage.getCountCart();
        Assert.assertEquals(countCart, "1");

        Thread.sleep(1000l);

    }
}
