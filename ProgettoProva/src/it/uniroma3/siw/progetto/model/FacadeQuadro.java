package it.uniroma3.siw.progetto.model;

import java.util.*;
import java.util.Date;

public class FacadeQuadro {
	private ArrayList<Quadro> quadri;
	
	public FacadeQuadro(){
		this.quadri = new ArrayList<Quadro>();
	}
	
	public Quadro inserisciQuadro(String titolo,String descrizione,int prezzo,Date annoRealizzazione){
		Quadro q = new Quadro();
		this.quadri.add(q);
		return q;
	}
	
	public ArrayList<Quadro> tuttiQuadri(){
		return this.quadri;
	}
}