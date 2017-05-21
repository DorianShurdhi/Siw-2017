package it.uniroma3.servlet.model;

import java.text.DateFormat;
import java.util.Date;

public class Prodotto {
	private String nome;
	private String descrizione;
	private Float prezzo;
	private Date dataScadenza;


	public Date getDataScadenza() {
		return dataScadenza;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo=prezzo;
		
	}

	public void setDataScadenza(Date date) {
		this.dataScadenza=dataScadenza;
		
	}
	


}
