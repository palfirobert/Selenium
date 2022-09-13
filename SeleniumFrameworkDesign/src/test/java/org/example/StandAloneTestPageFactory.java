package org.example;

import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.LogInPage;
import PageObjects.ProductCataloguePage;
import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StandAloneTestPageFactory {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //explicit wait
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));

        LogInPage logInPage=new LogInPage(driver);
        logInPage.goTo("https://rahulshettyacademy.com/client");
        logInPage.logIn("palfi.robert14@yahoo.com","Robertpalfi15");


        ProductCataloguePage productCataloguePage= new ProductCataloguePage(driver);
        productCataloguePage.addElementToCart("ZARA COAT 3");


        CartPage cartPage=productCataloguePage.goToCart();

        cartPage.verifyTheCart("ZARA COAT 3");

        CheckoutPage checkoutPage=cartPage.goToCheckout();

        checkoutPage.addCountry("Romania");
        checkoutPage.submitCheckout();
    }
}
