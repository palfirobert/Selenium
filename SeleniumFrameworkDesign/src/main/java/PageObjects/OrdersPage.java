package PageObjects;
import org.junit.Assert;
import AbstractComponents.SeleniumConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class OrdersPage extends SeleniumConfiguration {
    WebDriver driver;

    public OrdersPage(WebDriver webDriver)
    {
        super(webDriver);
        this.driver=webDriver;
        PageFactory.initElements(driver,this);
    }

    public void CheckProductDisplayed(String code)
    {
        List<WebElement>products=driver.findElements(By.className("ng-star-inserted"));
        if(products.stream().filter(s->s.getText().contains(code)).collect(Collectors.toList()).size()==0)
            Assert.assertTrue(false);
    }
}
