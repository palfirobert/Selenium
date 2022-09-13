
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Locators2 {
    public static void main(String[] args) throws InterruptedException {
        WebElement username, password;
        System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));   //asteapta 3 secunde sa apara elemente Ui dupa, nu merge daca cauta, un element din alta pagina cu aceeasi tag
        String pw = getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        username = driver.findElement(By.id("inputUsername"));
        username.sendKeys("palfirobert");
        password = driver.findElement(By.name("inputPassword"));
        password.sendKeys(pw);
        driver.findElement(By.className("submit")).click();

        Thread.sleep(1000);
        String loginMessage = driver.findElement(By.tagName("p")).getText();
        String helloMessage = driver.findElement(By.cssSelector("h2")).getText();
        Assert.assertEquals(loginMessage, "You are successfully logged in.");
        Assert.assertEquals(helloMessage, "Hello palfirobert,");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Log Out']")).click(); // sau //*[text()='Log Out']

        driver.close();
    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();
        String[] passwordArray = passwordText.split("'");
        return passwordArray[1].split("'")[0];

    }

}
