package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotYourPasswordPage {

	WebDriver driver;

	@FindBy(id = "input-email")
	WebElement e_mail;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btn_continue;

	// le constructeur de la classe
	public ForgotYourPasswordPage(WebDriver driver) {
		this.driver = driver;
		// on doit toujours ecrire cette ligne pour initialiser nos elelements
		PageFactory.initElements(driver, this);
	}

	public void renitialiserMotdePasse(String monEmail) {
		e_mail.sendKeys(monEmail);
		btn_continue.click();
	}

}
