package com.sysone.app.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sysone.app.model.Pelicula;
import com.sysone.app.repository.PeliculasRepository;

@Service
public class PeliculasServiceJPA implements IPeliculasService {

	@Autowired
	private PeliculasRepository peliculasRepository;

	private List<String> generos;

	public PeliculasServiceJPA() {
		generos = new LinkedList<String>();
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia Romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventura");
		generos.add("Romantica");
	}

	@Override
	public List<Pelicula> findAll() {
		return peliculasRepository.findAll();
	}

	@Override
	public Page<Pelicula> findAll(Pageable page) {
		return peliculasRepository.findAll(page);
	}

	@Override
	public Pelicula findById(int idPelicula) {
		Optional<Pelicula> optPelicula = peliculasRepository.findById(idPelicula);

		if (optPelicula.isPresent()) {
			return optPelicula.get();
		} else {
			return null;
		}
	}

	@Override
	public void save(Pelicula pelicula) {
		if (!peliculasRepository.existsById(pelicula.getId()))
			peliculasRepository.save(pelicula);
	}

	@Override
	public void update(Pelicula pelicula) {
		if (peliculasRepository.existsById(pelicula.getId()))
			peliculasRepository.save(pelicula);
	}

	@Override
	public void delete(Pelicula pelicula) {
		if (peliculasRepository.existsById(pelicula.getId()))
			peliculasRepository.delete(pelicula);
	}

	@Override
	public void deleteById(int idPelicula) {
		if (peliculasRepository.existsById(idPelicula))
			peliculasRepository.deleteById(idPelicula);
	}

	@Override
	public List<String> findGeneros() {
		return generos;
	}

	@Override
	public long count() {
		return peliculasRepository.count();
	}
}