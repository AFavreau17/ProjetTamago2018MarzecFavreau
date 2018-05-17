package tamago;

public class Viande extends Nourriture {
	
	private int varSante;
	private int varSatiete;
	private int varBonheur;
	
	public Viande(){
		varSante = -5;
		varSatiete = 10;
		varBonheur = 5;
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
