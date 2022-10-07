package pagesProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InscriptionPageAgeGenre {

	WebDriver driver;
	public InscriptionPageAgeGenre(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Ici la liste de tous les objects utilisés se trouvant dans la page Age/genre d'inscription
	@FindBy(xpath="//p[@class='sc-1xi0tc7-0 sc-1xi0tc7-1 iKrdxQ']") WebElement textTitrePageAgeGenre;
	@FindBy(xpath="//select[@id='gender']") WebElement choixGenre;
	@FindBy(xpath="//input[@id='birthdate']") WebElement inputAge;
	@FindBy(xpath="//button[@type='submit']") WebElement terminerBtn;
	@FindBy(xpath="//img[@class='sc-1sebzd4-0 eTGBFE']") WebElement logo6play2;
	@FindBy(xpath="//p[@class='sc-1veuio6-0 eNENtP e58cdc-0 evuHKM']") WebElement texteInfosGroupe;
	@FindBy(xpath="//button[@type='submit']") WebElement InscriptionBtn;

	/*
	 * Ci-dessous tous les actions utilisées dans les différents cas de test liées à la page Age/genre d'inscription
	 *  => les titres sont assez explicites pour définir quelle action la méthode correspond. 
	 */
	public void setAge(String age)
	{
		inputAge.clear();
		inputAge.sendKeys(age);  
	}
	public void choisirUnGenre()
	{
		Select optionsByValue = new Select(choixGenre);
		optionsByValue.selectByIndex(1);  
	}
	public void cliquerTerminerBtn()
	{
		terminerBtn.click();
	}
}









/*



//--------- page Age genre
@FindBy(xpath="//p[@class='sc-1xi0tc7-0 sc-1xi0tc7-1 iKrdxQ']") WebElement textTitrePageAgeGenre;
@FindBy(xpath="//select[@id='gender']") WebElement choixGenre;
@FindBy(xpath="//select[@id='gender']") WebElement inputAge;
@FindBy(xpath="//button[@type='submit']") WebElement terminerBtn;
@FindBy(xpath="//img[@class='sc-1sebzd4-0 eTGBFE']") WebElement logo6play2;
@FindBy(xpath="//p[@class='sc-1veuio6-0 eNENtP e58cdc-0 evuHKM']") WebElement texteInfosGroupe;
@FindBy(xpath="//button[@type='submit']") WebElement InscriptionBtn;

//check vert format date naissance
//label[normalize-space()='Date de naissance']/ancestor::div[@class='sc-1kciujx-0 ffbQCc']/following-sibling::ul/li[contains(@class,'validation-rule-list-complete')][1]
//Check vert date de naissance correcte (+16)
//label[normalize-space()='Date de naissance']/ancestor::div[@class='sc-1kciujx-0 ffbQCc']/following-sibling::ul/li[contains(@class,'validation-rule-list-complete')][1]

//croix rouge format date naissance
//label[normalize-space()='Date de naissance']/ancestor::div[@class='sc-1kciujx-0 ffbQCc']/following-sibling::ul/li[contains(@class,'validation-rule-list-incomplete')][1]
//Croix rouge date de naissance correcte (+16)
//label[normalize-space()='Date de naissance']/ancestor::div[@class='sc-1kciujx-0 ffbQCc']/following-sibling::ul/li[contains(@class,'validation-rule-list-incomplete')][1]


*/

