package it.uniroma3.siw.servlet.repository;

import java.util.List;

import it.uniroma3.siw.servlet.model.Product;

public interface ProductCrudRepository {
	public Product save(Product artista);
	public Product findOne(Long id);
	public List<Product> findAll();
	public void delete(Product artista);
	public void deleteAll();
}
