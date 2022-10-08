package com.example.NetpolixWeb.controlador;

import com.example.NetpolixWeb.interfaceService.IpersonaService;
import com.example.NetpolixWeb.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class ControladorPersona {

    @Autowired
    private IpersonaService service;

    @GetMapping("/listar")
    public String listar(Model model){
        List<Persona> personas = service.listar();
        System.out.println("----LISTA DE PERSONAS----");
        System.out.println(personas.toString());
        System.out.println("-------------------------");
        model.addAttribute("personas", personas);
        return "listadatos";
    }

    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("persona", new Persona());
        return "form";
    }

    @PostMapping("/save")
    public String save (Persona p, Model model){
        service.save(p);
        return "redirect:/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(Model model, @PathVariable int id){
        service.delete(id);
        return "redirect:/listar";
    }
}