package it.uniroma3.siw.progetto.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.siw.progetto.model.Quadro;

public class ValidatorQuadro {
	public boolean validate(HttpServletRequest request){
		boolean tuttoOk = true;
		String titolo = request.getParameter("titolo");
		String descrizione = request.getParameter("descrizione");
		String annoRealizzazione = request.getParameter("annoRealizzazione");
		String prezzo = request.getParameter("prezzo");
		
		Quadro quadro=(Quadro) request.getAttribute("quadro");
		
		if(titolo == null || titolo.equals("")) {
			request.setAttribute("errTitolo", "Campo obbligatorio");
			tuttoOk = false;
		}
		else 
			quadro.setTitolo(titolo);
		
		if(descrizione == null || descrizione.equals("")) {
			request.setAttribute("errDescrizione", "Campo obbligatorio");
			tuttoOk = false;
		}
		else
			quadro.setDescrizione(descrizione);
		
		if(prezzo == null || prezzo.equals("")) {
			request.setAttribute("errPrezzo", "Campo obbligatorio");
			tuttoOk = false;
		}
		else {
			try {
				quadro.setPrezzo(Float.parseFloat(prezzo));
			}
			catch (NumberFormatException e) {
				request.setAttribute("errPrezzo", "Deve essere un numero!");
				tuttoOk = false;
			}
		}
		
		if(annoRealizzazione == null || annoRealizzazione.equals("")) {
			request.setAttribute("errAnnoRealizzazione", "Campo obbligatorio");
			tuttoOk = false;
		}
		else {
			try {
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				quadro.setAnnoRealizzazione(df.parse(annoRealizzazione));
				if(df.parse(annoRealizzazione).compareTo(new Date()) < 0) {
					request.setAttribute("errAnnoRealizzazione", "Deve essere successiva alla data di oggi!");
					tuttoOk = false;
				}
			} catch (ParseException e) {
				request.setAttribute("errAnnoRealizzazione", "Deve essere una data valida!");
				tuttoOk = false;
			}
		
		}
		
		
		return tuttoOk;
	}
}