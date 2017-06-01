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
	private Float prezzo;
	private Date annoRealizzazione;
	
	public String getTitolo() {
		return titolo;
	}
	
	public Date getAnnoRealizzazione() {
		return annoRealizzazione;
	}

	public void setAnnoRealizzazione(Date annoRealizzazione) {
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

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float price) {
		this.prezzo = price;
	}
	
		
}