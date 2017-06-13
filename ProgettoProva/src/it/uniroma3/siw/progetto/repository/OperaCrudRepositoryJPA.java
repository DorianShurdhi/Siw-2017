package it.uniroma3.siw.progetto.repository;

import java.util.List;
import javax.persistence.*;

import it.uniroma3.siw.progetto.model.Opera;


public class OperaCrudRepositoryJPA implements OperaCrudRepository {
	private EntityManager em;
	private EntityTransaction tx;
	public  OperaCrudRepositoryJPA(EntityManager em) {
		this.em=em;
	
	}
	@Override
	public Opera save(Opera opera) { //permette di fare la persist o l'update
		if(opera.getId()==null)
			em.persist(opera);
		else
			return  em.merge(opera);  //update così l'oggetto di ritorno è managed
		return opera;
	}

	@Override
	public Opera findOne(Long id) {
		return em.find(Opera.class, id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Opera> findAll() {
		Query query= em.createQuery("SELECT o FROM 	Opera o");
		return query.getResultList();
	}

	@Override
	public void delete(Opera opera) {
		em.remove(opera);
		
	}
	@Override
	public void deleteAll() {
		Query query=em.createQuery("DELETE FROM Opera");
		query.executeUpdate();
		
	}

}
