package com.superenalotto.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.superenalotto.model.GiocataDAO;
import com.superenalotto.model.Utente;
import com.superenalotto.model.UtenteDAO;

/**
 * Servlet implementation class NuovaServlet
 */
public class NuovaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	private void fromLogin(HttpServletRequest request, HttpServletResponse response, String user, String pass) throws ServletException, IOException {
		UtenteDAO ut = new UtenteDAO();
		Utente x = new Utente();
		
		try {
			int id = ut.getId(user, pass);
			if(id==-1) {
				response.sendRedirect("index.jsp");
				return;
			}
				double saldo = ut.getSaldo(id);
				x.setId(id);
				x.setUser(user);
				x.setPassword(pass);
				x.setSaldo(saldo);
		}
		catch(SQLException e){ 
		}
		
		RequestDispatcher disp=request.getRequestDispatcher("/view/scheda_utente.jsp");
		request.setAttribute("utente", x);
		disp.forward(request,response);
	}
	
	private void fromRegister(HttpServletRequest request, HttpServletResponse response, String user, String pass) throws ServletException, IOException {
		UtenteDAO ut = new UtenteDAO();
		Utente x = new Utente();
		
		try {
			int id = ut.getId(user, pass);
			if(id == -1) {
				ut.addUtente(user, pass);
				id = ut.getId(user, pass);
				double saldo = ut.getSaldo(id);
				x.setId(id);
				x.setUser(user);
				x.setPassword(pass);
				x.setSaldo(saldo);
			}
			else {
				response.sendRedirect("view/registrazione.jsp");
				return;
			}
		}
		catch(SQLException e){ 
		}
		RequestDispatcher disp=request.getRequestDispatcher("/view/scheda_utente.jsp");
		request.setAttribute("utente", x);
		disp.forward(request,response);
	} 
	
	private void toSaldo(HttpServletRequest request, HttpServletResponse response, String id_ut) throws ServletException, IOException {
		RequestDispatcher disp=request.getRequestDispatcher("/view/ricarica.jsp");
		request.setAttribute("id", id_ut);
		disp.forward(request,response);
	}
	private void fromSaldo(HttpServletRequest request, HttpServletResponse response, String addSaldo, String id_ut) throws ServletException, IOException {
		Utente x = new Utente();
		int id = Integer.parseInt(id_ut);
		double saldo = ut.getSaldo(id);
		x.setId(id);
		x.setUser(user);
		x.setPassword(pass);
		x.setSaldo(saldo);
		RequestDispatcher disp=request.getRequestDispatcher("/view/scheda_utente.jsp");
		request.setAttribute("utente", x);
		disp.forward(request,response);
	}
	
	private String estrazione() {
		int i=0;
		String num_estratti = "";
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(i=0; i<90; i++) {
			array.add(i+1);
		}
		Random random = new Random();
		int j = 1;
		int n = 90-j;
		int primo   = random.nextInt(n)+j;
		num_estratti += (array.get(primo)+" - ");
		array.remove(primo);
		
		n--;
		int secondo = random.nextInt(n)+j;
		num_estratti += (array.get(secondo)+" - ");
		array.remove(secondo);

		n--;
		int terzo   = random.nextInt(n)+j;
		num_estratti += (array.get(terzo)+" - ");
		array.remove(terzo);

		n--;
		int quarto  = random.nextInt(n)+j;
		num_estratti += (array.get(quarto)+" - ");
		array.remove(quarto);

		n--;
		int quinto  = random.nextInt(n)+j;
		num_estratti += (quinto+" - ");
		array.remove(quinto);

		n--;
		int sesto   = random.nextInt(n)+j;
		num_estratti += (sesto);
		array.remove(sesto);
		
		return num_estratti;
	}
	private void toGiocata(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num_estratti = estrazione();
		
		int id = Integer.parseInt(request.getParameter("id_utente"));
		
		String num_giocati="";
		num_giocati += (request.getParameter("uno")+" - ");
		num_giocati += (request.getParameter("due")+" - ");
		num_giocati += (request.getParameter("tre")+" - ");
		num_giocati += (request.getParameter("qua")+" - ");
		num_giocati += (request.getParameter("cin")+" - ");
		num_giocati += request.getParameter("sei");
		
		GiocataDAO g = new GiocataDAO();

		try {
			g.addGiocata(id, num_giocati, num_estratti);
		} catch (SQLException e) { } 
		
		UtenteDAO ut = new UtenteDAO();
		String us="";
		String pa="";
		try {
			us = ut.getUser(id);
			pa = ut.getPass(id);
		} catch (SQLException e) { }
		
		String id_boh = ""+id;

		RequestDispatcher disp=request.getRequestDispatcher("/view/giocata.jsp");
		request.setAttribute("n_giocati", num_giocati);
		request.setAttribute("n_estratti", num_estratti);
		request.setAttribute("id", id_boh);
		request.setAttribute("user", us);
		request.setAttribute("pass", pa);

		disp.forward(request,response);
	}
	private void fromGiocata(HttpServletRequest request, HttpServletResponse response, String id_ut, String user) throws ServletException, IOException {
		
		UtenteDAO ut = new UtenteDAO();
		int id = Integer.parseInt(id_ut);
		String us = null;
		String pa = null;
		double saldo = 0.0;
		try {
			saldo = ut.getSaldo(id);
			us = ut.getUser(id);
			pa = ut.getPass(id);
		} catch (SQLException e) { }
		Utente x = new Utente();
		x.setId(id);
		x.setUser(us);
		x.setPassword(pa);
		x.setSaldo(saldo);
		
		RequestDispatcher disp = request.getRequestDispatcher("/view/scheda_utente.jsp");
		request.setAttribute("utente", x);
		disp.forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hidden = request.getParameter("controllo"); 
		
		if(hidden.equals("1")) {
			fromLogin(request, response, request.getParameter("username"),request.getParameter("password"));
		}
		if(hidden.equals("2")) {
			fromRegister(request, response, request.getParameter("user"), request.getParameter("pwd1"));
		}
		if(hidden.equals("3")) {
		    toSaldo(request, response, request.getParameter("id"));
		}
		if(hidden.equals("4")) {
			toGiocata(request, response);
		}
		if(hidden.equals("5")) {
			fromGiocata(request, response, request.getParameter("id"), request.getParameter("user"));
		}
		if(hidden.equals("6")) {
			fromSaldo(request, response, request.getParameter("addsaldo"), request.getParameter("id_utente"));
		}
	}

}
