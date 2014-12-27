package service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UtilisateurDAO;
import beans.Utilisateur;


public class UtilisateurService {

	public boolean authentifier(String login, String password, HttpServletRequest request) throws SQLException {
		UtilisateurDAO user_dao = new UtilisateurDAO();
		//on vérifie que le login existe dans la base donc qu'il renvoie un objet qui n'est pas null
		if(user_dao.getUser(login) != null) {
			//on vérifie que le mot de passe saisie correspond au mot de passe en BD et si le compte est VALIDE
			if(password.equals(user_dao.getUser(login).getPassword())  &&  user_dao.getUser(login).getEtat().equals("VALIDE")) {
				//on créé une session
				HttpSession lasession = request.getSession(true);
				//on stocke l'utilisateur en session
				lasession.setAttribute("user", user_dao.getUser(login));
				return true;
			}
			else return false;
		}
		else {
			request.setAttribute("erreur_connexion", true);
			return false;
		}
		
	}
	
	/* NON UTILISÉ */
	public String creerCompte(String login, String pwd, String nom, String prenom, String mail) throws SQLException {
		Utilisateur u = new Utilisateur();
		u.setPseudo(login);
		u.setPassword(pwd);
		u.setNom(nom);
		u.setPrenom(prenom);
		u.setMail(mail);
		UtilisateurDAO user_dao = new UtilisateurDAO();
		boolean res = user_dao.ajouterUtilisateur(u);
		if(res) return "OK";
		else return "NOK";
		
	}
}
