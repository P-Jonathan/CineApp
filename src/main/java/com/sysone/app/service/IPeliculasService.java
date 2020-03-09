package com.sysone.app.service;

import java.util.List;

import com.sysone.app.model.Pelicula;

public interface IPeliculasService {
	List<Pelicula> buscarTodas();
	Pelicula buscarPorId(int idPelicula);
}
