package tn.iit.glid23.auth.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tn.iit.dao.UtilisateurDao;
import tn.iit.glid23.auth.model.UtilisateurModel;

/**
 * Servlet implementation class AuthController
 */
@WebServlet("/AuthController")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("email");
		String pwd = request.getParameter("password");
		HttpSession session = request.getSession();
		UtilisateurDao dao = new UtilisateurDao();
		UtilisateurModel u = dao.getByLoginPdw(login, pwd);
		if (u == null) {
			request.setAttribute("erreur", "Veuillez vérifier vos paramètres !!!");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/auth.jsp");
			rd.forward(request, response);
		} else {
			session.setAttribute("courant", u);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/bienvenu.jsp");
			rd.forward(request, response);
		}

	}

}
