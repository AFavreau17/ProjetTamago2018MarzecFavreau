package morpion;

public class Grille {
	
	private CaseGrille[] cases;
	
	public Grille(){
		this.cases = new CaseGrille[9];
		for (int i = 0; i < this.cases.length; i++){
			this.cases[i] = new CaseGrille(i);
		}
	}
	
	private Joueur getDetenteur_de(int id){
		return this.cases[id].getDetenteur();
	}
	
	public void setSymboleOnCase(int caseId, Symbole symbole){
		this.cases[caseId].setSymbole(symbole);
	}
	
	private Joueur getGagnantLigne(){
		Joueur gagnant = null;
		
		for (int ligne = 0; ligne < 3; ligne++){
			Joueur joueur = getDetenteur_de(ligne * 3);
			
			if (joueur == null){
				continue;
			}
			
			if (joueur.equals(getDetenteur_de(1 + ligne * 3))){
				if (joueur.equals(getDetenteur_de(2 + ligne * 3))){
					gagnant = joueur;
					break;
				}
				
			}
		}
		return gagnant;
	}
	
	private Joueur getGagnantColonne(){
		Joueur gagnant = null;
		
		for (int col = 0; col < 3; col++){
			Joueur joueur = getDetenteur_de(col);
			
			if (joueur == null){
				continue;
			}
			
			if (joueur.equals(getDetenteur_de(col + 3))){
				if (joueur.equals(getDetenteur_de(col + 6))){
					gagnant = joueur;
					break;
				}
				
			}
		}
		return gagnant;
	}
	
	public Joueur getGagnant(){
		Joueur gagnant = null;
		
		gagnant = getGagnantLigne();
		if (gagnant != null){
			return gagnant;
		}
		
		gagnant = getGagnantColonne();
		if (gagnant != null){
			return gagnant;
		}
		
		Joueur joueur = getDetenteur_de(0);
		if (joueur != null && joueur.equals(getDetenteur_de(4))){
			if (joueur.equals(getDetenteur_de(8))){
				return joueur;
			}	
		}
		
		joueur = getDetenteur_de(2);
		if (joueur != null && joueur.equals(getDetenteur_de(4))){
			if (joueur.equals(getDetenteur_de(6))){
				return joueur;
			}	
		}
		return gagnant;
	}
	
	public boolean complet(){
		boolean complet = true;
		
		for (int i = 0; i < this.cases.length; i++){
			if (this.cases[i].vide()){
				complet = false;
				break;
			}
				
		}
		return complet;
	}
	
	public void clear(){

	}
	
	public String toString() {
		StringBuilder construction = new StringBuilder(" _____ _____ _____");
		construction.append(System.lineSeparator());
		construction.append("|     |     |     |");
		construction.append(System.lineSeparator());
		construction.append("|  ");
		construction.append(this.cases[0]);
		construction.append("  |  ");
		construction.append(this.cases[1]);
		construction.append("  |  ");
		construction.append(this.cases[2]);
		construction.append("  |");
		construction.append(System.lineSeparator());
		construction.append("|_____|_____|_____|");
		construction.append(System.lineSeparator());
		construction.append("|     |     |     |");
		construction.append(System.lineSeparator());
		construction.append("|  ");
		construction.append(this.cases[3]);
		construction.append("  |  ");
		construction.append(this.cases[4]);
		construction.append("  |  ");
		construction.append(this.cases[5]);
		construction.append("  |");
		construction.append(System.lineSeparator());
		construction.append("|_____|_____|_____|");
		construction.append(System.lineSeparator());
		construction.append("|     |     |     |");
		construction.append(System.lineSeparator());
		construction.append("|  ");
		construction.append(this.cases[6]);
		construction.append("  |  ");
		construction.append(this.cases[7]);
		construction.append("  |  ");
		construction.append(this.cases[8]);
		construction.append("  |");
		construction.append(System.lineSeparator());
		construction.append("|_____|_____|_____|");
		return construction.toString();
	}
	

}
