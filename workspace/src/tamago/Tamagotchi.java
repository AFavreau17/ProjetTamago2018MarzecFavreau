package tamago;

import java.util.ArrayList;
import java.util.Scanner;

public class Tamagotchi {
	
	private String nom;
	private Etat etat;
	private ArrayList<String> vocabulaire;
	private int plus_grand_nombre;
	
	public String getNom(){
		return this.nom; 
	}  
	
	public void setNom(String newNom){
		nom = newNom;
	}
	
	public Etat getEtat(){
		return this.etat;
	}
	
	public void setEtat(Etat newEtat){
		etat = newEtat;	
	}
	
	
	public Tamagotchi(){
		this.etat = new Etat(50, 50, 50, 50, 0, false);
		vocabulaire = new ArrayList<String>();
		plus_grand_nombre = 0;
		
	}
	
	public void manger(Nourriture aliment) {
		this.etat.setSante(aliment.get_varSante());
		this.etat.setSatiete(aliment.get_varSatiete());
		this.etat.setBonheur(aliment.get_varBonheur());
	}
	
	public void soigner(Medicament medoc) {
		this.etat.setSante(medoc.get_varSante());
		this.etat.setBonheur(medoc.get_varBonheur());
	}
	
	public void jouer(Jeu action) {
		this.etat.setSante(action.get_varSante());
		this.etat.setBonheur(action.get_varBonheur());
		this.etat.setEnergie(action.get_varEnergie());
	}
	

	public void afficher_stats(){
		System.out.println("Santé = " + this.etat.getSante());
		System.out.println("Satiété = " + this.etat.getSatiete());
		System.out.println("Energie = " + this.etat.getEnergie());
		System.out.println("Bonheur = " + this.etat.getBonheur());
		System.out.println("Intelligence = " + this.etat.getIntelligence());
		System.out.println("Sommeil = " + this.etat.getSommeil());
	}
	
	private boolean verifier_mot(String mot) {
		int verif = this.vocabulaire.indexOf(mot);
		return !(verif == -1);	
	}

	public void mot() throws InterruptedException{
		Scanner sc = new Scanner(System.in); 
		System.out.println("Quel mot apprendre ?");
		String word = sc.next();
		sc.close();
		if (verifier_mot(word)){
			this.vocabulaire.add(word);
			this.getEtat().setEnergie(-3);
			this.getEtat().setBonheur(-1);
			this.getEtat().setIntelligence(5);
			Thread.sleep(2000);
			System.out.println(this.nom + " a appris le mot " + word);
		}
		else{
			System.out.println(this.nom + " connait déjà ce mot !");
		}
	}
	
	public void mots_appris(){
		System.out.println(this.nom + " connait les mots suivants : ");
		for(String mot:this.vocabulaire){
			System.out.print(mot + ", ");
		}
	}
	
	
	public void nombre() throws InterruptedException{
		System.out.println(this.nom + " se concentre !");
		double x = 1 + 5 * Math.random();
		int n = (int)x;
		this.plus_grand_nombre = this.plus_grand_nombre + n;
		this.getEtat().setIntelligence(n);
		this.getEtat().setEnergie(-4);
		this.getEtat().setBonheur(-2);
		Thread.sleep(2000);
		System.out.println("Intelligence augmentée de" + n + ". " + this.nom + "sait compter jusqu'à " + this.plus_grand_nombre);
	}
	
	public void calcul(int x, int y) throws InterruptedException{
		int z = x + y;
		if ((x < plus_grand_nombre) && (y < plus_grand_nombre) && (z < plus_grand_nombre)) {
			System.out.println(this.nom + " se concentre !");
			System.out.println("Ca fait " + z + " !");
			this.getEtat().setIntelligence(5);
			this.getEtat().setEnergie(-3);
			this.getEtat().setBonheur(1);
		}
		else {
			System.out.println(this.nom + " hésite...");
			System.out.println("Il ne connait pas la réponse...");
			this.getEtat().setEnergie(-3);
			this.getEtat().setBonheur(-5);
		}
	}
		
