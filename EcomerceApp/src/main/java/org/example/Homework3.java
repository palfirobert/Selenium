package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Homework3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> windows=driver.getWindowHandles();//[parentId,childID]
        Iterator<String> iterator=windows.iterator();
        String parentId=iterator.next();
        String childId= iterator.next();
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector(".example")).getText());
        driver.switchTo().window(parentId);
        System.out.println(driver.findElement(By.xpath("//div//h3")).getText());
    }
}
