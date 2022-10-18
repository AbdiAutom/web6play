
package homePage;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commun.Base;
import pagesProject.HomePage;
import pagesProject.ProgrammesTvPage;

/**
 * Objectif de cette classe : Récupérer les informations des Lives
 * Date de création : 22/07 
 */
/*
 * Point blocage => récupérer le texte du live ! puis ajoute une assert
 * Fait une boucle pour vérifier tous les lives + Attention de créer une method epour switcher d'une fenetre à une autre ... 
 */

public class infosProgLive extends Base{
	public WebDriver driver; 
	HomePage homePage;	
	ProgrammesTvPage programmesTvPage;

	//cette méthode initialise le driver et fait appel à la classe de base pour lancer le driver
	@BeforeClass
	public void initClass() throws IOException, InterruptedException
	{
		driver = setUpDriver();
		homePage = new HomePage(driver);
		programmesTvPage = new ProgrammesTvPage(driver);
		Thread.sleep(1000);
	}

	//Cette methode vérifie la correspondance des infos sur la page programme et celles contenues dans le lives de la home page
	//L'idée est d'ouvrir une nouvelle page(fenetre) et rentrer le lien
	//Puis parcourir tous les programmes et recupérer l'indexe du live à l'aide de l'heure de début affiché. 
	//Une fois indice recupéré, on localise le titre, le paragraphe ....
	//refléchir d'acceder aux fils de l'objet via les methodes webdriver
	@Test
	public void getInfosProgLive() throws InterruptedException, IOException 
	{
		//String chaine;
		String [] tabChaines = {"m6","w9","6ter","guilli"};  //mets ça dans un fichier propriety
		List<String> chaines = new ArrayList<String> (Arrays.asList(tabChaines));
		Iterator<String> it = chaines.iterator();
		/*
		while(it.hasNext())
		{
			//chaine = it.next();   //=> une chaine sera recupéré au fur et à mésure de la boucle ... plutard la liste devra être dans un fichier externe
		}
		 */

		String chaine = "m6";
		String heure = homePage.getHeureProgLive(chaine);
		String titre = homePage.getTitreLive(chaine);
		System.out.println("heure : "+heure);
		System.out.println("titre :"+titre);
		Thread.sleep(1000);
		programmesTvPage.newTabProgTv();
		Thread.sleep(2000);
		programmesTvPage.cliquerSurChaine("w9");
		//programmesTvPage.cliquerSurChaine(chaine);
		Thread.sleep(2000);
		String titreProgTrouve = programmesTvPage.parcerLesDatasLive(heure);
		Thread.sleep(2000);

		assertEquals(titre.toLowerCase(), titreProgTrouve.toLowerCase(), "Le test pour le live de la "+chaine+" est KO.");
	}
	@AfterClass
	public void tearnDown()
	{
		driver.quit();
	}
}	


