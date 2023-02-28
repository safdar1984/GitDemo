package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.testng.Assert;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;

	public CartPage(WebDriver driver) {

		super(driver);
		this.driver = driver;

	}

	//@FindBy(css = "tr td:nth-child(3)")
	//List<WebElement> productNames;
	
	@FindBy(xpath = "//div/div/h3")
		List<WebElement> productNames;
	
	@FindBy (css = ".totalRow button")
	WebElement checkOut;

	public boolean VerifyProductsDisplay(String productName) {
		Boolean match = productNames.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;

	}
	public CheckOutPage goToCheckOut() {

		checkOut.click();
		return new CheckOutPage(driver);
	}


}
