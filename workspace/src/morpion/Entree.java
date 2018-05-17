package morpion;

import java.util.Scanner;

public class Entree {
	
	public static int lireInt(Scanner scan){
		String entree = scan.nextLine();
		int result = -1;
			
		try{
			result = Integer.parseInt(entree);
		} catch (NumberFormatException e){
				
		}
		return result;
	}

}
