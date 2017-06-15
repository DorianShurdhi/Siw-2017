package it.uniroma3.siw.progetto.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.progetto.model.Admin;
//
public interface AdminRepository  extends CrudRepository<Admin, Long>{
	Admin findByUsername(String username);
	
}