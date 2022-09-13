package org.example;

import com.google.gson.internal.bind.util.ISO8601Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class StandAloneTest {
    public static void main(String[] args) throws InterruptedException {
        //setup
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        //explicit wait
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));

        //Automotion LoginPage
        driver.findElement(By.id("userEmail")).sendKeys("palfirobert14@yahoo.com");
        driver.findElement(By.id("userPassword")).sendKeys("Robertpalfi15");
        driver.findElement(By.id("login")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5")));

        //Automotion StorePage
        List<WebElement>products=driver.findElements(By.xpath("//h5"));
        List<WebElement>productsAddedInCart=products.stream().filter(s->s.getText().contains("ZARA COAT 3")).collect(Collectors.toList());
        productsAddedInCart.stream().forEach(s->addToCart(s));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));

        //Go to the cart
        driver.findElement(By.xpath("(//li/button)[3]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));

        //Verify the cart
        List<WebElement>elementsInTheCart=driver.findElements(By.cssSelector(".cartSection h3"));
        boolean match=elementsInTheCart.stream().anyMatch(elementInTheCart->elementInTheCart.getText().equals("ZARA COAT 3"));
        Assert.assertTrue(match);
        driver.findElement(By.cssSelector(".totalRow button")).click();

        //Checkout
        Actions a=new Actions(driver);

        a.sendKeys(driver.findElement(By.cssSelector(".details__user input:nth-child(1)")),"Romania").build().perform();
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.className("ta-item")).click();
        driver.findElement(By.className("action__submit")).click();

    }

   public static void addToCart(WebElement element)
   {
       element.findElement(By.xpath("following-sibling::button[2]")).click();

   }
}
