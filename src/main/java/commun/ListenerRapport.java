package commun;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

/**
 * Cette classe : est une version de listener avec génération de rapport. 
 *Crée : le 05/08/2022
 */

//extends ManagerRepport
public class ListenerRapport extends Base implements ITestListener{
	//public static String dateJour = String.format("%1$tY-%1$tm-%1$td", new Date());
	public static ExtentTest test;
	public static ExtentReports extent = ManagerRepport.extentGenerique("RapportsHTML/Spark"+dateJour+".html");

	@Override
	public void onStart(ITestContext context) 
	{
		//context.setAttribute("WebDriver", context.getName());
		//test = extent.createTest(context.get);
		//test.info("Test Start");
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println(" ************* Test completed "+context.getName());
		test.info("FIN Test");
		extent.flush();
	}

	@Override
	public void onTestStart(ITestResult result)    //Trouve une solution pour demarrer à chaque classe et donc organiser par classe mais non pas mééthode
	{
		test = extent.createTest(result.getName());
		test.info(" Test "+result.getMethod().getMethodName()+" started ");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println(" ************* La méthode "+result.getMethod().getMethodName()+ " est passé avec Succès");
		test.log(Status.PASS, "le test de la méthode "+result.getName()+ " est passé avec Succès");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{

		// ceci recupère le nom du scénario en echec
		String nomMethod = result.getMethod().getMethodName();
		
		//Initialisation du driver
		WebDriver driver = null;

		//Recupération du driver en cours
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e) {
			e.printStackTrace();
		}

		//Appel à la méthode de capture d'ecran
		try {
			getScreenshotPath(nomMethod,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.info(" Test "+result.getMethod().getMethodName()+" est KO ");
		
		//Ici affichage de l'erreur - log console - 
		test.fail(result.getThrowable());		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println(" ************* La méthode "+result.getMethod().getMethodName() + " est skipped");
		test.info(" Test skipped");
	}	
}
