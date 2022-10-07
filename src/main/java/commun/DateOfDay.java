
package commun;

import java.time.LocalDate;

/**
 * Objectif de cette classe : Renvoyer la date du jour 
 * 
 * A terme : On pourra implémenter d'autres méthodes ex : "une date aléatoire", "date dans le future"....
 * Date de création : 14/07/2022
 */
public class DateOfDay {

	public static LocalDate dateDay()
	{
		return LocalDate.now();
	}
}
