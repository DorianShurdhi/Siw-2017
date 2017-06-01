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
		//f.inserisciQuadro(q.getTitolo(), q.getCodice(), q.getPrezzo());
	
		// WORKAROUND
		String titolo = request.getParameter("titoloT");
		String descrizione = request.getParameter("codiceT");
		int prezzo = Integer.parseInt(request.getParameter("prezzoT"));
		
	
		
		String target = "Thu Sep 28 20:29:30 JST 2000";
		DateFormat df = new SimpleDateFormat("E MM dd kk:mm:ss z yyyy");
		Date annoRealizzazione =  df.parse(target); 
		
		Quadro q = f.inserisciQuadro(titolo, descrizione, prezzo,annoRealizzazione);
		//
		if(f.tuttiQuadri().contains(q)){
			risultato = "Success";
		}
		return risultato;
	}

}
	
