package commun;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Cette classe : est une version simplicifée de Listener 
 *Crée : le 05/08/2022
 */

public class ListenerOnly implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println(" ************* La méthode "+result.getName() + " Test Started");

	}
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println(" ************* La méthode "+result.getName()+ " est passé avec Succès");

	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println(" ************* La méthode "+result.getName() + " est en erreur");

	}
	
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println(" ************* La méthode "+result.getName() + " est skipped");

	}
	
	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println(" ************* Test completed "+context.getName());

	}
}
