package it.uniroma3.siw.progetto.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.siw.progetto.model.FacadeQuadro;
import it.uniroma3.siw.progetto.model.Quadro;

public class AzioneConfermaInserimento {
	private HttpServletRequest request;
	
	public AzioneConfermaInserimento(HttpServletRequest request){
		this.request = request;
	}
	public String esegui() throws ParseException{
		String risultato = "Fail";
		FacadeQuadro f = new FacadeQuadro();
		
		//HttpSession s = this.request.getSession();
		//Quadro q = (Quadro) s.getAttribute("quadro");
		//f.inserisciQuadro(s.getTitolo(), s.getDescrizione(), s.getPrezzo(), s.getAnnoRealizzazion());
	
		// WORKAROUND
		String titolo = request.getParameter("titolo");
		String descrizione = request.getParameter("descrizione");
		int prezzo = Integer.parseInt(request.getParameter("prezzo"));
		String annoRealizzazione = request.getParameter("annoRealizzazione");
	
		Quadro q = f.inserisciQuadro(titolo, descrizione, prezzo,annoRealizzazione);
		//
		if(f.tuttiQuadri().contains(q)){
			risultato = "Success";
		}
		return risultato;
	}

}
	
