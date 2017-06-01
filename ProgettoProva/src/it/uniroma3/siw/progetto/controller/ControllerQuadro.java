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

import it.uniroma3.siw.progetto.model.Quadro;
import it.uniroma3.siw.progetto.service.QuadroService;
import it.uniroma3.siw.progetto.validator.ValidatorQuadro;

/**
 * 
 * @author Dorian
 *
 */

@WebServlet("/quadro")
public class ControllerQuadro extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage;
		if(!request.getParameter("command").equals("remove")){
			Quadro quadro = new Quadro();
			request.setAttribute("quadro", quadro);
			ValidatorQuadro validator= new ValidatorQuadro();
			if(validator.validate(request)){
				QuadroService service = new QuadroService();
				service.inserisciQuadro(quadro);
				nextPage="/quadro.jsp";
			}else{
				nextPage="/index.jsp";
			}
		}else{

			nextPage="/quadri.jsp";
		}
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage;
		QuadroService service = new QuadroService();

		if(request.getParameter("id")!=null){                        //se nella richiesto ho l'id faccio questo
			Long id= Long.parseLong(request.getParameter("id"));
			Quadro one = service.getOneQuadro(id);
			request.setAttribute("quadro", one);
			nextPage="/quadro.jsp";
		}else{		
			List<Quadro> quadri=service.getQuadri();
			request.setAttribute("quadri",quadri);
			nextPage="/quadri.jsp";			
		}		

		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
