package testCases;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageFactory.AccountLogin;
import pageFactory.ConfirmRegisterPage;
import pageFactory.ForgotYourPasswordPage;
import pageFactory.HomePage;
import pageFactory.MyAccountPage;
import pageFactory.PageAddToCart;
import pageFactory.PageCheckout;
import pageFactory.PageOrderPlaced;
import pageFactory.PageResultatPremierProduit;
import pageFactory.RegisterPage;
import pageFactory.SearchResult888Page;
import pageFactory.SearchResultsamsungPage;

public class Demo {
	WebDriver driver;

	@Test
	public void exigence01() throws Exception {
		// L'utilisateur peut s'inscrire dans l'application en fournissant tous les
		// champs

		HomePage h1 = new HomePage(driver);
		h1.for_register();

		RegisterPage r1 = new RegisterPage(driver);
		r1.inscription_champsObligatoire("pedro", "mokhtar", "testsimo@gmail.com", "testpass");

		r1.agreePolicy();
		// Thread.sleep(3000);
		r1.click_continue();

		ConfirmRegisterPage c1 = new ConfirmRegisterPage(driver);
		c1.checkComfirmationMessage();

	}

	@Test
	public void exigence02() throws Exception {
		// l'utilisateur peut s'inscrire à l'application en optant pour l'abonnement à
		// la Newsletter

		HomePage h1 = new HomePage(driver);
		h1.for_register();

		RegisterPage r1 = new RegisterPage(driver);
		r1.inscription_champsObligatoire("pico", "nino", "test33@gmail.com", "test33");

		r1.subcribNewsLetter();
		r1.agreePolicy();
		r1.click_continue();

		ConfirmRegisterPage c1 = new ConfirmRegisterPage(driver);
		c1.checkComfirmationMessage();

	}

	@Test
	public void exigence03() throws Exception {
		// L'utilisateur ne peut pas enregistrer un compte en double.

		HomePage h1 = new HomePage(driver);
		h1.for_register();

		RegisterPage r1 = new RegisterPage(driver);
		Thread.sleep(2000);
		r1.inscription_champsObligatoire("pablo", "escobar", "6215122@bdeb.qc.ca", "1234");

		r1.agreePolicy();
		r1.click_continue();
		r1.assertionMessageAlert();

	}

	@Test
	public void exigence04() throws Exception {
		// l'utilisateur peut se connecter avec des informations d'identification
		// valides.

		// cliquez sur login
		HomePage h1 = new HomePage(driver);
		h1.for_login();

		// saisir email pour renitialiser mot de passe
		AccountLogin l1 = new AccountLogin(driver);
		l1.login("6215122@bdeb.qc.ca", "1234");

		String titlePage = driver.getTitle();

		// critere se succes
		if (!(titlePage.contains("Account"))) {
			fail("test echoué");
		}

	}

	@Test
	public void exigence05() throws Exception {
		// l'utilisateur est en mesure de réinitialiser le mot de passe oublié

		// cliquez sur login
		HomePage h1 = new HomePage(driver);
		h1.for_login();

		// cliquez sur mot de passe oublié
		AccountLogin l1 = new AccountLogin(driver);
		l1.cliquez_forgottenPassword();

		// saisir email pour renitialiser mot de passe
		ForgotYourPasswordPage f1 = new ForgotYourPasswordPage(driver);
		f1.renitialiserMotdePasse("6215122@bdeb.qc.ca");

		String messageSucceRenitialisation = l1.messageSuccessRenitiaPassword();
		String messageSuccesExpected = "password has been successfully updated";

		// verification message de succes de renitialisation
		if (!(messageSucceRenitialisation.contains(messageSuccesExpected))) {
			fail("test echoué");
		}

	}

	@Test
	public void exigence06() throws Exception {
		// l'utilisateur est en mesure de rechercher des produits

		// cliquez sur login
		HomePage h1 = new HomePage(driver);
		h1.for_login();

		// saisir email et password
		AccountLogin l1 = new AccountLogin(driver);
		l1.login("6215122@bdeb.qc.ca", "1234");
		Thread.sleep(2000);

		// chercher l article samsung
		MyAccountPage ac = new MyAccountPage(driver);
		ac.searchArticle("samsung");

		String titreProduit1Expected = "Samsung SyncMaster 941BW";
		String titreProduit2Expected = "Samsung Galaxy Tab 10.1";

		SearchResultsamsungPage sc = new SearchResultsamsungPage(driver);
		String titleProduct1 = sc.titrePremierProduit();
		String titleProduct2 = sc.titredeuxiemeProduit();

		// verifier les noms des produits affichés
		Assert.assertEquals(titleProduct1, titreProduit1Expected);
		Assert.assertEquals(titleProduct2, titreProduit2Expected);

	}

	@Test
	public void exigence07() throws Exception {
		// l'utilisateur est informé lorsque le produit n 'est pas disponible

		// cliquez sur login
		HomePage h1 = new HomePage(driver);
		h1.for_login();

		// saisir email et password
		AccountLogin l1 = new AccountLogin(driver);
		l1.login("6215122@bdeb.qc.ca", "1234");

		// chercher l article 888
		Thread.sleep(2000);
		MyAccountPage ac = new MyAccountPage(driver);
		ac.searchArticle("888");

		SearchResult888Page sc = new SearchResult888Page(driver);

		String messageAffiche = sc.messageproductNonAvailable();
		String messageExpected = "There is no product that matches the search criteria.";
		// verifier le message qui informe l'utilisateur que le produit n'est pas
		// disponible
		Assert.assertEquals(messageAffiche, messageExpected);

	}

	@Test
	public void exigence08() throws Exception {
		// l'utilisateur peut placer une commande

		// cliquez sur login
		HomePage h1 = new HomePage(driver);
		h1.for_login();

		// saisir email et password
		AccountLogin l1 = new AccountLogin(driver);
		l1.login("6215122@bdeb.qc.ca", "1234");

		// chercher l article samsung
		Thread.sleep(2000);
		MyAccountPage ac = new MyAccountPage(driver);
		ac.searchArticle("samsung");

		Thread.sleep(2000);

		// cliquez sur le produit 'Samsung SyncMaster 941BW'
		SearchResultsamsungPage sc = new SearchResultsamsungPage(driver);
		sc.cliquezSurLePremierProduit();

		// cliquez sur le btn add to cart
		PageResultatPremierProduit cart = new PageResultatPremierProduit(driver);
		cart.addToCartPremierProduitEtCliquezLinkShoppingCart();

		// saisir quantite du produit ici on peut avoir une erreur si on change quantite
		// par defaut
		PageAddToCart addcart = new PageAddToCart(driver);
		addcart.saisirQuantiteProduitAndCheckout("1");

		// saisir les information pour envoyer la commande
		PageCheckout ch = new PageCheckout(driver);
		ch.placeOrder();

		// message de confirmation
		String excpectedMessage = "Your order has been placed!";
		PageOrderPlaced ms = new PageOrderPlaced(driver);
		String message = ms.messageConfirmation();
		Assert.assertEquals(message, excpectedMessage);

	}

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost/opencart/upload/");

	}

	// postconditions : s execute apres chaque test)
	@AfterMethod
	public void tearDown() throws Throwable {
		Thread.sleep(3000);
		driver.quit();
	}

}
