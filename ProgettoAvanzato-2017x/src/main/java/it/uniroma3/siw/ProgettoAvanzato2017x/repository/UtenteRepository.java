package it.uniroma3.siw.ProgettoAvanzato2017x.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.ProgettoAvanzato2017x.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long> {
	  Utente findByUsername(String username);
}