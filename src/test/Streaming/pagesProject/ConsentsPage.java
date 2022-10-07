package pagesProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsentsPage {

	WebDriver driver;
	public ConsentsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class = 's9pqpz-3 fcBJOP']/ button")
	WebElement toutAccepterConsentBtn;
	@FindBy(xpath="")
	WebElement toutRefuserConsentBtn;
	@FindBy(xpath="")
	WebElement parametrerConsentBtn;
	@FindBy(className="sc-39i7e7-3.bNGjHB")
	WebElement bannierToster;


	public void cliquerAccepterConsentsBtn()
	{
		toutAccepterConsentBtn.click();
	}
}
