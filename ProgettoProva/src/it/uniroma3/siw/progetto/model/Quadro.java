package it.uniroma3.siw.progetto.model;

import java.util.Date;

import javax.persistence.*;


@Entity 
@NamedQuery(name = "findAllQuadri", query = "SELECT q FROM Quadro q")
public class Quadro {

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

	public Quadro(){

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

	public boolean equals(Object o){
		Quadro q = (Quadro) o;
		return this.titolo.equals(q.getTitolo()) && this.descrizione.equals(q.getDescrizione()) && q.getPrezzo() == this.prezzo;


	}
}