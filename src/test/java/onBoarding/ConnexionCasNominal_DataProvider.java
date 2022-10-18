package onBoarding;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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
 
public class ConnexionCasNominal_DataProvider extends Base
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
	@Test(dataProvider = "dataprovider")
	public void testConnexionPassant(String email, String mdp) throws InterruptedException
	{
		//String email = "abdi.bilehm6@gmail.com";
		System.out.println("--- Ceci est un test fonctionnel de la page OB connexion ---");
		pageConnexion.setEmail(email);
		pageConnexion.verifierLabelEmail();
		pageConnexion.verifierCheckVertEmail();
		pageConnexion.verifierCheckVertEmail();

		pageConnexion.setMdp(mdp);
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

	@DataProvider (name = "dataprovider")
	public Object[][] getData() {
		Object[][] profile = new Object[3][2];
		profile[0][0] = "abdi.bilehm6@gmail.com";
		profile[0][1] = "bonjourA1";

		profile[1][0] = "abdi.bilehm66@gmail.com";
		profile[1][1] = "bonjourA1";

		profile[2][0] = "abdi.bilehm6@gmail.com";
		profile[2][1] = "bonjourA1";
		
		return profile;
    
	}
	
	@AfterClass
	public void tearnDown() throws InterruptedException
	{
		Base.deconnexionDeCompte();
		driver.close();
	}
}
