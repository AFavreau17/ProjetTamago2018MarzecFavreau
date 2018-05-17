package blackjack;

public class Carte {

	private Couleur couleur;
	private Valeur valeur;
	
	public Carte(Couleur c, Valeur v){
		this.couleur = c;
		this.valeur = v;
	}
	
	public String toString(){
		return this.valeur.toString() + " de " + this.couleur.toString();
	}
	
	public Valeur getValeur(){
		return this.valeur;
	}

}