package com.sysone.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sysone.app.model.Noticia;
import com.sysone.app.service.INoticiasService;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {

	@Autowired
	private INoticiasService noticiasService;
	
	@GetMapping("/")
	public String list(Model model) {
		model.addAttribute("noticias", noticiasService.findAll());
		return "noticias/listNoticias";
	}

	@GetMapping("/create")
	public String crear(@ModelAttribute Noticia noticia, Model model) {
		model.addAttribute("action", "save");
		return "noticias/formNoticias";
	}

	@PostMapping("/save")
	public String guardar(@ModelAttribute Noticia noticia) {
		noticiasService.save(noticia);
		return "redirect:/noticias/";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("noticia", noticiasService.findById(id));
		model.addAttribute("action", "update");
		return "noticias/formNoticias";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Noticia noticia) {
		System.out.println("Se va a actualizar la siguiente noticia: " + noticia);
		noticiasService.update(noticia);
		return "redirect:/noticias/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		noticiasService.deleteByID(id);
		return "redirect:/noticias/";
	}
}
