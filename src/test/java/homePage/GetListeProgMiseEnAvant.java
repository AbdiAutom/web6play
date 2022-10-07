
package homePage;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commun.Base;
import commun.DataExcel;
import commun.DateOfDay;
import pagesProject.ConnexionPage;
import pagesProject.HomePage;

/**
 * Objectif de cette classe : Recupérer et exporter la liste de programmes mise en avant par la plateforme
 * Date de création : 14/07/2022
 * 
 */

public class GetListeProgMiseEnAvant extends Base{
	public WebDriver driver; 
	HomePage homePage;	
	ConnexionPage pageConnexion;	  

	//cette méthode initialise le driver et fait appel à la classe de base pour lancer le driver
	@BeforeClass
	public void initClass() throws IOException, InterruptedException
	{
		driver = setUpDriver();
		homePage = new HomePage(driver);	
		Thread.sleep(1000);
	} 

	//Cette méthode récupère les programmes mises en avant par le site m6 
	//et l'exporte vers un fichier excel avec la date du jour.
	@Test
	public void getListeProgmmeMEA() throws InterruptedException, IOException 
	{
		List<WebElement> listeProg = (List<WebElement>) homePage.get_li_ProgMiseAvant();
		Thread.sleep(1000);
		//Trouve une solution pour separer les données par une ligne vide...
		ArrayList<String> maListe = new ArrayList<String>();
		LocalDate date = DateOfDay.dateDay();						//la date du jour peut être mise dans une classe à part
		String formattedDate = date.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
		maListe.add(formattedDate);
		DataExcel.writeDataListe(maListe, "Feuil1","/Users/abdi.bileh17/Documents/ExcelData.xlsx");
		DataExcel.wordData(maListe, "/Users/abdi.bileh17/Documents/WriteToFile.txt");
		maListe.clear();

		int nbProg = listeProg.size();
		//cet assert vérifie que la liste n'est pas vide. On devrait avoir au moins un prog MEA affiché
		assertTrue(nbProg>0);  
		for(int i=1;i<nbProg+1;i++)
		{
			listeProg.get(i-1).click();
			Thread.sleep(1000);
			String titreProg = homePage.getTitreProgMEA();
			String commentProg = homePage.getDescriptionProgMEA();
			maListe.add(String.valueOf(i));
			maListe.add(titreProg);
			maListe.add(commentProg);
			System.out.println("Titre N°"+i+" : "+titreProg);
			System.out.println("Description : "+commentProg);
			
			// Export les données vers excel + word 
			DataExcel.writeDataListe(maListe, "Feuil1","/Users/abdi.bileh17/Documents/ExcelData.xlsx");
			DataExcel.wordData(maListe, "/Users/abdi.bileh17/Documents/WriteToFile.txt");
			maListe.clear();
		}
	}	
	@AfterClass
	public void tearnDown()
	{
		driver.close();	
	}
}