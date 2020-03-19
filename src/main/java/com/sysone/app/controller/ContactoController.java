package com.sysone.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sysone.app.model.Contacto;
import com.sysone.app.service.IPeliculasService;

@Controller
public class ContactoController {

	@Autowired
	private IPeliculasService peliculasService;

	@GetMapping("/contacto")
	public String mostrarFormulario(@ModelAttribute Contacto contacto, Model model) {
		model.addAttribute("generos", peliculasService.findGeneros());
		model.addAttribute("tipos", getTipoNotificaciones());
		return "formContacto";
	}

	@PostMapping("/contacto")
	public String guardar(@ModelAttribute Contacto contacto) {
		System.out.println(contacto);
		return "redirect:/contacto";
	}

	private List<String> getTipoNotificaciones() {
		List<String> notificaciones = new LinkedList<String>();
		notificaciones.add("Estrenos");
		notificaciones.add("Promociones");
		notificaciones.add("Noticias");
		notificaciones.add("Preventas");

		return notificaciones;
	}
}
