package it.uniroma3.siw.progetto.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.progetto.model.Autore;
import it.uniroma3.siw.progetto.repository.AutoreRepository;

@Service
public class AutoreService {
	
	@Autowired
	private AutoreRepository autoreRepository;
	
    public Iterable<Autore> findAll() {
        return this.autoreRepository.findAll();
    }
    
    @Transactional
    public void add(final Autore autore) {
        this.autoreRepository.save(autore);
    }

	public Iterable<Autore> findByCognome(String cognome) {
		return this.autoreRepository.findByNazionalita(cognome);
	}
    
	public Iterable<Autore> findByNazionalita(String nazionalita) {
		return this.autoreRepository.findByNazionalita(nazionalita);
	}
	
	public Iterable<Autore> findByDataNascita(Date dataNascita){
		return this.autoreRepository.findByDataDiNascita(dataNascita);
	}
	
	public Iterable<Autore> findByDataMorte(Date dataMorte){
		return this.autoreRepository.findByDataMorte(dataMorte);
	}
	
}