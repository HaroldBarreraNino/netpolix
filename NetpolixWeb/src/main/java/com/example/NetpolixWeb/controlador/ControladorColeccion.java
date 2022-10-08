package com.example.NetpolixWeb.controlador;

import com.example.NetpolixWeb.interfaceService.IcoleccionService;
import com.example.NetpolixWeb.modelo.Coleccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class ControladorColeccion {

    @Autowired
    private IcoleccionService service;

    @GetMapping("/listacolecciones")
    public String listarColecciones(Model model){
        List<Coleccion> coleccions = service.listarColeccion();
        System.out.println("----LISTA DE COLECCIONES----");
        System.out.println(coleccions.toString());
        System.out.println("-------------------------");
        model.addAttribute("colecciones", coleccions);
        return "listacolecciones";
    }

    @GetMapping("/newcoleccion")
    public String agregarColeccion(Model model){
        model.addAttribute("coleccion", new Coleccion());
        return "formcoleccion";
    }

    @PostMapping("/savecoleccion")
    public String saveColeccion (Coleccion p, Model model){
        service.saveColeccion(p);
        return "redirect:/listacolecciones";
    }

    @GetMapping("/eliminarcoleccion/{id}")
    public String deleteColeccion(Model model, @PathVariable int id){
        service.deleteColeccion(id);
        return "redirect:/listacolecciones";
    }
}
