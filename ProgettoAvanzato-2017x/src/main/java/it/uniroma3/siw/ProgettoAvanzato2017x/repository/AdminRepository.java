package it.uniroma3.siw.ProgettoAvanzato2017x.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.ProgettoAvanzato2017x.model.Admin;

public interface AdminRepository  extends CrudRepository<Admin, Long>{
	Admin findByUsername(String username);
	
}
