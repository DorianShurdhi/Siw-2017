package it.uniroma3.siw.progetto.repository;

import java.util.List;

import it.uniroma3.siw.progetto.model.Opera;

public interface OperaCrudRepository {
	public Opera save(Opera opera);
	public Opera findOne(Long id);
	public List<Opera> findAll();
	public void delete(Opera opera);
	public void deleteAll();
}
