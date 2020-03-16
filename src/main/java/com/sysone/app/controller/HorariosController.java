package com.sysone.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String listarHorarios(Model model) {
        model.addAttribute("horarios", horariosService.findAll());
        return "horarios/listHorarios";
    }

    @GetMapping("/create")
    public String crear(@ModelAttribute Horario horario, Model model) {
        model.addAttribute("peliculas", peliculasService.findAll());
        model.addAttribute("salas", getSalas());
        return "horarios/formHorarios";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Horario horario, BindingResult bResult, Model model) {
        if (bResult.hasErrors()) {
            System.err.println("Error al procesar formulario: ");
            bResult.getAllErrors().forEach(System.err::println);
            model.addAttribute("peliculas", peliculasService.findAll());
            model.addAttribute("salas", getSalas());
            return "horarios/formHorarios";
        }
        horario.setPelicula(peliculasService.buscarPorId(horario.getPelicula().getId()));
        horariosService.guardar(horario);
        return "redirect:/horarios/";
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
