package com.sysone.app.service;

import java.util.List;

import com.sysone.app.model.Pelicula;

public interface IPeliculasService {
	List<Pelicula> findAll();
	Pelicula buscarPorId(int idPelicula);
	void insertar(Pelicula pelicula);
	List<String> buscarGeneros();
}
