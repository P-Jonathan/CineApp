package com.sysone.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sysone.app.model.Pelicula;
import com.sysone.app.service.IPeliculasService;
import com.sysone.app.util.Utileria;

@Controller
public class HomeController {

	@Autowired
	private IPeliculasService peliculasService;
	private SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");;

	@GetMapping("/")
	public String goHome(Model model) {
		List<String> fechas = Utileria.getNextDays(7);
		model.addAttribute("fechas", fechas);
		model.addAttribute("fechaBusqueda", formater.format(new Date()));
		model.addAttribute("peliculas", peliculasService.buscarTodas());

		return "home";
	}

	@PostMapping("/search")
	public String search(Model model, @RequestParam("fecha") String fecha) throws ParseException {
		List<String> fechas = Utileria.getNextDays(7);
		List<Pelicula> peliculas = peliculasService.buscarTodas();

		model.addAttribute("fechas", fechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		return "home";
	}

	@GetMapping("/detalles")
	public String getDetalles(Model model, @RequestParam("id") int idPelicula, @RequestParam("fecha") String fecha) {
		Pelicula pelicula = peliculasService.buscarPorId(idPelicula);

		if (pelicula != null) {
			model.addAttribute("pelicula", pelicula);
			model.addAttribute("fecha", fecha);
		} else {
			model.addAttribute("error", "No se encontro la pelicula solicitada");
		}

		return "detalles";
	}
	
	@GetMapping("/detalles/{id}")
	public String getDetalles(Model model, @PathVariable("id") int idPelicula) {
		Pelicula pelicula = peliculasService.buscarPorId(idPelicula);

		if (pelicula != null) {
			model.addAttribute("pelicula", pelicula);
		} else {
			model.addAttribute("error", "No se encontro la pelicula solicitada");
		}

		return "detalles";
	}
}
