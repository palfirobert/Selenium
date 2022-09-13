package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // 1. number of links on the page
        List<WebElement>links=driver.findElements(By.tagName("a"));
        int numberOfLinks=links.size();
        System.out.println(numberOfLinks);

        //2. Number links on a specific scope

        System.out.println(driver.findElements(By.xpath("//table/tbody/tr/td/ul/li")).size());

        //OR

        WebElement footDriver=driver.findElement(By.id("gf-BIG"));
        System.out.println(footDriver.findElements(By.tagName("a")).size());

        // 3. Number of links in the first column of the scope
        WebElement firstColumnDriver= footDriver.findElement(By.xpath("(//table/tbody/tr/td/ul)[1]"));
        System.out.println(firstColumnDriver.findElements(By.tagName("a")).size());

        // 4. Click on the links and open them in a new page
        for(int i=0;i<firstColumnDriver.findElements(By.tagName("a")).size();i++)
        {
            String clickOnLinkTab= Keys.chord(Keys.CONTROL,Keys.ENTER);
            firstColumnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
        }
        Thread.sleep(4000);
        Set<String> windows=driver.getWindowHandles();//[parentId,childID]
        Iterator<String> iterator=windows.iterator();
        String mainPage=iterator.next();
        while(iterator.hasNext())
        {
            driver.switchTo().window(iterator.next());
            System.out.println(driver.getTitle());
        }
    }
}
