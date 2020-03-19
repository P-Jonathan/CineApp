package com.sysone.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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

import com.sysone.app.model.Banner;
import com.sysone.app.service.IBannerService;
import com.sysone.app.util.Utileria;

@Controller
@RequestMapping("/banners")
public class BannerController {

	@Autowired
	private IBannerService bannerService;

	@GetMapping("/")
	public String banners(Model model) {
		model.addAttribute("banners", bannerService.findAll());
		return "banners/listBanners";
	}

	@GetMapping("/create")
	public String create(@ModelAttribute Banner banner, Model model) {
		model.addAttribute("action", "save");
		return "banners/formBanner";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Banner banner, BindingResult bResult, RedirectAttributes rAttributes,
			@RequestParam("archivoImagen") MultipartFile multipartFile, HttpServletRequest request) {

		if (bResult.hasErrors()) {
			System.err.println("Error al capturar banner: ");
			bResult.getAllErrors().forEach(err -> System.err.println(err.getDefaultMessage()));
			return "banners/formBanner";
		}

		if (!multipartFile.isEmpty()) {
			String nombreArchivo = Utileria.guardarArchivo(multipartFile, request);
			banner.setArchivo(nombreArchivo);
		}

		bannerService.save(banner);
		rAttributes.addFlashAttribute("message", "El banner " + banner.getTitulo() + " se añadio correctamente.");
		return "redirect:/banners/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int idBanner, Model model) {
		model.addAttribute("banner", bannerService.findById(idBanner));
		model.addAttribute("action", "update");
		return "banners/formBanner";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Banner banner, BindingResult bResult, RedirectAttributes rAttributes,
			@RequestParam("archivoImagen") MultipartFile multipartFile, HttpServletRequest request) {

		if (bResult.hasErrors()) {
			System.err.println("Error al capturar banner: ");
			bResult.getAllErrors().forEach(err -> System.err.println(err.getDefaultMessage()));
			return "banners/formBanner";
		}

		if (!multipartFile.isEmpty()) {
			String nombreArchivo = Utileria.guardarArchivo(multipartFile, request);
			banner.setArchivo(nombreArchivo);
		}

		bannerService.update(banner);
		rAttributes.addFlashAttribute("message", "El banner " + banner.getTitulo() + " se actualizo correctamente.");
		return "redirect:/banners/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		bannerService.deleteById(id);
		return "redirect:/banners/";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
