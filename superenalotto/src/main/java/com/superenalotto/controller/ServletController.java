package com.superenalotto.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.superenalotto.model.DAO;
import com.superenalotto.model.Utente;
import com.superenalotto.model.UtenteDAO;

/**
 * Servlet implementation class ServletController
 */
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	private void fromLogin(HttpServletRequest request, HttpServletResponse response, String user, String pass) throws ServletException, IOException {
		UtenteDAO ut = new UtenteDAO();
		Utente x = new Utente();
		
		try {
			int id = ut.getId(user, pass);
			if(id==-1) {
				RequestDispatcher disp=request.getRequestDispatcher("/index.jsp");
				disp.forward(request,response);
			}
			else {
				double saldo = ut.getSaldo(id);
				x.setId(id);
				x.setUser(user);
				x.setPassword(pass);
				x.setSaldo(saldo);
			}
		}
		catch(SQLException e){ 
		}
		
		RequestDispatcher disp=request.getRequestDispatcher("/scheda_utente.jsp");
		request.setAttribute("utente", x);
		disp.forward(request,response);
	}
	private void fromRegister() {
		
	}
	private void toSaldo() {
		
	}
	private void toGiocata() {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   //String hidden = request.getParameter("controllo"); 
			response.setContentType("text/html");

	      // Actual logic goes here.
	      PrintWriter out = response.getWriter();
	      out.println("<h1> qualcosa </h1>");
	      /*if(hidden.equals("1")) {
			   //out.println("ciao");
			   //fromLogin(request, response, request.getParameter("username"),request.getParameter("password"));
		   }
		   if(hidden.equals("2")) {
			   fromRegister();
		   }
		   if(hidden.equals("3")) {
			   toSaldo();
		   }
		   if(hidden.equals("4")) {
			   toGiocata();
		   }*/
		   
		   
	}

}
