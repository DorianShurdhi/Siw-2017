package it.uniroma3.siw.progetto.controller;

import it.uniroma3.siw.progetto.model.FacadeLogin;
import it.uniroma3.siw.progetto.model.Utente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AzioneLogin {
	private HttpServletRequest request;

	public AzioneLogin(HttpServletRequest request) {
		this.request = request;
	}

	public String esegui() {
		HttpSession sessione = this.request.getSession();
		sessione.setMaxInactiveInterval(2*60*60);
		String risultato = "Fail";
		FacadeLogin f = new FacadeLogin();
		String username = this.request.getParameter("username");
		String password = this.request.getParameter("password");
		Utente u = f.login(username, password);
		if(u!= null){
			sessione.setAttribute("utente", u);
			risultato="Success";
		}
		return risultato;
	}

}