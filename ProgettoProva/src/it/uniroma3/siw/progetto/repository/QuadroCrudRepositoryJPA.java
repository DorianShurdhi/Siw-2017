package it.uniroma3.siw.progetto.repository;

import java.util.List;
import javax.persistence.*;

import it.uniroma3.siw.progetto.model.Quadro;


public class QuadroCrudRepositoryJPA implements QuadroCrudRepository {
	private EntityManager em;
	private EntityTransaction tx;
	public  QuadroCrudRepositoryJPA(EntityManager em) {
		this.em=em;
	
	}
	@Override
	public Quadro save(Quadro quadro) { //permette di fare la persist o l'update
		if(quadro.getId()==null)
			em.persist(quadro);
		else
			return  em.merge(quadro);  //update così l'oggetto di ritorno è managed
		return quadro;
	}

	@Override
	public Quadro findOne(Long id) {
		return em.find(Quadro.class, id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Quadro> findAll() {
		Query query= em.createQuery("SELECT a FROM 	Quadro a");
		return query.getResultList();
	}

	@Override
	public void delete(Quadro quadro) {
		em.remove(quadro);
		
	}
	@Override
	public void deleteAll() {
		Query query=em.createQuery("DELETE FROM Quadro");
		query.executeUpdate();
		
	}

}
