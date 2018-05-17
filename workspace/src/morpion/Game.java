package morpion;

import java.util.Scanner;

public class Game {
	
	private Grille grille;
	private Joueur joueur1;
	private Joueur joueur2;
	private Joueur joueurActuel;
	
	public Game(){
		this.grille = new Grille();
		this.joueur1 = new Joueur(0, 'O');
		this.joueur2 = new Joueur(1, 'X');
	}
	
	private void passerTour(){
		if (this.joueurActuel.equals(this.joueur1)){
			this.joueurActuel = this.joueur2;
		}
		else{
			this.joueurActuel = this.joueur1;
		}
	}
	
	private int getPositionJoueur(Scanner scan){
		int position = -1;
		
		while (true) {
			
			System.out.println("Joueur '" + this.joueurActuel.getSymbole() + "', c'est ton tour !");
			position = Entree.lireInt(scan);
			
			if (0 <= position && position <= 8){
				break;
			}
		}
		return position;
	}
	
	private void afficherGrille(){
		System.out.println(this.grille);
		//flush permet de réinitialiser notre affichage
		System.out.flush();
	}

	public void debuter(){
		joueurActuel = this.joueur1;
		Scanner scan = new Scanner(System.in);
		
		while (true){
			afficherGrille();
			
			int position = getPositionJoueur(scan);
			this.grille.setSymboleOnCase(position, this.joueurActuel.getSymbole());
			
			if (this.grille.getGagnant() != null){
				afficherGrille();
				System.out.println("Joueur '" + this.joueurActuel.getSymbole() + "' a gagné la partie !");
				break;
			} else if (this.grille.complet()){
				afficherGrille();
				System.out.println("Egalité !");
				break;
			}
			passerTour();
		}
		scan.close();
	}
	
	public void reset(){
		this.grille.clear();
	}
}
