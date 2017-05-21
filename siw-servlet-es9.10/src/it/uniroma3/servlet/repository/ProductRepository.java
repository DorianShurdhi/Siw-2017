package it.uniroma3.servlet.repository;

import javax.persistence.EntityManager;

import it.uniroma3.servlet.model.Prodotto;

public class ProductRepository extends CrudRepositoryJPA<Prodotto> {

	public ProductRepository(EntityManager em) {
		super(em, Prodotto.class);
	}
	

}
