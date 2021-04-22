package it.prova.gestionelibreria.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionelibreria.service.MyServiceFactory;

/**
 * Servlet implementation class PrepareUpdateArticoloServlet
 */
@WebServlet("/PrepareUpdateLibroServlet")
public class PrepareUpdateLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idLibroParam = request.getParameter("idLibro");

		if (!NumberUtils.isCreatable(idLibroParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		} 
		try {
			request.setAttribute("modifica_cd_attr", MyServiceFactory.getLibroServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idLibroParam)));
		} catch (Exception e) {
 			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		} 
		request.getRequestDispatcher("/libro/update.jsp").forward(request, response);
	}
 
}
