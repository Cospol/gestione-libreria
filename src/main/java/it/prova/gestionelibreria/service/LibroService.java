package it.prova.gestionelibreria.service;

import java.util.List;

import it.prova.gestionelibreria.dao.LibroDAO;
import it.prova.gestionelibreria.model.Libro;

public interface LibroService {

	// questo mi serve per injection
	public void setLibroDao(LibroDAO libroDao);

	public List<Libro> listAll() throws Exception;

	public Libro caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(Libro input) throws Exception;

	public void inserisciNuovo(Libro input) throws Exception;

	public void rimuovi(Libro input) throws Exception;

	public List<Libro> findByExample(Libro input) throws Exception;

}
