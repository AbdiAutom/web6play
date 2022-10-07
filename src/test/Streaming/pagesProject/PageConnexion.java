
package pagesProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Objectif de cette classe : Cette classe contient tous les objets de la page connexion de OB
 * Date de création : 28/06/22
 */

/* BLOCAGES :
 * Après le clique sur l'oeil, vérifie le type de input Mdp qui passe de password à text
 * compliqué d'identifier le check vert et les croix rouge
 * review le passage par le parent object pour identifier un child
 */

public class PageConnexion {

	public WebDriver driver;

	public PageConnexion(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="email")
	WebElement emailInput;
	@FindBy(id="password")
	WebElement passwordInput;
	@FindBy(xpath="//button[@type='submit']")
	WebElement connectionBtn;
	@FindBy(xpath="//img[@class='sc-1sebzd4-0 eTGBFE']")
	WebElement logo6Play;
	@FindBy(xpath="//p[@class='sc-1xi0tc7-0 sc-1xi0tc7-1 iKrdxQ']")
	WebElement titrePageConnexion;
	@FindBy(xpath="//button[@class='sc-1mhojej-0 KyGFc']")
	WebElement fbBtn;
	@FindBy(xpath="//button[@class='sc-1mhojej-0 watJn']")
	WebElement googleBtn;
	@FindBy(xpath="//button[@class='sc-1mhojej-0 heJLqj']")
	WebElement appleBtn;
	@FindBy(xpath="//p[@class='sc-1xi0tc7-0 sc-4lj84l-0 jURzdj']")
	WebElement titreConnexionEmail;
	@FindBy(xpath="//button[@class='w6qg4k-1 xz4vqp-0 fuHlzK']")
	WebElement oeilMdp;
	@FindBy(css=".sc-1rcwfs0-3.gRrIfc")
	WebElement lienMdpOublie;
	@FindBy(xpath="//p[@class='sc-1veuio6-0 dktssj sc-3k9bbt-2 jJtFKs']")
	WebElement textLienInscription;
	@FindBy(xpath="//a[@class='sc-3k9bbt-1 rMXKd']")
	WebElement inscriptionBtn;
	@FindBy(xpath="//input[@id='email']/following-sibling::label")
	WebElement labelEmail;
	@FindBy(xpath="//input[@id='password']/following-sibling::label")
	WebElement labelMdp;
	@FindBy(xpath="//*[name()='svg'][@class='ug9dnq-0 oadl3q-0 kTfaaX']") 
	WebElement croixRougeEmail;
	@FindBy(xpath="//*[name()='svg'][@class='ug9dnq-0 oadl3q-0 jsBZRU']") 
	WebElement checkVertEmail;
	@FindBy(xpath="//div[@id='email-error']")
	WebElement emailError;	
	@FindBy(xpath="//input[@type='text']")
	WebElement textMdpVisible;





	public void setEmail(String email)
	{
		emailInput.sendKeys(email);   		//la page factory nous aide à simplifier le code et à mieux localiser l'object, ce code est un exemple
	}
	public void setMdp(String motDePasse)
	{
		passwordInput.sendKeys(motDePasse);
	}
	public void cliquerSeConnecterBtn()
	{
		connectionBtn.click();
	}
	public void cliquerSurInscriptionBtn()
	{
		inscriptionBtn.click();
	}
	public void cliquerSurOeilMdp()
	{
		oeilMdp.click();
	}

	//Visuel action 
	public void verifierLogo6play()
	{
		logo6Play.isDisplayed();
	}
	public String verifierTitrePageConnexion()
	{
		titrePageConnexion.isDisplayed();
		return titrePageConnexion.getText();
	}
	public void verifierFbBtn()
	{
		fbBtn.isDisplayed();
	}
	public void verifierGoogleBtn()
	{
		googleBtn.isDisplayed();
	}
	public void verifierAppleBtn()
	{
		appleBtn.isDisplayed();
	}
	public String verifierTitreConnexionEmail()
	{
		titreConnexionEmail.isDisplayed();
		return titreConnexionEmail.getText();
	}
	public void verifierLienMdpOublie()
	{
		appleBtn.isDisplayed();
	}
	public void verifierTextInscription()
	{
		textLienInscription.isDisplayed();
	}
	public void verifierLabelEmail()
	{
		labelEmail.isDisplayed();
	}
	public void verifierLabelMdp()
	{
		labelMdp.isDisplayed();
	}
	public void verifierCroixRougeEmail()
	{
		croixRougeEmail.isDisplayed();
		emailError.isDisplayed();
	}
	public void verifierCheckVertEmail()
	{
		checkVertEmail.isDisplayed();
	}	
	public Boolean verifierMdpVisible()
	{
		return textMdpVisible.isDisplayed(); //Ici vérification de mdp visible, dans le cas false ça produit une erreur?
	}

}
