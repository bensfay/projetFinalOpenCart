package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ConfirmRegisterPage {

	WebDriver driver;

	@FindBy(xpath = "//div[@id='content']/h1")
	WebElement messageConfirm;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement btn_continue;

	// le constructeur de la classe
	public ConfirmRegisterPage(WebDriver driver) {
		this.driver = driver;
		// on doit toujours ecrire cette ligne pour initialiser nos elelements
		PageFactory.initElements(driver, this);
	}

	public void checkComfirmationMessage() {
		String message = messageConfirm.getText();
		String excpectedMessage = "Your Account Has Been Created!";
		Assert.assertEquals(message, excpectedMessage);
		btn_continue.click();

	}

}
