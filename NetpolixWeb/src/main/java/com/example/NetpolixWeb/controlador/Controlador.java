package com.example.NetpolixWeb.controlador;

import com.example.NetpolixWeb.interfaceService.IpersonaService;
import com.example.NetpolixWeb.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private IpersonaService service;

    @GetMapping("/listar")
    public String listar(Model model){
        List<Persona> personas = service.listar();
        System.out.println("----LISTA DE PERSONAS----");
        System.out.println(personas.toString());
        System.out.println("-------------------------");
        model.addAttribute("personas", personas);
        return "index";
    }

}
