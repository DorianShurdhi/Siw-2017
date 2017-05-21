package it.uniroma3.servlet.esec;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.servlet.model.Prodotto;

@WebServlet("/controllerDati")
public class ControllerDati extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		List<Prodotto> prodotti= new ArrayList<>();
		
		Prodotto p1 = new Prodotto();
		p1.setNome("Penna");
		p1.setPrezzo(3F);
		prodotti.add(p1);
		
		Prodotto p2 = new Prodotto();
		p2.setNome("Matita");
		p2.setPrezzo(2F);
		prodotti.add(p2);
		

		request.setAttribute("prodotti", prodotti);

		// inoltro
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/prodotti.jsp");
		rd.forward(request, response);
		return; 
	}
}

// metto i valori nella sessione
//HttpSession session = request.getSession();
//session.setAttribute("NOME", nome);
//session.setAttribute("COGNOME", cognome);
//session.setAttribute("DATA", data);