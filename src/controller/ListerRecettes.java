package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.RecetteService;
import service.UtilisateurService;

/**
 * Servlet implementation class ListerRecettes
 */
@WebServlet("/ListerRecettes")
public class ListerRecettes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListerRecettes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//on recupere la liste de recettes
		RecetteService rec = new RecetteService();
		request.setAttribute("recettes", rec.listerRecettes());
		
		//on authentifie l'utilisateur passé en paramètre dans l'url
		if(request.getParameterMap().containsKey("pseudo")) {
			UtilisateurService usr = new UtilisateurService();
			try {
				if ( ! (usr.authentifier(request.getParameter("pseudo"), request.getParameter("password"), request)) )
					request.setAttribute("erreur", true);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Impossible d'identifier l'utilisateur");
				e.printStackTrace();
			}
		}
		
		
		RequestDispatcher disp=request.getRequestDispatcher("/recettes.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameterMap().containsKey("suppRecette")) {
			RecetteService rec = new RecetteService();
			//on recupere les id des recettes cochées dans un tableau
			String[] lesrecettes = request.getParameterValues("suppRecette");
			for( String r : lesrecettes) {
				//parser en INTEGER
				rec.supprimerRecette(Integer.parseInt(r));
			}
		}
		response.sendRedirect("./ListerRecettes");
	}

}
