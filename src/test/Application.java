package test;

import java.sql.SQLException;

import beans.Ingredient;
import beans.Recette;
import beans.Utilisateur;
import dao.RecetteDAO;
import dao.UtilisateurDAO;

public class Application {
	
	public static void main (String[] arg) throws SQLException {
		/*	
		UtilisateurDAO dao_user = new UtilisateurDAO();
		Utilisateur u = dao_user.getUser("admin");
		System.out.println("-----INFOS ADMIN -----------");
		System.out.println("Nom : "+u.getNom());
		System.out.println("Prénom : "+u.getPrenom());
		System.out.println("Mail : "+u.getMail());
		System.out.println("\r");
		*/
		//Utilisateur nu = new Utilisateur("ldupont", "ldupont", "ldupont@gmail.com", "Dupont", "Laurent","ATTENTE",false);
		//System.out.println("AJout Utilisateur : "+ledao.ajouterUtilisateur(nu));
		//ledao.validerUtilisateur("tdupont");
		
		
		RecetteDAO dao_recette = new RecetteDAO();
		UtilisateurDAO user_dao = new UtilisateurDAO();
		Recette r = dao_recette.getRecetteById(1);
		System.out.println("-----MA PREMIERE RECETTE------");
		System.out.println("Titre : "+r.getTitre());
		System.out.println("Proposé par :"+r.getAuteur().getNom()+" "+r.getAuteur().getPrenom());
		System.out.println("Temps de préparation : "+r.getTemps_preparation());
		System.out.println("Temps de cuisson : "+r.getTemps_cuisson());
		System.out.println("Difficulté : "+r.getDifficulte()+"/5");
		System.out.println("------INGREDIENTS-------------");
		for(Ingredient i : r.getIngredients()) {
			System.out.println(i.getQuantite()+" "+i.getUnite()+" "+i.getNom());
		}
		System.out.println("------PREPARATION-------------");
		System.out.println(r.getPreparation());
		System.out.println("------AUTRES INFOS UTILES-----");
		System.out.println("Mots clés : ");
		for(String mot : r.getMotscles()) {
			System.out.println("-- "+mot);
		}
		Utilisateur auteur = user_dao.getUser(r.getAuteur().getPseudo());
		System.out.println("Nombre de recettes de "+r.getAuteur().getPseudo()+" : "+dao_recette.getRecettesByUtilisateur(auteur));
		
		
//		IngredientDAO ing_dao = new IngredientDAO();
//		System.out.println(ing_dao.getIngredientsRecette(1).get(1).getNom());
	}
}
