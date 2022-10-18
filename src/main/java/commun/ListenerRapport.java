package commun;

import java.io.IOException;
//import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;

/**
 * Cette classe : est une version de listener avec génération de rapport. 
 *Crée : le 05/08/2022
 */

public class ListenerRapport extends Base implements ITestListener{
	public static ExtentTest test;
	public static ExtentReports extent = ManagerRepport.extentGenerique("RapportsHTML/"+dateJour+"rapport.html");

	@Override
	public void onTestStart(ITestResult result)    //Trouve une solution pour demarrer à chaque classe et donc organiser par classe mais non pas mééthode
	{
		test = extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		//test.log(Status.PASS, "Test passed!");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{		
		//Initialisation du driver
		WebDriver driver = null;
		String filePath = null;

		//Recupération du driver en cours
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//Appel à la méthode de capture d'ecran
		try {
			filePath=getScreenshotPath(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Ici affichage de l'erreur - log console + La capture d'ecran
		test.fail(result.getThrowable());	
		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		//test.log(" Test skipped");
	}	
	
	@Override
	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}
}
