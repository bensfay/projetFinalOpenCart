package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCheckout {

	WebDriver driver;

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@name='address_1']")
	WebElement address;

	@FindBy(xpath = "//input[@name='city']")
	WebElement city;

	@FindBy(xpath = "//input[@name='postcode']")
	WebElement codePostal;

	@FindBy(xpath = "//select[@id='input-shipping-country']//option[text()='Canada']")
	WebElement country;

	@FindBy(xpath = "//select[@id='input-shipping-zone']//option[text()='Québec']")
	WebElement state;

	@FindBy(xpath = "//button[@id='button-shipping-address']")
	WebElement btn_continue;

	@FindBy(xpath = "//button[@id='button-shipping-methods']")
	WebElement btn_chooseShippingMethods;

	@FindBy(xpath = "//input[@id='input-shipping-method-flat-flat']")
	WebElement btn_radioMethodShippment;

	@FindBy(xpath = "//button[@id='button-shipping-method']")
	WebElement btn_continueMethodShippment;

	@FindBy(xpath = "//button[@id='button-payment-methods']")
	WebElement btn_choosePaymentMethod;

	@FindBy(xpath = "//input[@id='input-payment-method-cod-cod']")
	WebElement btn_radioChoosePaymentMethod;

	@FindBy(xpath = "//button[@id='button-payment-method']")
	WebElement btn_ContinueChoosePaymentMethod;

	@FindBy(xpath = "//button[@id='button-confirm']")
	WebElement btn_ConfirmOrder;

	public PageCheckout(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}
	
	
	public void placeOrder() {
		
		 firstName.sendKeys("faical");
		 lastName.sendKeys("simo");
		 address.sendKeys("67895 avenue");
		 city.sendKeys("montreal");
		 codePostal.sendKeys("h1t 4p3");
		 country.click();
		 state.click();
		 btn_continue.click();
		 btn_chooseShippingMethods.click();
		 btn_radioMethodShippment.click();
		 btn_continueMethodShippment.click();
		 btn_choosePaymentMethod.click();
		 btn_radioChoosePaymentMethod.click();
		 btn_ContinueChoosePaymentMethod.click();
		 btn_ConfirmOrder.click();
	}

}
