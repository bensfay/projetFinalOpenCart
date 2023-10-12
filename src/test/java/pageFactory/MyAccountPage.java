package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	WebDriver driver;

	@FindBy(xpath = "//input[@name='search']")
	WebElement search_field;

	@FindBy(xpath = "//button[@class='btn btn-light btn-lg']")
	WebElement search_btn;

	// le constructeur de la classe
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void searchArticle(String article) {
		search_field.sendKeys(article);
		search_btn.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

	}

}
