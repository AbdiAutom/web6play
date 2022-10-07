
package onBoarding;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commun.Base;
import pagesProject.ConnexionPage;
import pagesProject.HomePage;

/**
 * Objectif de cette classe : Décrire les différents étapes pour les différents cas d'une connexion KO
 * Date de création : 28/06/22
 *
 * Création de 3 méthodes pour les différents cas de figure d'erreur
 */
/*
 * emailListe.add("abdi.bielhm6@gmail.com"); => comment vérifier l'absence du message d'erreur
 * lien : https://stackoverflow.com/questions/12270092/best-way-to-check-that-element-is-not-present-using-selenium-webdriver-with-java
 */

public class ConnexionNonPassant extends Base{

	public WebDriver driver; 
	HomePage homePage;	
	ConnexionPage pageConnexion;


	//Setup : permet d'ouvrir le driver et se connecter sur m6.fr 
	@BeforeClass
	public void initTest() throws InterruptedException, IOException
	{
		driver = setUpDriver();    
	}
	
	//Pour chaque test, cette methode permet rafraichir la page et se rendre sur la page OB connexion
	@BeforeMethod
	public void cliquerMonCompte() throws InterruptedException, IOException
	{
		homePage = new HomePage(driver);	
		pageConnexion = new ConnexionPage(driver); 
		Thread.sleep(2000);
		homePage.cliquerMonCompteBtn();
	} 

	//méthode pour un test fonctionnel non passant cas mail : correct & mdp : incorrect 
	@Test(priority=0)
	public void testAvecMdpIncorrect() throws InterruptedException
	{
		pageConnexion.setEmail("abdi.AZERTY@Gmail.com");
		Thread.sleep(1000);
		pageConnexion.setMdp("bonjour");
		Thread.sleep(1000);
		pageConnexion.cliquerSeConnecterBtn();
		pageConnexion.verifierCroixRougeEmail();
		String messageError = pageConnexion.verifierMessageEmailError();
		System.out.println("Le message d'erreur affiché : "+messageError);
		assertEquals(messageError, "Email ou mot de passe incorrect");
	}

	//méthode pour un test fonctionnel non passant cas mail : incorrect 
	@Test(priority=1)
	public void testAvecEmailIncorrect() throws InterruptedException
	{
		pageConnexion.setEmail("abdi.bilehm6@Gmail.com");
		Thread.sleep(1000);
		pageConnexion.setMdp("bonjour");
		Thread.sleep(1000);
		pageConnexion.cliquerSeConnecterBtn();
		pageConnexion.verifierCroixRougeEmail();
		String messageError = pageConnexion.verifierMessageEmailError();
		System.out.println("Le message d'erreur affiché : "+messageError);
		assertEquals(messageError, "Email ou mot de passe incorrect");
	}

	//méthode pour un test fonctionnel non passant cas format mail incorrect 
	@Test(priority=2)
	public void testAvecFormatEmailIncorrect() throws InterruptedException
	{
		ArrayList<String> emailListe = new ArrayList<String>();
		emailListe.add("abdi.bielhm6gmail.com");
		emailListe.add("abdi.bielhm6gmail.com@");
		emailListe.add("abdi.bielhm6@gmail.com@");
		for(int i=0; i<emailListe.size();i++)
		{
			pageConnexion.setEmail(emailListe.get(i));
			Thread.sleep(1000);
			pageConnexion.setMdp("bonjourA1");
			Thread.sleep(1000);
			pageConnexion.verifierCroixRougeEmail();
			boolean etat = pageConnexion.verifierEtatConnexionBtn();		
			System.out.println("L'état du bouton connexion pour ("+emailListe.get(i)+") est : "+etat);
			assertFalse(etat,"L'état du bouton connexion pour (\"+emailListe.get(i)");		
			Thread.sleep(1000); 
		}
	}

	@AfterMethod
	public void tearnDownTest() throws InterruptedException
	{
		driver.navigate().refresh();
		Thread.sleep(5000); 
	}
	
	@AfterClass
	public void tearnDown()
	{
		driver.close();	
	}
}
