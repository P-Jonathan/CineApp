package com.sysone.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.sysone.app.service.IPeliculasService;
import com.sysone.app.service.PeliculasServiceImp;
import com.sysone.app.util.Utileria;

@Controller
public class AppController {

	private IPeliculasService peliculasService = new PeliculasServiceImp();
	private SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");;

	@GetMapping("/")
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	public String goHome(Model model) {
		List<String> fechas = Utileria.getNextDays(7);
		model.addAttribute("fechas", fechas);
		model.addAttribute("fechaBusqueda", formater.format(new Date()));
		model.addAttribute("peliculas", peliculasService.buscarTodas());

		return "home";
	}

	@PostMapping("/search")
	// @RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(Model model, @RequestParam("fecha") String fecha) throws ParseException {
		List<String> fechas = Utileria.getNextDays(7);
		List<Pelicula> peliculas = peliculasService.buscarTodas();

		model.addAttribute("fechas", fechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		return "home";
	}

	@GetMapping("/detalles")
	// @RequestMapping(value = "/detalles", method = RequestMethod.GET)
	public String getDetalles(Model model, @RequestParam("id") int idPelicula, @RequestParam("fecha") String fecha) {
		Optional<Pelicula> opt = peliculasService.buscarTodas().stream().filter(p -> p.getId() == idPelicula)
				.findFirst();

		if (opt.isPresent()) {
			model.addAttribute("pelicula", opt.get());
			model.addAttribute("fecha", fecha);
		} else {
			model.addAttribute("error", "No se encontro la pelicula solicitada");
		}
		return "detalles";
	}
}
