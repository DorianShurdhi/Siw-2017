package it.uniroma3.siw.progetto.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.siw.progetto.model.FacadeOpera;
import it.uniroma3.siw.progetto.model.Opera;

public class AzioneConfermaInserimento {
	private HttpServletRequest request;
	
	public AzioneConfermaInserimento(HttpServletRequest request){
		this.request = request;
	}
	public String esegui() throws ParseException{
		String risultato = "Fail";
		FacadeOpera f = new FacadeOpera();
		
		//HttpSession s = this.request.getSession();
		//Opera o = (Opera) s.getAttribute("opera");
		//f.inserisciOpera(s.getTitolo(), s.getDescrizione(), s.getPrezzo(), s.getAnnoRealizzazion());
	
		// WORKAROUND
		String titolo = request.getParameter("titolo");
		String descrizione = request.getParameter("descrizione");
		int prezzo = Integer.parseInt(request.getParameter("prezzo"));
		String annoRealizzazione = request.getParameter("annoRealizzazione");
	
		Opera o = f.inserisciOpera(titolo, descrizione, prezzo,annoRealizzazione);
		//
		if(f.tutteOpere().contains(o)){
			risultato = "Success";
		}
		return risultato;
	}

}
	
