package tamago;

public class Etat {
	
	private int sante;
	private int satiete;
	private int energie;
	private int bonheur;
	private int intelligence;
	private boolean sommeil;
	
	
	public Etat(int sante, int satiete, int energie, int bonheur, int intelligence, boolean sommeil){
		this.sante = sante;
		this.satiete = satiete;
		this.energie = energie;
		this.bonheur = bonheur;
		this.intelligence = intelligence;
		this.sommeil = sommeil;
	}
	
	
///////////////////////////////////////////////////////////////////
	
	public int getSante(){
		return sante; 
	}  
		
	public int getSatiete(){
		return satiete;
	} 
		
	public int getEnergie(){
		return energie;
	} 
		
	public int getBonheur(){
		return bonheur;
	} 
		
	public int getIntelligence(){
		return intelligence;
	} 
		
	public boolean getSommeil(){
		return sommeil;
	} 
		
///////////////////////////////////////////////////////////////////
	
	
	public void setSante(int sant){
		sante = getSante() + sant; 
		if (sante > 100){
			sante = 100;
		}
		if (sante <= 0){
			System.out.println("Le Tamagotchi est mort !");
			System.out.println("");
			System.out.println("GAME OVER");
		}
	}
	
	public void setSatiete(int sati){
		satiete = getSatiete() + sati; 
		if (satiete > 100){
			satiete = 100;
		}
		if (satiete < 0){
			setSante(satiete);
			satiete = 0;
		}
	}
	
	public void setEnergie(int ener){
		energie = getEnergie() + ener; 
		if (energie >100){
			energie = 100;
		}
		if (energie < 0){
			System.out.println("La tamagotchi tombe de fatigue !");
			System.out.println("...");
			System.out.println("Mieux vaut le laisser se reposer pour le moment");
			setSommeil();
			energie = 0;
		}
	}
	
	public void setBonheur(int bon){
		bonheur = getBonheur() + bon; 
		if (bonheur > 100){
			bonheur = 100;
		}
		if (bonheur < 0){
			System.out.println(" est déprimé.");
			System.out.println("Il ne fera plus aucune activité avant que vous ne lui redoniez le sourire.");
			setSante(bonheur);
			bonheur = 0;
		}
	}
	
	public void setIntelligence(int intel){
		intelligence = getIntelligence() + intel; 
	}
	
	public void setSommeil(){
		sommeil = !(sommeil); 
	}

///////////////////////////////////////////////////////////////////
	
	public void afficheEtat(){
		System.out.println("Sante : " + sante + "\nSatiete : " + satiete + "\nEnergie : " + energie + "\nBonheur : " + bonheur + "/nIntelligence : " + intelligence + "/nSommeil : " + sommeil);
	}

}
