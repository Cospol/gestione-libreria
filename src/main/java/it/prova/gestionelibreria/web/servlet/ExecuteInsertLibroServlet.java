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

@WebServlet("/ExecuteInsertLibroServlet")
public class ExecuteInsertLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertLibroServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		String titoloInputParam = request.getParameter("titolo");
		String genereInputParam = request.getParameter("genere");
		String pagineInputStringParam = request.getParameter("pagine");
		String dataPubblicazioneStringParam = request.getParameter("dataPubblicazione");
	 
		Date dataPubblicazioneParsed = UtilityLibroForm.parseDateArrivoFromString(dataPubblicazioneStringParam);
 
		if (!UtilityLibroForm.validateInput(titoloInputParam, genereInputParam, pagineInputStringParam,
				dataPubblicazioneStringParam) || dataPubblicazioneParsed == null) {
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/libro/insert.jsp").forward(request, response);
			return;
		}

		Libro libroInstance = new Libro(titoloInputParam, genereInputParam,
				Integer.parseInt(pagineInputStringParam), dataPubblicazioneParsed);
	 
		try {
			MyServiceFactory.getLibroServiceInstance().inserisciNuovo(libroInstance);
			request.setAttribute("listaLibriAttribute", MyServiceFactory.getLibroServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/libro/insert.jsp").forward(request, response);
			return;
		}
 
		request.getRequestDispatcher("/libro/results.jsp").forward(request, response);

	}

}
