package it.uniroma3.siw.ProgettoAvanzato2017x.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.ProgettoAvanzato2017x.model.Utente;
import it.uniroma3.siw.ProgettoAvanzato2017x.repository.UtenteRepository;

@Service
public class UtenteService {
	@Autowired
	private UtenteRepository utenteRepository;
	
    @Transactional
    public void add(final Utente utente) {
        this.utenteRepository.save(utente);
    }
    
    public Utente findByUserName(String username){
    	return this.utenteRepository.findByUsername(username);
    }
}