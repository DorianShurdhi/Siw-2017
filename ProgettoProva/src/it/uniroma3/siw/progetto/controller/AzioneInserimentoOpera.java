package it.uniroma3.siw.progetto.controller;


import it.uniroma3.siw.progetto.model.Opera;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AzioneInserimentoOpera {
	private HttpServletRequest request;
	
	public AzioneInserimentoOpera(HttpServletRequest request) {
		this.request = request;
	}

	public String esegui() {
		String risultato = "Fail";
		HelperInserimentoOpera h = new HelperInserimentoOpera(request);
		if(h.convalida()){
			HttpSession s = this.request.getSession();
			String titolo = request.getParameter("titolo");
			String descrizione = request.getParameter("descrizione");
			String prezzoS = request.getParameter("prezzo");
			int prezzo = Integer.parseInt(prezzoS);
			String annoRealizzazione = request.getParameter("annoRealizzazione");
			Opera o = new Opera();
			s.setAttribute("opera", o);
			risultato ="Success";
		}
		return risultato;
	}

}