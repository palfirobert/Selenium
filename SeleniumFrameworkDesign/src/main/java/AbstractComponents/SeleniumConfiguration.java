package AbstractComponents;

import PageObjects.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumConfiguration {
    WebDriver driver;
    protected static List<WebElement> productsAddedInCart;

    public SeleniumConfiguration(WebDriver webDriver)
    {
        this.driver=webDriver;

    }
    public void waitForElementToAppear(By selector)
    {WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public void waitForElementToDisappear(By selector)
    {  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(selector));
    }
    @FindBy(xpath = "(//li/button)[3]")
    WebElement cart;

    @FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
    WebElement orders;

    public CartPage goToCart()
    {
        cart.click();
        return new CartPage(driver);
    }

}
