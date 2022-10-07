package pagesProject;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



/**
 * Objectif de cette classe : Cette classe contient tous les objets de la page les programmes TV
 * Date de création : 21/07/22
 */

public class ProgrammesTvPage {

	WebDriver driver;
	
	public ProgrammesTvPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	//la liste de tous les objects utilisés se trouvant dans la page programme TV
	@FindBy(xpath="//div[@class='epg-page__list channels-wrapper__list']/a") List<WebElement> listeChaine;
	@FindBy(xpath="//div[@class='epg-page__list channels-wrapper__list']/a[@href='/m6/programme-tv']") WebElement chaineM6Btn;
	@FindBy(xpath="//div[@class='epg-page__list channels-wrapper__list']/a[@href='/w9/programme-tv']") WebElement chaineW6Btn;
	@FindBy(xpath="//div[@class='epg-page__list channels-wrapper__list']/a[@href='/6ter/programme-tv']") WebElement chaine6terBtn;
	@FindBy(xpath="//button[normalize-space()='En ce moment']") WebElement enCeMomentBtn;
	@FindBy(xpath="//ul[@class='slider-epg__list']/li") List<WebElement> programmesTv;
	@FindBy(xpath="//ul[@class='slider-epg__list']/li//div[@class='epg-program-tile__hour']") WebElement heureDuLive;
	@FindBy(xpath="//ul[@class='slider-epg__list']/li[1]//h2") WebElement titreDuLive;
	@FindBy(xpath="//ul[@class='slider-epg__list']/li[1]//p") WebElement texteDuLive;
	@FindBy(xpath="//div[@label='Les programmes']/ul//a[@href='/m6/programme-tv']") WebElement programmeM6Lien;
	
	public void cliquerSurChaine(String chaine)
	{
		int nbChaine = listeChaine.size();
		int i=0;
		while(i<nbChaine-3)
		{
			String nomChaine = listeChaine.get(i).getDomAttribute("href");			
			if (nomChaine.contains(chaine))
			{
				listeChaine.get(i).click();
			}			
			i++;
		}
	}
	
	public String parcerLesDatasLive(String heuredebut)
	{
		int nbProgrammes = programmesTv.size();
		int i=0;
		String titrepro="";
		while(i<nbProgrammes)
		{
			WebElement objetHeure = programmesTv.get(i).findElement(By.xpath(".//div[@class='epg-program-tile__hour']"));
			String heure = objetHeure.getText();
		if (heure.contains(heuredebut))
			{
				WebElement objetTitre = programmesTv.get(i).findElement(By.xpath(".//h2[@class='epg-program-tile__name']"));
				titrepro = objetTitre.getText();
				System.out.println("Le titre du programme : "+objetTitre.getText());
				break;
			}			
			i++;
		}
		return  titrepro;
	}
	
	public void newTabProgTv()
	{
		//Cette commande ouvre une nouvelle fenetre dans le driver
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.6play.fr/m6/programme-tv");
	}		
}