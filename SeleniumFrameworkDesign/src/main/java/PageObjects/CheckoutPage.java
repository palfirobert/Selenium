package PageObjects;

import AbstractComponents.SeleniumConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends SeleniumConfiguration {
    WebDriver driver;

    public CheckoutPage(WebDriver webDriver)
    {
        super(webDriver);
        this.driver=webDriver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".details__user input:nth-child(1)")
    WebElement countryInput;

    @FindBy(className ="action__submit" )
    WebElement submitButton;

    public void addCountry(String countryName)
    {
        Actions a=new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector(".details__user input:nth-child(1)")),countryName).build().perform();
        waitForElementToAppear(By.cssSelector(".ta-results"));
        driver.findElement(By.className("ta-item")).click();
    }

    public void submitCheckout()
    {
        submitButton.click();
    }


}
