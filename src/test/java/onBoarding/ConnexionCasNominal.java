package onBoarding;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commun.Base;
import pagesProject.HomePage;
import pagesProject.MonComptePage;
import pagesProject.ConnexionPage;

/**
 * Objectif de cette classe : Décrire les différents étapes pour 
 * un cas connexion nominale + le visuel de la page connexion
 * Date de création : 28/06/22
 * 
 * elle contient deux methodes : 
 * 1. pour vérifier le visuel 
 * 2. pour vérifier le fonctionnel
 * 
 *
 * Tearndown : fera clean et deconnecte le user  + remeture du driver
 * ?Reflechir pour voir si c'est possible de faire un choix entre data.properties ou data.xls? dans une methode ou ...
 */
 
public class ConnexionCasNominal extends Base
{
	public WebDriver driver; 
	HomePage homePage;	
	ConnexionPage pageConnexion;	
	MonComptePage pageMonCompte;
	
	//Setup : Ouvre le driver via la classe de Base et se connecte sur m6.fr + afficher la page Ob connexion
	@BeforeClass 
	public void initClass() throws IOException, InterruptedException
	{
		driver = setUpDriver();
		homePage = new HomePage(driver);	
		pageConnexion = new ConnexionPage(driver);
		pageMonCompte = new MonComptePage(driver);
		Thread.sleep(2000);
		homePage.cliquerMonCompteBtn();
	}
	
	//méthode pour un test fonctionnel cas passant 
	@Test(priority=1)
	public void testConnexionPassant() throws InterruptedException
	{
		String email = "abdi.bilehm6@gmail.com";
		System.out.println("--- Ceci est un test fonctionnel de la page OB connexion ---");
		pageConnexion.setEmail(email);
		pageConnexion.verifierLabelEmail();
		pageConnexion.verifierCheckVertEmail();
		pageConnexion.verifierCheckVertEmail();

		pageConnexion.setMdp("bonjourA1");
		pageConnexion.verifierLabelMdp();
		pageConnexion.cliquerSurOeilMdp();
		String mdpVisible1 = pageConnexion.verifierMdpVisible();
		System.out.println("Quand le mdp est visible le paramètre est en mode : "+mdpVisible1);
		assertEquals(mdpVisible1, "text");
		pageConnexion.cliquerSurOeilMdp();
		String mdpVisible2 = pageConnexion.verifierMdpVisible();
		System.out.println("Quand le mdp est visible le paramètre est en mode : "+mdpVisible2);
		assertEquals(mdpVisible2, "password");

		boolean etat = pageConnexion.verifierEtatConnexionBtn();	
		assertEquals(etat, true,"Le btn se connecter n'est pas actif");
		pageConnexion.cliquerSeConnecterBtn();
		Thread.sleep(2000);
		
		String emailMonCompte = pageMonCompte.verifierCompteEmail();
		assertEquals(emailMonCompte,email,"L'email sur mon compte ne correspond pas à celui utilisé pour la connexion!");			
	}

	//méthode pour un test visuel cas passant 
	@Test(priority=0)
	public void testVisuelPageConnexion()
	{
		System.out.println("--- Ceci est un test visuel de la page OB connexion ---");
		pageConnexion.verifierTitrePageConnexion();
		pageConnexion.verifierAppleBtn();
		//pageConnexion.verifierFbBtn();
		pageConnexion.verifierGoogleBtn();
		pageConnexion.verifierTitreConnexionEmail();
		pageConnexion.verifierLogo6play();
		pageConnexion.verifierLienMdpOublie();
		pageConnexion.verifierTextInscription();
		boolean etat = pageConnexion.verifierEtatConnexionBtn();
		assertEquals(etat, false);
	}
	
	@AfterClass
	public void tearnDown() throws InterruptedException
	{
		Base.deconnexionDeCompte();
		driver.close();
	}
}
