package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.id("search-field")).sendKeys("Rice");
        List<WebElement>elementSearched=driver.findElements(By.xpath("//tr/td[1]"));
        List<String>element=elementSearched.stream().filter(s->s.getText().contains("Rice")).map(s->s.getText()).collect(Collectors.toList());
        Assert.assertEquals(element.get(0),"Rice");
    }
}
