package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandlingCalendar {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.path2usa.com/travel-companion/");
        driver.manage().window().maximize();

        Thread.sleep(10000);
        driver.findElement(By.id("form-field-travel_comp_date")).click();
        selectDate(2022,"October",20);


    }

    public static void selectDate(int year,String month,int day) throws InterruptedException {   String text=month+" "+day+", "+year;

        do {

        driver.findElement(By.className("flatpickr-next-month")).click();
        }while(driver.findElement(By.className("cur-month")).equals(month));
        Thread.sleep(2000);
        List<WebElement>dates=driver.findElements(By.className("flatpickr-day"));
        int size= dates.size();

        for(int i=0;i<size;i++)
        {

            if(dates.get(i).getText().contains(Integer.toString(day)))
            {
                dates.get(i).click();
                break;
            }
        }
    }
}
