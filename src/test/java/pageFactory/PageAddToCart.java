package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAddToCart {
	WebDriver driver;

	@FindBy(xpath = "//div[@class='input-group']//input[@name='quantity']")
	WebElement field_quantite;

	@FindBy(xpath = "//a[text()='Checkout']")
	WebElement link_checkout;

	public PageAddToCart(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void saisirQuantiteProduitAndCheckout(String quantite) {
		field_quantite.clear();
		field_quantite.sendKeys(quantite);
		link_checkout.click();
	}

}
