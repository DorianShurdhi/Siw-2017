package it.uniroma3.servlet.controller;


import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.servlet.model.Prodotto;
import it.uniroma3.servlet.service.ProductService;
import it.uniroma3.servlet.validator.ProductValidator;

@WebServlet("/prodotto")
public class ControllerProdotto extends HttpServlet {

	public ControllerProdotto() {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextPage="/mostraDati";
		Prodotto prodotto = new Prodotto();

		ProductValidator validator = new ProductValidator();

		if(validator.validate(request)) {
		
			
			
			ProductService service = new ProductService();
			service.inserisciProdotto(prodotto);
		
		}
		else
			nextPage = "/index.jsp";

		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
