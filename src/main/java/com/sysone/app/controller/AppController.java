package com.sysone.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
//import static java.util.stream.Collectors.toList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sysone.app.model.Pelicula;
import com.sysone.app.util.Utileria;

@Controller
public class AppController {
	private List<Pelicula> peliculas;
	private SimpleDateFormat formater;

	{
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

	@GetMapping("/")
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	public String goHome(Model model) {
		List<String> fechas = Utileria.getNextDays(7);
		model.addAttribute("fechas", fechas);
		model.addAttribute("fechaBusqueda", formater.format(new Date()));
		model.addAttribute("peliculas", getPeliculas());

		return "home";
	}

	@PostMapping("/search")
	// @RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(Model model, @RequestParam("fecha") String fecha) throws ParseException {
		List<String> fechas = Utileria.getNextDays(7);
		List<Pelicula> peliculas = getPeliculas();

		model.addAttribute("fechas", fechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		return "home";
	}

	@GetMapping("/detalles")
	// @RequestMapping(value = "/detalles", method = RequestMethod.GET)
	public String getDetalles(Model model, @RequestParam("id") int idPelicula, @RequestParam("fecha") String fecha) {
		Optional<Pelicula> opt = getPeliculas().stream().filter(p -> p.getId() == idPelicula).findFirst();

		if (opt.isPresent()) {
			model.addAttribute("pelicula", opt.get());
			model.addAttribute("fecha", fecha);
		} else {
			model.addAttribute("error", "No se encontro la pelicula solicitada");
		}
		return "detalles";
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}
}
