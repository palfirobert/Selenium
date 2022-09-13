package PageObjects;

import AbstractComponents.SeleniumConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ProductCataloguePage extends SeleniumConfiguration {
    WebDriver driver;

    public ProductCataloguePage(WebDriver webDriver)
    {
        super(webDriver);
        this.driver=webDriver;
        PageFactory.initElements(driver,this);
        waitForElementToAppear(By.xpath("//h5"));
    }

    @FindBy(xpath ="//h5")
    List<WebElement>products;



    public void addElementToCart(String nameOfElement)
    {
        try{
            productsAddedInCart=products.stream().filter(s->s.getText().contains(nameOfElement)).collect(Collectors.toList());
            productsAddedInCart.stream().forEach(s->addToCart(s));
            waitForElementToAppear(By.id("toast-container"));
            waitForElementToDisappear(By.id("toast-container"));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void addToCart(WebElement element)
    {
        element.findElement(By.xpath("following-sibling::button[2]")).click();

    }

}
