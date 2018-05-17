package blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Carte> cartes;
	
	public Deck(){
		this.cartes = new ArrayList<Carte>();
	
	}
	

	public void creerDeck(){
		//on boucle pour chaque couleur puis pour chaque valeur des cartes pour creer notre deck
		for(Couleur couleurCarte : Couleur.values()){
			for(Valeur valeurCarte : Valeur.values()){
				this.cartes.add(new Carte(couleurCarte,valeurCarte));
			}
		}
	}
	
	
public void melanger(){
	//On cree une Arraylist qui correspond a notre nouveau deck 
	ArrayList<Carte> newDeck = new ArrayList<Carte>();
	//On prend au hasard une carte de notre premier deck pour l'ajouter au nouveau
	Random random = new Random();
	int randIndexCartes = 0;
	int tailleDeck = this.cartes.size();
	for(int i = 0; i<tailleDeck;i++){
		//a chaque boucle on genere un un index aléatoire comprit entre 0 et le nombre de cartes actuel de notre premier deck
		randIndexCartes = random.nextInt(this.cartes.size());
		//on ajoute maintenant la carte correspondant à l'index trouve
		newDeck.add(this.cartes.get(randIndexCartes));
		//bien sur on enleve la dite carte du premier deck
		this.cartes.remove(randIndexCartes);
	}
	//enfin on attribue à notre deck premier (ou principal) le contenu de newDeck qui est un deck melange 
	this.cartes = newDeck;
}
	
	
	public void retirerCarte(int i){
		this.cartes.remove(i);
	}
	
	public Carte getCarte(int i){
		return this.cartes.get(i);
	}
	
	public void ajouterCarte(Carte carte){
		this.cartes.add(carte);
	}
	
	//Ici on tire une carte d'un deck appele pioche pour le mettre dans notre main: cartes, qui est notre variable de classe
	public void piocher(Deck pioche){
		//on pioche dans la pioche pour remplir notre deck cartes qui sera notre main
		this.cartes.add(pioche.getCarte(0));
		//il faut donc retirer cette carte de la pioche
		pioche.retirerCarte(0);
	}
	
	//On peut afficher le deck
	public String toString(){
		String listeCartes = "";
		for(Carte carte : this.cartes){
			listeCartes += "\n" + carte.toString();
		}
		return listeCartes;
	}
	
	//On cherche a deplacer le deck pour par exemple remettre nos cartes dans la pioche
	public void deplacerDeck(Deck arrivee){
		int tailleDeck = this.cartes.size();
		for(int i = 0; i < tailleDeck; i++){
			arrivee.ajouterCarte(this.getCarte(i));
		}
		//on vide bien sur le deck qui a transmis ses cartes au deck arrivee
		for(int i = 0; i < tailleDeck; i++){
			this.retirerCarte(0);
		}
	}
	
	public int tailleDeck(){
		return this.cartes.size();
	}
	

	public int scoreCartes(){
		int total = 0;
		//On compte les as a part parce qu'ils peuvent prendre 2 valeurs
		int nb_as = 0;
		//on parcourt toutes les cartes de notre main
		for(Carte carte : this.cartes){
			//On convertit la valeur de la carte en son score et on l'ajoute au total ou a nb_as selon cette valeur
			switch(carte.getValeur()){
			case Deux: total += 2; break;
			case Trois: total += 3; break;
			case Quatre: total += 4; break;
			case Cinq: total += 5; break;
			case Six: total += 6; break;
			case Sept: total += 7; break;
			case Huit: total += 8; break;
			case Neuf: total += 9; break;
			case Dix: total += 10; break;
			case Valet: total += 10; break;
			case Reine: total += 10; break;
			case Roi: total += 10; break;
			case As: nb_as += 1; break;
			}			
		}
		
		//On convertit maintenant les as en 1 ou en 11 selon le score total actuel
		for(int i = 0; i < nb_as; i++){
			//Si total>10 alors un as valant 11 nous ferait depasser 11
			if (total > 10){
				total += 1;
			}
			else{
				total += 11;
			}
		}
		return total;
	
	}
	
	
}