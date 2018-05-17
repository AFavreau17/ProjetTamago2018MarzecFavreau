package tamago;

public class Chatouilles extends Jeu {

	private int varSante;
	private int varBonheur;
	private int varEnergie;
	
	public Chatouilles(){
		varSante = 2;
		varBonheur = 6;
		varEnergie = -7;
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
	