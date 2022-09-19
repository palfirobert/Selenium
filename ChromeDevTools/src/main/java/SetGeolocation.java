import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;

import java.util.HashMap;
import java.util.Map;

public class SetGeolocation {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeDriver driver=new ChromeDriver();


        DevTools devTools=driver.getDevTools();
        devTools.createSession();
        Map<String,Object>coordinates=new HashMap<>();
        coordinates.put("latitude",40);
        coordinates.put("longitude",3);
        coordinates.put("accuracy",1);

        driver.executeCdpCommand("Emulation.setGeolocationOverride",coordinates);
        driver.get("https://google.com");
        Thread.sleep(1000);
        WebElement popup=driver.findElement(By.id("CXQnmb"));


        popup.findElement(By.xpath("(//div[contains(text(),'Acc')])[2]")).click();
        driver.findElement(By.name("q")).sendKeys("Netflix", Keys.ENTER);
        driver.findElements(By.cssSelector(".LC20lb")).get(0).click();



    }
}
