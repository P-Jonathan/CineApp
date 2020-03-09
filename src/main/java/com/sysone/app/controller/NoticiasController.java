package com.sysone.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sysone.app.model.Noticia;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {

	@GetMapping("/create")
	public String crear() {
		return "noticias/formNoticias";
	}

	@PostMapping("/save")
	public String guardar(@RequestParam("titulo") String titulo, @RequestParam("estatus") String estatus,
			@RequestParam("detalle") String detalle) {
		Noticia noticia = new Noticia();
		noticia.setTitulo(titulo);
		noticia.setEstatus(estatus);
		noticia.setDetalle(detalle);
		System.out.println("Guardando noticia: " + noticia);
		return "home";
	}
}
