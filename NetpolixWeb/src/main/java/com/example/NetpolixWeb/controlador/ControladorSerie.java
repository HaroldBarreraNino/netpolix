package com.example.NetpolixWeb.controlador;

import com.example.NetpolixWeb.interfaceService.IserieService;
import com.example.NetpolixWeb.modelo.Coleccion;
import com.example.NetpolixWeb.modelo.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class ControladorSerie {

    @Autowired
    private IserieService service;

    @GetMapping("/listaseries")
    public String listarSeries(Model model){
        List<Serie> series = service.listarSerie();
        System.out.println("----LISTA DE COLECCIONES----");
        System.out.println(series.toString());
        System.out.println("-------------------------");
        model.addAttribute("series", series);
        return "listaseries";
    }

    @GetMapping("/newserie")
    public String agregarColeccion(Model model){
        model.addAttribute("serie", new Serie());
        return "formserie";
    }

    @PostMapping("/saveserie")
    public String saveColeccion (Serie p, Model model){
        service.saveSerie(p);
        return "redirect:/listaseries";
    }

    @GetMapping("/eliminarserie/{id}")
    public String deleteColeccion(Model model, @PathVariable int id){
        service.deleteSerie(id);
        return "redirect:/listaseries";
    }
}
