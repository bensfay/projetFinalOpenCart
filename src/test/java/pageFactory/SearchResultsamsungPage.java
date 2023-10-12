package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsamsungPage {
	WebDriver driver;

	@FindBy(xpath = "//h4/a[text()='Samsung SyncMaster 941BW']")
	WebElement titleFirstProduct;

	@FindBy(xpath = "//h4/a[text()='Samsung Galaxy Tab 10.1']")
	WebElement titleSecondProduct;

	public SearchResultsamsungPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public String titrePremierProduit() {

		return titleFirstProduct.getText();
	}

	public String titredeuxiemeProduit() {

		return titleSecondProduct.getText();
	}

	public void cliquezSurLePremierProduit() {
		titleFirstProduct.click();
			
	}
	
	
	
	
	
}
