package it.uniroma3.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/controllerDati")
public class ControllerDati extends HttpServlet {
	private static final long serialVersionID = 1L;
	
	protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException,IOException{
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		
		HttpSession session = request.getSession();
		session.setAttribute("nome", nome);
		session.setAttribute("cognome", cognome);
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/mostraDati.jsp");
		rd.forward(request,response );
		return;
		
	}
	}


