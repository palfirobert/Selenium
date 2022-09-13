package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.util.List;

public class Scroll {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //Scroll
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");

        //Grid
        List<WebElement>elements=driver.findElements(By.xpath("//div/table/tbody/tr"));
        int size=driver.findElements(By.xpath("//div/table/tbody/tr")).size();
        int sum=0;

        for(int i=1;i<size;i++)
        {
            String stringNumber=driver.findElement(By.xpath("//div/table/tbody/tr["+i+"]/td[4]")).getText();
            int number=Integer.parseInt(stringNumber);
            sum=sum+number;
        }
        String totalAmount=driver.findElement(By.className("totalAmount")).getText();
        String[]str=totalAmount.split(" ");
        Assert.assertEquals(Integer.parseInt(str[3]),sum);


    }
}
