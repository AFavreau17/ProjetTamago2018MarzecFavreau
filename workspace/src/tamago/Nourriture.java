package tamago;

public abstract class Nourriture {
	
	private int varSante;
	private int varSatiete;
	private int varBonheur;
	
	public Nourriture(){
		
	}

	public int get_varSante(){
		return this.varSante;
	}
	
	public int get_varSatiete(){
		return this.varSatiete;
	}
	
	public int get_varBonheur(){
		return this.varBonheur;
	}	
}







