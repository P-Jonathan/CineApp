package com.sysone.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sysone.app.model.Banner;
import com.sysone.app.model.Horario;
import com.sysone.app.model.Pelicula;
import com.sysone.app.service.IBannerService;
import com.sysone.app.service.IHorariosService;
import com.sysone.app.service.INoticiasService;
import com.sysone.app.service.IPeliculasService;

@Controller
public class HomeController {

	@Autowired
	private IPeliculasService peliculasService;
	@Autowired
	private IHorariosService horariosService;
	@Autowired
	private IBannerService bannerService;
	@Autowired
	private INoticiasService noticiasService;
	private SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");;

	@GetMapping("/")
	public String goHome(Model model) {
		List<String> fechas = horariosService.findAllAndSortByFecha().stream().map(h -> h.getFecha())
				.map(d -> formater.format(d)).collect(Collectors.toList());
		model.addAttribute("fechas", fechas);
		List<Pelicula> peliculas = peliculasService.findAll();
		List<Banner> banners = bannerService.findAll();
		model.addAttribute("peliculas", peliculas.size() > 0 ? peliculas : null);
		model.addAttribute("banners", banners.size() > 0 ? banners : null);
		model.addAttribute("noticias", noticiasService.findAll());
		model.addAttribute("isHome", true);
		return "home";
	}

	@PostMapping("/search")
	public String search(Model model, @RequestParam("fecha") String fecha) throws ParseException {
		List<String> fechas = horariosService.findAllAndSortByFecha().stream().map(h -> h.getFecha())
				.map(d -> formater.format(d)).collect(Collectors.toList());

		List<Pelicula> peliculas = peliculasService.findAll().stream().filter(p -> p.getHorarios().stream()
				.map(h -> h.getFecha()).map(d -> formater.format(d)).anyMatch(f -> f.equals(fecha)))
				.collect(Collectors.toList());

		System.out.println("La fecha es: " + fecha);

		model.addAttribute("fechas", fechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		return "home";
	}

	@GetMapping("/detalles/{id}")
	public String getDetalles(Model model, @PathVariable("id") int idPelicula) {
		Pelicula pelicula = peliculasService.findById(idPelicula);

		if (pelicula != null) {
			model.addAttribute("pelicula", pelicula);
			model.addAttribute("horarios", horariosService.findAllAndSortByFecha());
			return "detallesConHorariosExpandidos";
		} else {
			model.addAttribute("error", "No se encontro la pelicula solicitada");
			return "redirect:/";
		}
	}

	@GetMapping("/detalles/{id}/{fecha}")
	public String getDetallesPorFecha(Model model, @PathVariable("id") int idPelicula,
			@PathVariable("fecha") Date fecha) {
		Pelicula pelicula = peliculasService.findById(idPelicula);

		if (pelicula != null) {
			List<Horario> horarios = horariosService.findByPelicula_IdAndFechaOrderByHora(idPelicula, fecha);

			System.out.println("Horarios: ");
			horarios.forEach(System.out::println);

			model.addAttribute("pelicula", pelicula);
			model.addAttribute("horarios", horarios);
			model.addAttribute("fecha", formater.format(fecha));
			return "detalles";
		} else {
			model.addAttribute("error", "No se encontro la pelicula solicitada");
			return "redirect:/";
		}
	}

	@GetMapping("/acerca")
	public String acerca() {
		return "acerca";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
