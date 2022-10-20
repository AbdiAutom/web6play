
package commun;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import pagesProject.ConsentsPage;
import pagesProject.MonComptePage;

/**
 * Objectif de cette classe : Contient toutes methodes communes avec les tests. 
 * Permet aussi d'ouvrir le navigateur et le fermer une fois le test terminé.
 * Date de création : 29/06/2022
 * 
 * => trouve une solution pour fermer tous les drivers couverts
 */

public class Base {
	
	public static WebDriver driver ;
	public static String dateJour = String.format("%1$td:%1$tm:%1$tY %1$tH-%1$tM", new Date());
	
	//@BeforeSuite
	@SuppressWarnings("deprecation")
	public WebDriver setUpDriver() throws IOException, InterruptedException
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config/Donnees.Properties");		
		prop.load(file);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");		
		System.out.println("Le test tourne avec le browser : "+browserName);
		
		if (browserName.contains("chrome")) {
			ChromeOptions option = new ChromeOptions();     //Tu peux utiliser bcp plus d'options (check plus tard)
			if(browserName.contains("headless")) {
				option.addArguments("headless");				
			}		
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");   //Crée un repetoire pour les drivers + change le chemin
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
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
		driver.get(prop.getProperty("url"));
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
	
	public static void deconnexionDeCompte() throws InterruptedException
	{
		MonComptePage monComptePage = new MonComptePage(driver);
		monComptePage.deconnecterUser();
		Thread.sleep(1000); 
		//monComptePage.waitDeconnectionUser();     => trop long le 30s ...
	}
	
	public static void suppressionDeCompte() throws InterruptedException
	{		
		MonComptePage monComptePage = new MonComptePage(driver);
		//Thread.sleep(20000);
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
		
		monComptePage.cliquerSurMesInformations();
		//Thread.sleep(3000);
		monComptePage.cliquerSurSupprimerCompte();
		//Thread.sleep(1000);
		monComptePage.cliquerSurConfirmerSuppression();
		
		Thread.sleep(5000);
		//monComptePage.waitSuppressionUser(); 		=> trop long le 30s ...
	}
	
	//Cette méthode réalise la prise de capture d'ecran 
	public  String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver ;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(System.getProperty("user.dir") + "//TestsScreenShots//"+dateJour+"_"+testCaseName+"_"+".png");
		FileUtils.copyFile(source, destinationFile);
		return System.getProperty("user.dir")+"//TestsScreenShots//"+dateJour+"_"+testCaseName+"_"+".png";
	}
	
	//Cette méthode recupère des données depuis un fichier Json
	public List<HashMap<String, String>> getJsonDataToMap(String pathLink) throws IOException {
		//read json to sting
	String jsonContent = FileUtils.readFileToString(new File(pathLink), StandardCharsets.UTF_8);
	
	//String to hashmap (use jackson data)
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference <List<HashMap<String, String>>>(){
		
	});
	return data;
	}
}
 