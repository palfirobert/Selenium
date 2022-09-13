package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocator {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement element=driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(element)).getText());
        element.sendKeys("hello");
        File file=element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("C:\\Java\\Selenium\\EcomerceApp\\src\\main\\Files\\logo.png"));

    }
}
