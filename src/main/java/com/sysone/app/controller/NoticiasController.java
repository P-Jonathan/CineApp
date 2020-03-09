package com.sysone.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sysone.app.model.Noticia;
import com.sysone.app.service.INoticiasService;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {

	@Autowired
	private INoticiasService noticiasService;

	@GetMapping("/create")
	public String crear() {
		return "noticias/formNoticias";
	}

	@PostMapping("/save")
	public String guardar(Noticia noticia) {
		noticiasService.guardar(noticia);

		return "home";
	}
}
