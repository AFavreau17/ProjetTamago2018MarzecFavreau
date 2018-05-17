package tamago;

public class Legume extends Nourriture {
	
	private int varSante;
	private int varSatiete;
	private int varBonheur;
	
	public Legume(){
		varSante = 5;
		varSatiete = 5;
		varBonheur = -10;
	}
	
	public int get_varSante(){
		return varSante;
	}
	
	public int get_varSatiete(){
		return varSatiete;
	}
	
	public int get_varBonheur(){
		return varBonheur;
	}
}



