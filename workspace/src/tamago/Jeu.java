package tamago;

public abstract class Jeu {
		
	private int varSante;
	private int varBonheur;
	private int varEnergie;
		
	public Jeu(){
			
	}

	public int get_varSante(){
		return this.varSante;
	}
		
	public int get_varBonheur(){
		return this.varBonheur;
	}
	
	public int get_varEnergie(){
		return this.varEnergie;
	}
	
}



