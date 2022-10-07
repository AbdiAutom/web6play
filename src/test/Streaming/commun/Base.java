
package commun;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import pagesProject.ConsentsPage;

/**
 * Objectif de cette classe : Contient toutes methodes communes avec les tests. 
 * Permet aussi d'ouvrir le navigateur et le fermer une fois le test terminé.
 * Date de création : 29/06/2022
 */

public class Base {

	public WebDriver driver ;
	public Properties prop = new Properties();
	
	//@BeforeSuite
	public WebDriver setUpDriver() throws IOException
	{
		FileInputStream file = new FileInputStream("/Users/abdi.bileh17/Documents/Java/Web/src/test/Streaming/commun/Donnees.Properties");
		//FileInputStream file = new FileInputStream("user.dir"+"/src/test/Streaming/commun/Donnees.Properties"); // Vérifie si le lien est ok 
		
		prop.load(file);
		String browserName = prop.getProperty("browser");
		String url6play = prop.getProperty("url");
		System.out.println("Le test tourne avec le browser : "+browserName);
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			driver = new ChromeDriver();
		}			
		else if(browserName.equals("firefox"))
		{
			 System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
			  driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			//execute avec IE driver
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url6play);
		driver.manage().window().maximize();
		ConsentsPage consent = new ConsentsPage(driver);
		consent.cliquerAccepterConsentsBtn();
		
		return driver;
	}
	@AfterSuite
	public void tearnDownDriver()
	{
		driver.close();
		driver.quit();
	}
}
