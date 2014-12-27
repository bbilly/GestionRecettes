package beans;

public class Ingredient {
	
	private int id_ingredient;
	private String nom;
	private int quantite;
	private String unite;
	private Recette unerecette;
	
	
	public Ingredient() {
	}
	
	public Ingredient(int id, String unnom, int unequantite, String uneunite) {
		this.id_ingredient = id;
		this.nom = unnom;
		this.quantite = unequantite;
		this.unite = uneunite;
	}
	public Ingredient(int id, String unnom, int unequantite, String uneunite, Recette r) {
		this.id_ingredient = id;
		this.nom = unnom;
		this.quantite = unequantite;
		this.unite = uneunite;
		this.unerecette = r;
	}

	public int getId_ingredient() {
		return id_ingredient;
	}


	public void setId_ingredient(int id_ingredient) {
		this.id_ingredient = id_ingredient;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public String getUnite() {
		return unite;
	}


	public void setUnite(String unite) {
		this.unite = unite;
	}


	public Recette getUnerecette() {
		return unerecette;
	}


	public void setUnerecette(Recette unerecette) {
		this.unerecette = unerecette;
	}


	
	
	
	
	
}
