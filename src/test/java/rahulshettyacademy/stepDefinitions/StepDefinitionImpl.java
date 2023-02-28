package rahulshettyacademy.stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class StepDefinitionImpl extends BaseTest {

	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;

	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException {

		landingPage = launchApplication();
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String password) {

		productCatalogue = landingPage.loginApplication(username, password);

	}

	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_Cart(String productname) {

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productname);
	}

	@When("^Checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String productname) {

		CartPage cartPage = productCatalogue.goToCartPage();

		boolean match = cartPage.VerifyProductsDisplay(productname);
		Assert.assertTrue(match);
		CheckOutPage checkOutPage = cartPage.goToCheckOut();
		checkOutPage.selectCountry("Australia");

	    confirmationPage = checkOutPage.submitOrder();

	}
	@Then("{string} message is displayed on Confirmation Page")
	public void message_displayed_confirmationPage(String string) {
		
		String confirmMessage = confirmationPage.getConfirmationMessage();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		
	}
	  @Then("^\"([^\"]*)\" message is displayed$")
	    public void something_message_is_displayed(String strArg1) throws Throwable {
		  
		  Assert.assertEquals(strArg1, landingPage.getErrorMessage());
		//  driver.close();
	    }
}
