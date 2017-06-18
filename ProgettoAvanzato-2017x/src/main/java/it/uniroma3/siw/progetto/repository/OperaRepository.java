package it.uniroma3.siw.progetto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.progetto.model.Autore;
import it.uniroma3.siw.progetto.model.Opera;

public interface OperaRepository extends CrudRepository<Opera, Long>{

	List<Opera> findByTitolo(String titolo);
	List<Opera> findByAutore(Autore autore);
	List<Opera> findByAnno(String anno);
	List<Opera> findByTecnica(String tecnica);

}