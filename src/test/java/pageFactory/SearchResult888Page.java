package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResult888Page {

	WebDriver driver;
	
	@FindBy(xpath = "//p[text()='There is no product that matches the search criteria.']")
	WebElement messageMissedProduct;
	
	
	
	
	

	public SearchResult888Page(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}
	
	
	
	public String messageproductNonAvailable()  {
		return messageMissedProduct.getText();
	}

}
