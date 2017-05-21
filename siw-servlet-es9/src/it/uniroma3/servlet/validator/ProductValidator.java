package it.uniroma3.servlet.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.http.HttpServletRequest;

import it.uniroma3.servlet.service.ProductService;
import it.uniroma3.servlet.model.Prodotto;


public class ProductValidator {

	public ProductValidator(){
		
	}

	public boolean validate(HttpServletRequest request){
		boolean tuttoOk=true;
		String nextPage ;
		String nome=request.getParameter("nome");
		String descrizione=request.getParameter("descrizione");
		String prezzo=request.getParameter("prezzo");
		String dataScadenza=request.getParameter("dataScadenza");
		Prodotto prodotto = (Prodotto) request.getAttribute("prodotto");

		if(nome == null || nome.equals("")) {
			request.setAttribute("errNome", "Campo obbligatorio");
			tuttoOk = false;
		}
		else{
			prodotto.setNome(nome);
		}
		if(descrizione == null || descrizione.equals("")) {
			request.setAttribute("errDescrizione", "Campo obbligatorio");
			tuttoOk = false;
		}
		else{
			prodotto.setNome(descrizione);
		}
		if(prezzo == null || prezzo.equals("")) {
			request.setAttribute("errPrezzo", "Campo obbligatorio");
			tuttoOk = false;
		}
		else{
			prodotto.setPrezzo(Float.parseFloat(prezzo));
		}

		boolean check;
		if(dataScadenza==null||dataScadenza.equals("")){
			request.setAttribute("errDataScadenza", "Campo Obbligatorio");
			check=false;
		}else{

			try{
				DateFormat d=new SimpleDateFormat("dd/mm/yyyy");
				prodotto.setDataScadenza(d.parse(dataScadenza));
			}catch(ParseException e){
				request.setAttribute("errDataScadenza", "Deve essere una data valida: dd/mm/yyyy");
				check=false;
			}
		}


		try {
			Float.parseFloat(prezzo);
		}
		catch (NumberFormatException e) {
			request.setAttribute("errPrezzo", "Deve essere un numero!");
			tuttoOk = false;
		}

		try {
			DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy"); 
			dateFormat.parse(dataScadenza);
		}
		catch (ParseException e) {
			request.setAttribute("errData", "Deve essere una data valida!");
			tuttoOk = false;
		}

		return tuttoOk;


	}

}
