package it.uniroma3.siw.progetto.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.siw.progetto.model.Opera;
import it.uniroma3.siw.progetto.service.OperaService;
import it.uniroma3.siw.progetto.validator.ValidatorOpera;

/**
 * 
 * @author Dorian
 *
 */

@WebServlet("/opera")
public class ControllerOpera extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage;
		if(!request.getParameter("command").equals("remove")){
			Opera opera = new Opera();
			request.setAttribute("opera", opera);
			ValidatorOpera validator= new ValidatorOpera();
			if(validator.validate(request)){
				OperaService service = new OperaService();
				service.inserisciOpera(opera);
				nextPage="/opera.jsp";
			}else{
				nextPage="/index.jsp";
			}
		}else{

			nextPage="/opere.jsp";
		}
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage;
		OperaService service = new OperaService();

		if(request.getParameter("id")!=null){                        //se nella richiesto ho l'id faccio questo
			Long id= Long.parseLong(request.getParameter("id"));
			Opera one = service.getOneOpera(id);
			request.setAttribute("opera", one);
			nextPage="/opera.jsp";
		}else{		
			List<Opera> opere=service.getOpere();
			request.setAttribute("opere",opere);
			nextPage="/opere.jsp";			
		}		

		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
