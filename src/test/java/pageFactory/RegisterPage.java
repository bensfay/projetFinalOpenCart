package pageFactory;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement link_MyAccount;

	@FindBy(xpath = "//a[text()='Register']")
	WebElement link_Register;

	@FindBy(xpath = "//a[text()='Login']")
	WebElement link_Login;

	@FindBy(id = "input-firstname")
	WebElement firstName;

	@FindBy(id = "input-lastname")
	WebElement lastName;

	@FindBy(id = "input-email")
	WebElement e_mail;

	@FindBy(id = "input-password")
	WebElement password;

	@FindBy(id = "input-newsletter")
	WebElement btn_subsribrNewsletter;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement btn_agreePolicy;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement btn_continue;
	
	@FindBy(xpath = "//div[@id='alert']/div[contains(text(),'Warning: E-Mail Address is already registered!')]")
	WebElement mesageAlert;
	
	

// le constructeur de la classe	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		// on doit toujours ecrire cette ligne pour initialiser nos elelements
		PageFactory.initElements(driver, this);
	}

	public void inscription_champsObligatoire(String fName, String lName, String email, String pass) {
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		e_mail.sendKeys(email);
		password.sendKeys(pass);	

	}
	
	public void subcribNewsLetter() {
		btn_subsribrNewsletter.click();	
	}

	public void agreePolicy() {
		btn_agreePolicy.click();	
	}
	
	public void click_continue() {
		btn_continue.click();	
	}
	
	public void assertionMessageAlert() {
		String messageAlerte = mesageAlert.getText();
		if (!(messageAlerte.contains("E-Mail Address is already registered"))) {
			fail("test echoué");	
			
		}
	}

	
	
	
	
	
	
	

}
