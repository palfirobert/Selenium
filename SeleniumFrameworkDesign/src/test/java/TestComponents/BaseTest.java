package TestComponents;

import PageObjects.LogInPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    protected LogInPage logInPage;

    public WebDriver initializeDriver() throws IOException {

        //Choose the browser
        Properties properties=new Properties();
        FileInputStream file=new FileInputStream("C:\\Java\\Selenium\\SeleniumFrameworkDesign\\src\\main\\java\\Resources\\GlobalData");
        properties.load(file);
        String browserName=properties.getProperty("browser");

        switch (browserName)
        {
            case "chrome":
                // Headless mode
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                //firefox driver
                break;
            case "edge":
                //edge driver
                break;
            case "chromeHeadless":
                ChromeOptions options=new ChromeOptions();
                options.addArguments("headless");
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver(options);
                driver.manage().window().setSize(new Dimension(1440,990));
                break;
        }


        //explicit wait
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void launchApplication() throws IOException {   driver=initializeDriver();
        logInPage=new LogInPage(driver);
        logInPage.goTo("https://rahulshettyacademy.com/client");


    }

    @AfterMethod(alwaysRun = true)
    public void quit()
    {
        driver.close();
    }


    public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
        String jsonContent= FileUtils.readFileToString(new File("C:\\Java\\Selenium\\SeleniumFrameworkDesign\\src\\test\\java\\Data\\PurchaseOrder.json"), StandardCharsets.UTF_8);
        ObjectMapper mapper=new ObjectMapper();
        List<HashMap<String,String>>data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }

    public String getScreenshot(String testCase,WebDriver driver) throws IOException {
        TakesScreenshot ts=(TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        File file=new File(System.getProperty("user.dir")+"//Reports//"+testCase+".png");
        FileUtils.copyFile(source,file);

        return System.getProperty("user.dir")+"//Reports//"+testCase+".png";
    }

}
