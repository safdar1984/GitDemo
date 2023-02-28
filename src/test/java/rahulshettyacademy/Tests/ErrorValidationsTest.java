package rahulshettyacademy.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

	// public static void main(String[] args) {
	@Test
	public void LoginErrorValidation() throws IOException {

		String productName = "ZARA COAT 3";

		landingPage.loginApplication("raosafdarraza@gmaill.com", "S@fdar123");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}

	@Test

	public void ProductErrorValidation() throws IOException {

		String productName = "ZARA COAT 3";

		ProductCatalogue productCatalogue = landingPage.loginApplication("raosafdarraza@gmail.com", "S@fdar123");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		List<WebElement> products = productCatalogue.getProductList();

		productCatalogue.addProductToCart(productName);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

		CartPage cartPage = productCatalogue.goToCartPage();

		boolean match = cartPage.VerifyProductsDisplay("ZARA COAT 33");
		Assert.assertFalse(match);

	}

}
