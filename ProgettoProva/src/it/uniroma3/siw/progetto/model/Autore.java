package it.uniroma3.siw.progetto.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Autore {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@ManyToMany
	private List<Opera> opere;
	
	public Autore() {
		this.opere = new ArrayList<>();
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public List<Opera> getOpere() {
		return opere;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}
	
	
	@Override
	public String toString() {
		return this.nome;
	}
}
