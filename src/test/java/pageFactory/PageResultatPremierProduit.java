package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageResultatPremierProduit {
	WebDriver driver;

	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement btn_addToCart;

	@FindBy(xpath = "//span[text()='Shopping Cart']")
	WebElement link_shoppingCart;

	public PageResultatPremierProduit(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void addToCartPremierProduitEtCliquezLinkShoppingCart() throws InterruptedException {

		btn_addToCart.click();
		Thread.sleep(2000);
		link_shoppingCart.click();

	}

	

}
