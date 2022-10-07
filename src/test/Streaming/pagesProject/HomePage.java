package pagesProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Objectif de cette classe : Cette classe contient tous les objets de la page home page
 * Date de création : 28/06/22
 */

public class HomePage {

	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//button[@class ='sc-1ajxxj-0 sc-1c6u83a-3 iUrMAG']")
	WebElement listeChaineBtn;
	@FindBy(xpath="//a[@class ='sc-1ajxxj-0 kInStr ye0ny3-1 bRTmBv']")
	WebElement rechercheBtn;
	//@FindBy(css="//button[@title='Mon Compte']")  
	//WebElement monCompteBtn;
	@FindBy(xpath="(//span[@class='sc-1veuio6-0 hSNsjM sc-5d8x85-0 eIGmNn'])[3]")
	WebElement monCompteBtn;	
	@FindBy(xpath="//a[@class ='sc-1ajxxj-0 kInStr ye0ny3-1 bRTmBv is-brand active']")
	WebElement homePageBtn;
	
	@FindBy(xpath="//button[@class='sc-1ge2gi9-0 iszHyP']")
	WebElement miseEnAvantBtn;
	@FindBy(xpath="//h1[@class='sc-1veuio6-0 gRnCIs sc-1nynu6f-4 bNUKAM']")
	WebElement titreProgMiseEnAvant;
	@FindBy(xpath="//p[@class='sc-1veuio6-0 ibGAjA sc-1nynu6f-5 jQDdA']")
	WebElement textProgMiseEnAvant;
	
		
	
	public void cliquerMonCompteBtn()
	{
		monCompteBtn.click();
	}
	public void cliquerHomePageBtn()
	{
		homePageBtn.click();
	}
	public void cliquerRechercheBtn()
	{
		rechercheBtn.click();;
	}
	public void cliquerListeChainesBtn()
	{
		listeChaineBtn.click();
	}
	
}
