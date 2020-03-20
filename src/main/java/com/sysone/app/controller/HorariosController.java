package com.sysone.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
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

import com.sysone.app.model.Horario;
import com.sysone.app.service.IHorariosService;
import com.sysone.app.service.IPeliculasService;

@Controller
@RequestMapping("/horarios")
public class HorariosController {

    @Autowired
    private IHorariosService horariosService;
    @Autowired
    private IPeliculasService peliculasService;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("horarios", horariosService.findAll());
        return "horarios/listHorarios/paginate?page=0";
    }
    
    @GetMapping("/paginate")
	public String indexPaginate(Model model, Pageable pageable) {
		Page<Horario> page = horariosService.findAll(pageable);
		int paginaActual = page.getNumber();
		model.addAttribute("horarios", page.toList());
		model.addAttribute("paginaActual", paginaActual);
		model.addAttribute("esPrimerPagina", page.isFirst());
		model.addAttribute("esUltimaPagina", page.isLast());
        return "horarios/listHorarios";
	}

    @GetMapping("/create")
    public String create(@ModelAttribute Horario horario, Model model) {
        model.addAttribute("peliculas", peliculasService.findAll());
        model.addAttribute("salas", getSalas());
        model.addAttribute("action", "save");
        return "horarios/formHorarios";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Horario horario, BindingResult bResult, Model model) {
        if (bResult.hasErrors()) {
            System.err.println("Error al procesar formulario: ");
            bResult.getAllErrors().forEach(System.err::println);
            model.addAttribute("peliculas", peliculasService.findAll());
            model.addAttribute("salas", getSalas());
            return "horarios/formHorarios";
        }
        horario.setPelicula(peliculasService.findById(horario.getPelicula().getId()));
        horariosService.save(horario);
        return "redirect:/horarios/paginate?page=0";
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
    	model.addAttribute("horario", horariosService.findById(id));
        model.addAttribute("peliculas", peliculasService.findAll());
        model.addAttribute("salas", getSalas());
        model.addAttribute("action", "update");
        return "horarios/formHorarios";
    }
    
    @PostMapping("/update")
    public String update(@ModelAttribute Horario horario, BindingResult bResult, Model model) {
        if (bResult.hasErrors()) {
            System.err.println("Error al procesar formulario: ");
            bResult.getAllErrors().forEach(System.err::println);
            model.addAttribute("peliculas", peliculasService.findAll());
            model.addAttribute("salas", getSalas());
            return "horarios/formHorarios";
        }
        horario.setPelicula(peliculasService.findById(horario.getPelicula().getId()));
        horariosService.update(horario);
        return "redirect:/horarios/paginate?page=0";
    }
    
    @GetMapping("/delete/{id}")
    public String edit(@PathVariable("id") int id) {
    	horariosService.deleteById(id);
        return "redirect:/horarios/paginate?page=0";
    }

    public List<String> getSalas() {
        List<String> salas = new LinkedList<>();
        salas.add("Sala Premium");
        salas.add("Sala 1");
        salas.add("Sala 2");
        salas.add("Sala 3");
        return salas;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
