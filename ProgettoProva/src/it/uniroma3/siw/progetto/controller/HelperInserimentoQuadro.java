package it.uniroma3.siw.progetto.controller;

import javax.servlet.http.HttpServletRequest;

public class HelperInserimentoQuadro {
	private HttpServletRequest request;
	
	public HelperInserimentoQuadro(HttpServletRequest request) {
		this.request = request;
	}

	public boolean convalida() {
		boolean risultato = true;
		String titolo = request.getParameter("titolo");
		String descrizione = request.getParameter("descrizione");
		String prezzo = request.getParameter("prezzo");
		String annoRealizzazione = request.getParameter("annorealizzazione");
		
		try{
			int valore = Integer.parseInt(prezzo);
		}catch(Exception ex){
			risultato = false;
		}
		if(titolo==null || titolo.equals("")) risultato = false;
		if(descrizione==null || descrizione.equals("")) risultato = false;
		if(annoRealizzazione==null || annoRealizzazione.equals("")) risultato = false;
		return risultato;
	}
	

}