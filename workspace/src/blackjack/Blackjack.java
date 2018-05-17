package blackjack;

import tamago.Jeu;
import tamago.Tamagotchi;
import tamago.Etat;

import java.util.Scanner;
import java.util.*;


public class Blackjack extends Jeu{		

	private int varIntelligence;	
	private int varBonheur; 
	private int varEnergie;
	Tamagotchi tama;

	public Blackjack(Tamagotchi tama){
		this.tama = tama;
	}
	
	public void statsBlackjack(int x, int y, int z){
		this.tama.getEtat().setIntelligence(this.tama.getEtat().getIntelligence()+x);
		this.tama.getEtat().setBonheur(this.tama.getEtat().getBonheur()+x);
		this.tama.getEtat().setEnergie(this.tama.getEtat().getEnergie()+x);
		
	}

	public int get_varIntelligence(){
		return varIntelligence;
	}
	
	public int get_varBonheur(){
		return varBonheur;
	}
	
	public int get_varEnergie(){
		return varEnergie;
	}
	


	public static void main(String[] args) throws InterruptedException{
			
		System.out.println("Jouons au Blackjack !");
			
		Deck pioche = new Deck();
		//la pioche est le deck duquel le joueur et la banque tireront leur mains
		pioche.creerDeck();
		pioche.melanger();
			
		//On cree un deck vide pour les cartes du joueur
		Deck cartesJoueur = new Deck();
		//de meme pour la banque
		Deck cartesBanque = new Deck();
			
		//On import un scanner pour que le joueur saisisse ses actions
		Scanner scan = new Scanner(System.in);
		System.out.println("On commence ? (O/N)");
		String rep = scan.next();	
		
		//On demarre une boucle de jeu qui ne se termine pas tant que le joueur veut jouer et que le tamagotchi a assez d'énergie
		if(rep.toLowerCase().equals("o")) {
			
			boolean endRound = false;
		
		System.out.println("Distribution...");
		//Le joueur pioche deux cartes
		cartesJoueur.piocher(pioche);
		cartesJoueur.piocher(pioche);
		
		//De même pour la banque
		cartesBanque.piocher(pioche);
		cartesBanque.piocher(pioche);
				
				//On fait une boucle qui s'arrete si le joueur depasse 21 ou arrete de piocher
				while(true)
				{
					Thread.sleep(1500);
					//On montre au joueur ses cartes
					System.out.println("Ta main:" + cartesJoueur.toString());
					Thread.sleep(1500);
					//On convertit cette main en points
					System.out.println("Tu as actuellement " + cartesJoueur.scoreCartes() + " points");
					Thread.sleep(1500);
					//On ne montre que la premiere carte de la main de la banque
					System.out.println("La main de la banque: " + cartesBanque.getCarte(0).toString() + " et une carte inconnue");
					Thread.sleep(1500);
					//On propose au joueur de tirer ou de s'arreter la
					System.out.println("Veux tu (1)piocher ou (2)arrêter ?");
					int response = scan.nextInt();	
					
					
					//Si le joueur pioche
					if(response == 1){
						cartesJoueur.piocher(pioche);
						Thread.sleep(1500);
						System.out.println("Tu pioches un: " + cartesJoueur.getCarte(cartesJoueur.tailleDeck()-1).toString());
						//Le jeu s'arrete si on depasse 21
						if(cartesJoueur.scoreCartes() > 21){
							Thread.sleep(1500);
							System.out.println("Eliminé ! Ta main a dépassé 21 ! Elle vaut: " + cartesJoueur.scoreCartes());
							endRound = true;
							break;
						}
					}
					
					//sinon
					if(response == 2){
						Thread.sleep(1500);
						break;
					}
					
				}
					
				//Ici le joueur ne joue plus, c'est à la banque de jouer
				System.out.println("Main de la banque: " + cartesBanque.toString());
				//On compare les scores
				if((cartesBanque.scoreCartes() > cartesJoueur.scoreCartes())&&endRound == false){
					Thread.sleep(1500);
					System.out.println("La banque t'a battu ! " + cartesBanque.scoreCartes() + " points à " + cartesJoueur.scoreCartes());
					endRound = true;
				}
				//La banque joue tant que son score n'est pas superieur à celui du joueur et qu'elle n'a pas perdu
				while((cartesBanque.scoreCartes() <  cartesJoueur.scoreCartes()) && endRound == false){
					cartesBanque.piocher(pioche);
					Thread.sleep(1500);
					System.out.println("La banque pioche: " + cartesBanque.getCarte(cartesBanque.tailleDeck()-1).toString());
				}
				//On montre le score de la banque
				Thread.sleep(1500);
				System.out.println("La main de la banque vaut: " + cartesBanque.scoreCartes());
				//On verifie que la banque ne saute pas
				if((cartesBanque.scoreCartes()>21)&& endRound == false){
					Thread.sleep(1500);
					System.out.println("la banque saute ! Tu as gagné !");
					endRound = true;
				}
				//Ici il y a le cas d'egalite
				if((cartesBanque.scoreCartes() == cartesJoueur.scoreCartes()) && endRound == false){
					Thread.sleep(1500);
					System.out.println("Egalité !");
					endRound = true;
				}
				//le cas où le joueur gagne
				if((cartesJoueur.scoreCartes() > cartesBanque.scoreCartes()) && endRound == false){
					Thread.sleep(1500);
					System.out.println("Tu as gagné !");
					endRound = true;
				}
				//si la banque gagne
				else if(endRound == false) 
				{
					Thread.sleep(1500);
					System.out.println("La banque l'emporte...");
				}

				//C'est la fin du jeu, on remet les cartes dans la pioche
				cartesJoueur.deplacerDeck(pioche);
				cartesBanque.deplacerDeck(pioche);
				System.out.println("Fin du jeu !");
			}
			scan.close();
			
		}
	
}
