package onBoarding;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commun.Base;
import pagesProject.HomePage;
import pagesProject.PageConnexion;

/**
 * Objectif de cette classe : Décrire les différents étapes pour 
 * un cas connexion nominale + le visuel de la page connexion
 * Date de création : 28/06/22
 * 
 * elle contient deux methodes : 1. pour vérifier le visuel 2. pour vérifier le fonctionnel
 * Setup : fera en sorte de ramener jusqu'à à la page Ob connexion
 * Tearndown : fera clean et deconnecte le user 
 * ?Reflechir pour voir si c'est possible de faire un choix entre data.properties ou data.xls? dans une methode ou ...
 */

public class ConnexionCasNominal extends Base
{
	//Variable => les objets des pages, le driver, les data utilisé ...
	//public WebDriver driver; 
	WebDriver driver; 
	
	@BeforeClass
	public void initClass() throws IOException, InterruptedException
	{
		driver = setUpDriver();
		HomePage homePage = new HomePage(driver);	
		Thread.sleep(2000);
		homePage.cliquerMonCompteBtn();
	}
	
	@Test(priority=0)
	public void testConnexionPassant()
	{
		System.out.println("OK 1");
	}
	@Test(priority=1)
	public void testVisuelPageConnexion()
	{
		System.out.println("OK 2");
	}
	
}
