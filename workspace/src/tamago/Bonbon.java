package tamago;

public class Bonbon extends Nourriture {
	
	private int varSante;
	private int varSatiete;
	private int varBonheur;
	
	public Bonbon(){
		varSante = -10;
		varSatiete = 5;
		varBonheur = 10;
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