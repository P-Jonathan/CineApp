package com.sysone.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sysone.app.model.Perfil;
import com.sysone.app.model.Usuario;
import com.sysone.app.service.IPerfilesService;
import com.sysone.app.service.IUsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private IUsuariosService usuariosService;
	@Autowired
	private IPerfilesService perfilesService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@GetMapping("/demo-bcrypt")
	public String bcrypt(Model model, @RequestParam("pass") String password) {
		String encriptado = encoder.encode(password);
		System.out.println("Contraseña: " + password);
		System.out.println("Contraseña encriptada: " + encriptado);
		model.addAttribute("password", password);
		model.addAttribute("encript", encriptado);
		return "usuarios/demo";
	}
	
	@GetMapping("/paginate")
	public String list(Model model, Pageable pageable) {
		Page<Usuario> page = usuariosService.findAll(pageable);
		int paginaActual = page.getNumber();
		model.addAttribute("usuarios", page.toList());
		model.addAttribute("paginaActual", paginaActual);
		model.addAttribute("esPrimerPagina", page.isFirst());
		model.addAttribute("esUltimaPagina", page.isLast());
		return "usuarios/index";
	}

	@GetMapping("/create")
	public String create(@ModelAttribute Usuario usuario, Model model) {
		model.addAttribute("action", "save");
		return "usuarios/formUsuario";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Usuario usuario, @RequestParam("perfil") String perfilType) {
		usuario.setPwd(encoder.encode(usuario.getPwd()));
		usuario.setActivo(1);
		Perfil perfil = new Perfil();
		perfil.setPerfil(perfilType);
		perfil.setCuenta(usuario.getCuenta());
		usuariosService.save(usuario);
		perfilesService.save(perfil);
		return "redirect:/usuarios/paginate?page=0";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("usuario", usuariosService.findById(id));
		model.addAttribute("action", "update");
		return "usuarios/formUsuario";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Usuario usuario, @RequestParam("perfil") String perfilType) {
		usuario.setPwd(encoder.encode(usuario.getPwd()));
		usuario.setActivo(1);
		Perfil perfil = new Perfil();
		perfil.setPerfil(perfilType);
		perfil.setCuenta(usuario.getCuenta());
		usuariosService.update(usuario);
		perfilesService.save(perfil);
		return "redirect:/usuarios/";
	}
}
