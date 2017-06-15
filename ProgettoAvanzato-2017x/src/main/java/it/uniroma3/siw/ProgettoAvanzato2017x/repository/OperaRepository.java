package it.uniroma3.siw.ProgettoAvanzato2017x.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.ProgettoAvanzato2017x.model.Autore;
import it.uniroma3.siw.ProgettoAvanzato2017x.model.Opera;

public interface OperaRepository extends CrudRepository<Opera, Long>{

	List<Opera> findByTitolo(String titolo);
	List<Opera> findByAutore(Autore autore);
	List<Opera> findByannoDiCreazione(String anno);
	List<Opera> findByTecnica(String tecnica);
	List<Opera> findByRestauro(String restauro);
}
