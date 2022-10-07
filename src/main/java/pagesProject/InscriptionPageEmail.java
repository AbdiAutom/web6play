package pagesProject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InscriptionPageEmail {

	WebDriver driver;
	public InscriptionPageEmail(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//la liste de tous les objects utilisés se trouvant dans la page Inscription email 
	@FindBy(xpath="//button[@type='submit']") WebElement inscriptionBtn;
	@FindBy(xpath="//input[@id='email']") WebElement emailInscriptionInput;
	@FindBy(xpath="//input[@id='password']") WebElement mdpInscriptionInput;
	@FindBy(xpath="//input[@id='newsletter']") WebElement checkBoxNewsletter;
	@FindBy(css="button[@class='sc-1mhojej-0 KyGFc']") WebElement fbInscriptionBtn;
	@FindBy(xpath="//img[@class='sc-1sebzd4-0 eTGBFE']") WebElement logo6play;
	@FindBy(xpath="//li[normalize-space()='8 caractères']//*[name()='svg']/parent::li[contains(@class,'validation-rule-list-complete')]") WebElement CroixRouge8caracteres;
	@FindBy(xpath="//li[normalize-space()='1 majuscule']//*[name()='svg']/parent::li[contains(@class,'validation-rule-list-complete')]") WebElement CroixRougeMajuscule;
	@FindBy(xpath="//li[normalize-space()='1 minuscule']//*[name()='svg']/parent::li[contains(@class,'validation-rule-list-complete')]") WebElement CroixRougeMiniscule;
	@FindBy(xpath="//li[normalize-space()='1 chiffre']//*[name()='svg']/parent::li[contains(@class,'validation-rule-list-complete')]") WebElement CroixRouge1chiffre;
	@FindBy(xpath="//button[@class='w6qg4k-1 xz4vqp-0 fuHlzK']") WebElement oeilMdp;
	@FindBy(xpath="//p[@class='foea98-0 hwPljP']") WebElement texteInfomationGroupe;
	@FindBy(css="label[for='email']") WebElement labelEmail;
	@FindBy(css="label[for='password']") WebElement labelmdp;
	@FindBy(xpath="//a[@class='sc-123zykd-1 lnPrpU']") WebElement lienConnexion;
	@FindBy(xpath="//a[@class='sc-1fvfbsa-0 hJzwCI']") List<WebElement> listeLiensGroupe;
	
	/*
	 * Ci-dessous tous les actions utilisées dans les différents cas de test liées à la page Inscription email 
	 *  => les titres sont assez explicites pour définir quelle action la méthode correspond. 
	 */
	public void setEmail(String email)
	{
		emailInscriptionInput.clear();
		emailInscriptionInput.sendKeys(email);   		//la page factory nous aide à simplifier le code et à mieux localiser l'object, ce code est un exemple
	}
	public void setMdp(String motDePasse)
	{
		mdpInscriptionInput.clear();
		mdpInscriptionInput.sendKeys(motDePasse);
	}
	public void cliquerInscriptionrBtn()
	{
		inscriptionBtn.click();
	}
} 