	public static void main(String[] args) throws InterruptedException {
		Tamagotchi tama = new Tamagotchi();
		Scanner scan = new Scanner(System.in);
			System.out.println("Voulez vous commencer une nouvelle partie ? (O/N)");
			String rep1 = scan.next();
			if (rep1.toLowerCase().equals("o")){
				System.out.println("Vous trouvez un oeuf au sol...");
				Thread.sleep(2000);
				
				System.out.println("Il bouge !");
				System.out.println("");
				Thread.sleep(2000);
				
				System.out.print(". "); Thread.sleep(500); 
				System.out.print(". "); Thread.sleep(500); 
				System.out.println(".");
				
				System.out.println("");
				Thread.sleep(2000);
				
				System.out.println("C'est un tamagotchi !");
				System.out.println("");
				Thread.sleep(3000);
				
				System.out.println("Il faut lui trouver un nom !");
				Thread.sleep(1000);
				System.out.println("Quel nom voulez vous lui donner ?");
				tama.setNom(scan.next());
				Thread.sleep(1000);
				System.out.println(tama.getNom() + " ? C'est bien ca ? (O/N)");
				String rep2 = scan.next();
				while (!(rep2.toLowerCase().equals("o"))){
					System.out.println("Quel nom voulez vous lui donner ?");
					tama.setNom(scan.next());
					Thread.sleep(1000);
					System.out.println(tama.getNom() + " ? C'est bien ca ? (O/N)");
					rep2 = scan.next();
				}
				
				
				System.out.println("Voila qui a l'air de lui plaire !");
				Thread.sleep(1000);
				System.out.println("Bonjour " + tama.getNom() + " !");
			}
			else { 
				System.out.println("Peut etre une prochaine fois alors !");
				System.exit(0);
			}	
		String choix = "0";
		while (!((choix.toLowerCase().equals("quitter la partie")) || (choix.toLowerCase().equals("quitter")) || (choix.equals("5")))){
			System.out.println("");
			System.out.println("Que voulez vous faire ?");
			System.out.println("1 : Manger");
			System.out.println("2 : Soigner");
			System.out.println("3 : Jouer");
			System.out.println("4 : Apprendre");
			System.out.println("5 : Quitter la partie ?");
			choix = scan.next();
			
			if ((choix.toLowerCase().equals("manger")) || (choix.equals("1"))){
				System.out.println("Que voulez vous donner a manger au Tamagotchi ?");
				System.out.println("1 : Viande");
				System.out.println("2 : Légume");
				System.out.println("3 : Bonbon");
				String choixBouffe = scan.next();
				if ((choixBouffe.toLowerCase().equals("viande")) || (choixBouffe.toLowerCase().equals("1"))){
					tama.manger(new Viande());
				}
				else if ((choixBouffe.toLowerCase().equals("legume")) || (choixBouffe.toLowerCase().equals("légume")) || (choixBouffe.equals("2"))){
					tama.manger(new Legume());
				}
				else if ((choixBouffe.toLowerCase().equals("bonbon")) || (choixBouffe.toLowerCase().equals("bonbec")) || (choixBouffe.equals("3"))){
					tama.manger(new Bonbon());
				}
				else{
					System.out.println("Nous n'avons pas ça en stock !");
				}
				tama.afficher_stats();
			}
			
			else if ((choix.toLowerCase().equals("soigner")) || (choix.equals("2"))){
				System.out.println("Quel médicament voulez vous donner au Tamagotchi ?");
				System.out.println("1 : Aspirine");
				System.out.println("2 : Sirop");
				String choixMedoc = scan.next();
				if ((choixMedoc.toLowerCase().equals("aspirine")) || (choixMedoc.toLowerCase().equals("1"))){
					tama.soigner(new Aspirine());
				}
				else if ((choixMedoc.toLowerCase().equals("sirop")) || (choixMedoc.equals("2"))){
					tama.soigner(new Sirop());
				}
				else{
					System.out.println("Nous n'avons pas ça en stock !");
				}
				tama.afficher_stats();
			}
		
			else if ((choix.toLowerCase().equals("jouer")) || (choix.equals("3"))){
				System.out.println("A quoi voulez vous jouer avec le Tamagotchi ?");
				System.out.println("1 : Balade");
				System.out.println("2 : Chatouilles");
				System.out.println("3 : Morpion");
				System.out.println("4 : BlackJack");
				String choixJeu = scan.next();
				if ((choixJeu.toLowerCase().equals("balade")) || (choixJeu.equals("1"))){
					tama.jouer(new Balade());
				}
				else if ((choixJeu.toLowerCase().equals("chatouilles")) || (choixJeu.toLowerCase().equals("chatouille")) || (choixJeu.equals("2"))){
					tama.jouer(new Chatouilles());
				}
				else if ((choixJeu.toLowerCase().equals("morpion")) || (choixJeu.equals("3"))){
					tama.jouer(new Morpion());
				}
				else if ((choixJeu.toLowerCase().equals("blackjack")) || (choixJeu.equals("4"))){
					tama.jouer(new Blackjack());
				}
				else{
					System.out.println("Nous ne pouvons pas jouer à ça !");
				}
				tama.afficher_stats();
			}
		
			else if ((choix.toLowerCase().equals("apprendre")) || (choix.equals("4"))){
				System.out.println("Quel cours voulez vous donner au Tamagotchi ?");
				System.out.println("1 : Vocabulaire (Apprendre des mots)");
				System.out.println("2 : Récitation (Dire les mots appris)");
				System.out.println("3 : Nombres (Apprendre des nombres)");
				System.out.println("4 : Calcul (Faire des additions)");
				String choixCours = scan.next();
				if ((choixCours.toLowerCase().equals("vocabulaire")) || (choixCours.equals("1"))){
					tama.mot();
				}
				else if ((choixCours.toLowerCase().equals("recitation")) || (choixCours.toLowerCase().equals("récitation")) || (choixCours.equals("2"))){
					tama.mots_appris();
				}
				else if ((choixCours.toLowerCase().equals("nombres")) || choixCours.toLowerCase().equals("nombre") || (choixCours.equals("3"))){
					tama.nombre();
				}
				else if ((choixCours.toLowerCase().equals("calcul")) || choixCours.toLowerCase().equals("calculs") || (choixCours.equals("4"))){
					System.out.println("Entrer un nombre : ");
					int i;
					String choixCalcul = scan.next();
					i = Integer.parseInt(choixCalcul); 
					System.out.println("Entrer un second nombre : ");
					int j;
					String choixCalcul2 = scan.next();
					j = Integer.parseInt(choixCalcul2); 
					tama.calcul(i, j);
				}
				else{
					System.out.println("Nous ne pouvons pas apprendre ça !");
				}
				tama.afficher_stats();
			}
			
			else{
				System.out.println("A bientôt !");
			}	
		}
		scan.close();
	}
}
