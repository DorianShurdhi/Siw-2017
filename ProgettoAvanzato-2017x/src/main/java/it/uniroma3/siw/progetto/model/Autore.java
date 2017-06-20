package it.uniroma3.siw.progetto.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Autore {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome;
    private String cognome;
    private String nazionalita;
    @Temporal(TemporalType.DATE)
    private Date dataDiNascita;
    @Temporal(TemporalType.DATE)
    private Date dataDellaMorte;


public Autore(String nome, String cognome, String nazionalita, Date dataDiNascita, Date dataDellaMorte) {
	super();
	this.nome = nome;
	this.cognome = cognome;
	this.nazionalita = nazionalita;
	this.dataDiNascita = dataDiNascita;
	this.dataDellaMorte = dataDellaMorte;
}


public String getNome() {
	return nome;
}


public void setNome(String nome) {
	this.nome = nome;
}


public String getCognome() {
	return cognome;
}


public void setCognome(String cognome) {
	this.cognome = cognome;
}


public String getNazionalita() {
	return nazionalita;
}


public void setNazionalita(String nazionalita) {
	this.nazionalita = nazionalita;
}


public Date getDataDiNascita() {
	return dataDiNascita;
}


public void setDataDiNascita(Date dataDiNascita) {
	this.dataDiNascita = dataDiNascita;
}


public Date getDataDellaMorte() {
	return dataDellaMorte;
}


public void setDataMorte(Date dataMorte) {
	dataDellaMorte = dataMorte;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}



}