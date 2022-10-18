package commun;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * Objectif de cette classe : la classe de base pour l'extent report
 * Date de création : 07/08/2022
 */

public class ManagerRepport {
	public static ExtentReports extent;
	//public static ExtentTest test;
	
	public static ExtentReports extentGenerique(String cheminFichier)
	{	
		ExtentSparkReporter reporter = new ExtentSparkReporter(cheminFichier);
		reporter.config().setReportName("report Name");
		reporter.config().setDocumentTitle("Test Autom");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Abdi Toto");
		extent.setSystemInfo("os", "MacOS");
			
		return extent;	
	}
}