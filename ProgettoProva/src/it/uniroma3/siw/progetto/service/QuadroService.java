package it.uniroma3.siw.progetto.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import it.uniroma3.siw.progetto.model.Quadro;
import it.uniroma3.siw.progetto.repository.QuadroCrudRepositoryJPA;

public class QuadroService {
	

	public QuadroService() {

	}
	public Quadro inserisciQuadro(Quadro quadro){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("progettoBase-unit");
		EntityManager em = emf.createEntityManager();
		QuadroCrudRepositoryJPA rep = new QuadroCrudRepositoryJPA(em);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		quadro=rep.save(quadro);
		tx.commit();
		return quadro;
	}
	public List<Quadro> getQuadri() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("progettoBase-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		QuadroCrudRepositoryJPA rep =new QuadroCrudRepositoryJPA(em);
		tx.begin();

		List<Quadro> quadri=rep.findAll();
		tx.commit();

		return quadri;
	}
	public Quadro getOneQuadro(Long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("progettoBase-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		QuadroCrudRepositoryJPA rep =new QuadroCrudRepositoryJPA(em);
		tx.begin();
		Quadro quadro = rep.findOne(id);
		tx.commit();
		return quadro;
	}
	public void remove(Quadro quadro){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("progettoBase-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		QuadroCrudRepositoryJPA rep =new QuadroCrudRepositoryJPA(em);
		tx.begin();
		rep.delete(quadro);
		tx.commit();	
	}
}