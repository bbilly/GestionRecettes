package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Ingredient;

public class IngredientDAO extends DAO{
	
	public IngredientDAO() {
		super();
	}
	
	public ArrayList<Ingredient> getIngredientsRecette(int id_recette) {
		ArrayList<Ingredient> lesingredients = new ArrayList<Ingredient> ();
		Connection conn = this.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("SELECT * from ingredient WHERE id_recette=?");
			ps.setInt(1, id_recette);
			rs = ps.executeQuery();
			while(rs.next()) {
				lesingredients.add(this.creerIngredient(rs));
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
		
		return lesingredients;
	}
	
	public void SupprimerIngredientsRecette(int id_recette) {
		Connection conn = this.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("DELETE FROM ingredient WHERE id_recette=?");
			ps.setInt(1, id_recette);
			ps.executeUpdate();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur SQL : " + e.getMessage());
			e.printStackTrace();
		} finally {
			this.closeConnection(ps);
			this.closeConnection(conn);
		}
		
	}
	
	
	/* On renvoie une instance d'ingredient à partir d'un resultSet */
	public Ingredient creerIngredient(ResultSet rs) {
		Ingredient i = new Ingredient();
		try {
			i.setId_ingredient(rs.getInt("id_ingredient"));
			i.setNom(rs.getString("nom"));
			i.setQuantite(rs.getInt("quantite"));
			i.setUnite(rs.getString("unite"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur SQL : " + e.getMessage());
			e.printStackTrace();
		}
		
		
		return i;
	}
	
}
