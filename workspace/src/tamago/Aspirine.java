package tamago;

public class Aspirine extends Medicament {
	
	private int varSante;
	private int varBonheur;
	
	public Aspirine(){
		varSante = 5;
		varBonheur = -5;
	}
	
	public int get_varSante(){
		return varSante;
	}
	
	public int get_varBonheur(){
		return varBonheur;
	}
}