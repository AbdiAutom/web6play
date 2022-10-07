package player;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commun.Base;
import pagesProject.HomePage;
import pagesProject.InscriptionPageEmail;
import pagesProject.PlayerPage;

/**
 * Objectif de cette classe : Effectuer un test Nominal pour user non connecté qui lance un live
 * Date de création : 25/07/22
 */

public class AccesLiveUserNonConnecte extends Base
{
	public WebDriver driver; 
	HomePage homePage;	
	InscriptionPageEmail inscriptionPageEmail;
	PlayerPage playerPage;

	//Setup : Ouvre le driver via la classe de Base et se connecte sur m6.fr 
	@BeforeClass
	public void initClass() throws IOException, InterruptedException
	{
		driver = setUpDriver();
		homePage = new HomePage(driver);	
		inscriptionPageEmail = new InscriptionPageEmail(driver);
		playerPage = new PlayerPage(driver);
		Thread.sleep(2000);
	}

	//méthode pour un test fonctionnel : 
	//Le user essaie d'accéder un live sans etre connecté puis il se connecte et visionne le live
	@Test(priority=1)
	public void testConnexionPassant() throws InterruptedException
	{
		System.out.println("--- Ceci est un test fonctionnel pour User non connecté accédant un live ---");
		String email = "abdi.bilehm6@gmail.com";
		String chaine = "6ter";
		
		String titreProg = homePage.getTitreLive(chaine);
		homePage.cliquerSurUnLive("6ter");  //Bientôt (méthode à spliter)
		Thread.sleep(1000);
		
		inscriptionPageEmail.setEmail(email);
		inscriptionPageEmail.setMdp("bonjourA1");
		inscriptionPageEmail.cliquerInscriptionrBtn();
		
		//Un wait explicite qui attend l'affichage des objets player
		playerPage.attendreAffichageObjetsPlayer();
		
		playerPage.verifierAffichagePublicite();
		String messagePlayer = playerPage.verifierMessagePlayer();
		assertTrue(messagePlayer.contains(titreProg), "ERREUR! un KO en l'air...");
		
		playerPage.cliquerPleinEcran();
		Thread.sleep(1000);
		playerPage.cliquerRetourALaNavigation();
		homePage.cliquerMonCompteBtn();
	}

	@AfterClass
	public void tearnDown() throws InterruptedException
	{
		Base.deconnexionDeCompte();
		driver.close();
		driver.quit();
	}
}
