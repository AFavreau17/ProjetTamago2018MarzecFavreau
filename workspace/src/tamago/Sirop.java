package tamago;

public class Sirop extends Medicament {
	
	private int varSante;
	private int varBonheur;
	
	public Sirop(){
		varSante = 2;
		varBonheur = -1;
	}
	
	public int get_varSante(){
		return varSante;
	}
	
	public int get_varBonheur(){
		return varBonheur;
	}
}