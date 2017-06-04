package it.uniroma3.siw.progetto.controller;


import it.uniroma3.siw.progetto.model.Quadro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AzioneInserimentoQuadro {
	private HttpServletRequest request;
	
	public AzioneInserimentoQuadro(HttpServletRequest request) {
		this.request = request;
	}

	public String esegui() {
		String risultato = "Fail";
		HelperInserimentoQuadro h = new HelperInserimentoQuadro(request);
		if(h.convalida()){
			HttpSession s = this.request.getSession();
			String titolo = request.getParameter("titolo");
			String codice = request.getParameter("codice");
			String prezzoS = request.getParameter("prezzo");
			int prezzo = Integer.parseInt(prezzoS);
			Quadro q = new Quadro();
			s.setAttribute("quadro", q);
			risultato ="Success";
		}
		return risultato;
	}

}