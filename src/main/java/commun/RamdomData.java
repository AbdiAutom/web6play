
package commun;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

/**
 * Objectif de cette classe : créer des emails, mdp random, 
 * Date de création : 
 */

public class RamdomData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//listeRandom(2);
		//System.out.println(emailRandom());
	System.out.println(dateRandom());
	}
	public static ArrayList<Integer> listeRandom(int nb)
	{
		ArrayList<Integer> maListeRandom = new ArrayList<Integer>();
		Random monRandom = new Random();
		int nombre=0;
		
		for(int i=0; i<3;i++)
		{
			nombre = monRandom.nextInt(nb);
			maListeRandom.add(nombre);
		}
		System.out.println(maListeRandom);
		return maListeRandom;
	}
	 
	public static String emailRandom()
	{	
		String emailRand;
		String alpha = "abcdefghijklmnoprstuvwyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * alpha.length());
            salt.append(alpha.charAt(index));
        }
        String saltStr = salt.toString();
        emailRand = saltStr+"@gmail.com";
	    return emailRand;	    
	}
	
	public static String mdpRandom()
	{	
		String mdpRand;
		String alphalower = "abcdefghijklmnoprstuvwyz";
		String alphaUpper = "ABCDEFGHIJKLMNOPRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        StringBuilder saltUpper = new StringBuilder();
        
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * alphalower.length());
            salt.append(alphalower.charAt(index));
        }
        while (saltUpper.length() < 3) { // length of the random string.
            int index = (int) (rnd.nextFloat() * alphaUpper.length());
            saltUpper.append(alphaUpper.charAt(index));
        }
        
        String saltStr = salt.toString();
        String saltUpperStr = saltUpper.toString();
        
        mdpRand = saltStr+"_8_"+saltUpperStr;
        return mdpRand;
	}
	
	public static String dateRandom()
	{
		LocalDate date = LocalDate.of(2000, 1, 1).minus(Period.ofDays((new Random().nextInt(365 * 70))));
		String formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
	    return formattedDate;
	    
	}
	

	
}
