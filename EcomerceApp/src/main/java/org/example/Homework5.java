package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Homework5 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement checkboxPanelDriver = driver.findElement(By.className("right-align"));
        int optionValue = 2;
        List<WebElement> optionsList = checkboxPanelDriver.findElements(By.tagName("label"));
        checkboxPanelDriver.findElements(By.tagName("input")).get(optionValue-1).click();
        String optionClicked=checkboxPanelDriver.findElements(By.tagName("label")).get(optionValue-1).getText();

        WebElement staticDropDown=driver.findElement(By.id("dropdown-class-example"));
        Select dropDown=new Select(staticDropDown);
        dropDown.selectByVisibleText(optionClicked);

        driver.findElement(By.id("name")).sendKeys(optionClicked);

    }

}
