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
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RecetteService rec_serv = new RecetteService();
		request.setAttribute("lesrecettes", rec_serv.dernieresRecettes(3));
		
		RequestDispatcher disp=request.getRequestDispatcher("/index.jsp");
		disp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameterMap().containsKey("login") && request.getParameterMap().containsKey("password")) {
			UtilisateurService usr = new UtilisateurService();
			try {
				if ( ! (usr.authentifier(request.getParameter("login"), request.getParameter("password"), request)) ) {
					request.setAttribute("erreur", "Login ou mot de passe incorrect");
					doGet(request,response);
				}
				else {
					response.sendRedirect("./ListerRecettes");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//else response.sendRedirect("./Index");
	}

}
