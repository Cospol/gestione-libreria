package it.prova.gestionelibreria.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionelibreria.model.Libro;
import it.prova.gestionelibreria.service.LibroService;
import it.prova.gestionelibreria.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteDeleteArticoloServlet
 */
@WebServlet("/ExecuteDeleteLibroServlet")
public class ExecuteDeleteLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String idInput = request.getParameter("idInput");
		 LibroService libroService = MyServiceFactory.getLibroServiceInstance();
		 Libro libroInstance= null;
		 try {
			 libroInstance = libroService.caricaSingoloElemento(Long.parseLong(idInput)); 
			 if (libroInstance == null) {
				request.setAttribute("errorMessage", "Attenzione il libro che si vuole eliminare non è presente");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			 }
			 libroService.rimuovi(libroInstance);
			 request.setAttribute("listaLibriAttribute", libroService.listAll());
			 request.setAttribute("successMessage", "Operazione effettuata con successo");
			 request.getRequestDispatcher("/libro/results.jsp").forward(request, response);
		 } catch (Exception e) {
 			e.printStackTrace();
 			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/libro.jsp").forward(request, response);
 		 }
	}

}
