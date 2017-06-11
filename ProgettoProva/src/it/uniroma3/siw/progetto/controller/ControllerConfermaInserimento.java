package it.uniroma3.siw.progetto.controller;


import it.uniroma3.siw.progetto.model.Quadro;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ControllerConfermaInserimento
 */
@WebServlet("/admin/confermaInserimento.do")
public class ControllerConfermaInserimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerConfermaInserimento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		Perchè non c'è l'attributo quadro in sessione?? Viene messo da AzioneInserimentoQuadro
		HttpSession sess = request.getSession();
		Quadro q = (Quadro) sess.getAttribute("quadro");
		*/
		AzioneInserimentoQuadro a = new AzioneInserimentoQuadro(request);
		String risultato = a.esegui();
		String prossimaPagina = "/admin/erroreInserimento.jsp";
		if(risultato.equals("Success")){
			prossimaPagina = "/admin/successoInserimento.jsp";
		}
		ServletContext s = request.getServletContext();
		RequestDispatcher d = s.getRequestDispatcher(prossimaPagina);
		d.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}