package beans;

import java.util.ArrayList;

public class Utilisateur {
	private String pseudo;
	private String password;
	private String mail;
	private String nom;
	private String prenom;
	private String etat;
	private boolean isAdmin;
	private ArrayList<Recette> sesrecettes;
	
	public Utilisateur() {
		
	}
	
	public Utilisateur(String unlogin, String password, String unmail, String unnom, String unprenom, String unetat, boolean unadmin) {
		this.pseudo = unlogin;
		this.password = password;
		this.mail = unmail;
		this.nom = unnom;
		this.prenom = unprenom;
		this.etat = unetat;
		this.isAdmin = unadmin;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String login) {
		this.pseudo = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public ArrayList<Recette> getLesrecettes() {
		return sesrecettes;
	}
	public void setLesrecettes(ArrayList<Recette> lesrecettes) {
		this.sesrecettes = lesrecettes;
	}
	

}
