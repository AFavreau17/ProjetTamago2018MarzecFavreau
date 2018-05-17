package morpion;

public class CaseGrille {
	
	private int id;
	private Symbole symb;
	
	public CaseGrille(int caseId){
		this.id = caseId;
		this.symb = null;
	}
	
	public CaseGrille(int caseId, Symbole symb){
		this.id = caseId;
		this.symb = symb;
	}
	
	public void setSymbole(Symbole symb){
		this.symb = symb;
	}
	
	public Joueur getDetenteur(){
		if (this.symb != null){
			return this.symb.getDetenteur();
		}
		else {
			return  null;
		}
	}
	
	public boolean vide(){
		return this.symb == null;
	}
	
	public String toString(){
		if (this.symb != null){
			return this.symb.toString();
		}
		else{
			return Integer.toString(this.id);
		}
	}

}
