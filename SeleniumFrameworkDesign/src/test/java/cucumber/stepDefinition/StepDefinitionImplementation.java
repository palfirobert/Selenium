package cucumber.stepDefinition;

import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.ProductCataloguePage;
import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class StepDefinitionImplementation extends BaseTest {
    ProductCataloguePage productCataloguePage;
    CartPage cartPage;
    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommece_Page() throws IOException {
        launchApplication();

    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_username_and_password(String username,String password)
    {
        logInPage.logIn(username,password);

    }
    @When("^I add the product (.+) to Cart$")
    public void I_add_product_to_cart(String productName)
    {   productCataloguePage= new ProductCataloguePage(driver);
        System.out.println(productName);
        productCataloguePage.addElementToCart(productName);
        cartPage=productCataloguePage.goToCart();
        cartPage.verifyTheCart(productName);
    }
    @Then("^Checkout (.+) and submit the order$")
    public void submit_order(String productName)
    {
        CheckoutPage checkoutPage=cartPage.goToCheckout();
        checkoutPage.addCountry("Romania");
        checkoutPage.submitCheckout();
    }
    @Then("Verify toast if the text is {string}")
    public void verify_toast_message(String errorMessage)
    {
        String toastMessage= logInPage.getErrorMessage();
        Assert.assertEquals(toastMessage,errorMessage);
        driver.close();
    }

}
