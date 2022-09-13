import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxes {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
        System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
        verifyIfCalendarIsEnabled(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

        verifyIfCalendarIsEnabled(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"));
    }

    public static void verifyIfCalendarIsEnabled(boolean styleValue) {
        if (styleValue == true)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
