package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageOrderPlaced {
	WebDriver driver;
	
	@FindBy(xpath = "//h1")
	WebElement titleConfirmation;

	public PageOrderPlaced(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}
	
	
	
	public String messageConfirmation() {
		return titleConfirmation.getText();
	}
	
	
	
	
	
	
	
}
