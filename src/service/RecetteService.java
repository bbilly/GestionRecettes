package service;

import java.util.ArrayList;

import dao.RecetteDAO;
import beans.Recette;

public class RecetteService {
	
	public ArrayList<Recette> listerRecettes() {
		RecetteDAO rec_dao = new RecetteDAO();
		return rec_dao.lesrecettes();
	}
	
	public void supprimerRecette(int id_recette) {
		RecetteDAO rec_dao = new RecetteDAO();
		rec_dao.supprimerRecette(id_recette);
	}
	
	public ArrayList<Recette> dernieresRecettes(int n) {
		RecetteDAO rec_dao = new RecetteDAO();
		return rec_dao.dernieresRecettes(n);
	}
}
