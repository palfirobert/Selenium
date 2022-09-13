package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.JsonOutput;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VerifyTableWithStreams {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.className("sort-icon")).click();

        List<WebElement>webElementsFromTabel=driver.findElements(By.xpath("//tbody/tr/td[1]"));

        List<String>elements=webElementsFromTabel.stream().map(s->s.getText()).collect(Collectors.toList());

        List<String>sortedElements=new ArrayList<>(elements);
        Assert.assertEquals(elements,sortedElements.stream().sorted().collect(Collectors.toList()));
        List<String> price;
        do {
            List<WebElement>elementsOnPage=driver.findElements(By.xpath("//tbody/tr/td[1]")); //aici daca nu dadeam referesh dadea stale element fiindca nu mai gasea pe pagina acea lista
            price = elementsOnPage.stream().filter(element -> element.getText().equals("Rice")).map(element -> getPrice(element))
                    .collect(Collectors.toList());
            if(price.size()==0)
                driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
        }while(price.size()==0);
    }

    public static String getPrice(WebElement element)
    {
         return element.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
