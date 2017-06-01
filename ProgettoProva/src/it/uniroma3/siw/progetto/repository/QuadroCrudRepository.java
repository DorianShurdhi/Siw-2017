package it.uniroma3.siw.progetto.repository;

import java.util.List;

import it.uniroma3.siw.progetto.model.Quadro;

public interface QuadroCrudRepository {
	public Quadro save(Quadro quadro);
	public Quadro findOne(Long id);
	public List<Quadro> findAll();
	public void delete(Quadro quadro);
	public void deleteAll();
}
