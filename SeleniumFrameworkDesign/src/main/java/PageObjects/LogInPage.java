package PageObjects;

import AbstractComponents.SeleniumConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends SeleniumConfiguration {

    WebDriver driver;

    public LogInPage(WebDriver webDriver)
    {
        super(webDriver);
        this.driver=webDriver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement userPassword;

    @FindBy(id="login")
    WebElement login;
    @FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
    WebElement toastMessage;

    public void logIn(String email,String password)
    {
         userEmail.sendKeys(email);
        userPassword .sendKeys(password);
        login.click();

    }

    public void goTo(String url)
    {
        driver.get(url);
    }

    public String getErrorMessage()
    {
        waitForElementToAppear(By.xpath("//div[@aria-label='Incorrect email or password.']"));
        return toastMessage.getText();
    }
    public void clearInput()
    {
        userEmail.clear();
        userPassword.clear();
    }

}
