package pagesProject;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * Objectif de cette classe : Cette classe contient tous les objets de la page home page
 * Date de création : 28/06/22
 */

//Attention comment recupérer le texte du live!!!! voir dans la methode originale, en bas et commentée

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Ici la liste de tous les objects utilisés se trouvant dans la homepage
		@FindBy(xpath="//button[@class ='sc-1ajxxj-0 sc-1c6u83a-3 iUrMAG']") WebElement listeChaineBtn;
		@FindBy(xpath="//a[@class ='sc-1ajxxj-0 kInStr ye0ny3-1 bRTmBv']") WebElement rechercheBtn;
		@FindBy(xpath="//button[@title='Mon Compte']")   WebElement monCompteBtn;	
		@FindBy(xpath="//a[@class ='sc-1ajxxj-0 kInStr ye0ny3-1 bRTmBv is-brand active']") WebElement homePageBtn;	
		@FindBy(xpath="//button[@class='sc-1ge2gi9-0 iszHyP']") List<WebElement> listeMiseEnAvantBtn;
		@FindBy(xpath="//li[@class='sc-1ge2gi9-1 dOnoct']") List<WebElement> liste_li_MiseEnAvantBtn2;						
		@FindBy(xpath="//h1[@class='sc-1veuio6-0 iZkAMX sc-1nynu6f-4 fxeNJX']") WebElement titreProgMiseEnAvant2;
		@FindBy(xpath="//p[@class='sc-1veuio6-0 gPgFpb sc-1nynu6f-5 dCypZP']") WebElement textProgMiseEnAvant2;
		@FindBy(xpath="//h1[@class='sc-1veuio6-0 iBPSfB nngvz8-0 dafPtp']/span") WebElement titreBlocLives;
		@FindBy(xpath="//a[@href='/m6/direct']/ancestor::ul/li") List<WebElement> listeLives;
		@FindBy(xpath="(//ul[@class='sc-1jzygab-6 cJCqTO'])[2]/li") List<WebElement> listeLives3;
		@FindBy(xpath="(//div[@id='page_62d529f07e62b0.15440234--699a7291-ba26-4f58-8ece-4081a5355876'])//ul/li[1]") WebElement live6play;
		@FindBy(xpath="(//div[@id='page_62d529f07e62b0.15440234--699a7291-ba26-4f58-8ece-4081a5355876'])//ul/li[1]//div[@class='sc-7w8ccx-8 uOgUS']/p") WebElement heureDuLive;
		@FindBy(xpath="(//div[@id='page_62d529f07e62b0.15440234--699a7291-ba26-4f58-8ece-4081a5355876'])//ul/li[1]//div[@class='sc-7w8ccx-8 uOgUS']/h1") WebElement titreDuLive;
		@FindBy(xpath="(//div[@id='page_62d529f07e62b0.15440234--699a7291-ba26-4f58-8ece-4081a5355876'])//ul/li[1]//div[@class='sc-1qvs8sx-3 eMFQXC']/img") WebElement chaineDuLive;
		@FindBy(xpath="//a[@href='/tous-les-programmes']") WebElement tousLesProgBtn;

		/*
		 * Ci-dessous tous les actions utilisées dans les différents cas de test liées à la homePage 
		 *  
		 * la page factory nous aide à simplifier le code et à mieux localiser l'object, ce code est un exemple
		 */

	public void cliquerMonCompteBtn()
	{	 
		monCompteBtn.click();
	}
	public void waitMonCompteBtnEnable()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(monCompteBtn));
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
	public int getNbProgMiseAvant()
	{
		return listeMiseEnAvantBtn.size();
	}
	public List<WebElement> get_li_ProgMiseAvant() throws InterruptedException
	{
		return liste_li_MiseEnAvantBtn2;
	}
	public String getTitreProgMEA()
	{
		return titreProgMiseEnAvant2.getText();
	}
	public String getDescriptionProgMEA()
	{
		return textProgMiseEnAvant2.getText();
	}

	public String getHeureProgLive(String nom)
	{
		int nbLive = listeLives3.size();
		int i=0;
		String heure="";

		while(i<nbLive-3)
		{
			WebElement nomChaine = listeLives3.get(i).findElement(By.xpath(".//a"));

			if (nomChaine.getDomAttribute("href").contains(nom))
			{
				WebElement heureDuLive = listeLives3.get(i).findElement(By.xpath(".//p"));
				String[] heureDebut = heureDuLive.getText().split(" ");
				heure = heureDebut[0];								
				break;
			}			
			i++;
		}
		return heure;
	}

	public String getTitreLive(String nom)
	{
		int nbLive = listeLives3.size();
		int i=0;
		String titre="";

		while(i<nbLive-3)
		{
			WebElement nomChaine = listeLives3.get(i).findElement(By.xpath(".//a"));

			if (nomChaine.getDomAttribute("href").contains(nom))
			{
				WebElement titreElem = listeLives3.get(i).findElement(By.xpath(".//h1"));
				titre = titreElem.getText();
				break;
			}
			i++;
		}
		return titre;
	}

	public void cliquerSurUnLive(String nomChaine)
	{	
		int nbLive = listeLives.size();
		for(int i=0; i<nbLive;i++)
		{
			if(listeLives.get(i).findElement(By.xpath("./a")).getAttribute("href").contains(nomChaine))
			{
				listeLives.get(i).findElement(By.xpath("./a")).click();
				break;
			}
		}
	}

}



/*
 * 	public List<String> getProgLiveChaine(String nom)
	{
		int nbLive = listeLives3.size();
		int i=0;
		String hd="";
		List<String> tab = new ArrayList<String>();

		while(i<nbLive-3)
		{
			WebElement nomChaine = listeLives3.get(i).findElement(By.xpath(".//a"));

			if (nomChaine.getDomAttribute("href").contains(nom))
				//if (nomChaine.getDomAttribute("href").equals(nom))
			{
				WebElement titreElem = listeLives3.get(i).findElement(By.xpath(".//h1"));
				WebElement heureDuLive = listeLives3.get(i).findElement(By.xpath(".//p"));
				//WebElement TexteDuLive = listeLives3.get(i).findElement(By.xpath(".//p[@class='sc-1veuio6-0 cJKdVI sc-7hu8x9-0 eqlpOO']"));
				String[] heureDebut = heureDuLive.getText().split(" ");
				hd = heureDebut[0];

				tab.add(hd);
				tab.add(titreElem.getText());

				System.out.println("Titre du live : "+titreElem.getText()); 
				System.out.println("Heure du live : "+heureDuLive.getText()); 
				System.out.println(hd);
				break;
			}

			//System.out.println("Texte du live : "+TexteDuLive.getDomAttribute("text")); 
			//System.out.println("Nom du live : "+nomChaine.getDomAttribute("href")); 
			i++;
		}
		return tab;
	}
 */
