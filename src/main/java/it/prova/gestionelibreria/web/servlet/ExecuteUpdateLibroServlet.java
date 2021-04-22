package it.prova.gestionelibreria.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionelibreria.model.Libro;
import it.prova.gestionelibreria.service.MyServiceFactory;
import it.prova.gestionelibreriautility.UtilityLibroForm;

/**
 * Servlet implementation class ExecuteUpdateArticoloServlet
 */
@WebServlet("/ExecuteUpdateLibroServlet")
public class ExecuteUpdateLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idInputParam = request.getParameter("id");
		String titoloInputParam = request.getParameter("titolo");
		String genereInputParam = request.getParameter("genere");
		String pagineInputStringParam = request.getParameter("pagine");
		String dataPubblicazioneStringParam = request.getParameter("dataPubblicazione");
		Date dataPubblicazioneParsed = UtilityLibroForm.parseDateArrivoFromString(dataPubblicazioneStringParam);

		Libro libroInstance = new Libro(Long.parseLong(idInputParam),titoloInputParam, genereInputParam,
				pagineInputStringParam != ""  ? Integer.parseInt(pagineInputStringParam) : 0, dataPubblicazioneParsed);
		 
		if (!UtilityLibroForm.validateInput(titoloInputParam, genereInputParam, pagineInputStringParam,
				dataPubblicazioneStringParam) || dataPubblicazioneStringParam == null) {
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.setAttribute("modifica_libro_attr", libroInstance);
			request.getRequestDispatcher("/libro/update.jsp").forward(request, response);
			return;
		}

		try {
			MyServiceFactory.getLibroServiceInstance().aggiorna(libroInstance);
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore nella modifica del libro");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}

 		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


}
