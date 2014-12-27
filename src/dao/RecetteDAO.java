package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Photo;
import beans.Recette;
import beans.Utilisateur;

public class RecetteDAO extends DAO {
	
	public RecetteDAO() {
		super();
	}
	
	public Recette getRecetteById(int id_recette) {
		Connection conn = this.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Recette r = null;
		
		try {
			
			//requete pour recuperer la recette
			ps = conn.prepareStatement("SELECT * FROM recette WHERE id=?");
			ps.setInt(1, id_recette);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				r = new Recette(rs.getInt("id"), rs.getString("nom"),rs.getInt("temps_preparation"),rs.getInt("temps_cuisson"),rs.getString("preparation"),rs.getString("remarque"),rs.getInt("difficulte"));
				
				//on recupere l'auteur de la recette
				UtilisateurDAO dao_user = new UtilisateurDAO();
				Utilisateur auteur = dao_user.getUser(rs.getString("auteur"));
				r.setAuteur(auteur);
				
				//on recupere les ingredients
				IngredientDAO ing_dao = new IngredientDAO();
				r.setIngredients(ing_dao.getIngredientsRecette(rs.getInt("id")));
				
				
				//on recupere les mots cles pour les stocker dans une liste
				ArrayList<String> lesmotscles = new ArrayList<String> ();
				for(String mot:rs.getString("mots_cles").split(";")) {
					lesmotscles.add(mot);
				}
				r.setMotscles(lesmotscles);

				
				//requete pour recuperer la/les photo(s) de la recette
				PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM photo_recette WHERE id_recette=?");
				ps2.setInt(1, rs.getInt("id"));
				ResultSet rs2 = ps2.executeQuery();
				ArrayList<Photo> lesphotos = new ArrayList<Photo> ();
				while(rs2.next()) {
					Photo p = new Photo(rs2.getString("titre"), rs2.getString("contenu"));
					lesphotos.add(p);
				}
				r.setPhotos(lesphotos);
				this.closeConnection(rs2);
				this.closeConnection(ps2);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur SQL : " + e.getMessage());
			e.printStackTrace();
		} finally {
			this.closeConnection(rs);
			this.closeConnection(ps);
			this.closeConnection(conn);
		}
		
		return r;
	}
	
	public ArrayList<Recette> getRecettesByUtilisateur(Utilisateur user) {
		
		ArrayList<Recette> sesrecettes = new ArrayList<Recette> ();
		Connection conn = this.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT id from recette WHERE auteur=? ORDER BY DESC");
			ps.setString(1, user.getPseudo());
			rs = ps.executeQuery();
			while(rs.next()) {
				Recette r = this.getRecetteById(rs.getInt("id"));
				sesrecettes.add(r);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur SQL : " + e.getMessage());
			e.printStackTrace();
		} finally {
			this.closeConnection(rs);
			this.closeConnection(ps);
			this.closeConnection(conn);
		}
		
		return sesrecettes;
	}
	
	public ArrayList<Recette> lesrecettes() {
		
		ArrayList<Recette> lesrecettes = new ArrayList<Recette> ();
		Connection conn = this.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps  = conn.prepareStatement("SELECT * from recette");
			rs = ps.executeQuery();
			while(rs.next()) {
				Recette r = this.getRecetteById(rs.getInt("id"));
				lesrecettes.add(r);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur SQL : " + e.getMessage());
			e.printStackTrace();
		} finally {
			this.closeConnection(rs);
			this.closeConnection(ps);
			this.closeConnection(conn);
		}
		
		return lesrecettes;
		
	}
	
	public ArrayList<Recette> dernieresRecettes(int n) {
		
		ArrayList<Recette> lesrecettes = new ArrayList<Recette> ();
		Connection conn = this.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT id from recette order by id desc LIMIT ? ");
			ps.setInt(1, n);
			rs = ps.executeQuery();
			while(rs.next()) {
				Recette r = this.getRecetteById(rs.getInt("id"));
				lesrecettes.add(r);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur SQL : " + e.getMessage());
			e.printStackTrace();
		} finally {
			this.closeConnection(rs);
			this.closeConnection(ps);
			this.closeConnection(conn);
		}
		
		return lesrecettes;
	}
	
	public boolean supprimerRecette(int id) {
		Connection conn = this.getConnection();
		PreparedStatement ps = null;
		try {
		
			IngredientDAO ing_dao = new IngredientDAO();
			//on supprime les ingredients avant la recette
			ing_dao.SupprimerIngredientsRecette(id);
			ps = conn.prepareStatement("DELETE FROM recette WHERE id=?");
			ps.setInt(1, id);
			int res = ps.executeUpdate();
			if(res==0)return true;
			else return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur SQL : " + e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			this.closeConnection(ps);
			this.closeConnection(conn);
		}
		
	}
}
