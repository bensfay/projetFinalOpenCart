package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountLogin {

	WebDriver driver;

	@FindBy(id = "input-email")
	WebElement email;
	
	@FindBy(id = "input-password")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnLogin;
	
	@FindBy(xpath = "//aside[@id='column-right']/div/a[text()='Forgotten Password']")
	WebElement link_forgottenPassword;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement messageSuccesRenitiaPassword;
	
	//div[@class='alert alert-success alert-dismissible']
	

	// le constructeur de la classe
	public AccountLogin(WebDriver driver) {
		this.driver = driver;
		// on doit toujours ecrire cette ligne pour initialiser nos elelements
		PageFactory.initElements(driver, this);
	}
	
	
	public void login(String mail , String pass) {
		email.sendKeys(mail);
		password.sendKeys(pass);
		btnLogin.click();
	}
	
	
	public void cliquez_forgottenPassword() {
		link_forgottenPassword.click();
	}
	
	
	public String  messageSuccessRenitiaPassword() {
		return messageSuccesRenitiaPassword.getText();
	}

}
