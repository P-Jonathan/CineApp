package com.sysone.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sysone.app.model.Pelicula;
import com.sysone.app.service.IPeliculasService;
import com.sysone.app.util.Utileria;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

	@Autowired
	private IPeliculasService peliculasService;

//	@GetMapping("/")
//	public String index(Model model) {
//		model.addAttribute("peliculas", peliculasService.findAll());
//		return "peliculas/listPeliculas";
//	}

	@GetMapping("/paginate")
	public String indexPaginate(Model model, Pageable page) {
		int actualPage = page.getPageNumber();
		int maxPage = Math.round(peliculasService.count() / 5);
		model.addAttribute("actualPage", actualPage);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("peliculas", peliculasService.findAll(page));
		return "peliculas/listPeliculas";
	}

	@GetMapping("/create")
	public String create(@ModelAttribute Pelicula pelicula, Model model) {
		model.addAttribute("action", "save");
		return "peliculas/formPelicula";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Pelicula pelicula, BindingResult bResult, RedirectAttributes rAttributes,
			@RequestParam("archivoImagen") MultipartFile multipartFile, HttpServletRequest request) {
		if (bResult.hasErrors()) {
			System.out.println("Error: ");
			bResult.getAllErrors().stream().forEach(err -> System.err.println(err.getDefaultMessage()));
			return "peliculas/formPelicula";
		}

		if (!multipartFile.isEmpty()) {
			String nombreImagen = Utileria.guardarArchivo(multipartFile, request);
			pelicula.setImagen(nombreImagen);
		}

		peliculasService.save(pelicula);
		rAttributes.addFlashAttribute("message", "La pelicula " + pelicula.getTitulo() + " se añadio correctamente.");
		return "redirect:/peliculas/";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Pelicula pelicula, BindingResult bResult, RedirectAttributes rAttributes,
			@RequestParam("archivoImagen") MultipartFile multipartFile, HttpServletRequest request) {
		if (bResult.hasErrors()) {
			System.out.println("Error: ");
			bResult.getAllErrors().stream().forEach(err -> System.err.println(err.getDefaultMessage()));
			return "peliculas/formPelicula";
		}

		if (!multipartFile.isEmpty()) {
			String nombreImagen = Utileria.guardarArchivo(multipartFile, request);
			pelicula.setImagen(nombreImagen);
		}

		peliculasService.update(pelicula);
		rAttributes.addFlashAttribute("message", "La pelicula " + pelicula.getTitulo() + " se añadio correctamente.");
		return "redirect:/peliculas/";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int idPelicula, Model model) {
		Pelicula pelicula = peliculasService.findById(idPelicula);
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("action", "update");
		return "peliculas/formPelicula";
	}

	@GetMapping("/delete/{id}")
	public String delte(@PathVariable("id") int idPelicula, RedirectAttributes rAttributes) {
		peliculasService.deleteById(idPelicula);
		rAttributes.addAttribute("message", "Se ha eliminado la pelicula con id: " + idPelicula);
		return "redirect:/peliculas/";
	}

	@ModelAttribute("generos")
	public List<String> getGeneros() {
		return peliculasService.findGeneros();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
