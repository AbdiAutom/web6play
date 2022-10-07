package pagesProject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlayerPage {

	WebDriver driver;
	public PlayerPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//la liste de tous les objects utilisés se trouvant dans la page player 
	@FindBy(css=".sc-1veuio6-0.hjWmfO.sc-1nm66sh-0.kvaKE") WebElement publiciteLabelPlayer2;	
	@FindBy(xpath="//h2[@class='sc-1veuio6-0 iYWCHT sc-1nm66sh-1 hBLPgK']") WebElement messageAttenteLive2;
	@FindBy(xpath="//span[@class='sc-1esye45-3 hZosKo']") WebElement retourArrierePlayer2;		
	@FindBy(xpath="//button[@class='sc-18pg9dp-1 kIdQgw']") WebElement pleinEcranBtn2;
	
	/*
	 * Ci-dessous tous les actions utilisées dans les différents cas de test liées à la page player
	 *  => les titres sont assez explicites pour définir quelle action la méthode correspond. 
	 */
	public void verifierAffichagePublicite()
	{
		publiciteLabelPlayer2.isDisplayed();
	}
	public String verifierMessagePlayer()
	{		
		messageAttenteLive2.isEnabled();
		String message = messageAttenteLive2.getText();
		System.out.println("Message :"+message);
		return message;
	}
	public void cliquerRetourALaNavigation()
	{ 
		retourArrierePlayer2.click();
	} 
	public String cliquerPleinEcran()
	{
		pleinEcranBtn2.click(); 
		return pleinEcranBtn2.getAttribute("aria-label");
	}
	// => reflechir comment attendre que les objets soit bien affiché et disponibles
	public void attendreAffichageObjetsPlayer()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(pleinEcranBtn2));
	}
}
