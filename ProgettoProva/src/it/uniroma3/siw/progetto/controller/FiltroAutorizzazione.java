package it.uniroma3.siw.progetto.controller;

import it.uniroma3.siw.progetto.model.Utente;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class FiltroAutorizzazione implements Filter {
	private ServletContext application;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		String ruolo = null;
		if (session.getAttribute("utente")!= null){
			ruolo = ((Utente)session.getAttribute("utente")).getRole();
			if (ruolo.equals("admin")){
				chain.doFilter(request, response);	
			}
			else {
				RequestDispatcher rd  = this.application.getRequestDispatcher("/errore.jsp");
				rd.forward(request, response);
			}
		}else{
			RequestDispatcher rd  = this.application.getRequestDispatcher("/admin/controllerLogin.do");
			rd.forward(request, response);
		}
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.application = arg0.getServletContext();		
	}


}