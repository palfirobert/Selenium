package PageObjects;

import AbstractComponents.SeleniumConfiguration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends SeleniumConfiguration {
    WebDriver driver;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public void verifyTheCart(String productName)
    {   waitForElementToAppear(By.cssSelector(".cartSection h3"));
        List<WebElement> elementsInTheCart=driver.findElements(By.cssSelector(".cartSection h3"));
        boolean match=elementsInTheCart.stream().anyMatch(elementInTheCart->elementInTheCart.getText().equals(productName));
        Assert.assertTrue(match);
    }
    @FindBy(css =".totalRow button")
    WebElement checkoutButton;

    public CheckoutPage goToCheckout()
    {
        checkoutButton.click();
        return new CheckoutPage(driver);
    }

}
