
package commun;

import java.io.BufferedWriter;
/**
 * Objectif de cette classe : créer une classe générique qui lit et écrit des données dans un fichier excel et word
 * Date de création : 29/06/2022
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Les principaux actions : 
 * Create a workbook
 * Create a sheet in workbook
 * Create a row in sheet
 * Add cells in sheet
 * 
 * Ajoute plusieurs methode statiques avec des paramètres différents : avec liste, 1 ou deux paramètres selon le besoin
 * les paramètres possibles : lien du fichier/nom de la feuille et pour Ecriture : le nom d'une liste ou une variable en plus
 */

public class DataExcel 
{
	public static void main(String[] args) throws IOException 
	{
		//Cette main est utilisée uniquement pour effectuer des tests si les methodes fonctionne OK
		//writeData("toto","son frere");   //Ici on faisait un test pour voir si la fonction write fonctionne
	}

	/**
	 * cette methode ajoutera une ligne de données dans une feuille deja existante
	 * la ligne sera ajouté juste après la dernière ligne de la feuille 
	 */
	public static void writeDataListe(ArrayList <String> maListe, String nomFeuil, String cheminFichier) throws IOException
	{
		FileInputStream file = new FileInputStream(cheminFichier); 

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		//Read a sheet
		XSSFSheet sheet = workbook.getSheet(nomFeuil);  

		int nbRow = sheet.getLastRowNum(); 	        
		Row row = sheet.createRow(nbRow+1);	

		for(int i=0; i<maListe.size();i++)
		{
			Cell cell = row.createCell(i);
			cell.setCellValue(maListe.get(i));

			//Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File(cheminFichier));
			workbook.write(out);
			out.close();
		}	
		workbook.close();
	}


	/**
	 * CETTE METHODE - permet de recuperer les données d'une feuille passé en paramètre
	 * Ces données peut importe leur types seront recupérées grâce à ce switch case
	 * 
	 * Plusieurs possibilités : 
	 * 	1- Afficher le contenu d'une feuille, 
	 * 	2- Affecter une variable au contenu d'une cellule, 
	 * 	3- Remplir un tableau avec le contenu d'une liste de cellules, 
	 * 	4-
	 */
	public static ArrayList<String> readData(String cheminAccesFichier, String nomFeuille) throws IOException
	{
		FileInputStream file = new FileInputStream(cheminAccesFichier);
		ArrayList<String>  maListeRandom = new ArrayList<String>();

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		int sheets = workbook.getNumberOfSheets();

		for(int i=0; i<sheets;i++)
		{
			if (workbook.getSheetName(i).equalsIgnoreCase(nomFeuille))   // => Que veut dire ...
			{
				XSSFSheet sheet = workbook.getSheetAt(i);	// => Que veut dire ...

				//FormulaEvaluator formule = workbook.getCreationHelper().createFormulaEvaluator();
				int nbRow = sheet.findEndOfRowOutlineGroup(1);

				System.out.println("le nb de ligne est : "+nbRow);
				for (Row row :sheet)   //Toutes les lignes de la feuille 
				{
					for (Cell cell : row)   // Puis toutes les colonnes de lignes - étape par étape
					{
						switch (cell.getCellType()) 
						{
						case NUMERIC:
							System.out.print(cell.getNumericCellValue()+"\t\t");
							break;
						case STRING:
							System.out.print(cell.getStringCellValue()+"\t\t");
							maListeRandom.add(cell.getStringCellValue());
							break;
						default:
							break;
						}
					}
					System.out.println();
				}
			}
		}
		workbook.close();
		return maListeRandom;
	}
	
	/**
	 * cette methode permettra d'importer et sauvegarder la liste des programmes favoris tous les jours. 
	 */
	
	public static void wordData(List<?> data, String cheminFichier) throws IOException
	{
		FileWriter file = new FileWriter(cheminFichier, true);
		BufferedWriter writer = new BufferedWriter(file);

		for(int i=0; i<data.size();i++)
		{
			String var = (String) data.get(i);
			writer.append(var+"\n");			
		}

		writer.close();
		file.close();
	}

}
