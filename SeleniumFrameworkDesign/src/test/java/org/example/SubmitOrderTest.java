package org.example;

import PageObjects.*;
import TestComponents.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {

    @Test(dataProvider = "getData",groups = {"Purchase"})
    public void submitOrder(HashMap<String,String> input)
    {
        logInPage.logIn(input.get("email"),input.get("password"));
        ProductCataloguePage productCataloguePage= new ProductCataloguePage(driver);
        productCataloguePage.addElementToCart(input.get("productName"));


        CartPage cartPage=productCataloguePage.goToCart();

        cartPage.verifyTheCart(input.get("productName"));

        CheckoutPage checkoutPage=cartPage.goToCheckout();

        checkoutPage.addCountry("Romania");
        checkoutPage.submitCheckout();

    }

    @Test()
    public void OrderHistoryTest() throws InterruptedException {   Thread.sleep(2000);
        String productCode=driver.findElement(By.className("ng-star-inserted")).getText();
        OrdersPage ordersPage=new OrdersPage(driver);
        ordersPage.CheckProductDisplayed(productCode);

    }

//    @DataProvider
//    public Object[][] getData() throws IOException {
//        List<HashMap<String, String>>data=getJsonDataToMap();
//        return new Object[][]{{"palfi.robert14@yahoo.com","Robertpalfi15","ZARA COAT 3"},{"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
//    }


    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>>data=getJsonDataToMap();
        return new Object[][]{{data.get(0)},{data.get(1)}};
    }


}
