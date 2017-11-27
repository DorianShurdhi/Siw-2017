package com.superenalotto.model;

public class Giocata {
	private int id_estrazione;
	private int id_utente;
	private String num_giocati;
	private String num_estratti;
	
	public Giocata() {
		super();
	}
	public int getId_estrazione() {
		return id_estrazione;
	}
	public void setId_estrazione(int id_estrazione) {
		this.id_estrazione = id_estrazione;
	}
	public int getId_utente() {
		return id_utente;
	}
	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}
	public String getNum_giocati() {
		return num_giocati;
	}
	public void setNum_giocati(String num_giocati) {
		this.num_giocati = num_giocati;
	}
	public String getNum_estratti() {
		return num_estratti;
	}
	public void setNum_estratti(String num_estratti) {
		this.num_estratti = num_estratti;
	} 
	
}
