package it.uniroma3.siw.progetto.controller;


import it.uniroma3.siw.progetto.model.Utente;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ControllerLogin
 */
@WebServlet("/admin/controllerLogin.do")
public class ControllerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contesto = request.getServletContext();
		RequestDispatcher dispatcher = contesto.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AzioneLogin a = new AzioneLogin(request);
		String prossimaPagina = "/login.jsp";
		String risultato = a.esegui();
		/* */
		//Controllo per il primo login
		HttpSession s = request.getSession();
		Utente u = (Utente) s.getAttribute("utente");
		String ruolo = u.getRole();
		if(risultato.equals("Success") && ruolo.equals("admin")){
			prossimaPagina = "/admin/inserimento.jsp";
		}
		if(risultato.equals("Success") && ruolo.equals("user")){
			prossimaPagina = "/errore.jsp";
			s.removeAttribute("utente");
		}
		
		/* */
		
		ServletContext contesto = request.getServletContext();
		RequestDispatcher dispatcher = contesto.getRequestDispatcher(prossimaPagina);
		dispatcher.forward(request, response);
	}

}