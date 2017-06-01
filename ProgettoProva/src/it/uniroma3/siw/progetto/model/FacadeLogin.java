package it.uniroma3.siw.progetto.model;

public class FacadeLogin {
	public Utente login(String username,String password){
		Utente u = null;
		if(username.equals("mario") && password.equals("rossi")){
			u = new Utente(username,"admin");
		}else{
			u = new Utente(username,"user");
		}
		return u;
	}
}