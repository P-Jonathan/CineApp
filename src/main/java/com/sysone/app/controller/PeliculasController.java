package com.sysone.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sysone.app.model.Pelicula;
import com.sysone.app.service.IPeliculasService;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

	@Autowired
	private IPeliculasService peliculasService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("peliculas", peliculasService.findAll());

		return "peliculas/listPeliculas";
	}

	@GetMapping("/create")
	public String create() {
		return "peliculas/formPelicula";
	}

	@PostMapping("/save")
	public String save(Pelicula pelicula, BindingResult bResult, RedirectAttributes rAttributes) {
		if (bResult.hasErrors()) {
			System.out.println("Error: ");
			bResult.getAllErrors().stream().forEach(err -> System.err.println(err.getDefaultMessage()));
			return "peliculas/formPelicula";
		}
		peliculasService.insertar(pelicula);
		rAttributes.addFlashAttribute("message", "La pelicula " + pelicula.getTitulo() + " se añadio correctamente.");
		return "redirect:/peliculas/";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
