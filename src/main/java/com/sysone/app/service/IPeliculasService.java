package com.sysone.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sysone.app.model.Pelicula;

public interface IPeliculasService {
	List<Pelicula> findAll();
	
	Page<Pelicula> findAll(Pageable page);
	
	Pelicula findById(int idPelicula);
	
	void save(Pelicula pelicula);
	
	void update(Pelicula pelicula);
	
	void delete(Pelicula pelicula);
	
	void deleteById(int idPelicula);
	
	long count();
	
	List<String> findGeneros();
}
