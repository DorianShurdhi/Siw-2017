package it.uniroma3.siw.progetto.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.progetto.model.Autore;

public interface AutoreRepository extends CrudRepository<Autore, Long>{
	
	  List<Autore> findAll();
	  List<Autore> findByCognome(String cognome);
	  List<Autore> findByNazionalita(String nazionalita);
	  List<Autore> findByDataDiNascita(Date dataDiNascita);
	  List<Autore> findByDataMorte(Date dataDellaMorte);
}
