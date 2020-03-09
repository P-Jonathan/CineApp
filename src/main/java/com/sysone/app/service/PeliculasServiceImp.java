package com.sysone.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import com.sysone.app.model.Pelicula;
import com.sysone.app.util.Utileria;

public class PeliculasServiceImp implements IPeliculasService {

	private List<Pelicula> peliculas;
	private SimpleDateFormat formater;

	public PeliculasServiceImp() {
		peliculas = new LinkedList<Pelicula>();
		formater = new SimpleDateFormat("dd-MM-yyyy");
		List<String> fechas = Utileria.getNextDays(7);

		try {
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("En este rincon del mundo");
			pelicula1.setDuracion(140);
			pelicula1.setClasificacion("A");
			pelicula1.setGenero("Animacion");
			pelicula1.setFechaEstreno(formater.parse(fechas.get(0)));
			pelicula1.setImagen("estreno1.png");
			pelicula1.setEstatus("Activa");

			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("Logan");
			pelicula2.setDuracion(145);
			pelicula2.setClasificacion("R");
			pelicula2.setGenero("Accion");
			pelicula1.setFechaEstreno(formater.parse(fechas.get(1)));
			pelicula2.setImagen("estreno2.png");
			pelicula2.setEstatus("Activa");

			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Fragmentado");
			pelicula3.setDuracion(240);
			pelicula3.setClasificacion("B");
			pelicula3.setGenero("Suspenso");
			pelicula1.setFechaEstreno(formater.parse(fechas.get(2)));
			pelicula3.setImagen("estreno3.png");
			pelicula3.setEstatus("activa");

			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("Konh La isla calavera");
			pelicula4.setDuracion(110);
			pelicula4.setClasificacion("B");
			pelicula4.setGenero("Accion");
			pelicula1.setFechaEstreno(formater.parse(fechas.get(3)));
			pelicula4.setImagen("estreno4.png");
			pelicula4.setEstatus("activa");

			Pelicula pelicula5 = new Pelicula();
			pelicula5.setId(5);
			pelicula5.setTitulo("Life");
			pelicula5.setDuracion(125);
			pelicula5.setClasificacion("B");
			pelicula5.setGenero("Suspenso");
			pelicula1.setFechaEstreno(formater.parse(fechas.get(4)));
			pelicula5.setImagen("estreno5.png");
			pelicula5.setEstatus("Activa");

			peliculas.add(pelicula1);
			peliculas.add(pelicula2);
			peliculas.add(pelicula3);
			peliculas.add(pelicula4);
			peliculas.add(pelicula5);

		} catch (ParseException e) {
			e.printStackTrace(System.out);
		}
	}

	@Override
	public List<Pelicula> buscarTodas() {
		return peliculas;
	}
}