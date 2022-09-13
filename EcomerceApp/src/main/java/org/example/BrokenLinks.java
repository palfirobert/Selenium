package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        SoftAssert softAssert = new SoftAssert();
        //One site verify
        String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        int responseCode = conn.getResponseCode();
        System.out.println(responseCode);

        // Verify all the links
        List<WebElement> links = driver.findElements(By.xpath("//li/a"));
        for (int i = 0; i < driver.findElements(By.xpath("//li/a")).size(); i++) {
            url = links.get(i).getAttribute("href");
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            responseCode = conn.getResponseCode();
            softAssert.assertTrue(responseCode<400,url + " is broken");
        }
        softAssert.assertAll();
    }
}
