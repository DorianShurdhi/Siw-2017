package it.uniroma3.siw.progetto.model;

import java.util.Date;

import javax.persistence.*;


@Entity 
@NamedQuery(name = "findAllOpere", query = "SELECT o FROM Opera o")
public class Opera {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String titolo;	
	private String descrizione;
	private int prezzo;
	private String annoRealizzazione;

	public String getTitolo() {
		return titolo;
	}

	public String getAnnoRealizzazione() {
		return annoRealizzazione;
	}

	public void setAnnoRealizzazione(String annoRealizzazione) {
		this.annoRealizzazione = annoRealizzazione;
	}

	public Opera(){

	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String description) {
		this.descrizione = description;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int price) {
		this.prezzo = price;
	}
	public String toHTML(){
		String r = "";
		r += "<p><h1>" + this.titolo + "</h1></p><p><h2>" + this.descrizione + "</h2></p><p><h3>" + this.prezzo + "</h3></p>";   
		return r;
	}

	public boolean equals(Object ob){
		Opera o = (Opera) ob;
		return this.titolo.equals(o.getTitolo()) && this.descrizione.equals(o.getDescrizione()) && o.getPrezzo() == this.prezzo;


	}
}