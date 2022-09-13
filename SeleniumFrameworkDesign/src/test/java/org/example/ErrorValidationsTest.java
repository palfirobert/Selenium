package org.example;

import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.ProductCataloguePage;
import TestComponents.BaseTest;
import TestComponents.Retry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidationsTest extends BaseTest {

    @Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
    public void submitOrder() {
        logInPage.logIn("palfi.robert14@yahoo.com","Robertpalfi151");
        String toastMessage= logInPage.getErrorMessage();
        Assert.assertEquals(toastMessage,"Incorrect email or password.");


    }

    @Test(dependsOnMethods = {"submitOrder"})
    public void productErrorValidation()
    {   logInPage.clearInput();
        logInPage.logIn("palfi.robert14@yahoo.com","Robertpalfi15");
        ProductCataloguePage productCataloguePage= new ProductCataloguePage(driver);
        productCataloguePage.addElementToCart("ZARA COAT 3");


        CartPage cartPage=productCataloguePage.goToCart();

        cartPage.verifyTheCart("ZARA COAT 3");

    }
}
