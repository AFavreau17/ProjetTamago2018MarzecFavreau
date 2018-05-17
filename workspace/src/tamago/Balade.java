package tamago;

public class Balade extends Jeu {

	private int varSante;
	private int varBonheur;
	private int varEnergie;
	
	public Balade(){
		varSante = 5;
		varBonheur = 5;
		varEnergie = -10;
	}
	
	public int get_varSante(){
		return varSante;
	}
	
	public int get_varBonheur(){
		return varBonheur;
	}
	
	public int get_varEnergie(){
		return varEnergie;
	}
	
}
	