package morpion;

public class Joueur {
	
	private int id;
	private Symbole symbole;

	public Joueur(int idJoueur, char c){
		this.id = idJoueur;
		this.symbole = new Symbole(c, this);
	}
		
	public Symbole getSymbole(){
		return this.symbole;
	}
		
	public boolean equals(Object other){
		if (other == null){
			return false;
		}
		if (other instanceof Joueur){
			Joueur joueur = (Joueur)other;
			return joueur.id == this.id;
		} 
		else {
			return false;
		}
	}

}
