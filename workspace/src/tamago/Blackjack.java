package tamago;

public class Blackjack extends Jeu {

	private int varSante;
	private int varBonheur;
	private int varEnergie;
	
	public Blackjack(){
		varSante = 2;
		varBonheur = 8;
		varEnergie = -5;
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
	