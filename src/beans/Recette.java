package beans;

import java.util.ArrayList;

public class Recette {
	private int id;
	private String titre;
	private int temps_preparation;
	private int temps_cuisson;
	private String preparation;
	private String remarque;
	private int difficulte;
	private ArrayList<String> lesmotscles;
	private Utilisateur auteur;
	private ArrayList<Ingredient> lesingredients;
	private ArrayList<Photo> lesphotos;
	
	public Recette() {		
	}
	
	public Recette(int unid, String t, int t_prep, int t_cui, String unepreparation, String uneremarque, int d) {
		
		this.id = unid;
		this.titre = t;
		this.temps_preparation = t_prep;
		this.temps_cuisson = t_cui;
		this.preparation = unepreparation;
		this.remarque = uneremarque;
		this.difficulte = d;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getTemps_preparation() {
		return temps_preparation;
	}
	public void setTemps_preparation(int temps_preparation) {
		this.temps_preparation = temps_preparation;
	}
	public int getTemps_cuisson() {
		return temps_cuisson;
	}
	public void setTemps_cuisson(int temps_cuisson) {
		this.temps_cuisson = temps_cuisson;
	}
	public String getPreparation() {
		return preparation;
	}
	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public int getDifficulte() {
		return difficulte;
	}
	public void setDifficulte(int difficulte) {
		this.difficulte = difficulte;
	}
	public ArrayList<String> getMotscles() {
		return lesmotscles;
	}
	public void setMotscles(ArrayList<String> motscles) {
		this.lesmotscles = motscles;
	}
	public Utilisateur getAuteur() {
		return auteur;
	}
	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}
	public ArrayList<Ingredient> getIngredients() {
		return lesingredients;
	}
	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.lesingredients = ingredients;
	}
	public ArrayList<Photo> getPhotos() {
		return lesphotos;
	}
	public void setPhotos(ArrayList<Photo> photos) {
		this.lesphotos = photos;
	}

	
	
	

}
