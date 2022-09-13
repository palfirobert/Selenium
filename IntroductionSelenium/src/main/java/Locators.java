import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    WebElement username,password;
    public static void main(String[] args) throws InterruptedException {
        WebElement username,password;
        System.setProperty("webdriver.chrome.driver","C:\\Java\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));   //asteapta 3 secunde sa apara elemente Ui dupa
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        username=driver.findElement(By.id("inputUsername"));
        username.sendKeys("Nu ma bate ca ma doare");
        password=driver.findElement(By.name("inputPassword"));
        password.sendKeys("milbei");
        driver.findElement(By.className("submit")).click();
        String errorMessage=driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println(errorMessage);
        //tagul din hmtl e cel dupa <  ex: <p id="dsds"  -aici este p
        //pentru css selector se foloseste tag.classname/ tagname#id
        //in html un link are tagul <a de la anchor
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Palfi Robert");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("palfi.robert14@yahoo.com");
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).clear();
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("palfi.robert14@yahoo.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("0723211123");
        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.className("go-to-login-btn")).click();

        //login
        username.sendKeys("palfi.robert14@yahoo.com");
        password.sendKeys("rahulshettyacademy");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();


    }
}
