package it.uniroma3.siw.progetto.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import it.uniroma3.siw.progetto.model.Opera;
import it.uniroma3.siw.progetto.repository.OperaCrudRepositoryJPA;

public class OperaService {
	

	public OperaService() {

	}
	public Opera inserisciOpera(Opera opera){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("progettoBase-unit");
		EntityManager em = emf.createEntityManager();
		OperaCrudRepositoryJPA rep = new OperaCrudRepositoryJPA(em);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		opera=rep.save(opera);
		tx.commit();
		return opera;
	}
	public List<Opera> getOpere() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("progettoBase-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		OperaCrudRepositoryJPA rep =new OperaCrudRepositoryJPA(em);
		tx.begin();

		List<Opera> opere=rep.findAll();
		tx.commit();

		return opere;
	}
	public Opera getOneOpera(Long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("progettoBase-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		OperaCrudRepositoryJPA rep =new OperaCrudRepositoryJPA(em);
		tx.begin();
		Opera opera = rep.findOne(id);
		tx.commit();
		return opera;
	}
	public void remove(Opera opera){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("progettoBase-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		OperaCrudRepositoryJPA rep =new OperaCrudRepositoryJPA(em);
		tx.begin();
		rep.delete(opera);
		tx.commit();	
	}
}