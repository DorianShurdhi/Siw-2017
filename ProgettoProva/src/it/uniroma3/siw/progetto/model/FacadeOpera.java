package it.uniroma3.siw.progetto.model;

import java.util.*;
import java.util.Date;

public class FacadeOpera {
	private ArrayList<Opera> opere;
	
	public FacadeOpera(){
		this.opere = new ArrayList<Opera>();
	}
	
	public Opera inserisciOpera(String titolo,String descrizione,int prezzo,String annoRealizzazione){
		Opera o = new Opera();
		this.opere.add(o);
		return o;
	}
	
	public ArrayList<Opera> tutteOpere(){
		return this.opere;
	}
}