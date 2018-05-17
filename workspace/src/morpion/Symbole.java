package morpion;

public class Symbole {
	
	private char symbole;
	private Joueur detenteur;
	
	public Symbole(char c, Joueur joueur){
		this.symbole = c;
		this.detenteur = joueur;
	}
	
	public Joueur getDetenteur(){
		return this.detenteur;
	}
	
	public String toString(){
		return Character.toString(this.symbole);
	}


}
