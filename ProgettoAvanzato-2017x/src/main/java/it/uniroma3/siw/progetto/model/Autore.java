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
	private String Nome;
    private String Cognome;
    private String Nazionalita;
    @Temporal(TemporalType.DATE)
    private Date DataDiNascita;
    @Temporal(TemporalType.DATE)
    private Date DataDellaMorte;


public Autore(String nome, String cognome, String nazionalita, Date dataDiNascita, Date dataDellaMorte) {
	super();
	this.Nome = nome;
	this.Cognome = cognome;
	this.Nazionalita = nazionalita;
	this.DataDiNascita = dataDiNascita;
	this.DataDellaMorte = dataDellaMorte;
}


public String getNome() {
	return Nome;
}


public void setNome(String nome) {
	Nome = nome;
}


public String getCognome() {
	return Cognome;
}


public void setCognome(String cognome) {
	Cognome = cognome;
}


public String getNazionalita() {
	return Nazionalita;
}


public void setNazionalita(String nazionalita) {
	Nazionalita = nazionalita;
}


public Date getDataDiNascita() {
	return DataDiNascita;
}


public void setDataDiNascita(Date dataDiNascita) {
	DataDiNascita = dataDiNascita;
}


public Date getDataDellaMorte() {
	return DataDellaMorte;
}


public void setDataMorte(Date dataMorte) {
	DataDellaMorte = dataMorte;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}



}