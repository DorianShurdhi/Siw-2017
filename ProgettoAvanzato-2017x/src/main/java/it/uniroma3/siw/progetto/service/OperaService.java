package it.uniroma3.siw.progetto.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.progetto.model.Autore;
import it.uniroma3.siw.progetto.model.Opera;
import it.uniroma3.siw.progetto.repository.OperaRepository;

@Service
public class OperaService {

	@Autowired
	private OperaRepository operaRepository;

	public Iterable<Opera> findAll() {
		return this.operaRepository.findAll();
	}

	@Transactional
	public void add(final Opera opera) {
		this.operaRepository.save(opera);
	}

	public Opera findbyId(Long id) {
		return this.operaRepository.findOne(id);
	}

	public Iterable<Opera> findByTitolo(String titolo){
		return this.operaRepository.findByTitolo(titolo);
	}

	public Iterable<Opera> findByAutore(Autore autore){
		return this.operaRepository.findByAutore(autore);
	}

	public Iterable<Opera> findByAnno(String anno){
		return this.operaRepository.findByAnno(anno);
	}

	public Iterable<Opera> findByTecnica(String tecnica){
		return this.operaRepository.findByTecnica(tecnica);
	}

	public void update(Opera opera){
		 this.operaRepository.save(opera);
	}

	public void remove(Opera opera) {
		opera=findbyId(opera.getId());
		operaRepository.delete(opera);
	}

}