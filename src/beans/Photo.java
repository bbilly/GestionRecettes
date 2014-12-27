package beans;

public class Photo {
	private String titre;
	private String base64;
	private Recette unerecette;
	
	public Photo() {
	}
	
	public Photo(String untitre, String uncontenu) {
		this.titre = untitre;
		this.base64 = uncontenu;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getBase64() {
		return base64;
	}
	public void setBase64(String base64) {
		this.base64 = base64;
	}
	public Recette getUnerecette() {
		return unerecette;
	}
	public void setUnerecette(Recette unerecette) {
		this.unerecette = unerecette;
	}
	
	
	
	
}
