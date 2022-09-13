package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Homework2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();
        driver.findElement(By.className("form-control")).click();
        driver.findElement(By.xpath("//div/select/option[3]")).click();
        driver.findElement(By.cssSelector("#terms")).click();
        driver.findElement(By.id("signInBtn")).click();
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-primary")));
        List elements = driver.findElements(By.xpath("//h4"));

        for (int i = 1; i <= elements.size(); i++) {
            driver.findElement(By.xpath("(//app-card/div/div/button)[" + i + "]")).click();
        }

        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector(".btn-success")).click();
        driver.findElement(By.id("country")).sendKeys("Romania");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".suggestions")));
        driver.findElement(By.cssSelector(".suggestions")).click();
        driver.findElement(By.xpath("//div/div[2]/label")).click();
        driver.findElement(By.cssSelector(".btn-lg")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div/div/strong")).getText(),"Success!");

    }
}
