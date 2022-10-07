package onBoarding;

import static org.testng.Assert.assertEquals;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commun.Base;
import commun.RamdomData;
import pagesProject.HomePage;
import pagesProject.InscriptionPageAgeGenre;
import pagesProject.InscriptionPageEmail;
import pagesProject.MonComptePage;
import pagesProject.ConnexionPage;

/**
 * Objectif de cette classe : Décrire les différents étapes pour 
 * un cas d'inscription nominale + le visuel des pages inscription
 * Date de création : 20/07/22
 * 
 * elle contiendra deux methodes : 
 * 1. pour vérifier le visuel 
 * 2. pour vérifier le fonctionnel
 * Setup : fera en sorte de ramener jusqu'à à la page Ob connexion
 * Tearndown : fera clean et supprime le user 
 * ?Reflechir pour voir si c'est possible de faire un choix entre data.properties ou data.xls? dans une methode ou ...
 */
 
public class InscriptionCasNominal extends Base
{
	public WebDriver driver; 
	HomePage homePage;	
	ConnexionPage pageConnexion;	
	MonComptePage pageMonCompte;
	InscriptionPageEmail inscriptionPageEmail;
	InscriptionPageAgeGenre inscriptionPageAgeGenre;

	//Setup : Ouvre le driver via la classe de Base et se connecte sur m6.fr + afficher la page Ob connexion
	@BeforeClass 
	public void initClass() throws IOException, InterruptedException
	{
		driver = setUpDriver();
		homePage = new HomePage(driver);	
		pageConnexion = new ConnexionPage(driver);
		pageMonCompte = new MonComptePage(driver);
		inscriptionPageEmail = new InscriptionPageEmail(driver);
		inscriptionPageAgeGenre = new InscriptionPageAgeGenre(driver);
		Thread.sleep(2000);
		homePage.cliquerMonCompteBtn();
	}

	//méthode pour un test fonctionnel cas passant 
	@Test
	public void testInscriptionPassant() throws InterruptedException
	{
		System.out.println("--- Ceci est un test fonctionnel de la page OB Inscription ---");
		String email = RamdomData.emailRandom();
		String mdp = RamdomData.mdpRandom();
		String dateNaissance = RamdomData.dateRandom();
		pageConnexion.cliquerSurInscriptionBtn();
		
		inscriptionPageEmail.setEmail(email);
		inscriptionPageEmail.setMdp(mdp);
		Thread.sleep(2000);
		inscriptionPageEmail.cliquerInscriptionrBtn();
		Thread.sleep(2000);
		
		inscriptionPageAgeGenre.choisirUnGenre();
		inscriptionPageAgeGenre.setAge(dateNaissance);
		Thread.sleep(2000);
		inscriptionPageAgeGenre.cliquerTerminerBtn();
		Thread.sleep(5000);
		
		String emailMonCompte = pageMonCompte.verifierCompteEmail();
		assertEquals(emailMonCompte,email,"L'email sur mon compte ne correspond pas à celui utilisé pour la connexion!");
		//Vérification de la date de naissance ?
	}
	
	@AfterClass
	public void tearnDown() throws InterruptedException
	{
		Base.suppressionDeCompte();
		driver.quit();
	}
}
