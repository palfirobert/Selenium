package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.className("blinkingText")).click();
        Set<String>windows=driver.getWindowHandles();//[parentId,childID]
        Iterator<String>iterator=windows.iterator();
        String parentId=iterator.next();
        String childId= iterator.next();

        driver.switchTo().window(childId);//driverul se muta la a doua pagina
        String email=driver.findElement(By.xpath("//strong/a")).getText();
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(email);
    }
}
