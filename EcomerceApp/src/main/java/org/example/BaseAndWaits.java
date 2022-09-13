package org.example;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class BaseAndWaits {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        String[] productName = {"Cucumber", "Brocolli"};
        List<String> productList = Arrays.asList(productName);
        int j = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (j < productList.size()) {
                driver.findElement(By.xpath("//h4[contains(text(),'" + productList.get(i) + "')]/following-sibling::div[@class='product-action']/button")).click();
                j++;
            } else
                break;
        }
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
        driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("promoBtn")).click();
        //explicit wait

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
        Assert.assertEquals(driver.findElement(By.cssSelector(".promoInfo")).getText(),"Code applied ..!");

    }
}
