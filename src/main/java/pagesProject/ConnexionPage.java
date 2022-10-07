
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

public class ConnexionPage {

	public WebDriver driver;

	public ConnexionPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}  

	//Ici la liste de tous les objects utilisés se trouvant dans la page de connexion
	@FindBy(id="email") WebElement emailInput;
	@FindBy(id="password") WebElement passwordInput;
	@FindBy(xpath="//button[@type='submit']") WebElement connectionBtn;
	@FindBy(xpath="//img[@class='sc-1sebzd4-0 kJAPgH']") WebElement logo6Play2;
	@FindBy(xpath="//p[@class='sc-1xi0tc7-0 sc-1xi0tc7-1 gRyCcm kiQJQV']") WebElement titrePageConnexion2;
	@FindBy(xpath="//button[@class='sc-1mhojej-0 heJLqj']") WebElement fbBtn2;
	@FindBy(xpath="//button[@class='sc-1mhojej-0 iRoUgY']") WebElement googleBtn2;
	@FindBy(xpath="//button[@class='sc-1mhojej-0 iracYc']") WebElement appleBtn2;	
	@FindBy(xpath="//p[@class='sc-1xi0tc7-0 sc-4lj84l-0 gRyCcm RQAxf']") WebElement titreConnexionEmail2;
	@FindBy(xpath="//button[@class='sc-w6qg4k-1 sc-xz4vqp-0 Zsvbk jaRJaN']") WebElement oeilMdp2;
	@FindBy(css=".sc-1rcwfs0-3.cJzLdj") WebElement lienMdpOublie;	
	@FindBy(xpath="//p[@class='sc-1veuio6-0 Sutdw sc-3k9bbt-2 SoifC']") WebElement textLienInscription2;
	@FindBy(xpath="//a[@class='sc-3k9bbt-1 ibLBde']") WebElement inscriptionBtn2;	
	@FindBy(css=".sc-ilqmce-1.bPRzIc") WebElement inscriptionBtn3;	
	@FindBy(xpath="//input[@id='email']/following-sibling::label") WebElement labelEmail;
	@FindBy(xpath="//input[@id='password']/following-sibling::label") WebElement labelMdp;
	@FindBy(xpath="//*[name()='svg'][@class='sc-ug9dnq-0 sc-oadl3q-0 hPmneE dYUqWK']")  WebElement croixRougeEmail2; //une liste de deux elements 1. pour l'email 2. pour le mdp	
	@FindBy(xpath="//*[name()='svg'][@class='sc-ug9dnq-0 sc-oadl3q-0 hPmneE eRuYch']")  WebElement checkVertEmail2;			   
	@FindBy(xpath="//div[@id='email-error']") WebElement emailError;
	@FindBy(xpath="//p[@class='sc-1rcwfs0-0 ftHgWs']") WebElement messageErrorConnexion2;
	@FindBy(xpath="//input[@type='text']") WebElement textMdpVisible;


	/*
	 * Ci-dessous tous les actions utilisées dans les différents cas de test liées à la page de connexion 
	 *  => les titres sont assez explicites pour définir quelle action la méthode correspond. 
	 *  
	 * la page factory nous aide à simplifier le code et à mieux localiser l'object, ce code est un exemple
	 */
	public void setEmail(String email)
	{
		emailInput.clear();
		emailInput.sendKeys(email);   		
	}
	public void setMdp(String motDePasse)
	{
		passwordInput.clear();
		passwordInput.sendKeys(motDePasse);
	}
	public void cliquerSeConnecterBtn()
	{
		connectionBtn.click();
	}
	public void cliquerSurInscriptionBtn()
	{
		inscriptionBtn3.click();
	}
	public void cliquerSurOeilMdp()
	{
		oeilMdp2.click();
	}

	//Visuel action 
	public boolean verifierEtatConnexionBtn()
	{
		return connectionBtn.isEnabled();
	}
	public void verifierLogo6play()
	{
		logo6Play2.isDisplayed();
	}
	public String verifierTitrePageConnexion()
	{
		titrePageConnexion2.isDisplayed();
		return titrePageConnexion2.getText();
	}
	public void verifierFbBtn()
	{
		fbBtn2.isDisplayed();
	}
	public void verifierGoogleBtn()
	{
		googleBtn2.isDisplayed();
	}
	public void verifierAppleBtn()
	{
		appleBtn2.isDisplayed();
	}
	public String verifierTitreConnexionEmail()
	{
		titreConnexionEmail2.isDisplayed();
		return titreConnexionEmail2.getText();
	}
	public void verifierLienMdpOublie()
	{
		appleBtn2.isDisplayed();
	}
	public void verifierTextInscription()
	{
		textLienInscription2.isDisplayed();
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
		croixRougeEmail2.isDisplayed();
	}
	public String verifierMessageEmailError()
	{
		//emailError.isDisplayed();
		//return emailError.getText();
		messageErrorConnexion2.isDisplayed();
		return messageErrorConnexion2.getText();
		
	}	
	public void verifierCheckVertEmail()
	{
		checkVertEmail2.isDisplayed();
	}	
	public String verifierMdpVisible()
	{
		//return textMdpVisible.isDisplayed(); //Ici vérification de mdp visible, dans le cas false ça produit une erreur?
		return passwordInput.getAttribute("type");
	}

}
