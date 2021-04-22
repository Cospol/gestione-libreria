package it.prova.gestionelibreria.dao;

public class MyDaoFactory {

	private static LibroDAO libroDaoInstance = null;

	public static LibroDAO getArticoloDAOInstance() {
		if (libroDaoInstance == null)
			libroDaoInstance = new LibroDAOImpl();

		return libroDaoInstance;
	}

}
