package org.SwagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends AbstractPage{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//span[@class='title']")
    private WebElement title;

    @FindBy(xpath = ".//button[@name='add-to-cart-sauce-labs-backpack']")
    private WebElement addToCartBackpack;

    @FindBy(xpath = ".//button[@name='add-to-cart-sauce-labs-bike-light']")
    private WebElement addToCartBikeLight;

    @FindBy(xpath = ".//span[@class='shopping_cart_badge']")
    private WebElement cart;

    @FindBy(xpath = ".//button[@name='remove-sauce-labs-backpack']")
    private WebElement removeBackpack;


    public MainPage title() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//span[@class='title']")));
        return this;
    }

    public MainPage cart() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//span[@class='shopping_cart_badge']")));
        return this;
    }

    public MainPage removeBackpackVisibility() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@name='remove-sauce-labs-backpack']")));
        return this;
    }

    public String getNameTitle() {
        String nameTitle = title.getText();
        return nameTitle;
    }

    public MainPage clickAddToCartBackpack() {
        addToCartBackpack.click();
        return this;
    }

    public MainPage clickAddToCartBikeLight() {
        addToCartBikeLight.click();
        return this;
    }

    public String getCountCart() {
        String countCart = cart.getText();
        return countCart;
    }

    public MainPage clickRemoveBackpack() {
        removeBackpack.click();
        return this;
    }

}
