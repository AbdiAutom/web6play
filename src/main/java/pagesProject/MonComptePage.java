
package pagesProject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Objectif de cette classe : 
 * Date de création : 
 */

public class MonComptePage {
	public WebDriver driver;

	public MonComptePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	//la liste de tous les objects utilisés se trouvant dans la page mon compte 
		@FindBy(xpath="//button[@class='sc-8qd2v2-0 gmAIju sc-1esye45-2 hnEUlH sc-10ahcun-0 iraLqh is-primary']") WebElement deconnectionBtn2;	
		@FindBy(xpath="//input[@id='email']") WebElement monCompteEmail;
		@FindBy(xpath="//a[@class='sc-1esye45-2 bdXdiT sc-o6a45d-1 sc-1onmnf9-0 eOYppo jSjwNb is-secondary']") WebElement supprimerCompteBtn2;
		@FindBy(xpath="//a[@class='zain8u-1 llrjHy active']") WebElement vuEnsembleBtn;
		@FindBy(xpath="(//li[@class='sc-pcbanq-1 eEknPj'])[3]") WebElement mesInformationsBtn2;
		@FindBy(xpath="//button[@class='sc-1esye45-2 bdXdiT sc-o6a45d-1 eOYppo is-primary']") WebElement confirmerSuppressionBtn2;
			
	/*
	 * Ci-dessous tous les actions utilisées dans les différents cas de test liées à la page mon compte
	 *  => les titres sont assez explicites pour définir quelle action la méthode correspond. 
	 */
	public void deconnecterUser()
	{
		deconnectionBtn2.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOf(deconnectionBtn2));
	}
	public void waitDeconnectionUser()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOf(deconnectionBtn2));
	}
	public String verifierCompteEmail()
	{
		monCompteEmail.isDisplayed(); 
		String emailAffiche = monCompteEmail.getAttribute("value").trim();
		return emailAffiche;
	}
	public void cliquerSurMesInformations()
	{
		mesInformationsBtn2.click();
	}
	public void cliquerSurSupprimerCompte()
	{
		supprimerCompteBtn2.click();
	}
	public void cliquerSurConfirmerSuppression()
	{
		confirmerSuppressionBtn2.click();
	}
	public void waitSuppressionUser()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOf(confirmerSuppressionBtn2));
	}
	
}
