package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement link_MyAccount;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement link_Register;

	@FindBy(xpath = "//a[text()='Login']")
	WebElement link_Login;

	// le constructeur de la classe
	public HomePage(WebDriver driver) {
		this.driver = driver;
		// on doit toujours ecrire cette ligne pour initialiser nos elelements
		PageFactory.initElements(driver, this);
	}

	public void for_register() {
		link_MyAccount.click();
		link_Register.click();

	}

	public void for_login() {
		link_MyAccount.click();
		link_Login.click();
	}

}
