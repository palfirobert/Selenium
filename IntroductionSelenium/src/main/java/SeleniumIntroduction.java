import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class SeleniumIntroduction {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Java\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();//closes the last window opened
        driver.quit();//closes every single window open by the driver
    }


}
